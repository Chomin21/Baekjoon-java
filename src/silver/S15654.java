package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//N과 M(5)
public class S15654 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		StringBuilder answer = new StringBuilder();

		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		int[] inputNumArr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

		dfs(n, m, inputNumArr, new ArrayList<>(), answer);

		System.out.println(answer);
	}

	public static void dfs(int n, int m, int[] inputNumArr, ArrayList<Integer> numList, StringBuilder answer){ // 4 2 1
		if(numList.size() == m){
			answer.append(numList.stream()
					.map(String::valueOf)
					.collect(Collectors.joining(" "))).append("\n");

			return;
		}

		for(int k = 0; k < n; k++){
			if(!numList.contains(inputNumArr[k])){
				numList.add(inputNumArr[k]);
				dfs(n, m, inputNumArr, numList, answer);
				numList.remove(numList.size() - 1);
			}
		}
	}
}