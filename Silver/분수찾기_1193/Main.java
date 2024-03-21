package Silver.분수찾기_1193;

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        /**
         이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.

         X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int a = 1;
        int b = 1;

        if(num ==1){
            bw.write("1/1");
        }else {
            b++;
            boolean flag = true;
            for(int i = 1  ; i < num-1 ; i++) {
                if(a==1 && flag == false){
                    b++;
                    flag = true;
                }else if(b==1 && flag == true){
                    a++;
                    flag = false;
                }else if(a<b&& flag == true){
                    a++;
                    b--;
                }else if(a<b&& flag == false){
                    a--;
                    b++;
                }else if(a>b&& flag == false) {
                    a--;
                    b++;
                }else if(a>b&& flag == true) {
                    a++;
                    b--;
                }else if(a==b){
                    a--;
                    b++;
                }
            }
            bw.write(a+"/"+b);
        }


        bw.close();
        br.close();


    }
}
