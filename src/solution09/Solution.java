package solution09;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 트리의 부모 찾기
 * https://www.acmicpc.net/problem/11725
 */

public class Solution {
    static ArrayList<Integer>[] tree; // 트리를 저장할 인접 리스트, 각 노드가 연결된 다른 노드들을 동적으로 저장하기 위해 ArrayList를 사용
    static int[] parents; // 각 노드의 부모를 저장할 배열
    static boolean[] visited; // 방문 여부를 저장할 배열, DFS 탐색 중에 이미 방문한 노드를 다시 방문하지 않도록 하기 위해 필요

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 노드의 개수
        tree = new ArrayList[n + 1];
        parents = new int[n + 1];
        visited = new boolean[n + 1];

        // 트리 초기화, 각 노드에 대해 연결된 노드들을 저장하기 위한 공간을 할당
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 입력 받기
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b); // a 노드에 b를 연결
            tree[b].add(a); // b 노드에 a를 연결 (무방향 트리이므로 양방향으로 연결)
        }

        // DFS로 부모 찾기 시작 (루트는 1로 설정)
        // 1번 노드를 루트로 설정하고 DFS를 시작합니다.
        dfs(1);

        // 결과 출력
        // 2번 노드부터 각 노드의 부모를 출력합니다.
        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    // DFS 탐색
    // 각 호출에서 현재 노드와 연결된 노드를 탐색하며, 부모 노드를 설정하고 재귀적으로 탐색을 이어감
    static void dfs(int node) {
        visited[node] = true; // 현재 노드를 방문했음을 표시
        for (int next : tree[node]) { // 현재 노드와 연결된 모든 노드를 탐색
            if (!visited[next]) { // 방문하지 않은 노드라면
                parents[next] = node; // 현재 노드를 부모로 설정
                dfs(next); // 재귀적으로 DFS 수행
            }
        }
    }
}
