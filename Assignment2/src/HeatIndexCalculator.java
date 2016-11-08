//Alan Birmaher
//COP 3330-001
//Description:Given the real temperature and humidity this
//program tells the user what it feels like the temperature is.

//Import classes
import java.text.DecimalFormat;
import java.util.Scanner;

//Start of heatIndexCalculator class
public class HeatIndexCalculator {

	//Start of main
	public static void main(String[] args) {
		
		//Variables
		int temperature=0;
		double humidity=0;
		double heatIndex=0;
		
		//Create a scanner
		Scanner scanner = new Scanner (System.in);
		
		//Read in our temperature value
		System.out.println("Please enter the current temperature in degrees Fahrenheit:");
		temperature = scanner.nextInt();
		
		//Read in our humidity percentage
		System.out.println("Please enter the current humidity as a percentage:");
		humidity = scanner.nextDouble();
		
		//Do the calculations
		heatIndex=calculateHeatIndex(temperature, humidity);
		
		//Format heatIndex to 2 decimal places
		DecimalFormat format = new DecimalFormat("#.##"); 
		heatIndex= Double.valueOf(format.format(heatIndex)); 
		
		//Print the new value
		printHeatIndex(temperature, humidity, heatIndex);

	}
	
	//Setting up the calculateHeatIndex 
	public static double calculateHeatIndex(int currentTemp, double currentHumidity){
		
		//Variables
		final double c1= -42.379;
		final double c2= 2.04901523;
		final double c3 = 10.14333127;
		final double c4= -0.22475541;
		final double c5= -0.00683783;
		final double c6= -0.05481717;
		final double c7= 0.00122874;
		final double c8= 0.00085282;
		final double c9= -0.00000199;
		double heatIndex = 0;
		
		//Calculates the value for the heatIndex
		heatIndex+= c1+(c2*currentTemp)+(c3*currentHumidity)+(c4*currentTemp*currentHumidity);
		heatIndex+= (c5*currentTemp*currentTemp)+(c6*currentHumidity*currentHumidity);
		heatIndex+= (c7*currentTemp*currentTemp*currentHumidity);
		heatIndex+= (c8*currentTemp*currentHumidity*currentHumidity);
		heatIndex+= (c9*currentTemp*currentTemp*currentHumidity*currentHumidity);
		
		//Returns the heatIndex value
		return heatIndex;
	}
	
	//Setting up the printHeatIndex method
	public static void printHeatIndex(int currentTemp, double currentHumidity, double calculatedHeatIndex){
		
		//These two lines print our output
		System.out.println("At a temperature of " + currentTemp+"F and a humidity of "+currentHumidity+ "0 percent . . .");
		System.out.println("It actually feels like: "+calculatedHeatIndex+"F");
		
	}

}//End
