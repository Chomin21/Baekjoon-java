package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

//N과 M(3)
public class S15651 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		StringBuilder answer = new StringBuilder();

		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		dfs(n, m, new ArrayList<>(), answer);

		System.out.println(answer);
	}

	public static void dfs(int n, int m, ArrayList<Integer> numList, StringBuilder answer){
		if(numList.size() == m){
			answer.append(numList.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "))).append("\n");

			return;
		}

		for(int k = 1; k <= n; k++){
			numList.add(k);
			dfs(n, m, numList, answer);
			numList.remove(numList.size() - 1);
		}
	}
}
