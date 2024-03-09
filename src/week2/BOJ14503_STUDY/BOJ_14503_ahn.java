package week2.BOJ14503_STUDY;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	// 북 동 남 서
	static int dx []= {-1 ,0 , 1, 0};
	static int dy []= {0, 1, 0 ,-1};
	public static void main(String[] ewr) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int arr[][] = new int [n][m];
		//1.  0은 청소 필요 현재 칸 청소
		// 2.주변 4칸 중 청소되지않은 빈칸이 없는 경우
		// 방향 유지한 채로 후진 후 1번으로
		// 후진이 벽이면 멈춤
		// if 4방 0이아닌경우 
		// 3. 주변 4칸 중 빈칸이 있는 경우
		// 왼쪽 90도 회전
		// 앞쪽칸 청소 안되었으면 전진 후 1번으로
		
		// d - 0 북 1 동 2 남 3 서
		st = new StringTokenizer(br.readLine());
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		int dir=Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		// 청소횟수 cnt
		int cnt = 1;
		arr[x][y]=3;
		
		loop : while(true) {
		boolean go = false;
		// 청소할 곳 있나 탐색
		for(int d=0;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx>=0&&ny>=0&&nx<n&&ny<m) {
				if(arr[nx][ny]==0) {
					go=true;
					break;
				}
			}
		}
		// 0이 있으면
		if(go) {
			// 나올 때 까지 돌려야함
			while(true) {
				dir = (dir+3)%4;
				int gox = x+dx[dir];
				int goy = y+dy[dir];
				if(gox>=0&&goy>=0&&gox<n&&goy<m&&arr[gox][goy]==0) {
					x=gox;
					y=goy;
					arr[x][y]=3;
					cnt++;
					break;
				}
				gox= x-dx[dir];
				goy= y-dx[dir];
				
				dir = (dir+3)%4;
				gox = x+dx[dir];
				goy = y+dy[dir];
				if(gox>=0&&goy>=0&&gox<n&&goy<m&&arr[gox][goy]==0) {
					x=gox;
					y=goy;
					arr[x][y]=3;
					cnt++;
					break;
				}
				gox= x-dx[dir];
				goy= y-dx[dir];
				
				dir = (dir+3)%4;
				gox = x+dx[dir];
				goy = y+dy[dir];
				if(gox>=0&&goy>=0&&gox<n&&goy<m&&arr[gox][goy]==0) {
					x=gox;
					y=goy;
					arr[x][y]=3;
					cnt++;
					break;
				}
				gox= x-dx[dir];
				goy= y-dx[dir];
				
				dir = (dir+3)%4;
				gox = x+dx[dir];
				goy = y+dy[dir];
				if(gox>=0&&goy>=0&&gox<n&&goy<m&&arr[gox][goy]==0) {
					x=gox;
					y=goy;
					arr[x][y]=3;
					cnt++;
					break;
				}
				gox= x-dx[dir];
				goy= y-dx[dir];
				

			}
		}
		// 0이 없어
		else {
			int backdir= (dir+2)%4;
			int backx = x+dx[backdir];
			int backy = y+dy[backdir];
			// 종료 조건 back 했는데 벽
			if(arr[backx][backy]==1||backx==-1||backy==-1||backx==n||backy==m) {
				break loop;
			}// 벽이아니면 이동, 청소도해
			else if (arr[backx][backy]!=1&&backx>=0&&backy>=0&&backx<n&&backy<m){
				x=backx;
				y=backy;
				if(arr[x][y]==0) {
				arr[x][y]=3;
				cnt++;
				}
			}
		}
		
	
	}
		System.out.println(cnt);
	}
}