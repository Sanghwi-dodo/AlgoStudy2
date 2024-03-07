package week2.BOJ30892;
import java.util.*;
import java.io.*;

public class BOJ_30892_Ahn{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 상어 수 n 꿀꺽 가능 상어 k 샼 최초 크키 T
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long shak = Integer.parseInt(st.nextToken());

		Stack<Integer> stk = new Stack<>();
		// 자 스택에 기능이 맨뒤에있는거 꺼내기
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		//
		ob: for (int i = 0; i < arr.length; i++) {
			if (arr[i] < shak) {
				stk.push(arr[i]);
			} else if (arr[i] >= shak) {
				while (k > 0 && arr[i] >= shak) {
					if (stk.isEmpty())
						break ob;
					shak += stk.pop();
					k--;
				}
				stk.push(arr[i]);
			}
		}
		for(int i=0;i<k;i++) {
			if(!stk.isEmpty()) {
				shak+=stk.pop();
			}
		}
		
		
		System.out.println(shak);

	}
}
