package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//덱
public class S10866 {
	public static int sIndex = 0;
	public static ArrayList<Integer> arr = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String input;
        String[] inputs;
        for(int i = 0; i < num; i++){  	
            input = br.readLine();
            if(input.contains("push_back")){
                inputs = input.split(" ");
                pushBack(Integer.parseInt(inputs[1]));
            }else  if(input.contains("push_front")){
                inputs = input.split(" ");
                pushFront(Integer.parseInt(inputs[1]));
            }else{
                switch (input) {
                    case "front":
                    	bw.write(Integer.toString(front()) + "\n");
                        break;
                    case "back":
                    	bw.write(Integer.toString(back()) + "\n");
                        break;
                    case "size":
                    	bw.write(Integer.toString(getSize()) + "\n");
                        break;
                    case "pop_front":
                    	bw.write(Integer.toString(popFront()) + "\n");
                        break;
                    case "pop_back":
                    	bw.write(Integer.toString(popBack()) + "\n");
                        break;
                    case "empty":
                    	bw.write(Integer.toString(empty()) + "\n");
                        break;
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static void pushBack(int n){
        arr.add(n);
    }
    public static void pushFront(int n){
    	ArrayList<Integer> copyArr = new ArrayList<>();
    	copyArr.add(n);
    	for(int i = sIndex; i < arr.size(); i ++) {
    		copyArr.add(arr.get(i));
    	}
    	sIndex = 0;
    	arr = copyArr;
    }
    public static int front(){
        int s = getSize();
        return s == 0 ? -1 : arr.get(sIndex);
    }
    public static int back(){
        int s = getSize();
        return s == 0 ? -1 : arr.get(arr.size() - 1);
    }
    public static int getSize(){
        return arr.size() - sIndex;
    }
    public static int popFront(){
        int s = getSize();
        if(s == 0){
            return -1;
        }else{
            return arr.get(sIndex++);
        }
    }
    public static int popBack(){
        int s = getSize();
        if(s == 0){
            return -1;
        }else{
            return arr.remove(arr.size() - 1);
        }
    }
    public static int empty(){
        return getSize() == 0 ? 1 : 0;
    }
}
