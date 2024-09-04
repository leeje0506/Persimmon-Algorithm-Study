import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < K; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a > 0) {
                stack.push(a);
            } else {
                stack.pop();
            }
        }
        
        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        
        System.out.println(answer);
    }
}
