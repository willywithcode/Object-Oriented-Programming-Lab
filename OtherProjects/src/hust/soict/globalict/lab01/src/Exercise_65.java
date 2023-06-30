import java.util.Arrays;
import java.util.Scanner;
public class Exercise_65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        System.out.println("Enter numbers: ");
        for(int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = arr[i];
                if (arr[i] > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i = 0; i < n; i++) sum += arr[i];
        String result = Arrays.toString(arr);
        System.out.println(result);
        System.out.println("Sum: " + sum);
        System.out.println(("Average: " + sum/n));
    }
}
