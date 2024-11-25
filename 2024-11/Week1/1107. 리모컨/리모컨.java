import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int targetChannel = Integer.parseInt(br.readLine());
        int brokenCount = Integer.parseInt(br.readLine());

        // 초기값 설정
        int startChannel = 100;
        int minPresses = Math.abs(targetChannel - startChannel);

        // 고장난 버튼이 없을 경우를 처리
        Set<Integer> brokenButtons = new HashSet<>();
        if (brokenCount != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < brokenCount; i++) {
                brokenButtons.add(Integer.parseInt(st.nextToken()));
            }
        }

        // 모든 채널을 확인하여 가장 가까운 접근 방법 찾기
        for (int i = 0; i <= 999999; i++) {
            String strChannel = String.valueOf(i);
            boolean isValid = true;

            // 현재 채널 번호가 고장난 버튼을 포함하는지 검사
            for (char ch : strChannel.toCharArray()) {
                if (brokenButtons.contains(ch - '0')) {
                    isValid = false;
                    break;
                }
            }

            // 유효한 채널 번호일 경우 최소 클릭 수 계산
            if (isValid) {
                int pressCount = strChannel.length() + Math.abs(i - targetChannel);
                minPresses = Math.min(minPresses, pressCount);
            }
        }

        System.out.println(minPresses);
    }
}