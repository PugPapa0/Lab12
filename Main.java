/********************************************
 *	AUTHOR:	Travis Becker
 * COLLABORATORS:
 *	LAST MODIFIED:
 ********************************************/

/********************************************
 *	Quipu
 *********************************************
 *	PROGRAM DESCRIPTION:
 *	A user enters a number between 0 and 999
 *	and this program displays the number as a digital quipu.
 *********************************************
 *	ALGORITHM:
 *	- Get user input
 *	- Validate input is between 0 and 999
 *	- Split number into hundreds, tens, ones
 *	- Display quipu representation
 *	- Repeat until user chooses to quit
 *********************************************/


public class Main
{

  /***** CONSTANT SECTION *****/

  public static final int WIDTH = 30;


  public static void main(String[] args)
  {
    /***** DECLARATION SECTION *****/

    int number;
    int hundreds;
    int tens;
    int ones;
    char again;


    /***** INITIALIZATION SECTION *****/

    again = 'Y';


    /***** INTRO SECTION *****/

    System.out.println("Hello! This program turns any whole number between 0 and 999 into a digital Quipu.");


    /***** INPUT + PROCESSING + OUTPUT SECTION *****/

    while(again == 'Y')
    {

      do
      {
        number = UtilityBelt.readInt("\nPlease enter a number between 0 and 999: ", -9999, 9999);

        if(number < 0 || number > 999)
        {
          System.out.println("ERROR: please enter value between 0 - 999");
        }

      } while(number < 0 || number > 999);


      hundreds = number / 100;
      tens = (number / 10) % 10;
      ones = number % 10;


      System.out.println();

      System.out.println("Hundreds   = " + hundreds);
      System.out.println("Tens       = " + tens);
      System.out.println("Ones       = " + ones);


      System.out.println("\nYour quipu:");

      printQuipu(hundreds, tens, ones);


      again = UtilityBelt.readChar("\nWould you like to make another quipu? [Y/N]: ", "YNyn");

      again = Character.toUpperCase(again);

    }


    System.out.println("\nGoodbye!");

  }


  /***** STATIC METHODS *****/


  /**
   * Prints vertical knots represented by a number.
   *
   * @param knots number of knots to display
   */
  public static void printKnots(int knots)
  {
    for(int i = 0; i < knots; i++)
    {
      UtilityBelt.printCentered(WIDTH, "*");
    }
  }



  /**
   * Prints a digital quipu using hundreds, tens, and ones places.
   *
   * @param hundreds number of hundreds knots
   * @param tens number of tens knots
   * @param ones number of ones knots
   */
  public static void printQuipu(int hundreds, int tens, int ones)
  {

    UtilityBelt.printCentered(WIDTH, "---");


    UtilityBelt.printCentered(WIDTH, "|");


    printKnots(hundreds);


    UtilityBelt.printCentered(WIDTH, "|");


    printKnots(tens);


    UtilityBelt.printCentered(WIDTH, "|");


    printKnots(ones);


    UtilityBelt.printCentered(WIDTH, "|");


    UtilityBelt.printCentered(WIDTH, "‾");

  }

}