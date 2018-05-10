import java.util.Scanner;

/**
 * 
 * @author Shayan
 * 
 * This program calculates the factorial for any integer between 0 and 20.
 *
 */
public class Factorial
{
	public static void main(String[] args)
	{
		// initialize variables
		boolean q = false;														// program state
		Scanner in = new Scanner(System.in);									// input scanner
		String input;															// user input
		
		int n;																	// number to be processed
		int c = 1;																// counter
		long f = 1;																// factorial
		long t;																	// temporary number to hold the value of previous number factorial
		
		// user input loop
		while (!(q)) {
			
			System.out.println("Enter an integer between 0 and 20. "			// input prompt
					+ "Enter \"q\" to quit: ");
			
			input = in.nextLine();												// record user input
			
			// check for program termination input
			if (input.equals("q")) {
				
				q = true;														// change program state to program termination
				System.out.println("Program terminated.");						// program termination prompt
				
			} else {
			
				// check for integer input
				try {
					
				    n = Integer.parseInt(input);								// copy input to number variable
				    
				} catch (NumberFormatException ex) {
					
					n = -1;														// set input to invalid number
					
				}
				
				// check for valid input range
				if (0 <= n && n <= 20) {
					
					// iteration count
					while (c <= n) {
						
						t = f;													// copy current factorial to temporary variable
						f = t * c;												// multiply factorial by count
						c ++;													// increment count
					}

					System.out.println(n + "! = " + f);							// print results
					System.out.println();										// print new line
					
				} else {

					System.out.println("Invalid input.");						// invalid input prompt
					System.out.println();										// print new line
				}

				// reset variables
				c = 1;															// reset count
				f = 1;															// reset factorial
				t = 1;															// reset temporary variable
				n = -1;															// reset input number
				
			}

		}
		
		in.close();																// close input
		
	}
}
