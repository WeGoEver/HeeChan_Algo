import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sizes = new int[9];
        int sum = 0;
        boolean flag = false;
        int[] ridOf = new int[2];

        for(int i = 0; i<9; i++){
            sizes[i] = Integer.parseInt(br.readLine());
            sum += sizes[i];
        }

        for(int i=0 ; i<9;i++){
            for(int j=i+1 ; j<9;j++){
                if((sum - sizes[i] - sizes[j]) == 100) {
                    ridOf[0] = sizes[i];
                    ridOf[1] = sizes[j];
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        Arrays.sort(sizes);

        for(int size: sizes){
            if(size != ridOf[0] && size != ridOf[1]){
                System.out.println(size);
            }
        }
    }
}