package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//도영이가 만든 맛있는 음식
public class S2961 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputCnt = Integer.parseInt(br.readLine());

		int[][] inputArray = new int[inputCnt][2];

		for(int i = 0; i < inputCnt; i++){
			inputArray[i] = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}

		int totalCombinations = (int) Math.pow(2, inputCnt);

		int sumS, sumB;
		int minDiff = 1000000000;
		int tempDiff;

		for (int i = 1; i < totalCombinations; i++) { // 1부터 시작 (000 제외)
			String binary = Integer.toBinaryString(i); // 이진수 변환
			// inputCnt 자릿수로 맞추기 위해 앞에 0을 채우기
			while (binary.length() < inputCnt) {
				binary = "0" + binary;
			}

			sumS = 1;
			sumB = 0;

			for(int j = 0; j < binary.length(); j++){
				char ch = binary.charAt(j);

				if(ch == '0') continue;

				sumS *= inputArray[j][0];
				sumB += inputArray[j][1];
				tempDiff = Math.abs(sumS - sumB);

				if(tempDiff < minDiff){
					minDiff = tempDiff;
				}
			}
		}
		System.out.println(minDiff);
	}
}
