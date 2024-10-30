package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

//ATM
public class S11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] pArr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(pArr);

        int sum = 0; //돈 인출에 필요한 시간 총합

        for(int p : pArr){
            sum += p * num;
            num--;
        }

        System.out.println(sum);

    }
}
