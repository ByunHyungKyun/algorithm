package Bronze.적어도대부분의배수_1145;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        /**
         문제
         다섯 개의 자연수가 있다. 이 수의 적어도 대부분의 배수는 위의 수 중 적어도 세 개로 나누어 지는 가장 작은 자연수이다.

         서로 다른 다섯 개의 자연수가 주어질 때, 적어도 대부분의 배수를 출력하는 프로그램을 작성하시오.

         입력
         첫째 줄에 다섯 개의 자연수가 주어진다. 100보다 작거나 같은 자연수이고, 서로 다른 수이다.

         출력
         첫째 줄에 적어도 대부분의 배수를 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer num = new StringTokenizer(br.readLine());

        ArrayList<Integer> val = new ArrayList<>();

        while (num.hasMoreTokens()){
            val.add(Integer.valueOf(num.nextToken()));
        }

        Collections.sort(val);

        int result = 0;
        int a = 0;
        int i = val.get(0);
        while(true){
            a = 0;
            for (Integer vlaue : val) {
                if (i % vlaue == 0) {
                    a++;
                }
            }
            if (3 <= a) {
                result = i;
                break;
            }
            i++;
        }

        bw.write(String.valueOf(result));
        bw.close();
        br.close();


    }
}
