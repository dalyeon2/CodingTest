package solution03;
/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/147355
 */

public class Solution {

    public int solution(String t, String p) {

        int count = 0;

        for (int i = 0; i <= t.length() - p.length(); i++) {
            String substring = t.substring(i, i + p.length());
            if (Long.parseLong(substring) <= Long.parseLong(p)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
       Solution sol = new Solution();

        // 테스트 케이스 1
        System.out.println(sol.solution("3141592", "271")); // 2

        // 테스트 케이스 2
        System.out.println(sol.solution("500220839878", "7")); // 8

        // 테스트 케이스 3
        System.out.println(sol.solution("10203", "15")); // 3

        // 추가 테스트 케이스
        System.out.println(sol.solution("1234567890", "123")); // 1
        System.out.println(sol.solution("987654321", "1000")); // 0
    }
}

