package application;

import java.util.Scanner;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class FluentBMI{
	
	//3 DoubleProperty class member vars:
	DoubleProperty height = new SimpleDoubleProperty();
	DoubleProperty weight = new SimpleDoubleProperty();
	DoubleProperty bmi = new SimpleDoubleProperty();
	
	//method for caculating bmi
	void calcBMI() {
		
		//expression for calculating bmi using the 'fluent' approach +++++++++++++++++++++++++++++++++++++++++++++++++++++++
		bmi.bind(weight.multiply(703).divide(height.multiply(height))); //bmi = (weight * 703)/(height * height)
		
		//-------------
		//take in two numbers from user to calc bmi (twice due to loop):
		Scanner input = new Scanner(System.in); //create scanner obj
		
		for (int i=0;i<2;i++) {
			
			System.out.println("Enter weight in pounds: ");
			weight.set(input.nextInt()); //receive weight val
			System.out.println("Enter height in inches: ");
			height.set(input.nextInt()); //receive height val
			
			System.out.println("BMI is: " + bmi.get()); //show results
			System.out.println("****************");
		}
		
		input.close(); //CLOSE SCANNER - important! 
	}
	
	public static void main(String[] args) {
	
		//create an instance of this class, and invoke the 'calcBMI' method:
		FluentBMI fluentBMI = new FluentBMI();
		fluentBMI.calcBMI();
		
	}
	
	
}
