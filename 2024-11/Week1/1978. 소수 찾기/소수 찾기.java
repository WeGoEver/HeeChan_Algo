import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = 0;

        for(int i = 0; i<n; i++) {
            boolean bool = true;
            int number = Integer.parseInt(st.nextToken());
            if(number == 1){
                bool = false;
            }else{
                for(int j=2; j<=Math.sqrt(number); j++) {
                    if(number%j == 0){
                        bool = false;
                        break;
                    }
                }
            }

            if(bool){
                count++;
            }
        }
        System.out.println(count);
    }
}