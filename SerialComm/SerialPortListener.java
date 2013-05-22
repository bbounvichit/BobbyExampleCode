

// Import RXTX library references
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;

public class SerialPortListener extends Thread {

  public CommPortIdentifier portIdentifier;
  public SerialPort serialPort;
  public InputStream inputStream;
  public boolean mainloop = true;
  
  // Constructor for the serial port listener
  // portId is a string that identifies the COMM port to use (i.e. COMM11)
  public SerialPortListener(String portId) {
    try {
      this.portIdentifier = CommPortIdentifier.getPortIdentifier("COM11"); 
      this.serialPort = (SerialPort) portIdentifier.open("Crittercam", 5000);
      serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
      this.inputStream = serialPort.getInputStream();
    }
    catch (NoSuchPortException e) {
      System.err.println("Error: Invalid port identifier");
    } 
    catch (PortInUseException e) {
      System.err.println("Error: Serial port already in use");
    }
    catch (UnsupportedCommOperationException e) {
      System.err.println("Error: Unsupported COMM port operation");
    }
    catch (IOException e) {
      System.err.println("Error: Could not get serial port's input stream");
    }
  }
  
  @Override
  // Run method for this listener thread
  public void run() {
	try{
	  byte c = 0;
	  byte[] buffer = new byte[128];
	  while (mainloop) {
		          //another loop that resets and i
		          int i = 0;
		          boolean readpacket = true;
		          while(readpacket){
		              //WHEN FE received, then ADD FF to buffer
		              //TEST PACKETS
		              while (( c = (byte) inputStream.read()) == -1) {
		              }
		              
		              if(c == (byte) 0xFE){
		                  buffer[i] = (byte) 0xFF;
		                  i++;
		              }
		              buffer[i] = (byte) c;
		              i++;
		              if(i > 25){
		                  readpacket = false;
		              }
		              
		              
		          }
		          
		          DataPacket packet = new DataPacket(buffer);
		          System.out.println(packet);
		  }
		  //CLOSE INPUT STREAM before exiting.
		}catch (NullPointerException e){
		  System.out.println("Null serial port");
		}catch (IOException e) {
		  System.out.println("IO exception for input Streaming");
		}finally {
		  System.exit(0);
		}
  }
  
}

/*
public class SerialPortListener {

    static CommPortIdentifier portIdentifier;
    static boolean mainloop = true;
    
    public static void main(String[] args) throws PortInUseException {
        try {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("COM11");      
            SerialPort serial = (SerialPort) portIdentifier.open("Crittercam", 5000);
            serial.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            InputStream inputStream = serial.getInputStream();
            
            //File file = new File("C:\\Users\\Bobby\\Desktop\\GPSsampling.txt");
            //PrintWriter outputFile = new PrintWriter("C:\\Users\\Bobby\\Desktop\\GPSsampling.txt");
            //PrintWriter outputFile = new PrintWriter(new FileWriter(file, true));
            
            byte c = 0;
            byte[] buffer = new byte[256];
            while (mainloop) {
                    //another loop that resets and i
                    int i = 0;
                    boolean readpacket = true;
                    while(readpacket){
                        //WHEN FE received, then ADD FF to buffer
                        //TEST PACKETS
                        while (( c = (byte) inputStream.read()) == -1) {
                        }
                        
                        if(c == (byte) 0xFE){
                            buffer[i] = (byte) 0xFF;
                            i++;
                        }
                        buffer[i] = (byte) c;
                        i++;
                        if(i > 25){
                            readpacket = false;
                        }
                        
                        
                    }
                    
                    DataPacket packet = new DataPacket(buffer);
                    
                    int latBits = 0;
                    int b3 = ((int) packet.Payload[2]) & 0x000000FF;
                    int b2 = ((int) packet.Payload[3]) & 0x000000FF;
                    int b1 = ((int) packet.Payload[4]) & 0x000000FF;
                    int b0 = ((int) packet.Payload[5]) & 0x000000FF;
                    latBits = (b0 << 24) | (b1 << 16) | (b2 << 8) | b3;
                    float latitude = Float.intBitsToFloat(latBits);
                    
                    int longBits = 0;
                    int l3 = ((int) packet.Payload[6]) & 0x000000FF;
                    int l2 = ((int) packet.Payload[7]) & 0x000000FF;
                    int l1 = ((int) packet.Payload[8]) & 0x000000FF;
                    int l0 = ((int) packet.Payload[9]) & 0x000000FF;
                    longBits = (l0 << 24) | (l1 << 16) | (l2 << 8) | l3;
                    float longitude = Float.intBitsToFloat(longBits);
                    
                    //outputFile.println(latitude + "," + longitude);
                    //outputFile.flush();
                    System.out.println("latitude " + latitude + " longitude " + longitude + "\n");
                    //System.out.println(packet.toString());
            }
            //CLOSE INPUT STREAM before exiting.
        } catch (NoSuchPortException e) {
            // TODO Auto-generated catch block
            System.out.println("No such port exists");
        } catch (UnsupportedCommOperationException e1) {
            System.out.println("Unsupported COMM operation");
        }catch (NullPointerException e){
            System.out.println("Null serial port");
        }catch (IOException e) {
            System.out.println("IO exception for input Streaming");
        }finally {
            System.exit(0);
        }
    }
    
    public static class DataPacket{
        byte[] startDelimiter = new byte[1];
        byte[] length = new byte[2];
        byte[] frameType = new byte[1];
        byte[] address = new byte[8];
        byte[] reserved = new byte[2];
        byte[] receiveOption = new byte[1];
        byte[] Payload = new byte[128];
        byte[] checksum = new byte[1];
        
        public DataPacket(byte[] array){
            this.startDelimiter[0] = array[0];
            this.length[0] = array[1];
            this.length[1] = array[2];
            this.frameType[0] = array[3];
            this.address[0] = array[4];
            this.address[1] = array[5];
            this.address[2] = array[6];
            this.address[3] = array[7];
            this.address[4] = array[8];
            this.address[5] = array[9];
            this.address[6] = array[10];
            this.address[7] = array[11];
            this.reserved[0] = array[12];
            this.reserved[1] = array[13];
            this.receiveOption[0] = array[14];
            this.Payload[0] = array[15];
            this.Payload[1] = array[16];
            this.Payload[2] = array[17];
            this.Payload[3] = array[18];
            this.Payload[4] = array[19];
            this.Payload[5] = array[20];
            this.Payload[6] = array[21];
            this.Payload[7] = array[22];
            this.Payload[8] = array[23];
            this.Payload[9] = array[24];
            this.checksum[0] = array[25];
            
        }
        
        public String toString() {
            String str = "";
            str += "SD: " + DatatypeConverter.printHexBinary(startDelimiter);
            str += " \nlength: " + DatatypeConverter.printHexBinary(length);
            str += " \nFrameType: " + DatatypeConverter.printHexBinary(frameType);
            str += " \nAddress: " + DatatypeConverter.printHexBinary(address);
            str += " \nreserved: " + DatatypeConverter.printHexBinary(reserved);
            str += " \nReceiveOption: " + DatatypeConverter.printHexBinary(receiveOption);
            str += " \nPayload: " + DatatypeConverter.printHexBinary(Payload);
            str += " \nchecksum: " + DatatypeConverter.printHexBinary(checksum);
    
            return str;
        }
        
    }

}
*/