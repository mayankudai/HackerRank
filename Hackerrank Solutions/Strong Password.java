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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+";
    
    public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
        
        int addNum = 0;
        if (!password.chars().anyMatch(Character::isDigit)) {
            addNum++;
        }
        if (!password.chars().anyMatch(Character::isLowerCase)) {
            addNum++;
        }
        if (!password.chars().anyMatch(Character::isUpperCase)) {
            addNum++;
        }
        if (!password.chars().anyMatch(ch -> SPECIAL_CHARACTERS.indexOf((char) ch) >= 0)) {
            addNum++;
        }
        addNum = Math.max(addNum, 6 - password.length());

        return addNum;
        
        

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
