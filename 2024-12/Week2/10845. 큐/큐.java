import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            
            if (command.equals("push")) {//push X: 정수 X를 큐에 넣는 연산이다.
                queue.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if (!queue.isEmpty()) {
                    System.out.println(queue.pop());
                } else {
                    System.out.println(-1);
                }
            } else if (command.equals("size")) {//size: 큐에 들어있는 정수의 개수를 출력한다.
                System.out.println(queue.size());
            } else if (command.equals("empty")) {//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
                if(queue.isEmpty()){
                    System.out.println(1);
                }else System.out.println(0);
            } else if (command.equals("front")) {//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if(!queue.isEmpty()){
                    System.out.println(queue.getFirst());
                }else System.out.println(-1);
            } else if (command.equals("back")) {//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if(!queue.isEmpty()){
                    System.out.println(queue.getLast());
                }else System.out.println(-1);
            }
        }
    }
}
