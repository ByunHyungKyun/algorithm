package Bronze.가장큰금민수;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        /**
         문제
         은민이는 4와 7을 좋아하고, 나머지 숫자는 싫어한다. 금민수는 어떤 수가 4와 7로만 이루어진 수를 말한다.
         N이 주어졌을 때, N보다 작거나 같은 금민수 중 가장 큰 것을 출력하는 프로그램을 작성하시오.

         입력
         첫째 줄에 N이 주어진다. N은 4보다 크거나 같고 1,000,000보다 작거나 같은 자연수이다.

         출력
         첫째 줄에 N보다 작거나 같은 금민수 중 가장 큰 것을 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        while(true) {
            boolean check = true;
            for(int i = 0; i < N.length(); i++) {
                if(N.charAt(i) != '4' && N.charAt(i) != '7') {
                    check = false;
                    break;
                }
            }
            if(check == true) break;
            else N = String.valueOf(Integer.parseInt(N) - 1);
        }
        System.out.println(N);
    }

}

























