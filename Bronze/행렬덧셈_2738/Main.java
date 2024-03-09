package Bronze.행렬덧셈_2738;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer val  =  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(val.nextToken());
        int m = Integer.parseInt(val.nextToken());

        ArrayList<String> list =  new ArrayList<>();

        for (int i = 0 ; i < (n*2);i++){
            list.add(br.readLine());
        }



        for(int i = 0 ; i < n;i++){
            String result = "";
            StringTokenizer first = new StringTokenizer(list.get(i));
            StringTokenizer second = new StringTokenizer(list.get(n+i));

            for(int j = 0 ; j < m;j++){
                if(j == m-1){
                    result += Integer.parseInt(first.nextToken())+Integer.parseInt(second.nextToken());
                }else {
                    result += Integer.parseInt(first.nextToken())+Integer.parseInt(second.nextToken())+" ";
                }

            }
            bw.write(result+"\n");
        }

        bw.close();
        br.close();
    }
}
