package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//팀 이름 정하기
public class B1296 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String yeondu = br.readLine();
		int len = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int numL=0, numO=0, numV=0, numE=0;
		int YnumL=0, YnumO=0, YnumV=0, YnumE=0;
		
		for(int j = 0; j < yeondu.length();j++) {
			if(yeondu.charAt(j) == 'L') {
				YnumL++;
			}else if (yeondu.charAt(j) == 'O') {
				YnumO++;
			}else if (yeondu.charAt(j) == 'V') {
				YnumV++;
			}else if (yeondu.charAt(j) == 'E') {
				YnumE++;
			}
		}
		
		String teamName;
		for(int i = 0;i < len;i++) {
			numL=YnumL;
			numO=YnumO;
			numV=YnumV;
			numE=YnumE;
			teamName = br.readLine();
			for(int j = 0; j < teamName.length();j++) {
				if(teamName.charAt(j) == 'L') {
					numL++;
				}else if (teamName.charAt(j) == 'O') {
					numO++;
				}else if (teamName.charAt(j) == 'V') {
					numV++;
				}else if (teamName.charAt(j) == 'E') {
					numE++;
				}
				
			}	
			map.put(teamName, winningOdds(numL, numO, numV, numE));
		}
		
		Entry<String, Integer> maxValue = Collections.max(map.entrySet(), new Comparator< Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				
				if(o1.getValue() < o2.getValue()) return -1;
				else if (o1.getValue() > o2.getValue()) return 1;
				else return o2.getKey().compareTo(o1.getKey());
			}
		});
		
		System.out.println(maxValue.getKey());
	}
	
	public static int winningOdds(int numL, int numO, int numV, int numE) {
		return ((numL+numO) * (numL+numV) * (numL+numE)*(numO + numV) *(numO+numE)*(numV+numE))%100;
	}

}
