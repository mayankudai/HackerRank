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
     * Complete the 'decentNumber' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void decentNumber(int n) {
    // Write your code here
        
         int fives = n;
        int threes = 0;
        
        
        while (fives%3!=0) 
        {
            fives -= 5;
            threes += 5;
            if (fives < 0)
            {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i=0;i<fives;i++)
        {
            result.append("5");
        }
        for (int i=0;i<threes;i++)
        {
            result.append("3");
        }
        System.out.println(result.toString());


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                Result.decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
