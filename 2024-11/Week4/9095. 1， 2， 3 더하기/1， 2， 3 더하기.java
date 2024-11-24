import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //n을 1, 2, 3의 합으로 나타내는 방법의 수
        //n은 양수이며 11보다 작다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int a = 0; a <= n; a++) {
                for (int b = 0; b <= n - a; b++) {
                    for (int c = 0; c <= n - a - b; c++) {
                        if (a + 2 * b + 3 * c == n) {
                            count += (factorial(a+b+c) / (factorial(a) * factorial(b) * factorial(c)));
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
    private static int factorial(int n){
        int value = 1;
        for(int i = 1; i<=n ;i++){
            value *=i;
        }
        return value;
    }
}