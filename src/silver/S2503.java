package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

//숫자 야구
public class S2503 {

	public static ArrayList<Integer> answerList = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int questionNum = Integer.parseInt(br.readLine());

		int[][] inputArr = new int[questionNum][3];

		for(int qNum = 0; qNum < questionNum; qNum++) {
			inputArr[qNum] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		dfs(inputArr, new ArrayList<>());

		System.out.println(answerList.size());
	}

	public static boolean checkStrikeByOneCondition(int[] inputElement, ArrayList<Integer> numElementList){
		int strikeCnt = 0;
		int ballCnt = 0;

		//비교하기 쉽게 세자리 숫자를 배열로 변환
		int[] inputNumArr = String.valueOf(inputElement[0])
								.chars()
								.map(Character::getNumericValue)
								.toArray();

		//스트라이크/볼 갯수 카운트
		for(int i = 0; i < inputNumArr.length; i++){
			if(inputNumArr[i] == numElementList.get(i)){
				strikeCnt ++;
			}else if(numElementList.contains(inputNumArr[i])){
				ballCnt ++;
			}
		}

		//입력받은 숫자와 다른 경우 스트라이크가 아님
        return strikeCnt == inputElement[1] && ballCnt == inputElement[2];
    }

	public static boolean checkStrikeConditions(int[][] inputArr, ArrayList<Integer> numElementList) {
		//각각의 스트라이크 조건에 대해 검사
		for(int[] inputElement : inputArr) {
			if(!checkStrikeByOneCondition(inputElement, numElementList)){
				return false;
			}
		}

		return true;
	}

	public static void dfs(int[][] inputArr, ArrayList<Integer> numElementList){
		if(numElementList.size() == 3){
			//스트라이크/볼 조건 확인
			if(checkStrikeConditions(inputArr, numElementList)){
				//정답 요소 삽입
				answerList.add(numElementList.get(0) * 100 + numElementList.get(1) * 10 + numElementList.get(2));
			}
			return;
		}

		for(int k = 1; k <= 9; k++){
			if(!numElementList.contains(k)){ // 서로 다른 세 숫자인 경우만 탐색
				numElementList.add(k);
				dfs(inputArr, numElementList);
				numElementList.remove(numElementList.size() - 1);
			}
		}
	}
}
