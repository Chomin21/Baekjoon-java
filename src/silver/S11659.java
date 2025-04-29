package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//구간 합 구하기 4
public class S11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStrArr = br.readLine().split(" ");

        int n = Integer.parseInt(inputStrArr[0]);
        int m = Integer.parseInt(inputStrArr[1]);

        int[] numArr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();


        int[] sumArr = new int[n + 1];
        sumArr[0] = 0;
        for(int i = 1 ; i <= n; i++){
            sumArr[i] = sumArr[i - 1] + numArr[i - 1];
        }

        for(int i = 0; i < m; i ++){
            int[] tempArr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

            System.out.println(sumArr[tempArr[1]] - sumArr[tempArr[0] - 1]);
        }
    }
}
