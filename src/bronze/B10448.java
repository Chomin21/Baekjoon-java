package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 유레카 이론
public class B10448 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int inputNum;
		int[] inputArr = new int[num];


		for(int i = 0; i < num; i++){
			inputNum = Integer.parseInt(br.readLine());
			inputArr[i] = inputNum;
		}

		for(int arrNum :  inputArr){
			System.out.println(isEureka(arrNum));
		}
	}

	// 삼각수
	public static int triangleNum(int num){
		return (num * (num + 1)) / 2;
	}

	// 입력된 숫자가 유레카 숫자인지 확인
	public static int isEureka(int num){
		for(int i = 1; i <= num/2; i++){
			for(int j = i; j <= num/2; j++){
				for(int k = j; k <= num/2; k++){
					if(num == (triangleNum(i) + triangleNum(j) + triangleNum(k))){
						return 1;
					}
				}
			}
		}

		return 0;
	}
}
