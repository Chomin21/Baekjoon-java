package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//유진수
public class B1356 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String originNum = br.readLine();
		for(int i = 0; i < originNum.length()-1; i++) {
			if(checking(originNum.substring(0, i+1), originNum.substring(i+1))) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}
	
	public static boolean checking(String front, String back) {
		int flen = front.length();
		int blen = back.length();
		
		long fnum = Integer.parseInt(front);
		long bnum = Integer.parseInt(back);
		
		long fsum=1, bsum=1; 
		for(int i = 0; i < flen; i++) {
			fsum *= fnum%10;
			fnum /= 10;
		}
		
		
		for(int j = 0; j < blen; j++) {
			bsum *=  bnum%10;
			bnum /=10;
		}
		
		if(fsum == bsum) {
			return true;
		}
		return false;
	}
	
}
