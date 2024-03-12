package week2.BOJ18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111_김수아 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int max = 0;
        for (int r=0; r<N; r++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine());
            for (int c=0; c<M; c++) {
                map[r][c] = Integer.parseInt(tmp.nextToken());
                max = Math.max(max, map[r][c]); //max 값 구해놓기
            }
        }

        int num = 0;
        int minTime = Integer.MAX_VALUE;
        int minHeight = Integer.MAX_VALUE;

        while (num<=max) { //0부터 max까지 다 돌기
            int time = 0;
            int inventory = B;
            for (int r=0; r<N; r++) {
                for (int c=0; c<M; c++) {
                    if (map[r][c] < num) { //블록이 지금 num보다 작으면
                        inventory -= num - map[r][c]; //재고에서 빼줌
                        time += (num - map[r][c]); //뺀 만큼 시간은 추가됨
                    } else {
                        inventory += map[r][c] - num;
                        time += 2*(map[r][c] - num);
                    }
                }
            }
            if (inventory >= 0) { //재고가 0 이상이어야 유효한 결과임
                if (time <= minTime && time >= 0) {
                    minTime = time;
                    minHeight = num;
                }
            }
            num++;
        }
        System.out.println(minTime + " " + minHeight);
    }
}
