package Bronze.저항_1076;

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        /**
         문제
         전자 제품에는 저항이 들어간다. 저항은 색 3개를 이용해서 그 저항이 몇 옴인지 나타낸다. 처음 색 2개는 저항의 값이고, 마지막 색은 곱해야 하는 값이다. 저항의 값은 다음 표를 이용해서 구한다.
         예를 들어, 저항의 색이 yellow, violet, red였다면 저항의 값은 4,700이 된다.

         입력
         첫째 줄에 첫 번째 색, 둘째 줄에 두 번째 색, 셋째 줄에 세 번째 색이 주어진다. 위의 표에 있는 색만 입력으로 주어진다.

         출력
         입력으로 주어진 저항의 저항값을 계산하여 첫째 줄에 출력한다.
         */


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String first = br.readLine();
        color firstColor = color.valueOf(first);

        String second = br.readLine();
        color secondColor = color.valueOf(second);

        String third = br.readLine();
        val thirdNum = val.valueOf(third);


        String a = String.valueOf(firstColor.getColornum());
        String b = String.valueOf(secondColor.getColornum());

        String numVal = a+b;
        String result = String.valueOf(Long.parseLong(numVal)*thirdNum.getValnum());

        bw.write(result);

        bw.close();
        br.close();
    }
}

enum color {
    black(0),brown(1),red(2),orange(3),yellow(4),green(5)
    ,blue(6),violet(7),grey(8),white(9);

    private  final int colornum;

    color(int colornum){
        this.colornum = colornum;
    }
    public int getColornum(){
        return colornum;
    }
}

enum val {
    black(1),brown(10),red(100),orange(1000),yellow(10000),green(100000)
    ,blue(1000000),violet(10000000),grey(100000000),white(1000000000);

    private  final int valnum;

    val(int valnum){
        this.valnum = valnum;
    }
    public int getValnum(){
        return valnum;
    }
}