package solution12;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181847
 * 0 떼기
 */

class Solution {
    public String solution(String n_str) {
        return n_str.replaceFirst("^0+", "");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] testCases = {"0010", "854020", "000123", "0456000", "0000001"};

        for (String testCase : testCases) {
            String result = sol.solution(testCase);
            System.out.println("Input: " + testCase + " -> Output: " + result);
        }
    }
}

