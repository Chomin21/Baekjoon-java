package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//RGB거리
//예제는 맞지만 시간초과 뜨는 코드
public class S1149 {
    public static int n;
    public static int[][] colorCost;
    public static int minCost = 1000000;

    public static void main(String[] args) throws IOException{
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        int[] houseColor = new int[n];
        colorCost = new int[n][3];

        for(int i = 0; i < n; i++){
            colorCost[i] = Arrays.stream(bf.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        }

        dfs(0, houseColor);

        System.out.println(minCost);
    }

    public static void dfs(int index, int[] houseColor){
        if(index == n){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += colorCost[j][houseColor[j]];
            }
            
            if(minCost > sum){
                minCost = sum;
            }
            
            return;
        }

        List<Integer> color = new ArrayList<>(Arrays.asList(0 , 1, 2));
        if(index != 0){
            color.remove(houseColor[index - 1]);
        }
        
        for(int i : color){
            houseColor[index] = i;
            dfs(index + 1, houseColor);
        }

    }
}
