package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//올바른 배열
public class S1337 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		ArrayList<Long> numArr =new ArrayList<>();
		for(int i = 0; i < len; i++) {
			numArr.add(Long.parseLong(br.readLine()));
		}
	
		Collections.sort(numArr);

		int[] cnt = new int[len];
		 
		/**
		 * numArr의 모든 요소에 각각 1~4를 더해서 더한 값을 가지고 있는지 여부를 체크해서 cnt배열에 저장함.
		 * cnt배열의 최소값이 답.
		 */
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < 5; j++) {
                if (!numArr.contains(numArr.get(i) + j)) cnt[i]++;
            }
        }
        Arrays.sort(cnt);
        System.out.println(cnt[0]);

	}
}
