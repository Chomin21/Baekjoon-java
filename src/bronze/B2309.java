package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int totalCount = 9;
		int height;
		int[] heightArr = new int[9]; // 아홉 난쟁이 키 배열
		int totalHeight = 0; // 아홉 난쟁이 키 총합

		for(int i =0; i < totalCount;i++) {
			height = Integer.parseInt(br.readLine());
			heightArr[i] = height;
			totalHeight += height;
		}

		int diff = Math.abs(totalHeight - 100); // 추가된 두 난쟁이의 키 합
		Arrays.sort(heightArr);

		for(int h1 = 0; h1 < totalCount; h1++){
			for(int h2 = h1 + 1 ; h2 < totalCount; h2++){
				if((heightArr[h1] + heightArr[h2]) == diff){
					for(int h3 : heightArr){
						if(h3 != heightArr[h1] && h3 != heightArr[h2]){
							System.out.println(h3);
						}
					}

					return;
				}
			}
		}
	}
}
