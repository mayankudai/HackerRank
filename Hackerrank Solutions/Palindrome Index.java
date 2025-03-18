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
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
static boolean ispalin(String s, int first,int last)
        {
            for(int i=first,j=last;i<j;i++,j--)
            {
                if(s.charAt(i)!=s.charAt(j))
                    return false;
            }
            return true;
        }
    public static int palindromeIndex(String s) {
    // Write your code here
        
        
        for(int i=0,j=s.length()-1;i<j;i++,j--)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                if(ispalin(s,i+1,j))
                    return i;
                else
                    return j;
            }
        }
        return -1;
        
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
