//a program to calculate sum, difference, product, and quotient of 2 double numbers which are entered by users.
import java.util.Scanner;
public class Exercise225 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double number_1 = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter the second number: ");
        double number_2 = Double.parseDouble(scanner.nextLine());
        System.out.println("The sum of two number is: " + (number_1 + number_2));
        System.out.println("The difference of two number is: " + (number_1 - number_2));
        System.out.println("The product of two number is: " + (number_1 * number_2));
        System.out.println("The quotient of two number is: " + (number_1 / number_2));
    }
}
