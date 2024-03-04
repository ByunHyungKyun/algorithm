package Bronze.단어공부_1157;

import java.io.*;
import java.util.HashMap;

class Main {
    public static void main(String[] args) throws IOException {

        /**
         문제
         알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

         입력
         첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

         출력
         첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] val = br.readLine().split("");

        for(int i = 0 ; i < val.length;i++){
            val[i] = val[i].toUpperCase();
        }

        HashMap<String,Integer> result = new HashMap<>();

        for(int i = 0 ; i < val.length;i++){
            if(result.get(val[i])==null){
                result.put(val[i],1);
            }else {
                result.put(val[i],result.get(val[i])+1);
            }
        }

        String resultch = "";
        int temp = 0;

        for(String value : result.keySet()) {
            if (temp < result.get(value)) {
                resultch = value;
                temp = result.get(value);
            }
        }

        for(String value : result.keySet()) {
            if (temp == result.get(value) && !resultch.equals(value)) {
                resultch = "?";
            }
        }

        bw.write(String.valueOf(resultch));
        bw.close();
        br.close();


    }
}
