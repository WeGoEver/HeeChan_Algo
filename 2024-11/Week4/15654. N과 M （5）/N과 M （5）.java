import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        List<Integer> list = new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        choice(list, chosen, M);

        System.out.println(sb);
    }
    private static void choice(List<Integer> list, List<Integer> chosen, int M) {
        if(chosen.size() == M){
            for(int i = 0; i < M; i++) {
                sb.append(chosen.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < list.size(); i++) {
            if(!chosen.contains(list.get(i))) {
                chosen.add(list.get(i));
                choice(list, chosen, M);
                chosen.remove(chosen.size() - 1);
            }
        }
    }
}