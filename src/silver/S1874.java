package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//스택 수열
public class S1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 1000000);
		int n = Integer.parseInt(br.readLine());
		int input;
		ArrayList<Integer> stack = new ArrayList<Integer>();
		int k = 1;
		boolean sw = true;
		for (int i = 1; i <= n; i++) { // n번
			input = Integer.parseInt(br.readLine());

			if (sw) {
				while (input >= k) {
					stack.add(k);
					bw.write("+\n");
					k++;
				}
				int lastIndex = stack.size() - 1;

				if (input == stack.get(lastIndex)) {
					bw.write("-\n");
					stack.remove(lastIndex);
				} else {
					bw = new BufferedWriter(new OutputStreamWriter(System.out));
					bw.write("NO\n");
					sw = false;
				}
			}else continue;
		}

		bw.flush();
		br.close();
		bw.close();
	}

}
