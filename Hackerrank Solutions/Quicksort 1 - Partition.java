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
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static List<Integer> quickSort(List<Integer> arr) {
    // Write your code here

        int temp=arr.get(0);
        List<Integer> left=new ArrayList<>();
        List<Integer> eq=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i)==temp)
            {
                eq.add(arr.get(i));
            }
            else if(arr.get(i)>temp)
            {
                right.add(arr.get(i));
            }
            else
            {
                left.add(arr.get(i));
            }
        }
        left.addAll(eq);
        left.addAll(right);        
        return left;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.quickSort(arr);
        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
    }
}
