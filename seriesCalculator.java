import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;

public class seriesCalculator {
	private double firstTerm;
	private double commonRatio;
	private double precision;
	private double total;
	
	
	Scanner input = new Scanner (System.in);
	
	public void getValues (){
		
		System.out.println("First term: ");
		firstTerm = input.nextDouble(); 
		
		if (firstTerm == 0) {
			
			do {
				
				System.out.println("Error: first term can not be 0."); 
				System.out.println("First term: ");
				firstTerm = input.nextDouble();
				
			} while (firstTerm == 0);
			
		}
		//end of getting first term
		
		System.out.println("Common ratio: ");
		commonRatio = input.nextDouble();
		
		if (commonRatio > 1 || commonRatio < -1) {
			
			do {
				System.out.println("Error: common ratio must be between 1 and -1.");
				System.out.println("Common ratio: ");
				commonRatio = input.nextDouble();
				
			} while (commonRatio > 1 || commonRatio < -1);
			
		}
		//end of getting common ratio
		
		
		System.out.println("Precision: ");
		precision = input.nextDouble();
		
		if (precision < 0 ) {
			
			do {
				System.out.println("Error : precision must be greater than 0.");
				
				System.out.println("Precision: ");
				precision = input.nextDouble();
				
			} while (precision < 0);
			
		}
	}
	
	public void calculateSeries() {
		double term; 
		
		total = 0;
		term = firstTerm;
		
		while (term > precision || -term > precision) {
			
			total = total + term; 
			term = term * commonRatio;
			
		}
		
		
	}
	
	public void display () {
		
		int decimalPlaces; //will hold how many decimal places to round to
		int integer; // variable to help figure out what the index of the decimal is, in order to count the numbers that come after it and not all of the numbers
		String hashtagsForRounding = "";
		
		//To round to the same number of decimal places we need to figure 
		//out how many decimal places the precision number has
		
		//turning it into a string in order to use indexOf function to count digits after the decimal
		String precisionAsAString = Double.toString(precision);
		integer = precisionAsAString.indexOf('.'); //figuring out index of the decimal point
		decimalPlaces = precisionAsAString.length() - integer -1 ;// i noticed it had one too many decimal places so i had to subtract an extra 1 here for some reason 
		
		for (int x = 0; x < decimalPlaces; x++){
			
			hashtagsForRounding += "#";// i swear there's a # here WHAT ITS NOT SHOWING UP A POUND SIGN
			
					
		}//creating the decimal format to round to "decimalPlaces" decimalPlaces
		
		DecimalFormat thisFormat = new DecimalFormat ("0." + hashtagsForRounding);
		
		System.out.println(thisFormat.format(total));
		
	}
	
	
}
