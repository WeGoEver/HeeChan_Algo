import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        List<Integer> chosen = new ArrayList<>();
        boolean[] visited = new boolean[N]; // 방문 여부를 체크하는 배열

        generatePermutations(numbers, chosen, visited, M);
    }
    private static void generatePermutations(List<Integer> numbers, List<Integer> chosen, boolean[] visited, int m) {
        if (chosen.size() == m) {
            // m개를 모두 뽑았다면 출력
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++) {
                sb.append(chosen.get(i)).append(" ");
            }
            sb.replace(sb.length() - 1, sb.length(), "");
            System.out.println(sb);

            return;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (!visited[i]) {
                visited[i] = true; // 현재 숫자를 선택
                chosen.add(numbers.get(i));

                generatePermutations(numbers, chosen, visited, m);

                // 백트래킹
                visited[i] = false;
                chosen.remove(chosen.size() - 1);
            }
        }
    }
}
