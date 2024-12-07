package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//스타트와 링크
public class S14889 {

	static int inputCnt;
	static int teamCnt;
	static List<Integer> totalTeam;
	static int[][] numArray;
	static int minDiff = 2000;
	static int tempDiff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputCnt = Integer.parseInt(br.readLine());
		numArray = new int[inputCnt][];

		for(int i = 0; i < inputCnt; i++){
			numArray[i] = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}

		teamCnt = inputCnt / 2;

		totalTeam = IntStream.rangeClosed(1, inputCnt)
				.boxed()
				.collect(Collectors.toCollection(ArrayList::new));

		dfs(1, new ArrayList<>());

		System.out.println(minDiff);
	}

	public static void dfs(int index, ArrayList<Integer> startTeam){
		if(startTeam.size() == teamCnt){ // 팀원을 모두 찾은 경우
			List<Integer> linkTeam = new ArrayList<>(totalTeam);
			linkTeam.removeAll(startTeam);

			int startTeamSum = 0;
			int linkTeamSum = 0;

			for(Integer s1 : startTeam){
				for(Integer s2 : startTeam){
					if(s1 == s2) continue;
					startTeamSum += numArray[s1 - 1][s2 - 1];
				}
			}

			for(Integer l1 : linkTeam){
				for(Integer l2 : linkTeam){
					if(l1 == l2) continue;
					linkTeamSum += numArray[l1 - 1][l2 - 1];
				}
			}

			tempDiff = Math.abs(startTeamSum - linkTeamSum);

			if(tempDiff < minDiff){
				minDiff = tempDiff;
			}

			return;
		}

		for(int k = index; k <= inputCnt; k++){
			if(!startTeam.contains(k)){
				startTeam.add(k);
				dfs(k + 1, startTeam);
				startTeam.remove(startTeam.size() - 1);
			}
		}
	}
}
