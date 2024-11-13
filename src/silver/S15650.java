package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

//N과 M(2)
public class S15650 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");

		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		dfs(n, m, 0, new ArrayList<>());
	}
	// i : 바로 이전에 넣은 숫자
	public static void dfs(int n, int m, int i, ArrayList<Integer> numList){
		if(numList.size() == m){
			// 배열 요소 출력
			System.out.println(numList.stream()
					.map(String::valueOf)
					.collect(Collectors.joining(" ")));

			return;
		}

		// 바로 이전에 넣은 숫자보다 1씩 크게 삽입
		for(int k = i + 1; k <= n; k++){
			numList.add(k);
			dfs(n, m, k, numList);
			numList.remove(numList.size() - 1);
		}
	}
}
