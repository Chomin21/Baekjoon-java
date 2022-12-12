package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//명령 프롬프트
public class B1032 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		String[][] strArr = new String[num][];
		StringBuilder sb = new StringBuilder();
		for(int i =0;i < num;i++) {
			strArr[i] = br.readLine().split("");
		}
		
		int len = strArr[0].length;
		int j =0;
		for(int i = 0; i < len;i++) {
			j = 0;
			for(; j < num - 1; j++) {
				if(!strArr[j][i].equals(strArr[j+1][i])) {
					sb.append("?");
					break;
				}
			}
			if(j == num-1) {
				sb.append(strArr[0][i]);
			}
		}
		
		System.out.println(sb);
	}
}
