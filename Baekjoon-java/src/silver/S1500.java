package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//최대 곱
public class S1500 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int num1 = Integer.parseInt(str[0]);
		int num2 = Integer.parseInt(str[1]);
		
		Long answer = 1L;
		int num = num1 / num2;	
		int rest =  num1 % num2;

		int totalCount = 0;
		int restCount = 0;
		int temp = num;
		while(totalCount < num2) {
			temp = num;
			if(restCount < rest) {
				temp = num + 1;
				restCount++;
			}
			answer *= temp; 
			
			totalCount++;
		}
		System.out.println(answer);
	}

}
