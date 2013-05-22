
public class DriverPacket {

	/**
	 * @param args
	 */
	public static void main (String args[]) {
		  // Spawn a SerialPortListener Thread
		  SerialPortListener listener = new SerialPortListener("COMM11");
		  // Start the thread
		  listener.start();
		}

}
