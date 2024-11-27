package silver;

import java.io.*;
import java.util.StringTokenizer;

public class S2961_Best {
	static int N;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		backTracking(0, 1, 0, 0);
		System.out.println(min);
	}

	private static void backTracking(int idx, int sour, int bitter, int cnt) {
		if(idx == N) {
			if(cnt > 0) min = Math.min(min, Math.abs(sour - bitter));
			return;
		}

		backTracking(idx + 1, sour * arr[idx][0], bitter + arr[idx][1], cnt + 1);
		backTracking(idx + 1, sour, bitter, cnt);
	}
}