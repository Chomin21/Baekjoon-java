package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//동전 0
public class S11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for(int i = n - 1; i >= 0; i--){
            if(k < arr[i]){
                continue;
            }
            sum += k / arr[i];
            k = k % arr[i];
        }

        System.out.println(sum);

    }
}
