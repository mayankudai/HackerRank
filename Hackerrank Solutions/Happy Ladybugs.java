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
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */

    public static String happyLadybugs(String b) {
    // Write your code here   
        
        b = b.toLowerCase();
        boolean yes = false;
        boolean empt = true;
        int[] chars = new int[26];
    
        for(int i=0; i<b.length(); i++)
        {
            if(b.charAt(i)=='_') 
                yes = true;
            else
            {
                chars[((int)b.charAt(i)) - 97]++;
                empt = false;
            }
        }
        
        if(empt) 
            return "YES";
    
        if(b.length()<=1)
            return "NO";
        
        for(int i=0; i<26; i++)
        {
            if(chars[i]==1)
                return "NO";
        }
        
        for(int i=0; i<b.length(); i++)
        {
            if (i==0)
            {
                if(b.charAt(i)!=b.charAt(i+1) && !yes)
                {
                    return "NO";
                }
            } 
            else if(i==b.length()-1)
            {
                if(b.charAt(i)!=b.charAt(i-1) && !yes)
                {
                    return "NO";
                }
            }
            else
            {
                if (b.charAt(i)!=b.charAt(i-1) && b.charAt(i)!=b.charAt(i+1) && !yes)
                {
                    return "NO";
                }
            }
        }
        return "YES";
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
