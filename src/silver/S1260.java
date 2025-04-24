package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//DFS와 BFS
public class S1260 {

    public static boolean[] visited;
    public static Map<Integer, List<Integer>> graph;
    public static List<Integer> answer;
    public static void main(String[] args) throws IOException{
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]); // 정점 갯수
        int m = Integer.parseInt(inputs[1]); // 간선 갯수
        int v = Integer.parseInt(inputs[2]); // 시작 정점
        
        graph = new TreeMap<>();
        
        for(int i = 1; i <= m; i++){
            inputs = bf.readLine().split(" ");

            int start = Integer.parseInt(inputs[0]); // 4 정점 갯수
            int end = Integer.parseInt(inputs[1]);
            setGraph(start, end);
            setGraph(end, start);
        }

        // System.out.println(graph);
        init(n);
        dfs(v);
        printAnswer(answer);
        
        init(n);
        bfs(v);
        printAnswer(answer);
    }

    //변수 초기화
    public static void init(int n){
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
    }

    //출력
    public static void printAnswer(List<Integer> answer){
        System.out.println(answer.stream()
                            .map(String::valueOf)         
                            .collect(Collectors.joining(" ")));
    }

    public static void setGraph(int start, int end){
        List<Integer> endList = graph.getOrDefault(start, new ArrayList<>());
        endList.add(end);
        Collections.sort(endList);
        graph.put(start, endList);
    }

    public static void dfs(int i){
        visited[i] = true; 
        answer.add(i);

        List<Integer> endList = graph.getOrDefault(i, new ArrayList<>());
        for(int j : endList){
            if(!visited[j]) dfs(j);
        }
    }

    public static void bfs(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true; 
        List<Integer> endList;

        while(!queue.isEmpty()){
            int temp = queue.poll();

            answer.add(temp);
            endList = graph.getOrDefault(temp, new ArrayList<>());

            for(int j : endList){
                if(!visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}
