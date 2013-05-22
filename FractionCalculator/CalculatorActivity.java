package calculator.fractions;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends Activity {
    
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonSlash;
    Button buttonEquals;
    Button buttonAdd;
    Button buttonSubtract;
    Button buttonMultiply;
    Button buttonNegate;
    Button buttonClr;
    Button buttonRecip;
    Button buttonProp;
    Button buttonDivide;
    
    EditedText textedView;
    TextView operations;
    TextView answers;
    
    Fraction mainFraction;
    Fraction subFraction;
    
    boolean div = true;
	boolean multi = true;
	boolean sla = true;
	boolean plus= true;
	boolean sub = true;
	boolean proper = false;
	
	int gcd;

	String current;
	String updated;
	String operated;
	String userFraction;
	

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        mainFraction = new Fraction();
        subFraction = new Fraction();
    }

    
public void onClickEvent(View thisview){
    	
    	
        button1 = (Button) findViewById(R.id.one);
        button2 = (Button) findViewById(R.id.two);
        button3 = (Button) findViewById(R.id.three);
        button4 = (Button) findViewById(R.id.four);
        button5 = (Button) findViewById(R.id.five);
        button6 = (Button) findViewById(R.id.six);
        button7 = (Button) findViewById(R.id.seven);
        button8 = (Button) findViewById(R.id.eight);
        button9 = (Button) findViewById(R.id.nine);
        button0 = (Button) findViewById(R.id.zero);
        buttonSlash = (Button) findViewById(R.id.slash);
        buttonEquals = (Button) findViewById(R.id.equals);
        buttonAdd = (Button) findViewById(R.id.add);
        buttonSubtract = (Button) findViewById(R.id.subtract);
        buttonMultiply = (Button) findViewById(R.id.multiply);
        buttonNegate = (Button) findViewById(R.id.negate);
        buttonClr = (Button) findViewById(R.id.clear);
        buttonRecip = (Button) findViewById(R.id.reciprocal);
        buttonProp = (Button) findViewById(R.id.proper);
        buttonDivide = (Button) findViewById(R.id.divide);

        textedView = (EditedText) findViewById(R.id.main_fraction);
        operations = (TextView) findViewById(R.id.operation);
        answers = (TextView) findViewById(R.id.answer_fraction);
        
        
    	switch(thisview.getId()){
    	
    		case (R.id.one): {
    			current = textedView.getText().toString();
    			updated = current + "1";
    			textedView.setText(updated);
    			break;
    		}
    		
    		case (R.id.two): {
    			current = textedView.getText().toString();
    			updated = current + "2";
    			textedView.setText(updated);
    			break;
    		}
    		case (R.id.three): {
    			current = textedView.getText().toString();
    			updated = current + "3";
    			textedView.setText(updated);
    			break;
    		}
    		case (R.id.four): {
    			current = textedView.getText().toString();
    			updated = current + "4";
    			textedView.setText(updated);
    			break;
    		}
    		case (R.id.five): {
    			current = textedView.getText().toString();
    			updated = current + "5";
    			textedView.setText(updated);
    			break;
    		}
    		case (R.id.six): {
    			current = textedView.getText().toString();
    			updated = current + "6";
    			textedView.setText(updated);
    			break;
    		}
    		case (R.id.seven): {
    			current = textedView.getText().toString();
    			updated = current + "7";
    			textedView.setText(updated);
    			break;
    		}
    		case (R.id.eight): {
    			current = textedView.getText().toString();
    			updated = current + "8";
    			textedView.setText(updated);
    			break;
    		}
    		case (R.id.nine): {
    			current = textedView.getText().toString();
    			updated = current + "9";
    			textedView.setText(updated);
    			break;
    		}
    		case (R.id.zero): {
    			current = textedView.getText().toString();
    			updated = current + "0";
    			textedView.setText(updated);
    			break;
    		}
    		case (R.id.slash): {
    			boolean check;
    			if (textedView.getText().toString().equals("Enter Fraction") || 
    	        		textedView.getText().toString().equals("Invalid Input") ||
    	        		textedView.getText().toString().equals("")){
    				check = false;
    	        }
    			else {check = true;}
    			
    			if(sla && check){
	    			current = textedView.getText().toString();
	    			updated = current + "/";
	    			textedView.setText(updated);
	    			sla = false;
    			}
    			break;
    		}
    		
    		case (R.id.equals): {
    			if (textedView.getText().toString().equals("Enter Fraction") || 
    	        		textedView.getText().toString().equals("Invalid Input") ||
    	        		textedView.getText().toString().equals("")){
		    			if(div){
		    	        	subFraction = Fraction.parseFractions("0");
		    			}
		    			else{
		    				subFraction = Fraction.parseFractions("1");
		    			}
    	        }
    	        else{
    			 userFraction = textedView.getText().toString();
    			 subFraction = Fraction.parseFractions(userFraction);
    	        }
    			 operations.setText("~");
     			 textedView.setText("");
     			 
     			 
     			 if(!plus){
     				 mainFraction.add(subFraction);
        			 if(mainFraction.errorZero()){
        				 onClickEvent(buttonClr);
        				 answers.setText("E: /0");
        				 mainFraction.setNumerator(0);
        				 mainFraction.setDenominator(1);
        			 }
     			 }
     			 else if(!multi){
     				 mainFraction.multiply(subFraction);
        			 if(mainFraction.errorZero()){
        				 onClickEvent(buttonClr);
        				 answers.setText("E: /0");
        				 mainFraction.setNumerator(0);
        				 mainFraction.setDenominator(1);
        			 }
     				 
     			 }
     			 else if(!div){
     				 mainFraction.divide(subFraction);
        			 if(mainFraction.errorZero()){
        				 onClickEvent(buttonClr);
        				 answers.setText("E: /0");
        				 mainFraction.setNumerator(0);
        				 mainFraction.setDenominator(1);
        			 }
     			 }
     			 else if(!sub){
     				 mainFraction.subtract(subFraction);
        			 if(mainFraction.errorZero()){
        				 onClickEvent(buttonClr);
        				 answers.setText("E: /0");
        				 mainFraction.setNumerator(0);
        				 mainFraction.setDenominator(1);
        			 }
     			 }
     			 if (proper)
    					answers.setText(mainFraction.improper().toString());
    			 else
     		        	answers.setText(mainFraction.proper().toString());
     			 
     			 sla = true;
    		     div = true;
    			 multi = true;
    			 plus= true;
    			 sub = true;
    			break;
    		}
    		
    		
    		
    		case (R.id.add): {
    	        if (textedView.getText().toString().equals("Enter Fraction") || 
    	        		textedView.getText().toString().equals("Invalid Input") ||
    	        		textedView.getText().toString().equals("")){
    	        	subFraction = Fraction.parseFractions("0");
    	        }
    	        else{
    			 userFraction = textedView.getText().toString();
    			 subFraction = Fraction.parseFractions(userFraction);
    	        }
    			 operations.setText("+");
     			 textedView.setText("");
     			 mainFraction.add(subFraction);
     			 sla = true;
    		     div = true;
    			 multi = true;
    			 plus= false;
    			 sub = true;
    			 
    			 if(mainFraction.errorZero()){
    				 onClickEvent(buttonClr);
    				 answers.setText("E: /0");
    				 mainFraction.setNumerator(0);
    				 mainFraction.setDenominator(1);
    			 }
    			 else{
    				 gcd = mainFraction.GCD(mainFraction.denominator, mainFraction.numerator);
    				 if (gcd != 0)
     		         {
     		            mainFraction.setNumerator(mainFraction.numerator/gcd);
     		            mainFraction.setDenominator(mainFraction.denominator/gcd);
     		         }
    				mainFraction.negativeNumerator();
    				if (proper)
    					answers.setText(mainFraction.improper().toString());
    				else
     		        	answers.setText(mainFraction.proper().toString());
     		        }
    			break;
    		}
    		
    		case (R.id.subtract): {
    			
    			if (textedView.getText().toString().equals("Enter Fraction") || 
    	        		textedView.getText().toString().equals("Invalid Input") ||
    	        		textedView.getText().toString().equals("")){
    	        	subFraction = Fraction.parseFractions("0");
    	        }
    	        else{
    			 userFraction = textedView.getText().toString();
    			 subFraction = Fraction.parseFractions(userFraction);
    	        }
    			 operations.setText("-");
     			 textedView.setText("");
     			 mainFraction.subtract(subFraction);
     			 sla = false;
    		     div = true;
    			 multi = true;
    			 plus= true;
    			 sub = true;
    			 
    			 if(mainFraction.errorZero()){
    				 onClickEvent(buttonClr);
    				 answers.setText("E: /0");
    				 mainFraction.setNumerator(0);
    				 mainFraction.setDenominator(1);
    			 }
    			 else{
    				 gcd = mainFraction.GCD(mainFraction.denominator, mainFraction.numerator);
    				 if (gcd != 0)
     		         {
     		            mainFraction.setNumerator(mainFraction.numerator/gcd);
     		            mainFraction.setDenominator(mainFraction.denominator/gcd);
     		         }
    				mainFraction.negativeNumerator();
    				if (proper)
    					answers.setText(mainFraction.improper().toString());
    				else
     		        	answers.setText(mainFraction.proper().toString());
     		        }
    			break;
    		}
    		case (R.id.multiply): {
    			if (textedView.getText().toString().equals("Enter Fraction") || 
    	        		textedView.getText().toString().equals("Invalid Input") ||
    	        		textedView.getText().toString().equals("")){
    	        	subFraction = Fraction.parseFractions("0");
    	        }
    	        else{
    			 userFraction = textedView.getText().toString();
    			 subFraction = Fraction.parseFractions(userFraction);
    	        }
    			 operations.setText("x");
     			 textedView.setText("");
     			 mainFraction.multiply(subFraction);
     			 sla = true;
    		     div = true;
    			 multi = false;
    			 plus= true;
    			 sub = true;
    			 
    			 if(mainFraction.errorZero()){
    				 onClickEvent(buttonClr);
    				 answers.setText("E: /0");
    				 mainFraction.setNumerator(0);
    				 mainFraction.setDenominator(1);
    			 }
    			 else{
    				 gcd = mainFraction.GCD(mainFraction.denominator, mainFraction.numerator);
    				 if (gcd != 0)
     		         {
     		            mainFraction.setNumerator(mainFraction.numerator/gcd);
     		            mainFraction.setDenominator(mainFraction.denominator/gcd);
     		         }
    				mainFraction.negativeNumerator();
    				if (proper)
    					answers.setText(mainFraction.improper().toString());
    				else
     		        	answers.setText(mainFraction.proper().toString());
     		        }
    			break;
    		}
    		case (R.id.negate): {
    			if (textedView.getText().toString().equals("Enter Fraction") || 
    	        		textedView.getText().toString().equals("Invalid Input") ||
    	        		textedView.getText().toString().equals("")){
    				 
	       			 updated = "-";
	       			 textedView.setText(updated);
	    				
    	        }
    			else{
    				mainFraction.setNumerator(mainFraction.getNumerator() * -1);
    				mainFraction.negativeNumerator();
    				if (proper)
    					answers.setText(mainFraction.improper().toString());
    				else
     		        	answers.setText(mainFraction.proper().toString());
    			}
    			break;
    		}
    		case (R.id.clear): {
    			if (textedView.getText().toString().equals("Enter Fraction") || 
    	        		textedView.getText().toString().equals("Invalid Input") ||
    	        		textedView.getText().toString().equals("")){
    				answers.setText("0");
    				mainFraction.setNumerator(0);
	    			updated = "";
	    			textedView.setText(updated);
    	        }
    			else{
	    			updated = "";
	    			textedView.setText(updated);
    			}
    			sla=true;
    			break;
    		}
    		case (R.id.reciprocal): {
    			 mainFraction.reciprocal();
    			 if(mainFraction.errorZero()){
    				 onClickEvent(buttonClr);
    				 answers.setText("E: /0");
    				 mainFraction.setNumerator(0);
    				 mainFraction.setDenominator(1);
    			 }
    			 else{
    				gcd = mainFraction.GCD(mainFraction.denominator,mainFraction.numerator);
     		        if (gcd != 0)
     		        {
     		            mainFraction.setNumerator(mainFraction.numerator/gcd);
     		            mainFraction.setDenominator(mainFraction.denominator/gcd);
     		        }
     		        mainFraction.negativeNumerator();
     		       if (proper)
   					answers.setText(mainFraction.improper().toString());
     		       else
    		        answers.setText(mainFraction.proper().toString());
    			 }
    			
    			break;
    		}
    		case (R.id.proper): {
    			
    			if(proper){
    				answers.setText(mainFraction.proper());
    				proper = false;
    			}
    			else{
    				answers.setText(mainFraction.improper());
    				proper = true;
    			}
    	   
    			
    			
    			break;
    		}
    		case (R.id.divide): {
    			if (textedView.getText().toString().equals("Enter Fraction") || 
    	        		textedView.getText().toString().equals("Invalid Input") ||
    	        		textedView.getText().toString().equals("")){
    	        	subFraction = Fraction.parseFractions("1");
    	        }
    	        else{
    			 userFraction = textedView.getText().toString();
    			 subFraction = Fraction.parseFractions(userFraction);
    	        }
    			 operations.setText("÷");
     			 textedView.setText("");
     			 mainFraction.divide(subFraction);
     			 sla = true;
    		     div = false;
    			 multi = true;
    			 plus= true;
    			 sub = true;
    			 
    			 if(mainFraction.errorZero()){
    				 onClickEvent(buttonClr);
    				 answers.setText("E: /0");
    				 mainFraction.setNumerator(0);
    				 mainFraction.setDenominator(1);
    			 }
    			 else{
    				 gcd = mainFraction.GCD(mainFraction.denominator, mainFraction.numerator);
    				 if (gcd != 0)
     		         {
     		            mainFraction.setNumerator(mainFraction.numerator/gcd);
     		            mainFraction.setDenominator(mainFraction.denominator/gcd);
     		         }
    				mainFraction.negativeNumerator();
    				if (proper)
    					answers.setText(mainFraction.improper().toString());
    				else
     		        	answers.setText(mainFraction.proper().toString());
     		        }
    			break;
    		}
    		default: textedView.setText("Invalid Input");break;
    	}
    	
    	
    	
    	
    }
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calculator, menu);
        return true;
    }

    
}




/*
//switch determines which option user entered and allows user to change mainFraction
switch (option)
{
    //addition
    case 1:
        //user uses add method in Fractions class
        System.out.print("   >");
        String userFraction = kbd.nextLine();
        //if parseFractions method returns null then error is displayed
        //takes user back to menu
        if (Fractions.parseFractions(userFraction) == null)
            System.out.println("Invalid Input");
        //if user input is valid then calculations are made
        else
        {
        // sets a reference to the new Fraction instance created by user input
        subFractions = Fractions.parseFractions(userFraction);
        //calls add method and adds users inputed fraction to the mainFraction
        mainFraction.add(subFractions);
        //checks for zero in denominator
        mainFraction.errorZero();
        //finds greatest common denominator
        //simplifies fraction if needed and if denominator doesnt equal 0
        gcd = mainFraction.GCD(mainFraction.denominator,mainFraction.numerator);
        if (gcd != 0)
        {
            mainFraction.setNumerator(mainFraction.numerator/gcd);
            mainFraction.setDenominator(mainFraction.denominator/gcd);
        }
        //checks for negative denominator and switches it to numerator using method in Fractions
        mainFraction.negativeNumerator();
        //displays correct output depending on users preference for proper or improper
        if (properOrImproper)
            System.out.println(mainFraction.improper());
        else
            System.out.println(mainFraction.proper());
        }
        System.out.println();
        break;

    //subtract
    case 2:
        //works just the same as add method but uses subtract() method instead
        System.out.print("   >");
        String userFraction1 = kbd.nextLine();
        if (Fractions.parseFractions(userFraction1) == null)
            System.out.println("Invalid Input");
        else
        {
        subFractions = Fractions.parseFractions(userFraction1);
        mainFraction.subtract(subFractions);
        mainFraction.errorZero();
        gcd = mainFraction.GCD(mainFraction.denominator,mainFraction.numerator);
        if (gcd != 0)
        {
            mainFraction.setNumerator(mainFraction.numerator/gcd);
            mainFraction.setDenominator(mainFraction.denominator/gcd);
        }
        mainFraction.negativeNumerator();
        if (properOrImproper)
            System.out.println(mainFraction.improper());
        else
            System.out.println(mainFraction.proper());
        }
        System.out.println();
        break;

    //multiply
    case 3:
        //works same as add method, uses multiply() method instead
        System.out.print("   >");
        String userFraction2 = kbd.nextLine();
        if (Fractions.parseFractions(userFraction2) == null)
            System.out.println("Invalid Input");
        else
        {
        subFractions = Fractions.parseFractions(userFraction2);
        mainFraction.multiply(subFractions);
        mainFraction.errorZero();
        gcd = mainFraction.GCD(mainFraction.denominator,mainFraction.numerator);
        if (gcd != 0)
        {
            mainFraction.setNumerator(mainFraction.numerator/gcd);
            mainFraction.setDenominator(mainFraction.denominator/gcd);
        }
        mainFraction.negativeNumerator();
        if (properOrImproper)
            System.out.println(mainFraction.improper());
        else
            System.out.println(mainFraction.proper());
        }
        System.out.println();
        break;

    //divide
    case 4:
        //works just as the add,subtract and multiply method, uses divide()method instead
        System.out.print("   >");
        String userFraction3 = kbd.nextLine();
        if (Fractions.parseFractions(userFraction3) == null)
            System.out.println("Invalid Input");
        else
        {
        subFractions = Fractions.parseFractions(userFraction3);
        mainFraction.divide(subFractions);
        mainFraction.errorZero();
        gcd = mainFraction.GCD(mainFraction.denominator,mainFraction.numerator);
        if (gcd != 0)
        {
            mainFraction.setNumerator(mainFraction.numerator/gcd);
            mainFraction.setDenominator(mainFraction.denominator/gcd);
        }
        mainFraction.negativeNumerator();
        if (properOrImproper)
            System.out.println(mainFraction.improper());
        else
            System.out.println(mainFraction.proper());
        }
        System.out.println();
        break;

    //reciprocal
    case 5:
        //simply switches numerator and denominator using reciprocal method in Fraactions
        //check if denominator is zero and if can simplify
        //checks for negative denominator and outputs to user preference
        mainFraction.reciprocal();
        mainFraction.errorZero();
        gcd = mainFraction.GCD(mainFraction.denominator,mainFraction.numerator);
        if (gcd != 0)
        {
            mainFraction.setNumerator(mainFraction.numerator/gcd);
            mainFraction.setDenominator(mainFraction.denominator/gcd);
        }
        mainFraction.negativeNumerator();
        if (properOrImproper)
            System.out.println(mainFraction.improper());
        else
            System.out.println(mainFraction.proper());
        System.out.println();
        break;

    //clear
    case 6:
        //sets the mainFraaction back to original numerator =0 and denominator =1
        //displaays cleared fraction
        mainFraction.setNumerator(0);
        mainFraction.setDenominator(1);
        if (properOrImproper)
            System.out.println(mainFraction.improper());
        else
            System.out.println(mainFraction.proper());
        System.out.println();
        break;

    //reverse sign
    case 7:
        //simply makes numerator negative or positive by running switchsign() method in Fracitons
        mainFraction.switchsign();
        mainFraction.negativeNumerator();
        if (properOrImproper)
            System.out.println(mainFraction.improper());
        else
            System.out.println(mainFraction.proper());
        System.out.println();
        break;

    //proper
    case 8:
        //sets properOrImproper to false causing all fractions to output in proper form
        properOrImproper = false;
        System.out.println(mainFraction.proper());
        System.out.println();
        break;

    //improper
    case 9:
        //sets properOrImproper to true causing all fractions to output in improper form
        properOrImproper = true;
        System.out.println(mainFraction.improper());
        System.out.println();
        break;

    //quit
    case 10:
        //exits loop and displays ?? like the specs
        System.out.println("Goodbye");
        exit = false;
        break;

    //Error message
    default:
        //if user's input is invalid they will get an error message
        System.out.println("Invalid Input");
        System.out.println();
        break;
}
}

}
}

*/