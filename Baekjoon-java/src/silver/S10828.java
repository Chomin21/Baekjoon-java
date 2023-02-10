package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//스택
public class S10828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String input;
        String[] inputs;
        ArrayList<Integer> stack = new ArrayList<>();

        for(int i = 0; i < num; i++){
            input = br.readLine();
            if(input.contains("push")){
                inputs = input.split(" ");
                push(stack, Integer.parseInt(inputs[1]));
            }else{
                switch (input) {
                    case "top":
                        System.out.println(top(stack));
                        break;
                    case "size":
                        System.out.println(getSize(stack));
                        break;
                    case "pop":
                        System.out.println(pop(stack));
                        break;
                    case "empty":
                        System.out.println(empty(stack));
                        break;
                }
            }
        }


    }

    public static void push(ArrayList<Integer> arr, int n){
        arr.add(n);
    }
    public static int top(ArrayList<Integer> arr){
        int s = arr.size();
        return s == 0 ? -1 : arr.get(s - 1);
    }
    public static int getSize(ArrayList<Integer> arr){
        return arr.size();
    }
    public static int pop(ArrayList<Integer> arr){
        int s = arr.size();
        if(s == 0){
            return -1;
        }else{
            return arr.remove(s - 1);
        }
    }
    public static int empty(ArrayList<Integer> arr){
        return arr.size() == 0 ? 1 : 0;
    }
}
