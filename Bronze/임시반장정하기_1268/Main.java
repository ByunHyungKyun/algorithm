package Bronze.임시반장정하기_1268;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] students = new int[N+1][6];
        int ans = 0;
        int max = 0;

        for(int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=5; j++) {
                students[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i<=N; i++) {
            int cnt = 0;
            for(int j = 1; j<=N; j++) {
                for(int k = 1; k <= 5; k++) {
                    if(students[i][k] == students[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max) {
                max = cnt;
                ans = i;
            }
        }


        System.out.println(ans);
    }

}

























