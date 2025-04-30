package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class S11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        BigDecimal[] numArr = new BigDecimal[n + 1];

        numArr[0] = BigDecimal.ONE;
        numArr[1] = BigDecimal.ONE;

        for (int i = 2; i <= n; i++) {
            numArr[i] = numArr[i - 1].add(numArr[i - 2]);
        }

        System.out.println(numArr[n].remainder(BigDecimal.valueOf(10007)));
    }
}
