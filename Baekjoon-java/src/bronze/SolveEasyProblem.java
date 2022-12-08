package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1292번 - 쉽게 푸는 문제
public class SolveEasyProblem {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		
		int num1 = Integer.parseInt(arr[0])-1;
		int num2 = Integer.parseInt(arr[1])-1;
		
		int sum = 0; //총합
		int cnt = 1; //한번, 두번, 세번 인지 세는 변수
		int totalCnt = 0; //전체 횟수
		int num = 1; //더할 숫자
		while(totalCnt <= num2) {	
			if(totalCnt >= num1) {
				sum += num;					
			}
			if( num == cnt) {
				cnt = 1;
				num++;
				totalCnt++;
				continue;
			}
			cnt++;
			totalCnt++;
		}
		System.out.println(sum);
		
	}

}
