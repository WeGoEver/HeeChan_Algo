import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        2와 5로 나누어 떨어지지 않는 정수 n(1 ≤ n ≤ 10000)가 주어졌을 때, 각 자릿수가 모두 1로만 이루어진 n의 배수를 찾는 프로그램을 작성하시오.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while((input = br.readLine()) != null){
            int N = Integer.parseInt(input);
            int base = 1;
            int count = 1;

            while((base=base%N) != 0) {
                count++;
                base = base * 10 + 1;
            }
            System.out.println(count);
        }
    }
}