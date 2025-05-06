package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 색종이
public class S2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        //도화지 영역 배열
        boolean[][] check = new boolean[101][101];
        //색종이 붙이기 진행
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //색종이 영역 boolean[][] = true 설정
            for(int j = y; j < y + 10; j++){
                for(int k = x; k < x + 10; k++)
                    check[j][k] = true;
            }
        }

        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++)
                if(check[i][j])	//true일 때
                    answer++;
        }

        System.out.println(answer);
    }
}
