package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

//N과 M(1)
public class S15649 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");

		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		dfs(n, m, 1, new ArrayList<>());
	}

	public static void dfs(int n, int m, int i, ArrayList<Integer> numList){ // 4 2 1
		if(numList.size() == m){
			// 배열 요소 출력
			System.out.println(numList.stream()
					.map(String::valueOf)
					.collect(Collectors.joining(" ")));

			return;
		}

		for(int k = 1; k <= n; k++){
			if(!numList.contains(k)){
				numList.add(k);
				dfs(n, m, i + 1, numList);
				numList.remove(numList.size() - 1);
			}
		}
	}
}
/*
	i=1  k=1 [1]
	i=2 k=2 [1, 2] -----(3)
	i=3 k=3 [1, 2, 3] -----(2)
	i=4 k=4 [1, 2, 3, 4] -----(1)
	종료 (1)

	i=3 k=4 [1, 2, 4]
	i=4 k=4 [1, 2, 4, 3]
	종료 (2)

	i=2 k=3 [1, 3]
	i=3 k=3 [1, 3, 2]
	i=4 k=3 [1, 3, 2, 4]
	종료 (3)
	...
*/
