package week1.BOJ14499_STUDY;
import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int x;
	static int y;
	static int k;
	static int arr[][];
	static int dx[] = { 0, 0, 0, -1, 1 };
	static int dy[] = { 0, 1, -1, 0, 0 };
	static int d[];
	static StringBuilder sb;

	public static void main(String[] ewr) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		// 주사위 좌표 x,y
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		// 명령의 개수 k
		k = Integer.parseInt(st.nextToken());
		d= new int[6];
		arr = new int[n][m];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 명령 받기
		int cmd[] = new int[k];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			cmd[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < k; i++) {
			굴린다(cmd[i]);
		}
		System.out.println(sb);
		// 1. 윗면 1 동쪽 3
		// 2. 모든면 0 시작
		// 3. 동 1 서 2 남 3 북 4
		// arr[nx][ny]=0 주사위 바닥숫자가=> 맵 숫자
		// arr[nx][ny]!=0 맵의 숫자 = > 주사위 바닥 숫자
		// 주사위가 방향에 따라 idx 가 어떻게 바뀌는지

	}
	// 동서 남 북 메서드 구현

	public static void 굴린다 (int cmd) {
		// 굴러갈 다음 좌표 nx , ny
		int nx = x + dx[cmd];
		int ny = y + dy[cmd];
		// 경계 넘어가면 출력X
		if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
			return ;
		}
		int tmp = d[5];
		switch (cmd) {
		// 동
		case 1:
			d[5] = d[2];
			d[2] = d[0];
			d[0] = d[3];
			d[3] = tmp;
			break;
		// 서
		case 2:
			d[5] = d[3];
			d[3] = d[0];
			d[0] = d[2];
			d[2] = tmp;
			break;
		// 북
		case 4:
			d[5] = d[1];
			d[1] = d[0];
			d[0] = d[4];
			d[4] = tmp;
			break;
		// 남
		case 3:
			d[5] = d[4];
			d[4] = d[0];
			d[0] = d[1];
			d[1] = tmp;
			break;
		}
		sb.append(d[0]+"\n");
		// 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사
		x = nx;
		y = ny;
		if (arr[x][y] == 0) {
			arr[x][y] = d[5];
		}
		// 0 이 아닌 경우 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사
		else {
			d[5] = arr[x][y];
			arr[x][y]=0;
		}
		// 주사위 위치 최신화
	}
}
