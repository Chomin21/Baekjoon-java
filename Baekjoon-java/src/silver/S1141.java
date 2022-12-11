package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//접두사
public class S1141 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		String[] words = new String[num];
		for (int i = 0; i < num; i++) {
			words[i] = br.readLine();
		}
		Arrays.sort(words, (o1, o2)-> o1.toString().length()-o2.toString().length());
		
		int count = 1;
		int j ;
		for(int i = 0; i < num - 1; i++) {
			for(j= i + 1; j < num; j++) {
				if(words[j].startsWith(words[i])){
					break;
				}
			}
			
			if(j == num) {
				count++;
			}
			
		}
		System.out.println(count);
	}

}
