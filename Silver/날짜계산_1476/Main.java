package Silver.날짜계산_1476;
// 당신은 또한 가져오기를 사용할 수 있습니다, 예를 들면: // import java.util. *;  // 디버깅 목적으로 stdout에 쓸 수 있습니다, 예. // System.out.println("이것은 디버그 메시지입니다");  클래스 솔루션 { Public int solution(int[] start, int[] dest, int[] limit) { // 여기에서 당신의 해결책을 구현하세요 }ss// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message")sd;

class Solution2 {
    static int maxValue = 0;
    static int maxLocation = 0;
    static int sum = 0;

    public int solution(int[] start, int[] dest, int[] limit) {
        // Implement your solution here

        for (int i = 0; i < start.length; i++) {
            MaxValue(maxValue, start[i]);
            MaxValue(maxValue, dest[i]);
            SumValue(Math.abs(start[i] - dest[i]));
        }

        if (limit[maxLocation] < sum) {
            sum = limit[maxLocation];
        }

        return sum;
    }

    public void MaxValue(int maxVal, int val) {
        if (maxVal < val) {
            maxValue = val;
            maxLocation = maxValue;
        }
    }

    public void SumValue(int result) {
        if (result == 1) {
            sum += 3;
        } else {
            sum += (1 + (result * 2));
        }
    }
}