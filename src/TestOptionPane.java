

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import client.BackEnd.Colors;

public class TestOptionPane {

	public static void main(String[] args) {
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 16));
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 13));
		UIManager.put("OptionPane.background", Colors.DARK_GRAY);
		UIManager.put("OptionPane.messageForeground", Colors.WHITE);
		UIManager.getLookAndFeelDefaults().put("Panel.background",  Colors.DARK_GRAY);
		UIManager.getLookAndFeelDefaults().put("TextField.background",  Colors.GRAY);
		UIManager.getLookAndFeelDefaults().put("TextField.border", null);
		UIManager.getLookAndFeelDefaults().put("TextField.foreground", Colors.WHITE);
		UIManager.getLookAndFeelDefaults().put("TextField.caretForeground", Colors.WHITE);
		UIManager.getLookAndFeelDefaults().put("Button.background", Colors.BLACK);
		UIManager.getLookAndFeelDefaults().put("Button.foreground", Colors.WHITE);
		UIManager.getLookAndFeelDefaults().put("Button.focus", Colors.BLACK);
		UIManager.getLookAndFeelDefaults().put("OptionPane.okButtonText", "<html><b style=\"color:#6BFF56;\">OK");
		UIManager.getLookAndFeelDefaults().put("OptionPane.cancelButtonText", "<html><b style=\"color:#F34473;\">Cancel");
		
	
		// get user input from JOptionPane input dialogs
		String number1 = JOptionPane.showInputDialog("First number ? ");
		String number2 = JOptionPane.showInputDialog("Second number ? ");

		try {
		
		// convert String inputs to Integers to use in calculation
		int n1 = Integer.parseInt(number1);
		int n2 = Integer.parseInt(number2);

		int mult = n1 * n2;
		
		// display result in a JOptionPane message dialog
		// first argument: if null, display the dialog box at the center of the screen
		// second argument: message to display
		// third argument: title bar text
		// fourth argument: type of message dialog to display		
		JOptionPane.showMessageDialog(null, "Multiplication of  " + n1 + " and " + n2 + " is: " 
										+ mult, "Multiplication of two numbers", JOptionPane.PLAIN_MESSAGE);

		} // end of try block
		catch(NumberFormatException e)
 		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Entered value not valid");
		}
	}
}
