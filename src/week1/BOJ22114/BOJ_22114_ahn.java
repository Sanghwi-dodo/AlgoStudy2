package week1.BOJ22114;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] ewr) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 창영이와 점프

		StringTokenizer st = new StringTokenizer(br.readLine());
		// n 블럭 k 보폭
		int n = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		// 투포인터
		// left right 
		// 변수 좌표값 초기화 위한 save
		// superjmp 사용 여부 true false
		// max , cnt
		
		int left=0; int right=0;
		int save =0;
		boolean superjmp =true;
		int max = 0,cnt=1;
		
		while(right<=arr.length-1) {
			if(arr[right]<=k) {
				cnt++;
				right++;
				max = Math.max(max, cnt);
			}
			// 못 건널때 superjmp 가능한지 여부
			else {
				if(superjmp) {
					superjmp=false;
					save = right+1;
					right++;
					cnt++;
				}else if(!superjmp) {
					max = Math.max(max, cnt);
					left=save;
					right=save;
					cnt=1;
					superjmp = true;
				}
			}
		}
		
		System.out.println(Math.max(cnt , max));
		
	

	}
}
