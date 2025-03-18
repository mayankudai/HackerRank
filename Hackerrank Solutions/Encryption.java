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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
        
        s=s.replaceAll(" ","");
        int len=s.length();
        int rows=(int) Math.floor(Math.sqrt(len));
        int cols=(int) Math.ceil(Math.sqrt(len));
        
        if((rows*cols)<len)
            rows++;
        
        char[][] grid=new char[rows][cols];
        int idx=0;
        
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(idx<len)
                {
                    grid[i][j]=s.charAt(idx++);
                }
            }
        }
        StringBuilder encr=new StringBuilder();
        
        for(int j=0; j<cols; j++)
        {
            for(int i=0; i<rows; i++)
            {
                if(grid[i][j]!=0)
                {
                    encr.append(grid[i][j]);
                }
            }
            encr.append(" ");
        }
        return encr.toString().trim();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
