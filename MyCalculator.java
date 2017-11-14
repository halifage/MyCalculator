import java.util.ArrayList;
import java.util.Scanner;


public class MyCalculator {

	public static void main(String[] args) {
		//Get user input for the operation to perform and display it

		int x = 1;

				do{

					try {
						Scanner scan = new Scanner(System.in);
						System.out.println("Please enter an operation:");
						String input = scan.next();
//						scan.close();

						Operations calc = new Operations();

						ArrayList<String> nums = calc.numList(input);

						ArrayList<String> signs = calc.opsList(input);

						ArrayList<String> operationList = calc.formatInput(nums, signs);

						ArrayList<String> finalOp= calc.afterPrecedence(operationList); 

						calc.multiNums(finalOp); // This is where the magic happens :)

						x++;
					}catch(Exception exception) {
						
						System.out.println("Invalid operation!"); 
									
						x=1;
					}

				}while(x==1);

	}
}






