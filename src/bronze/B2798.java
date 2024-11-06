package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//블랙잭
public class B2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] firstInputStrArr = br.readLine().split(" ");

		int numCnt = Integer.parseInt(firstInputStrArr[0]);
		int maxSum = Integer.parseInt(firstInputStrArr[1]); //M


		//카드에 쓰여있는 수 입력 받기
		String[] secondInputStrArr = br.readLine().split(" ");
		int[] inputNumArr = new int[numCnt];
		for(int i = 0; i < numCnt; i++) {
			inputNumArr[i] = Integer.parseInt(secondInputStrArr[i]);
		}

		//입력받은 수 오름차순 정렬
		Arrays.sort(inputNumArr);

		int answerSum = 0;
		int sum;
		for(int k = 0; k < numCnt; k++) {
			for(int j = k + 1; j < numCnt; j++) {
				for(int m = j + 1; m < numCnt; m++) {
					sum = inputNumArr[k] + inputNumArr[j] + inputNumArr[m];

					if(sum > maxSum) { //M보다 크면 패스
						continue;
					}

					if(answerSum < sum){ //새로 합산한 값이 더 크면 갱신
						answerSum = sum;
					}
				}
			}
		}

		System.out.println(answerSum);
	}
}
