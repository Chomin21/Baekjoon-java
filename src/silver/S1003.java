package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//피보나치 함수
public class S1003 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
        int[] inputNumArr = new int[t]; 

        for(int i = 0; i < t; i++){
            inputNumArr[i] = Integer.parseInt(br.readLine());
        }
        
        //입력받은 출력값들 중 가장 큰 수 찾기
        //가장 큰 수를 기준으로 피보나치 배열 만들기
        int maxInputNum =  Arrays.stream(inputNumArr).max().getAsInt();
        maxInputNum = maxInputNum == 0 ? 1 : maxInputNum;
        int[][] arr = makeFibonacci(maxInputNum);
        
        for(int i : inputNumArr){
            Arrays.stream(arr[i])
              .forEach(n -> System.out.print(n + " "));
            System.out.println();
        }
     }

     public static int[][] makeFibonacci(int maxSize){
        int[][] fibonacci = new int[maxSize + 1][2];

        fibonacci[0] = new int[]{1, 0};
        fibonacci[1] = new int[]{0, 1};
        for(int i = 2; i <= maxSize; i++){
            fibonacci[i][0] = fibonacci[i - 1][0] + fibonacci[i - 2][0];
            fibonacci[i][1] = fibonacci[i - 1][1] + fibonacci[i - 2][1];
        }

        return fibonacci;
     }
}
