import java.util.Scanner;

/**
 * 
 * @author Shayan
 * 
 * This program calculates the factorial for any integer between 0 and 20.
 * The user can toggle between recursive and iterative mode to get the factorial either recursively or iteratively.
 *
 */
public class Factorial
{
	public static void main(String[] args)
	{
		// initialize variables
		boolean q = false;														// program state
		boolean r = false;														// recursive/iterative mode
		Scanner in = new Scanner(System.in);									// input scanner
		String input;															// user input
		
		int n;																	// number to be processed
		int c;																	// counter
		long f;																	// factorial
		long t;																	// temporary number to hold the value of previous number factorial
				
		// user input loop
		do {

			// reset variables
			c = 1;																// reset count
			f = 1;																// reset factorial
			t = 1;																// reset temporary variable
			n = -1;																// reset input number
			
			System.out.println("Enter an integer between 0 and 20. ");			// input prompt
			System.out.println("Enter \"r\" to toggle between recursive and iterative mode");
			System.out.println("Enter \"q\" to quit: ");
			System.out.println();												// print new line
					
			input = in.nextLine();												// record user input
			System.out.println();												// print new line
			
			// check for program termination input
			if (input.equals("q")) {
				
				q = true;														// change program state to program termination
				System.out.println("Program terminated.");						// program termination prompt
				
			} else if (input.equals("r")) {
				
				r = !(r);														// toggle recursive/iterative mode
				
				if (r) System.out.println("Recursive mode");					// check and display mode
				else System.out.println("Iterative mode");
				
				System.out.println();
				
			} else {
			
				// check for integer input
				try {
					
				    n = Integer.parseInt(input);								// copy input to number variable
				    
				} catch (NumberFormatException ex) {
					
					n = -1;														// set input to invalid number
					
				}
				
				// check for valid input range
				if (0 <= n && n <= 20) {
					
					// check recursive/iterative mode
					if (r) {

						f = factorial(n);										// solve recursively
						
					} else {
						
						// iteration count
						while (c <= n) {
							
							t = f;												// copy current factorial to temporary variable
							f = t * c;											// multiply factorial by count
							c ++;												// increment count
						}
						
					}
					
					System.out.println(n + "! = " + f);							// print results
					System.out.println();										// print new line
					
				} else {
					
					System.out.println("Invalid input.");						// invalid input prompt
					System.out.println();										// print new line
				}
				
			}

		} while (!(q));															// check for termination
		
		in.close();																// close input
		
	}
	
	/**
	 * This method recursively determines the factorial of a given number.
	 * 
	 * @param n number to get the factorial for
	 * @return factorial of the given number
	 */
	private static long factorial(int n) {
		
		if (n >= 1) return n * factorial(n-1);
		else return 1;
		
	}
	
}
