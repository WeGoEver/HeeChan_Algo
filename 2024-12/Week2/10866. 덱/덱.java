import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("push_front")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if (command.equals("push_back")) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop_front")) {
                try {
                    System.out.println(deque.removeFirst());
                } catch (Exception e) {
                    System.out.println(-1);
                }
            } else if (command.equals("pop_back")) {
                try {
                    System.out.println(deque.removeLast());
                } catch (Exception e) {
                    System.out.println(-1);
                }
            } else if (command.equals("size")) {
                System.out.println(deque.size());
            } else if (command.equals("empty")) {
                if(deque.isEmpty()){
                    System.out.println(1);
                }else System.out.println(0);
            } else if (command.equals("front")) {
                try {
                    System.out.println(deque.getFirst());
                } catch (Exception e) {
                    System.out.println(-1);
                }
            } else if (command.equals("back")) {
                try {
                    System.out.println(deque.getLast());
                } catch (Exception e) {
                    System.out.println(-1);
                }
            }
        }
    }
}