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
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */
    
    private static final String[] temp={"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty","twenty one","twenty two","twenty three","twenty four","twenty five","twenty six","twenty seven","twenty eight","twenty nine"
    };
    

    public static String timeInWords(int h, int m) {
    // Write your code here
        
        if (m==0)
            return temp[h] + " o' clock";
        
        if (m<=30)
        {
            if(m == 15)
                return "quarter past "+temp[h];
            else if (m==30)
                return "half past "+temp[h];
            else if (m==1)
                return "one minute past "+temp[h];
            else
                return temp[m]+" minutes past " +temp[h];
        }
        
        int nhour =(h==12)?1:(h+1);
        int leftmin=60-m;
        
        if(leftmin==15)
            return "quarter to "+temp[nhour];
        else if(leftmin==1)
            return "one minute to " +temp[nhour];
        else
            return temp[leftmin]+" minutes to "+temp[nhour];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
