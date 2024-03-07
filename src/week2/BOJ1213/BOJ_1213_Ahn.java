package week2.BOJ1213;
import java.util.*;
import java.io.*;

public class BOJ_1213_Ahn {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
	String str = br.readLine();
	boolean pelin = true;
	String ans = "I'm Sorry Hansoo";
	//cnt 배열에 알파벳 갯수 세서 추가
	int cnt [] = new int[26];
	for(int i=0; i<str.length();i++) {
		int a = str.charAt(i)-'A';
		cnt[a]++;
	}
	
		// 팰린드롬 시도 해볼 result 배열
		int result[] = new int [str.length()];
		
		//길이 짝수 홀수 나누기
		// 짝수
		// cnt배열 탐색하면서 idx 0이아닐때부터 cnt--해주면서 그 숫자를 양끝에 넣자
		int cntidx=0;
		int resultidx=0;
		int horse=0;
		if(str.length()%2==0) {
		while(true) {
			//  0 아닌 문자 찾고
			while(cntidx<26&&cnt[cntidx]<=0) {
				cntidx++;
			} 
			if(cntidx>=26)break;
			// res 양옆에 넣고 cnt가 홀수일수도있잖음 그건 거르자
			if(cnt[cntidx]%2!=0) {
				pelin=false;
				break;
			}
			cnt[cntidx]-=2;
			if(resultidx>(str.length()/2)-1)break;
			result[resultidx]=cntidx;
			result[str.length()-resultidx-1]=cntidx;
			resultidx++;
		}
		//펠린드롬 확인하구 맞으면 그문자 아니면 ans 그대로 출력
		for(int i=0; i<str.length();i++) {
			if(result[i]!=result[str.length()-1-i]) {
				pelin=false;
				break;
			}
		}
		if(pelin) {
			for(int i=0; i<str.length();i++) {
				System.out.print((char)(result[i]+'A'));
			}
		}else {
			System.out.println(ans);
		}
		}else if(str.length()%2==1) {
			while(true) {
				//  0 아닌 문자 찾고
				while(cntidx<26&&cnt[cntidx]<=0) {
					cntidx++;
				} 
				if(cntidx>=26)break;
				// 홀수 cnt 는 항상 가운데에 한개와야댐 홀수 여러개면 break
				 if(cnt[cntidx]%2==1) {
					 horse++;
					 if(horse>1) {
						 pelin=false;
						 break;
					 }
					 result[str.length()/2]=cntidx;
					 cnt[cntidx]--;
					 continue;
				 }
				cnt[cntidx]-=2;
				if(resultidx>(str.length()/2)-1)break;
				result[resultidx]=cntidx;
				result[str.length()-resultidx-1]=cntidx;
				resultidx++;
			}
			for(int i=0; i<str.length();i++) {
				if(result[i]!=result[str.length()-1-i]) {
					pelin=false;
					break;
				}
			}
			if(pelin) {
				for(int i=0; i<str.length();i++) {
					System.out.print((char)(result[i]+'A'));
				}
			}else {
				System.out.println(ans);
			}
		}
	}
}
