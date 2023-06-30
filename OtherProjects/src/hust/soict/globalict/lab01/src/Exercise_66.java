import java.util.Scanner;
public class Exercise_66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of row: ");
        int m = scanner.nextInt();
        System.out.print("Number of col: ");
        int n = scanner.nextInt();
        int[][] arr1 = new int[m][n];
        int[][] arr2 = new int[m][n];
        int[][] res = new int[m][n];
        System.out.println("Enter array 1: ");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr1[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter array 2: ");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr2[i][j] = scanner.nextInt();
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        System.out.println("Result: ");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(res[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
