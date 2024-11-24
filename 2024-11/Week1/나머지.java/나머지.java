import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] numArr = new int[3];

        for(int i = 0 ; i < 3 ; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println((numArr[0]+numArr[1])%numArr[2]);
        System.out.println(((numArr[0]%numArr[2]) + (numArr[1]%numArr[2]))%numArr[2]);
        System.out.println((numArr[0]*numArr[1])%numArr[2]);
        System.out.println(((numArr[0]%numArr[2]) * (numArr[1]%numArr[2]))%numArr[2]);
    }

}
