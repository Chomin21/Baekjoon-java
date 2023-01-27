package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

//배열 합치기
public class S11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int totalNum = Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]);

        int[] arrA = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arrB = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int lengthA = arrA.length;
        int lengthB = arrB.length;

        int[] totalArr = new int[totalNum];

        int cntA = 0;
        int cntB = 0;
        int cntT = 0;

        //합병 정렬 (merge sort)
        while( cntT < totalNum){
            if(cntA == lengthA){
                totalArr[cntT++] = arrB[cntB++];
                continue;
            }else if(cntB == lengthB){
                totalArr[cntT++] = arrA[cntA++];
                continue;
            }
            if(arrA[cntA] <= arrB[cntB]){
                totalArr[cntT] = arrA[cntA++];
            }else if(arrA[cntA]>arrB[cntB]) {
                totalArr[cntT] = arrB[cntB++];
            }
            cntT++;
        }

        System.out.println(Arrays.toString(totalArr).replaceAll("[\\[,\\]]",""));
    }
}
