package solution05;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 집의 수
        int[][] cost = new int[N][3]; // 각 집을 칠하는 비용

        // 비용 입력
        for (int i = 0; i < N; i++) {
            cost[i][0] = sc.nextInt(); // 빨강 비용
            cost[i][1] = sc.nextInt(); // 초록 비용
            cost[i][2] = sc.nextInt(); // 파랑 비용
        }

        // DP 테이블 초기화
        int[][] dp = new int[N][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        // DP 계산
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }

        // 최솟값 출력
        int result = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.println(result);

        sc.close();
    }
}
