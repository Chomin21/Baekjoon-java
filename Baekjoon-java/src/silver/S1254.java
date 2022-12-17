package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//팰린드롬 만들기
public class S1254 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb;
        int len = str.length();
        int answer = 1;
        for (int i = 0; i < len; i++) {
            sb = new StringBuilder(str);
            StringBuilder substr = new StringBuilder(str.substring(0, i));
            sb.append(substr.reverse());
            String temp = sb.toString();

            int tlen = temp.length();
            int j = 0;
            for (; j < tlen / 2; j++) {
                if (temp.charAt((j)) != temp.charAt(tlen - 1 - j)) {
                    break;
                }
            }
            if (j == tlen / 2) {
                answer = tlen;
                break;
            }

        }
        System.out.println(answer);
    }
}
