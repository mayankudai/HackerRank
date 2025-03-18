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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    // Write your code here
        
        Map<Character,Integer> chfreq=new HashMap<>();
        for(char c:s.toCharArray())
        {
            chfreq.put(c,chfreq.getOrDefault(c,0)+1);
        }
        
        Map<Integer,Integer> f=new HashMap<>();
        for (int freq:chfreq.values())
        {
            f.put(freq,f.getOrDefault(freq,0)+1);
        }
        
        if(f.size()==1)
            return "YES";
        
        if(f.size()== 2)
        {
            List<Map.Entry<Integer,Integer>> freqList=new ArrayList<>(f.entrySet());
            int freq1=freqList.get(0).getKey();
            int freq2=freqList.get(1).getKey();
            int count1=freqList.get(0).getValue();
            int count2=freqList.get(1).getValue();
            
            if (freq1==1 && count1==1)
                return "YES";
            
            if (Math.abs(freq1-freq2)==1 && (count1==1 || count2==1))
                return "YES";
        }
        
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
