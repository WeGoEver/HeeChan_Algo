import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int line = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int M, N, x, y;
        boolean flag;

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            flag = false;

            for (int j = x-1; j < N * M; j+=M) {
                if ((j % N) == (y - 1)) {
                    System.out.println(j+1);
                    flag = true;
                    break;
                }
            }
            if (!flag){
                System.out.println(-1);
            }
        }
    }
}