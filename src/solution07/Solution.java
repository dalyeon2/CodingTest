package solution07;

/**
 * 나이 출력
 * https://school.programmers.co.kr/learn/courses/30/lessons/120820
 */

public class Solution {
    public static int solution(int age) {
        return 2022 - age + 1;
    }

    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(solution(40)); // 1983
        System.out.println(solution(23)); // 2000
    }

}
