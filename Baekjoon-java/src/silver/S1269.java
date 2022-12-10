package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

//1269번-대칭 차집합
public class S1269 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		int arrlen1 = Integer.parseInt(inputs[0]);
		int arrlen2 = Integer.parseInt(inputs[1]);
		
		String[] arr1 = br.readLine().split(" ");
		String[] arr2 = br.readLine().split(" ");
		
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < arr1.length;i++) {
			set.add(arr1[i]);
		}
		
		for(int i = 0; i < arr2.length;i++) {
			set.add(arr2[i]);
		}
		
		int intersect = arrlen1 + arrlen2 - set.size();
		int answer = set.size() - intersect;
		
		System.out.println(answer);
	}

}

