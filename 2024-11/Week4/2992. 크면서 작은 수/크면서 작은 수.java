import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArr = br.readLine().toCharArray();

        int length = charArr.length;
        int index = length - 1;

        boolean flag = false;

        if(length == 1){
            System.out.println(0);

        }else{
            for (int i = length - 2; i >= 0; i--) {
                for (int j = length - 1; j > i; j --) {
                    if(charArr[i] < charArr[j]){
                        char temp = charArr[i];
                        charArr[i] = charArr[j];
                        charArr[j] = temp;
                        flag = true;
                        index = i;
                        break;
                    }
                }
                if(flag) break;
            }
            if(!flag){
                System.out.println(0);
            }else{
                if (index != length-1) {
                    //index + 1 ~ charArr.length sort해줘야함
                    char[] sub = Arrays.copyOfRange(charArr, index + 1, charArr.length);
                    Arrays.sort(sub);
                    int idx = 0;
                    for(int i = index+1 ; i < charArr.length ; i++){
                        charArr[i] = sub[idx];
                        idx ++;
                    }
                }
                System.out.println(new String(charArr));
            }
        }
    }
}
