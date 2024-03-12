package week2.BOJ18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		int B = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int min = 256;
		int max = 0;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] > max)
					max = map[r][c];
				if (map[r][c] < min)
					min = map[r][c];
			}
		}

		int time = Integer.MAX_VALUE;
		int height = 0;

		// 좌표의 최댓값과 최솟값 사이에서만 탐색
		for (int i = min; i <= max; i++) {

			int cnt = 0;
			int b = B;

			// 완전 탐색하며 블록을 쌓을지 치울지 결정
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {

					// 현재 좌표가 i값보다 클 경우
					if (i < map[r][c]) {
						b += (map[r][c] - i);
						cnt += ((map[r][c] - i) * 2);
					}
					// 현재 좌표가 i값보다 작을 경우
					else {
						b -= (i - map[r][c]);
						cnt += (i - map[r][c]);
					}
				}
			}
			if (b < 0)
				break;
			
			if (time >= cnt) {
				time = cnt;
				height = i;
			}
		}
		System.out.println(time + " " + height);
	}
}
