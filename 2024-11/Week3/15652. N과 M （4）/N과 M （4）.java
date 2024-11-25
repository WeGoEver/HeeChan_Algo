import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(i+1);
        }

        choice(list, chosen, M, 0);

        System.out.println(sb);
    }
    private static void choice(List<Integer> list, List<Integer> chosen, int M, int start) {
        if(chosen.size() == M) {
            for(int i = 0; i < M; i++) {
                sb.append(chosen.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < list.size(); i++) {
            if(chosen.isEmpty() || chosen.get(chosen.size()-1) <= list.get(i)) {
                chosen.add(list.get(i));
                choice(list, chosen, M, i);
                //backtrack
                chosen.remove(chosen.size()-1);
            }
        }
    }
}