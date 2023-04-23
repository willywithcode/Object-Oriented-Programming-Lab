import java.util.Scanner;
public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter matrix rows: ");
        int m = sc.nextInt();
        System.out.print("Enter matrix columns: ");
        int n = sc.nextInt();
        int[][] A = new int[m][n];
        int[][] B = new int[m][n];
        System.out.println("Enter matrix A:");
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                A[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter matrix B:");
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                B[i][j] = sc.nextInt();
            }
        }
        int[][] C = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        System.out.println("Matrix C: ");
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}