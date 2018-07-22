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
		long f;																	// factorial
				
		// user input loop
		do {
			
			System.out.println("Enter an integer between 0 and 20.");			// input prompt
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
				System.out.println();											// print new line
				
			} else {
			
				// check for integer input
				try {
					
				    n = Integer.parseInt(input);								// copy input to number variable
				    
				} catch (NumberFormatException e) {
					
					n = -1;														// set input to invalid number
					
				}
				
				// check for valid input range
				if (0 <= n && n <= 20) {
					
					// check recursive/iterative mode
					if (r) f = rFactorial(n);									// solve recursively
					else f = factorial(n);										// solve iteratively
						
					System.out.println(n + "! = " + f);							// print results
					
				} else System.out.println("Invalid input.");					// invalid input prompt
				
				System.out.println();											// print new line
				
			}

		} while (!(q));															// check for termination
		
		in.close();																// close input
		
	}

	/**
	 * This method iteratively determines the factorial of a given number.
	 * 
	 * @param n number to get the factorial for
	 * @return factorial of the given number
	 */
	private static long factorial(int n) {
		
		int c = 1;																// counter
		long f = 1;																// factorial
		long t;																	// temporary number to hold the value of previous number factorial
		
		while (c <= n) {
			
			t = f;																// copy current factorial to temporary variable
			f = t * c;															// multiply factorial by count
			c ++;																// increment count
			
		}
		
		return f;																// return factorial
		
	}
	
	/**
	 * This method recursively determines the factorial of a given number.
	 * 
	 * @param n number to get the factorial for
	 * @return factorial of the given number
	 */
	private static long rFactorial(int n) {
		
		if (n >= 1) return n * rFactorial(n-1);									// multiply input by previous factorial
		else return 1;															// return 1 for 0 and 1
		
	}
	
}
