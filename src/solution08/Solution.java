package solution08;

/**
 * 정수 제곱근
 * https://school.programmers.co.kr/learn/courses/30/lessons/12934
 */

public class Solution {
    public static long solution(long n) {
        long sqrt = (long) Math.sqrt(n);
        return (sqrt * sqrt == n) ? (long) Math.pow(sqrt + 1, 2) : -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(121)); // 144
        System.out.println(solution(3));   // -1
    }
}

