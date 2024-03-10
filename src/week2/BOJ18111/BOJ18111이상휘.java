package week2.BOJ18111;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 설계
// 심어져 있는 블록과, 인벤토리내 블록을 포함하여 전체 경우중, 쌓을수 있느 모든높이를 탐색.


public class BOJ18111이상휘 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 한 층당, 사용되는 블록수를 체크하기 위해 따로 변수를 지정
        int square = N*M;

        // 2차원 배열로 풀이할 필요가 없기에, 1차원 배열로 만듬
        int[] list = new int[N*M];
        int idx = 0;

        // 인벤토리에 있는 블록의 개수를 초기값으로 하고
        int sum = B;
        for(int r = 1 ; r <=N; r++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            // 탐색을 통해, 모든 블록 값을 다 더해줌
            for(int c = 1; c <=M; c++) {
                list[idx] = Integer.parseInt(st2.nextToken());
                sum+= list[idx];
                idx++;
            }
        }

        int min = Integer.MAX_VALUE;
        int height = 0;
        // 최대 256층까지 가능하무로 전체 탐색 돌림
        for(int i = 0; i <= 256 ; i++) {
            int cal = 0;
            if (sum >= i* square) {
                for(int j = 0; j < list.length; j++) {
                    // 블록을 파 내야 하는 경우
                    if (list[j] > i) {
                        cal += (list[j]-i) * 2;
                    }
                    // 블록을 추가로 설치해야 하는 경우
                    else if (list[j] < i) {
                        cal += (i - list[j]);
                    }
                }
                // 최소 값 찾기
                if (cal <= min) {
                    min = cal;
                    height = i;
                }
            }

        }
        System.out.println(min + " " + height);
    }
}
