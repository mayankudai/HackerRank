import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
    // Write your code here
        
        boolean flag = false;
        
         for(long i=p; i<=q; i++)
         {
             long square = i * i;
             String squareStr = String.valueOf(square);
             
             int d = String.valueOf(i).length();
             
             String rightPart = (squareStr.length() >= d ? squareStr.substring(squareStr.length()- d) : "0");
             String leftPart = squareStr.substring(0, squareStr.length()- d);
             
             long left = (leftPart.isEmpty() ? 0 : Long.parseLong(leftPart));
             long right = Long.parseLong(rightPart);
             
             if(left+right == i)
             {
                System.out.print(i+" ");
                flag = true;
            }
             
         }
         if (!flag) {
            System.out.println("INVALID RANGE");
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
