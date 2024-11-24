import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int a = Math.max(E,Math.max(S,M));

        while(true){
            if((a-E)%15 == 0 && (a-S)%28 == 0 && (a-M)%19 == 0){
                break;
            }else {
                a++;
            }
        }
        System.out.println(a);
    }
}