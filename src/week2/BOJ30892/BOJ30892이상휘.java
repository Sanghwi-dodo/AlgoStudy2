package week2.BOJ30892;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 설계
// 상어가 먹을 수 있는것을 stack에 담고, stack.pop()을 한다면, 먹을 수 있는 것 중 가장 큰 것을
// 먹는 것이 된다.

public class BOJ30892이상휘 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 마리 수
        int N = Integer.parseInt(st.nextToken());
        // 최대 마리 수
        int K = Integer.parseInt(st.nextToken());
        // 최초 크기
        long T = Integer.parseInt(st.nextToken());


        // 상어들을 우선 배열에 담아서, sort 시킨후 stack에 담아줄 것임
        // 역순으로 뽑히므로, 큰 값이 나옴
        int[] sharks = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sharks[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(sharks);

        Stack<Integer> stk = new Stack<>();
        List<Integer> bigShark = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < N; i++) {
            // stack에 담기 전, 자신의 크기와 비교해 더 작은 (먹을 수 있는) 것만 stack에 담음
            if (sharks[i] < T) {
                stk.push(sharks[i]);
                // idx를 잡아줌으로서, 배열에서 다음에 담아야 할 값을 기억함.
                idx = i;
            } else {
                // 내 크기보다 큰 상어를 초기에 지정해 줌
                bigShark.add(sharks[i]);
            }
        }

        boolean eat = true;
        // 내 크기보다 큰 상어들만 있다면 아무것도 먹을 수 없다는 것 (자신의 크기 유지) 
        // 큰 상어 size와, 총 상어 마리수를 비교
        if (bigShark.size() == N) {
            System.out.println(T);
            eat = false;
        }
        if (eat) {
            int cnt =0;
            while(cnt < K) {
                if(stk.isEmpty()) {
                    break;
                }
                // 1. 현재, 먹을수 있는 가장 큰 것을 먹은 후 
                T += stk.pop();
                cnt++;
                // 2. 먹은 크기를 기준으로, 다시 상어들과 비교하여, stk에 추가적으로 담아 줌
                for(int i = idx + 1; i < N; i++) {
                    if (sharks[i] < T) {
                        stk.push(sharks[i]);
                        idx++;
                    }
                }
            }
            System.out.println(T);
        }
    }
}