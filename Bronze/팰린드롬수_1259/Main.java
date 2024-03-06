package Bronze.팰린드롬수_1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String answer = "yes";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            answer = "yes";
            solution(num);
        }
    }

    // two pointer
    private static void solution(int num) {
        String str = String.valueOf(num);

        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                answer = "no";
                break;
            }

            start++;
            end--;
        }

        System.out.println(answer);
    }
}