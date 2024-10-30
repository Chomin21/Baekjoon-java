package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

//큰 수 구성하기
public class S18511 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		int num = Integer.parseInt(inputs[0]);
		int numLength = inputs[0].length();
		int count = Integer.parseInt(inputs[1]);
		
		if(count == 1) {
			inputs = br.readLine().split("");
		}else {
			inputs = br.readLine().split(" ");
		}
		
		Integer[] intArr = new Integer[count];
		
		for(int i = 0; i < count; i++ ) {
			intArr[i] = Integer.parseInt(inputs[i]);
		}
		
		Arrays.sort(intArr, Collections.reverseOrder());
		
		int answer = 0; 
		int temp;
		
		/*
		 * min : 입력이 1000 1 (enter) 1 인 경우 처리를 위해 추가
		 * 1000에서 끝나버리는 경우를 처리하기 위함
		 *
		 * */
		String[] tempArr = new String[numLength - 1];
		Arrays.fill(tempArr, String.valueOf(intArr[count - 1]));
		int min = Integer.parseInt(String.join("", tempArr));

		while(numLength > 0) { 
			temp = (int) Math.pow(10,  numLength - 1); 
			
			for(int k : intArr) { 
				if(answer + temp * k + min<= num ) { //min을 더해주는 것이 중요
					answer += temp * k;
					break;
				}
			}
			
			min /= 10;
			numLength--;
			
		}
		System.out.println(answer);
	}
	
}
