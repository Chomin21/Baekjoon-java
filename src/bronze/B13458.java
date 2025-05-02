package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시험 감독 
public class B13458 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] examinee = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken()); // 총감독관 감시 가능 인원 수
        int c = Integer.parseInt(st.nextToken()); // 부감독관 감시 가능 인원 수

        long totalSupervisor = 0; // 전체 감독관 수
        long quotient; // 부감독관 수
        long remainder; // 나머지가 있는 경우 부감독관 수 + 1
        for(int e : examinee){
            e = e - b;
            totalSupervisor += 1; // 총감독관 수

            if(e > 0){
                quotient = e / c;
                remainder = e % c;
                totalSupervisor += (remainder > 0 ? quotient + 1 : quotient);
            }
        }

        System.out.println(totalSupervisor);

    }
}
