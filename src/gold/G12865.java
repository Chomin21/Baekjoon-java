package gold;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.max;

// 평범한 배낭
public class G12865 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 입력 갯수
        int k = sc.nextInt(); // 최대 무게
        int[] dy = new int[k + 1]; // 각 무게별 가치를 담은 배열

        for(int i = 0; i < n; i++){
            int w = sc.nextInt(); // 입력받은 무게
            int v = sc.nextInt(); // 입력받은 가치
            for(int j = k; j >= w; j--){
                dy[j] = max(dy[j], dy[j - w] + v);
            }
        }

        System.out.println(dy[k]);
    }
}
