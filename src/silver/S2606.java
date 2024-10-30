package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//바이러스
public class S2606 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computerCnt = Integer.parseInt(br.readLine());
		int inputCnt = Integer.parseInt(br.readLine());
		int[][] graph = new int[computerCnt + 1][computerCnt + 1];
		int[] visit = new int[computerCnt + 1];
		Stack<Integer> stack = new Stack<Integer>();
		int num1, num2;
		
		for(int i = 0; i < inputCnt; i++) {
			String[] inputs = br.readLine().split(" ");
			num1 = Integer.parseInt(inputs[0]);
			num2 = Integer.parseInt(inputs[1]);
			
			graph[num1][num2] = 1;
			graph[num2][num1] = 1;
		}

		
		stack.push(1);
		visit[1] = 1;
		loop:while(!stack.empty()) {
			int topNum = (int) stack.peek();
			
			int[] temp = graph[topNum];
			int i = 0;
			for(; i < temp.length; i++) {
				if(visit[i] == 0 && temp[i] == 1) {
					stack.push(i);
					visit[i] = 1;
					continue loop;
				}
			}
			if(i == temp.length) {
				stack.pop();
			}
		}
		
		int answer = 0;
		for(int i : visit) {
			if(i == 1) {
				answer++;
			}
		}
		answer--;
		
		System.out.println(answer);
		
	}

}
