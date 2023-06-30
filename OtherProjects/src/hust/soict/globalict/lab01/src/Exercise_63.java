import java.util.Scanner;

// program to display a triangle with a height of n stars (*), n is entered by users.
public class Exercise_63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for(int k = 1; k <= 1 + 2*(n - i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
