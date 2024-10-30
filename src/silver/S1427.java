package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

//소트인사이드
public class S1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numStr = br.readLine().split("");
        Arrays.sort(numStr, Collections.reverseOrder());
        String str = String.join("", numStr);
        System.out.println(str);
    }
}
