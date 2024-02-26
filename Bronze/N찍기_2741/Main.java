package Bronze.N찍기_2741;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 1 ; i <=num;i++){
            bw.write(String.valueOf(i));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
