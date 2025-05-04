package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//부녀회장이 될테야
public class B2775 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[][] apartment = setApartment();

        for(int i = 0; i < t; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(apartment[k][n]);
        }
    }

    public static int[][] setApartment(){
        int[][] apartment = new int[15][15];

        for(int i = 1; i <= 14; i++){
            apartment[0][i] = i;
        }

        for(int i = 1; i <= 14; i++){
            apartment[i][1] = apartment[i - 1][1];
            for(int j = 2; j <= 14; j++){
                apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
            }
        }

        return apartment;
    }
}
