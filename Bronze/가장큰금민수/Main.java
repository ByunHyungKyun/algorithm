package Bronze.가장큰금민수;
import java.io.*;

class Main {
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String val = br.readLine();

        char[] valList = val.toCharArray();
        boolean resultflag = false;
        String result = "";

        for (char aa : valList) {
            int temp = Integer.parseInt(String.valueOf(aa));
            if (temp != 4 && temp != 7) {
                resultflag = true;
            }
        }
        boolean testflag = false;
        boolean reflag = true;
        if (resultflag) {
            boolean flag = true;
            for (int i = 0; i < valList.length; i++) {
                int temp = Integer.parseInt(String.valueOf(valList[i]));
                if (i == 0) {
                    if (4 <= temp && temp < 7 ) {
                        result += flag(temp);
                        testflag = true;
                    } else if (7 == temp) {
                        result += flag(temp);
                    } else if (7 < temp) {
                        result += flag(temp);
                        testflag = true;
                    } else {
                        flag = false;
                    }
                } else {
                    if(temp != 0){
                        reflag =  false;
                    }
                    if(testflag){
                        result += "7";
                    }else{
                        if (flag) {
                            result += flag(temp);
                        } else {
                            result += "7";
                        }
                    }
                }
            }
        } else {
            result = val;
        }

        String realResult = "";
        if(reflag){
            realResult = result.substring(1);
        }else {
            realResult = result;
        }

        bw.write(realResult);

        bw.close();
        br.close();
    }

    public static String flag(int temp) {
        String a = "7";
        String b = "4";
        if (temp == 0) {
            return a;
        } else if (temp == 4) {
            return b;
        } else if (temp == 7) {
            return a;
        } else if (4 < temp && temp < 7) {
            return b;
        } else if (7 < temp && temp < 4) {
            return a;
        }
        return a;
    }

}

























