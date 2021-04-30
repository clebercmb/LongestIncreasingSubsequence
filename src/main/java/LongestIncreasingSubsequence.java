import com.sun.istack.internal.NotNull;

import java.util.Random;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("** Longest Increasing Subsequence of Random Numbers **");
        System.out.print("Enter a n number | 0 < n < 100: ");

        int n = readNumber(scan);

        int[] numbers = generateRandomNumbers(n);
        printNumbers(numbers);

        longestIncreasingSubsequence(numbers);

        scan.close();
        scan = null;



    }

    public static int[] generateRandomNumbers(int n) {
        Random random = new Random();

        return random.ints(n, 0, 100).toArray();
    }

    public static void printNumbers(int[] numbers) {
        for(int number : numbers) {
            System.out.printf("%d ",number);
        }
        System.out.println();
        System.out.println();
    }

    public static int readNumber(Scanner scan) {
        int n;
        do {
            n = scan.nextInt();

            if ( !(n>0 && n < 100) ) {
                System.out.println("You must enter a valid number! ");
            }
        } while( n < 1 || n >= 100 );
        return n;
    }

    private static void longestIncreasingSubsequence(@NotNull int[] numbers) {

        int indexInitial = 0;
        int maxCounter = 1;
        int counter = 1;
        int initial =0;
        for (int i=1; i < numbers.length; i++) {
            if( numbers[i] > numbers[i-1]  ) {
                counter++;
            } else {
                if (counter > maxCounter) {
                    maxCounter = counter;
                    indexInitial = initial;
                }

                initial = i;
                counter = 1;
            }
        }

        System.out.println("The longest increasing is:");

        for(int i = indexInitial; i <maxCounter+indexInitial; i++ ) {
            System.out.printf("%d ", numbers[i]);
        }
    }

}
