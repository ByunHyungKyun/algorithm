package Bronze.팀이름정하기_1269;


import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
/**
 문제
 연두는 프로그래밍 대회에 나갈 팀 이름을 정하려고 한다. 미신을 믿는 연두는 이환이에게 공식을 하나 받아왔고, 이 공식을 이용해 우승할 확률이 가장 높은 팀 이름을 찾으려고 한다.

 이환이가 만든 공식은 사용하려면 먼저 다음 4가지 변수의 값을 계산해야 한다.

 L = 연두의 이름과 팀 이름에서 등장하는 L의 개수
 O = 연두의 이름과 팀 이름에서 등장하는 O의 개수
 V = 연두의 이름과 팀 이름에서 등장하는 V의 개수
 E = 연두의 이름과 팀 이름에서 등장하는 E의 개수
 그 다음, 위에서 구한 변수를 다음 식에 입력하면 팀 이름의 우승할 확률을 구할 수 있다.

 ((L+O) × (L+V) × (L+E) × (O+V) × (O+E) × (V+E)) mod 100

 연두의 영어 이름과 팀 이름 후보 N개가 주어졌을 때, 우승할 확률이 가장 높은 팀 이름을 구해보자. 확률이 가장 높은 팀이 여러가지인 경우 사전 순으로 가장 앞서는 팀 이름이 우승할 확률이 가장 높은 것이다.

 입력
 첫째 줄에 연두의 영어 이름이 주어진다. 둘째 줄에는 팀 이름 후보의 개수 N이 주어진다. 셋째 줄부터 N개의 줄에 팀 이름이 한 줄에 하나씩 주어진다.
 연두의 영어 이름과 팀 이름은 길이는 1보다 크거나 같고, 20보다 작거나 같으며, 알파벳 대문자로만 이루어져 있다. N은 50보다 작거나 같은 자연수이다.

 출력
 첫째 줄에 우승할 확률이 가장 높은 팀 이름을 출력한다.


 1. 연우의 이름으로 맵을 만든다 --> 만들때 값을 각이름과 최종값을 저장하는 부분도 저장
 2. 주어진 num으로 각 이름을 입력받아 맵에 저장--> 값들을 만든다
 3. 맵에 대한 값들을 찾고 값이 같은 것들중에 가장 처음 알파벳을 찾기.
 */


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String yname = br.readLine();
        char[] charArray = yname.toCharArray();

        HashMap<String, String> valMap = new HashMap<>();
        valMap.put("L", "0");
        valMap.put("O", "0");
        valMap.put("V", "0");
        valMap.put("E", "0");
        ArrayList<HashMap> valList = new ArrayList<>();

        for (int i = 0; i < charArray.length; i++) {

            if (charArray[i] == 'L') {
                String l = valMap.get("L");
                int a = Integer.parseInt(l);
                a++;
                valMap.put("L", String.valueOf(a));
            } else if (charArray[i] == 'O') {
                String l = valMap.get("O");
                int a = Integer.parseInt(l);
                a++;
                valMap.put("O", String.valueOf(a));
            } else if (charArray[i] == 'V') {
                String l = valMap.get("V");
                int a = Integer.parseInt(l);
                a++;
                valMap.put("V", String.valueOf(a));
            } else if (charArray[i] == 'E') {
                String l = valMap.get("E");
                int a = Integer.parseInt(l);
                a++;
                valMap.put("E", String.valueOf(a));
            }
        }

        int num = Integer.parseInt(br.readLine());

        for (int j = 0; j < num; j++) {
            HashMap<String, String> strMap = new HashMap<>();
            strMap.put("L", valMap.get("L"));
            strMap.put("O", valMap.get("O"));
            strMap.put("V", valMap.get("V"));
            strMap.put("E", valMap.get("E"));

            String team = br.readLine();
            char[] strVal = team.toCharArray();

            for (int i = 0; i < strVal.length; i++) {
                if (strVal[i] == 'L') {
                    String l = strMap.get("L");
                    int a = Integer.parseInt(l);
                    a++;
                    strMap.put("L", String.valueOf(a));
                } else if (strVal[i] == 'O') {
                    String l = strMap.get("O");
                    int a = Integer.parseInt(l);
                    a++;
                    strMap.put("O", String.valueOf(a));
                } else if (strVal[i] == 'V') {
                    String l = strMap.get("V");
                    int a = Integer.parseInt(l);
                    a++;
                    strMap.put("V", String.valueOf(a));
                } else if (strVal[i] == 'E') {
                    String l = strMap.get("E");
                    int a = Integer.parseInt(l);
                    a++;
                    strMap.put("E", String.valueOf(a));
                }

                if (i == strVal.length - 1) {
                    strMap.put("name", team);

                    int L = Integer.parseInt(strMap.get("L"));
                    int O = Integer.parseInt(strMap.get("O"));
                    int V = Integer.parseInt(strMap.get("V"));
                    int E = Integer.parseInt(strMap.get("E"));

                    int result = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;

                    strMap.put("result", String.valueOf(result));
                }
            }
            valList.add(strMap);
        }

        int temp = Integer.parseInt(String.valueOf(valList.get(0).get("result")));
        ArrayList<String> resultlist = new ArrayList<>();

        for (int i = 0; i < valList.size(); i++) {
                if (temp < Integer.parseInt(String.valueOf(valList.get(i).get("result")))) {
                    temp = Integer.parseInt(String.valueOf(valList.get(i).get("result")));
                }
        }

        for (int i = 0; i < valList.size(); i++) {
                if (temp == Integer.parseInt(String.valueOf(valList.get(i).get("result")))) {
                    resultlist.add(String.valueOf(valList.get(i).get("name")));
                }
        }

        Collections.sort(resultlist);

        bw.write(String.valueOf(resultlist.get(0)));

        bw.close();
        br.close();
    }
}























