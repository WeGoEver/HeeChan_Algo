import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    final static int MAX = 1000001;
    static boolean[] isPrime = new boolean[MAX];

    private static void sieveOfEratosthenes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input;
        boolean bool = true;

        sieveOfEratosthenes();

        while((input = Integer.parseInt(br.readLine())) != 0){
            for(int i = 3 ; i<=input/2 ; i++){
                if(isPrime[i] && isPrime[input - i]){
                    System.out.println(input + " = " + i + " + " + (input-i));
                    bool = false;
                    break;
                }
            }
            if(bool) System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}