package week2.BOJ1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 알파벳 갯수 체크 배열
		int[] arr = new int[26];
		
		//출력 결과를 담을 result
		String result = "";
		
		// 팰린드롬으로 만들 문자열
		String str = br.readLine();
		
		// 각 알파벳이 몇 개 있는지 체크하기 위한 문자열 완전 탐색
		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'A';
			arr[idx]++;
		}
		
		// 홀수 갯수를 세기 위한 cnt 변수 , 홀수가 있다면 몇 번째 인덱스인지 저장
		int cnt = 0;
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				index = i;
				cnt++;
			}
		}
		// 홀수를 가진 알파벳이 2개 이상이면 회문 생성 불가
		if (cnt >= 2) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		// 배열 완전탐색
		for (int i = 0; i < arr.length; i++) {
			
			// 해당 배열에 문자가 존재함을 확인하는 반복문
			for (int j = 0; j < arr[i] / 2; j++) {
				// 정수에 문자 'A'를 더해 형변환 해서 StringBuilder에 저장
				sb.append((char) (i + 'A'));
			}
		}
		// result에 붙여넣기
		result += sb.toString();
		
		// 홀수 문자가 한 개라면 앞선 작업과 마찬가지로 형변환 하여 result에 붙여넣기
		if (cnt == 1) {
			result += (char) (index + 'A');
		}
		
		// StringBuilder에 담긴 문자들을 거꾸로 result에 붙여넣어 회문 완성
		result += sb.reverse().toString();
		
		//출력
		System.out.println(result);
	}
}
