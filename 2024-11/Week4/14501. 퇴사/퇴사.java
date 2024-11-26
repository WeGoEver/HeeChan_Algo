import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] consultList;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        result = 0;
        consultList = new int[N][2];

        for (int i = 0; i < N; i++) {
             st = new StringTokenizer(br.readLine(), " ");
            consultList[i][0] = Integer.parseInt(st.nextToken());
            consultList[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(N, 0, 0);

        System.out.println(result);
    }

    private static void solution(int N, int valueSum, int today) {
        result = Math.max(result, valueSum);
        for (int i = today; i < N; i++) {
           if ( N-i >= consultList[i][0]){
               solution(N, valueSum + consultList[i][1], i+consultList[i][0]);
           }
           solution(N, valueSum, i+1);
        }
    }
}