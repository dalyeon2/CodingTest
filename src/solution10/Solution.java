package solution10;

/**
 * 단어 변환
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */

class Solution {
    static int result;  // 최소 변환 단계 수
    static boolean[] visit;  // 방문 여부 체크 배열

    public int solution(String begin, String target, String[] words) {
        result = 0;  // 초기값 설정
        visit = new boolean[words.length];  // 방문 배열 초기화

        // 깊이 우선 탐색 시작
        dfs(begin, target, words, 0);

        return (result == 0) ? 0 : result;  // 변환 불가능할 경우 0 반환
    }

    // DFS 탐색 함수
    static void dfs(String begin, String target, String[] words, int count) {
        // 현재 단어가 목표 단어와 같으면
        if (begin.equals(target)) {
            if (result == 0 || count < result) {
                result = count;  // 최소 단계 업데이트
            }
            return;  // 탐색 종료
        }

        // 각 단어에 대해 탐색
        for (int i = 0; i < words.length; i++) {
            if (visit[i]) continue;  // 이미 방문한 단어는 무시

            int differenceCount = 0;  // 다른 알파벳 수 카운트
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    differenceCount++;  // 알파벳이 다르면 카운트
                }
            }

            // 한 알파벳만 다른 경우
            if (differenceCount == 1) {
                visit[i] = true;  // 방문 체크
                dfs(words[i], target, words, count + 1);  // 재귀 호출
                visit[i] = false;  // 탐색 후 방문 체크 해제
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"})); // 4
        System.out.println(solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"})); // 0
    }
}
