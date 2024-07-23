package solution01;

import java.util.Arrays;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=java
*
* */

public class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        // String.valueOf 객체를 string 으로 변환
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // Arrays.sort(array, comparator)
        // b + a와 a + b를 비교하여 정렬 순서를 결정
        // b + a: 문자열 b 뒤에 a를 붙인 문자열
        // a + b: 문자열 a 뒤에 b를 붙인 문자열
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // StringBuilder 를 사용해 각 숫자 문자를 append
        String answer = String.join("", arr);

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{6, 10, 2})); // "6210"
        System.out.println(sol.solution(new int[]{3, 30, 34, 5, 9})); // "9534330"
    }
}
