package Bronze.AB_2558;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        /**

         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int result = a+b;

        bw.write(String.valueOf(result));

        bw.close();
        br.close();
    }
}
