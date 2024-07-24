package Solution02;


/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12945?itm_content=course14743
 *
 * */

public class Solution {
    private static final int MOD = 1234567;

    public int solution(int n) {
        return fibonacci(n);
    }

    private int fibonacci(int n) {
        return n == 0 ? 0 :
                n == 1 ? 1 :
                (fibonacci(n - 1) + fibonacci(n - 2)) % MOD;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 예제 입력 값
        int n1 = 3;
        int n2 = 5;

        // solution 메서드 호출 및 결과 출력
        int result1 = sol.solution(n1);
        int result2 = sol.solution(n2);

        System.out.println("n = " + n1 + ", result = " + result1); // 출력: n = 3, result = 2
        System.out.println("n = " + n2 + ", result = " + result2); // 출력: n = 5, result = 5
    }
}
