import javax.swing.JOptionPane;
public class CalculateNumber {
    public static void main(String[] args ) {
        String strNum1, strNum2;
        String strNofication = "Your ansers:\n ";
        double Num1,Num2;
        strNum1= JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        Num1 = Double.parseDouble(strNum1);
        Num2 = Double.parseDouble(strNum2);
        double sum = Num1 + Num2;
        strNofication +="Sum: "+  sum;
        double difference = Num1 - Num2;
        strNofication += "\nDifference: " + difference;
        double multiple = Num1 * Num2;
        strNofication += "\nMultiple: " + multiple;
        if (Num2 == 0)  strNofication += "\nThe divisor is error!";
        else strNofication += "\nDivision: " + (Num1/Num2);

        JOptionPane.showMessageDialog(null, strNofication,"The ansers ",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}