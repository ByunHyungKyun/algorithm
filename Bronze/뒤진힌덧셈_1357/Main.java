package Bronze.뒤진힌덧셈_1357;


import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
/**
 문제
 어떤 수 X가 주어졌을 때, X의 모든 자리수가 역순이 된 수를 얻을 수 있다. Rev(X)를 X의 모든 자리수를 역순으로 만드는 함수라고 하자. 예를 들어, X=123일 때, Rev(X) = 321이다. 그리고, X=100일 때, Rev(X) = 1이다.

 두 양의 정수 X와 Y가 주어졌을 때, Rev(Rev(X) + Rev(Y))를 구하는 프로그램을 작성하시오

 입력
 첫째 줄에 수 X와 Y가 주어진다. X와 Y는 1,000보다 작거나 같은 자연수이다.

 출력
 첫째 줄에 문제의 정답을 출력한다.
 */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer num = new StringTokenizer(br.readLine());

        char[] a = num.nextToken().toCharArray();
        char[] b = num.nextToken().toCharArray();

        String resulta = "";
        String resultb = "";
        int resultc = 0;
        String resultCheck = "";
        int result = 0;

        for(int i = a.length-1; 0<=i ; i--){
            resulta += a[i];
        }
        for(int i = b.length-1; 0<=i ; i--){
            resultb += b[i];
        }

        resultc = Integer.parseInt(resulta)+Integer.parseInt(resultb);
        char[] c = String.valueOf(resultc).toCharArray();

        for(int i = c.length-1; 0<=i ; i--){
            resultCheck += c[i];
        }

        result = Integer.parseInt(resultCheck);

        bw.write(String.valueOf(result));

        bw.close();
        br.close();
    }
}























