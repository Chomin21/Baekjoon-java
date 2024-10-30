package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//숫자 정사각형
public class NumberSquare {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//직사각형의 세로, 가로 크기 입력.
		String[] inputs = bf.readLine().split(" ");
		
		int row = Integer.parseInt(inputs[0]);
		int col = Integer.parseInt(inputs[1]);
		
		String[][] rectArr = new String[row][col];
		
		for(int i = 0;i<row;i++) {
			String[] temp = bf.readLine().split("");
			rectArr[i] = temp;
		}
		
		
		int maxSize= 1;
		int tempSize = 1;
		for(int rowNum = 0; rowNum < row;rowNum++) {
				
			for(int i = 0; i < col-1;i++) { // 0 ~ 3
				for(int j = i+1; j < col; j++) { // 1 ~ 4
					if(rectArr[rowNum][i].equals(rectArr[rowNum][j])) {
						tempSize = findSquare(rectArr,rowNum, i, j);
						maxSize = maxSize < tempSize ? tempSize:maxSize;
					}
				}
	
			}
		}
		System.out.println(maxSize);
	}
	
	public static int findSquare(String[][] rectArr, int rowNum, int start, int last) {
		int length = last - start;
		
		int size = 1;
		
		if(rectArr.length-1 < rowNum+length) {
			return 1;
		} else {
			String a = rectArr[rowNum + length][start];
			String b = rectArr[rowNum + length][last];
			
			if(a.equals(b) && a.equals(rectArr[rowNum][start])){
				size = (length + 1)*(length + 1);
			}
			
			return size;
		}
		
	}

}
