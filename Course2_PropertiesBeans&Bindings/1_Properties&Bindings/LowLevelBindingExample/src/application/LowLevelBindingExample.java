package application;
	
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class LowLevelBindingExample{ 
	
	 //create an integer PROPERTY (for holding squared values):
	IntegerProperty squareSide = new SimpleIntegerProperty();
	
	//create an integer BINDING (for 0
	IntegerBinding squareArea = new IntegerBinding() {
		
		//initialisation block for declaring computeValue()'s dependencies:
		{
			super.bind(squareSide); //only dependency is 'squareSide'
		}

		//is an interface, so implemented method needs overridden: 
		@Override
		protected int computeValue() {
			return squareSide.get() * squareSide.get(); //return squared value
		}
		
	};
	
	public static void main(String[] args) {
		
		LowLevelBindingExample llbe = new LowLevelBindingExample(); //create instance of class
		
		llbe.squareSide.set(5); //set IntegerProperty value to 5  
		System.out.println("square area is: " + llbe.squareArea.get()); //call squareArea binding
		
		//change value of squareSide & reprint:
		llbe.squareSide.set(2);  
		System.out.println("square area is: " + llbe.squareArea.get());
		
	}
	
}
