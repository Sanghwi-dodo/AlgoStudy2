package week2.BOJ1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213_김수아 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmp = br.readLine();
        int[] cnt = new int[26]; //카운팅 배열 선언
        for (int i=0; i<tmp.length(); i++) {
            cnt[tmp.charAt(i)-'A']++; //각 알파벳이 몇개 있는지
        }

        //팰린드롬인지 검사
        int oneCnt = 0;
        char oneChar = 0;
        for (int i=0; i<26; i++) {
            if (cnt[i] % 2 == 1) {
                oneCnt++;
                oneChar = (char) (i+'A');
            }
        }

        StringBuilder sb = new StringBuilder();

        if (oneCnt > 1) { //홀수개가 1개 넘어가면 팰린드롬 실패
            System.out.println("I'm Sorry Hansoo");
            return;
        } else {
            for (int i=0; i<26; i++) {
                char c = (char) (i+65);
                sb.append(String.valueOf(c).repeat(cnt[i]/2)); //몫만큼
            }
        }
        String res = sb.toString();
        if (oneCnt == 1) {
            res += String.valueOf(oneChar);
        }
        res += sb.reverse().toString();
        System.out.print(res);
    }
}
