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
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    static int gcd(int x,int y)
    {
        if(y==0)
            return x;
        return gcd(y,x%y);
    }
    
    static int lcm(int x, int y)
    {
        return (x*y)/gcd(x,y);
    }
    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        int count=0;
        int fst=a.get(0);
        for(int i=1;i<a.size();i++)
        {
            fst=lcm(fst,a.get(i));
        }
         
        int lst=b.get(0);
        for(int i=1;i<b.size();i++)
        {
            lst=gcd(lst,b.get(i));
        }
        
        List<Integer> list=new ArrayList<>();
        int temp=fst;
        while(temp<=lst)
        {
            list.add(temp);
            temp+=fst;
        }
        
        for(int i:list)
        {
            if(lst%i==0)
                count++;
        }
        
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
