package week2.BOJ18111;
import java.util.*;
import java.io.*;

public class BOJ_181111_Ahn {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int bag = Integer.parseInt(st.nextToken());
		int arr[][]=new int [n][m];
		for (int i = 0; i < arr.length; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}

		int mintime=Integer.MAX_VALUE;
		int height =0;
		int time=0;
		int firstbag =bag;
		for (int h = 0; h <= 256; h++) {
			time=0;
			bag=firstbag;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					if(arr[i][j]>h) {
						bag+=arr[i][j]-h;
						time+=2*(arr[i][j]-h);
					}else if(arr[i][j]<h) {
						bag-=h-arr[i][j];
						time+=(h-arr[i][j]);
					}
				}
			}
			if(mintime>=time&&bag>=0) {
				mintime=time;
				height=h;
			}
			
			
		}
		System.out.println(mintime+" "+height);
		
		
	}
}
