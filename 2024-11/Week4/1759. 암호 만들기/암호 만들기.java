import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int L;
    static int C;
    static String vowel = "aeiou";
    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");

        C = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        List<String> selected = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < L; i++) {
            list.add(st.nextToken());
        }

        Collections.sort(list);

        solution(selected, 0);
    }
    private static void solution(List<String> selected, int start) {
        if(selected.size() == C){
            int count = 0;
            for (String sel : selected) {
                if (vowel.contains(sel)) count++;
            }
            if(count > 0 && C-count > 1) System.out.println(String.join("", selected));
            return;
        }

        for (int i = start; i < L; i++) {
            selected.add(list.get(i));
            start++;
            solution(selected, start);
            selected.remove(selected.size() - 1);
        }
    }
}