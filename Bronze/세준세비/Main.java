package Bronze.세준세비;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        /**
         문제
         세준이와 세비는 온라인 게임을 즐겨한다. 이 온라인 게임에서는 군대를 서로 키울 수 있다. 세준이는 N명의 병사를 키웠고, 세비는 M명의 병사를 키웠다.
         이제 서로 전쟁을 하려고 한다.
         전쟁은 여러 번의 전투로 이루어진다. 각 전투에서 살아있는 병사중 제일 약한 병사가 죽는다. 만약 제일 약한 병사가 여러 명이고, 제일 약한 병사가 모두 같은 편에 있다면,
         그 중에 한 명이 임의로 선택되어 죽는다. 하지만, 제일 약한 병사가 여러 명이고, 양 편에 모두 있다면, 세비의 제일 약한 병사 중 한 명이 임의로 선택되어 죽는다.
         전쟁은 한 명의 병사를 제외하고 모두 죽었을 때 끝난다. 전쟁의 승자를 출력하는 프로그램을 작성하시오.


         입력
         첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 100보다 작거나 같다. 각 테스트 케이스는 다음과 같이 이루어져 있다. 첫째 줄에 N과 M이 들어오고,
         둘째 줄에는 세준이의 병사들의 힘이 들어오고, 셋째 줄에는 세비의 병사들의 힘이 들어온다. 힘은 정수이고, 이 값이 클수록 강하고, 작을수록 약하다.
         각 테스트 케이스는 줄 바꿈으로 구분되어 있다.


         출력
         각 테스트 케이스에 대해서 한 줄에 하나씩 차례대로 승자를 출력한다. 세준이가 이기면 S를 세비가 이기면 B를 둘다 아닐 경우에는 C를 출력한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer val = new StringTokenizer(br.readLine());
            val = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(val.nextToken());
            int b = Integer.parseInt(val.nextToken());

            ArrayList<Integer> alist = new ArrayList<>();
            ArrayList<Integer> blist = new ArrayList<>();

            val = new StringTokenizer(br.readLine());
            for (int j = 0; j < a; j++) {
                alist.add(Integer.parseInt(val.nextToken()));
            }

            val = new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++) {
                blist.add(Integer.parseInt(val.nextToken()));
            }

            Collections.sort(alist);
            Collections.sort(blist);

            int resulta = alist.get(alist.size() - 1);
            int resultb = blist.get(blist.size() - 1);

            if (resulta < resultb) {
                bw.write("B" + "\n");
            } else if (resulta > resultb) {
                bw.write("S" + "\n");
            } else if (resulta == resultb) {
                if (a < b) {
                    bw.write("B" + "\n");
                } else if (a > b) {
                    bw.write("S" + "\n");
                } else {
                    bw.write("S" + "\n");
                }
            }
        }

        bw.close();
        br.close();
    }
}
