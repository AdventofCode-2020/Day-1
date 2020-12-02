import java.io.*;
import java.util.*;

public class Advent2020_Day_1 {

    public static final int SUM = 2020;

    public static void main (String[] args) throws IOException {
        String fileName = "input";
        int [] expenses = getArray(fileName);
        //int result = getResult(expenses);
        int result = getResult2(expenses);
        if (result == -1)
            System.out.println("There was no answer.");
        else
            System.out.println("The product is: " + result);
    }

    public static int getLength (String fileName) throws IOException {
        int length = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        while (bufferedReader.readLine() != null) {
            length++;
        }
        bufferedReader.close();
        return length;
    }

    public static int[] getArray (String fileName) throws IOException {
        File file = new File(fileName);
        Scanner input = new Scanner(file);;

        int length = getLength(fileName);
        int [] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = input.nextInt();
        }
        return arr;
    }

    public static int getResult (int[] arr) {
        int result = 0;
        int left = 0;
        int right = arr.length - 1;
        Arrays.sort(arr);
        while (arr[left] < arr[right]) {
            int temp = arr[right] + arr[left];
            if (temp == SUM) {
                result = arr[right] * arr[left];
                return result;
            } else if (temp < SUM)
                left++;
            else
                right--;
        }
        return -1;
    }

    public static int getResult2 (int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                if (set.contains(SUM - arr[i] - arr[j])) {
                    System.out.println(arr[i] + ", " + arr[j] + ", " + (SUM - arr[i] - arr[j]));
                    return arr[i] * arr[j] * (SUM - arr[i] - arr[j]);
                }
                else
                    set.add(arr[j]);
            }
        }
        return -1;
    }
}
