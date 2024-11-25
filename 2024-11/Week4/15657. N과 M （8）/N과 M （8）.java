import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n ; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        choice(list, chosen, m, 0);

        System.out.println(sb);
    }
    private static void choice(List<Integer> list, List<Integer> chosen, int m, int start){
        if(chosen.size() == m){
            for(int i = 0 ; i< m ; i ++){
                sb.append(chosen.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start ; i < list.size() ; i++){
            if (chosen.isEmpty() || chosen.get(chosen.size() - 1) <= list.get(i)) {
                chosen.add(list.get(i));
                start = i;
                choice(list, chosen, m, start);
                chosen.remove(chosen.size() - 1);
            }
        }
    }
}
