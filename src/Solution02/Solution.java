package Solution02;

public class Solution {
    public int solution(int n) {
        // 모듈러 연산을 위한 상수
        final int MOD = 1234567;

        // 피보나치 수를 저장할 배열
        int[] fib = new int[n + 1];

        // 초기값 설정
        fib[0] = 0;
        fib[1] = 1;

        // 동적 프로그래밍을 사용하여 피보나치 수열 계산
        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % MOD;
        }

        // n번째 피보나치 수를 반환
        return fib[n];
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
