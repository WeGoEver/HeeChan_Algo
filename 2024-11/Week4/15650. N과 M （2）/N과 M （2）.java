import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i+1);
        }
        List<Integer> chosen = new ArrayList<>();

        choice(list, chosen, M, 0);
    }
    private static void choice(List<Integer> list, List<Integer> chosen, int M, int start) {
        if(chosen.size() == M) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++) {
                sb.append(chosen.get(i)).append(" ");
            }
            System.out.println(sb);
            sb.delete(0, sb.length());
        }

        for(int i = start; i < list.size(); i++) {
            if(!chosen.contains(list.get(i))) {
                chosen.add(list.get(i));
                start++;
                choice(list, chosen, M, start);
                chosen.remove(chosen.size()-1);
            }
        }
    }
}