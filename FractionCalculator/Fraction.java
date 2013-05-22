package calculator.fractions;

//Bobby Bounvichit
//March 30 2010
//Fractions class will hold instance of a fraction and accumulate according to user.


public class Fraction
{
  //public integer fields numerator and denominator, an instance of fraction will hold each.
  public int numerator;
  public int denominator;

  //constructor sets numerator to 0 and denominator to 1
  public Fraction()
  {
      numerator = 0;
      denominator=1;
  }

  //Constructor that initializes numerator and denominator to parameter integers a,b.
  public Fraction(int a, int b)
  {
      numerator = a;
      denominator = b;
  }
  //method to switch the negative to the numerator
  //simply will multiply both numerator and denominator by -1
  public void negativeNumerator()
  {
      if (denominator<0)
      {
          this.numerator = numerator*-1;
          this.denominator = denominator*-1;
      }
  }
  //method to check if user inputed a zero for denominator
  //use of System.exit(1);
  public boolean errorZero()
  {
      if(denominator==0)
      {
          return true;
      }
      return false;
  }

  //get and set methods for both numerator and denominator
  public int getNumerator()
  {
      return numerator;
  }
  public int getDenominator()
  {
      return denominator;
  }
  public void setNumerator(int c)
  {
      numerator = c;
  }
  
  
  //will check if user tries to make denominator 0.  if so then it will print Error
  public void setDenominator(int d)
  {
      if (errorZero())
          denominator=1;
      else
          denominator = d;
  }
  //method that will calculate GCD
  //according to pseudocode in specs.
  
  
  public int GCD(int e,int f)
  {
      // a and b are both positive
      int remainder;
      int max;
      int min;

      // ifelse statements determine whether a or b should be max
      if (e<=f)
      {
          max = f;
          min = e;
      }
      else
      {
          max = e;
          min = f;
      }


      //do while loop does calculations in order to find GCD of both numbers
      do
      {
          if (min == 0)
              remainder = 0;
          else
              remainder = max%min;

          if (remainder != 0)
          {
              max = min;
              min = remainder;
          }
      }while (remainder != 0);
      //returns min which is greatest common denominator
      return min;
  }
  
  //method add will take another instance of Fractions and add it to the current instance.
  //all methods used fraction arithmetic learned in elementary school..
  //all methods will change current instance and hold new values for numerator and denominator
  public Fraction add(Fraction a)
  {
      this.numerator = this.numerator*a.denominator + a.numerator*this.denominator;
      this.denominator = this.denominator*a.denominator;
      return this;
  }
  
  //method will subtract current instance of Fractions new instance of Fractions
  public Fraction subtract(Fraction b)
  {
      this.numerator = this.numerator*b.denominator - b.numerator*this.denominator;
      this.denominator = this.denominator*b.denominator;
      return this;
  }
  
  //method multiplies current instance by another instance of Fractions
  public Fraction multiply(Fraction c)
  {
      this.numerator = this.numerator*c.numerator;
      this.denominator = this.denominator*c.denominator;
      return this;
  }
  
  //method multiplies current instance by reciprocal of another instane of Fractions
  //same arithmetic as dividing
  public Fraction divide(Fraction d)
  {
      this.numerator = this.numerator*d.denominator;
      this.denominator = this.denominator*d.numerator;
      return this;
  }
  
  //Switches numerator and denominator
  public Fraction reciprocal()
  {
      int swap = this.numerator;
      this.numerator = this.denominator;
      this.denominator = swap;

      return this;
      
  //turns Numerator to a negative or positive number.
  }
  public Fraction switchsign()
  {
      this.numerator = this.numerator*-1;
      return this;
  }


  /*
 This method takes a String representation of a (proper or improper)
 fraction and returns a corresponding instance of Fraction.  If the
 String is invalid null is returned.
*/

//copied this method from specs.  Takes userinput string and converts to an instance of Fraction
public static Fraction parseFractions(String input)
{
  boolean negative = input.charAt(0) == '-';     // negative value?
  int numberStartIndex = (negative ? 1 : 0);     // beginning of digits
  int spaceIndex = input.indexOf(' ');    // separates whole and frac parts
  int slashIndex = input.indexOf('/');
  int intPart = 0;                        // whole number part of the input
  if (slashIndex == -1)      // input is a whole number
  {
      try
      {
               // read input as a whole number: no fraction part
              intPart = Integer.parseInt(input.substring(numberStartIndex));
              if (negative)
                  intPart = -intPart;           // correct for sign
      }
      catch (NumberFormatException e)
      {
         return null;
      }
      return new Fraction(intPart, 1);   // whole number
   }
   int fractionStart = 0;       // where the fraction starts in input
   if (spaceIndex != -1)        // input is a whole number and a fraction
   {
       // read whole number part
       fractionStart = spaceIndex + 1;  // fraction part starts here
       try
       {
          intPart =
          Integer.parseInt(input.substring(numberStartIndex, spaceIndex));
       }
       catch (NumberFormatException e)
       {
          return null;
       }
   }
   // read the fraction part
   int num, denom;
   try
   {
       // read numerator
       if (input.charAt(fractionStart) == '-')
          fractionStart++;      // may have '-' if not a mixes fraction
       num = Integer.parseInt(input.substring(fractionStart, slashIndex));
   }
   catch (NumberFormatException e)
   {
       return null;
   }
   try
   {
      // read denominator
      denom = Integer.parseInt(input.substring(slashIndex + 1));
   }
   catch (NumberFormatException e)
   {
        return null;
   }
   int numerator = intPart*denom + num;      // total numerator
   if (negative)
      numerator = -numerator;                // correct sign if necessary
   return new Fraction(numerator, denom);
   }


//improper method is a toString method, will take instance and return a string representation
//if the numerator is zero display will be 0
//if the denominator is 1 then solely the numerator will be displayed
   public String improper()
   {
       int d = this.denominator;
       int n = this.numerator;
       if (n == 0)
           return Integer.toString(n);
       else if(d == 1)
           return Integer.toString(n);
       else
           return Integer.toString(n) + "/" + Integer.toString(d);

   }
   // proper is also a toString method that converts instance of Fraction to a proper fraction display string
   //made int wholeNumber to display the numerator / denominator
   //newN is the simplified numerator
   //just as the improper display, if numerator is 0 only 0 will be displayed
   //if whole Number is zero then the fraction is displayed without a wholenumber
   //if denominator is one then only numerator is displayed
   public String proper()
   {
       int d = this.denominator;
       int n = this.numerator;
       int wholeNumber = n/d;
       int newN = n%d;
       if (n == 0)
           return Integer.toString(n);
       else if(wholeNumber ==0)
           return Integer.toString(newN) + "/" + Integer.toString(d);
       else if(d == 1)
           return Integer.toString(n);
       else if(newN<0)
           return Integer.toString(wholeNumber) + " " + Integer.toString(newN*-1)
                   + "/" + Integer.toString(d);
       else
           return Integer.toString(wholeNumber) + " " + Integer.toString(newN)
                   + "/" + Integer.toString(d);

   }
}