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
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
    // Write your code here
         int n = s.length();
         for (int i = 1; i <= n / 2; i++) 
         {
            String firstNum = s.substring(0, i);
             
            if (firstNum.length() > 1 && firstNum.charAt(0) == '0') 
                continue;
             
            long currentNum = Long.parseLong(firstNum);
            StringBuilder strb = new StringBuilder(firstNum);
             
             while (strb.length() < n) {
                currentNum++;
                strb.append(currentNum);
            }
             
            if (strb.toString().equals(s)) 
            {
                System.out.println("YES " + firstNum);
                return;
            }
         }
         System.out.println("NO");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}