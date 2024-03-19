package Bronze.평균_1546;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        /**
         문제
         세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
         예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
         세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.

         입력
         첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다. 둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.

         출력
         첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer val = new StringTokenizer(br.readLine());
        ArrayList<Integer> valList = new ArrayList<>();
        ArrayList<Double> resultList = new ArrayList<>();

        while (val.hasMoreTokens()){
            valList.add(Integer.parseInt(val.nextToken()));
        }

        Collections.sort(valList);

        double flag = valList.get(valList.size()-1);

        for (Integer s : valList) {
            double temp = s;
            resultList.add(temp / flag * 100);
        }

        double result = 0;

        for (Double value : resultList){
            result += value;
        }

        bw.write(String.valueOf((result/num)));

        bw.close();
        br.close();


    }
}
