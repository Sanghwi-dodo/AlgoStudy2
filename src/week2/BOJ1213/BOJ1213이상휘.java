package week2.BOJ1213;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 설계
// 펠린드롬이 가능한 경우의 수를 파악하고
// 아스키코드를 통해 배열로서 단어를 파악함.
public class BOJ1213이상휘 {

    public static void BOJ1213(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int len = str.length();

        char[] list = str.toCharArray();

        // 알파벳 총 갯수 만큼의 배열을 생성함.
        int[] check = new int[26];

        // 입력된 값을, 순회하며, 아스키 코드값 변환을 통해 A가 0번인덱스를 가지도록 보정해서
        // counting 배열 형식으로 해당 idx++을 통해, 어떤 알파벳이 있는지 파악
        for(char chr : list) {
            check[chr-65]++;
        }

        boolean isOdd = false;
        boolean pal = true;

        // 팰린드롬 불가능 : 홀수인 개수가 2개 이상
        // 홀수를 포함할 수 있는 경우는, 가운데에 홀수를 딱 1개 가지는 경우를 제외하고는 없음.
        for(int i : check) {
            if (isOdd) {
                if(i%2 != 0) {
                    pal = false;
                    System.out.println("I'm Sorry Hansoo");
                    break;
                }
            }
            // 홀수가 2개 이상인지 체크하기위해, Flag를 세움
            if (i % 2 != 0) {
                isOdd = true;
            }
        }

        if (pal) {
            int sIdx = 0;
            int rIdx = len - 1;
            int mid = (len - 1) / 2;
            int[] nums = new int[len];


            for (int i = 0; i < 26; i++) {
                while (check[i] > 0) {
                    // 홀수가 1개인경우 (여러개는 위에서 벌써 걸러짐)
                    // 홀수에 해당하는 알파벳은 가장 가운데에 그 값이 지정되어야 함,
                    // mid 인덱스를 통해 그 값을 지정해줌.
                    if (check[i] == 1) {
                        nums[mid] = i;
                        check[i]--;
                        continue;
                    }
                    // 한 cycle 당 , 시작점과 끝점에 count배열의 idx를 추가함.
                    nums[sIdx++] = i;
                    nums[rIdx--] = i;
                    check[i] -= 2;
                }
            }
            // idx는 앞서, 보정된 아스키코드 값과 같으므로 다시 역으로 보정 해줌.
            for (int i = 0; i < list.length; i++) {
                list[i] = (char) ((char) (nums[i] + 65));
            }
            for (char a : list) {
                System.out.print(a);
            }
        }
    }
}