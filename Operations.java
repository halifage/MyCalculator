import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// perform operations on a math string

public class Operations {

	public double multiNums(ArrayList<String> ops) {

		double result = Double.parseDouble(ops.get(0)); // Assign first element of list to result

		// Loop through math string looking for operand and perform appropriate operations.
		for(int x = 1; x < ops.size(); x++){

			String item = ops.get(x);

			switch(item) {

			case "/":
				result /= Double.parseDouble(ops.get(x+1));
				break;
			case "*":
				result *= Double.parseDouble(ops.get(x+1));
				break;	
			case "+":
				result += Double.parseDouble(ops.get(x+1));
				break;
			case "-":
				result -= Double.parseDouble(ops.get(x+1));
				break;
			}

		}
		System.out.println("The result is: " + result); //Print result.
		return result;
	}

	
	
	public ArrayList<String> opsList(String input) {
	// extract all operands of the operation to an iterable list
		
		String regex = "[+\\-*/]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matches = pattern.matcher(input);
		ArrayList<String> signs =  new ArrayList<String>();
		
		while(matches.find()) {
			signs.add(matches.group());
		}
		return signs;
	}
	
	
	
	public ArrayList<String> numList(String input){
	// Extract numbers of the operation to an iterable list
		
		ArrayList<String> array = new ArrayList<String>();
		String[] list = input.split("[+\\-*/]");
		
		for(String item:list) {
			array.add(item);
		}
		return array;	
	}
	
	

	public ArrayList<String> formatInput(ArrayList<String> numbers, ArrayList<String> signs){
	// Rebuild the operation (math string input by user) by inserting 
		int i = 1;
		
		for(Object item:signs) {
			numbers.add(i,(String)item);
			i+=2;
		}
		return numbers;
	}

	
	
	public ArrayList<String> afterPrecedence(ArrayList<String> ops){
		// add arithmetic precedence rule for '/', '*', '+', '-'
		
		ArrayList<String> array = new ArrayList<String>();
		double result = 0;
		
		for(int i = 0; i < ops.size(); i++) {
			if((i+1< ops.size()) && (ops.get(i+1).equals("/"))){
				result =  Double.parseDouble((String) ops.get(i)) / Double.parseDouble((String) ops.get(i+2)); 
				ops.set(i+2,String.valueOf(result));
				i+=1;
			}else if((i+1< ops.size()) && (ops.get(i+1).equals("*"))){
				result =  Double.parseDouble((String) ops.get(i)) * Double.parseDouble((String) ops.get(i+2)); 
				ops.set(i+2,String.valueOf(result));
				i+=1;
			}else {
				array.add((String)ops.get(i));
			}
		}
		System.out.println("After precedence : " + array);
		return array;
	}
}
