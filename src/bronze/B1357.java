package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1357 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int answer = 0;
		
		for(String s : inputs) {
			answer += rev(s);
		}
		
		answer = rev(String.valueOf(answer));
		System.out.println(answer);
	}
	
	public static int rev(String s) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(s);
		sb.reverse();
		
		return Integer.parseInt(sb.toString());
	}

}
