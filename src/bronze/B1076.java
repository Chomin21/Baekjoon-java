package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1076 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
		
		String temp = "";
		Long answer = 0L;
		for (int i = 0; i < 3; i++) {
			String str = br.readLine();
			for(int j = 0; j<10;j++) {
				if(arr[j].equals(str)) {
					if(i == 2) {
						answer = (long) (Long.parseLong(temp) * (Math.pow(10, j)));
					}else {
						temp += String.valueOf(j);
					}
					break;
				}
			}
		}
		System.out.println(answer);

	}

}
