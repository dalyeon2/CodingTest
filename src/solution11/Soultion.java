package solution11;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120808
 * 분수의 덧셈
 */

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int denom = denom1 * denom2;
        int numerA = numer1 * denom2;
        int numerB = numer2 * denom1;
        int totalNumer = numerA + numerB;

        for (int i = denom; i >= 1; i--) {
            if (totalNumer % i == 0 && denom % i == 0) { // 공약수 구하기
                totalNumer /= i; // 공약수로 분자 나누기
                denom /= i; // 공약수로 분모 나누기
            }
        }

        return new int[]{totalNumer, denom};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] testCases = {
                {1, 2, 3, 4},
                {9, 2, 1, 3}
        };

        for (int[] testCase : testCases) {
            int numer1 = testCase[0];
            int denom1 = testCase[1];
            int numer2 = testCase[2];
            int denom2 = testCase[3];
            int[] result = sol.solution(numer1, denom1, numer2, denom2);
            System.out.println("Input: [" + numer1 + ", " + denom1 + ", " + numer2 + ", " + denom2 + "] -> Output: [" + result[0] + ", " + result[1] + "]");
        }
    }
}
