package solution06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    // 내부 클래스: 토마토의 위치를 저장하는 클래스
    static class Position {
        int x, y, z;

        // 생성자: Position 객체를 생성할 때 x, y, z 좌표를 설정
        Position(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력: 상자의 크기 M(가로), N(세로), H(높이)
        int M = sc.nextInt();
        int N = sc.nextInt();
        int H = sc.nextInt();

        // 3차원 배열을 사용하여 토마토 상자 정보와 일수를 저장
        int[][][] farm = new int[H][N][M];
        int[][][] days = new int[H][N][M];

        // BFS를 위한 큐 선언, 초기에는 익은 토마토의 위치를 담음
        Queue<Position> queue = new LinkedList<>();

        // 토마토 상태 입력과 초기 설정
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    farm[h][n][m] = sc.nextInt();
                    // 익은 토마토는 큐에 추가
                    if (farm[h][n][m] == 1) {
                        queue.add(new Position(h, n, m));
                    }
                    // 익지 않은 토마토의 일수를 -1로 초기화
                    if (farm[h][n][m] == 0) {
                        days[h][n][m] = -1;
                    }
                }
            }
        }

        // 6방향으로 이동하기 위한 배열 설정
        // dz, dy, dx는 각각 위/아래, 앞/뒤, 왼쪽/오른쪽 이동을 나타냄
        int[] dz = {-1, 1, 0, 0, 0, 0}; // 위, 아래
        int[] dy = {0, 0, -1, 1, 0, 0}; // 앞, 뒤
        int[] dx = {0, 0, 0, 0, -1, 1}; // 왼쪽, 오른쪽

        // BFS 수행
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nz = pos.z + dz[i];
                int ny = pos.y + dy[i];
                int nx = pos.x + dx[i];

                // 유효한 좌표인지 확인
                if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    // 익지 않은 토마토가 있을 경우
                    if (farm[nz][ny][nx] == 0 && days[nz][ny][nx] == -1) {
                        // 토마토가 익는데 걸리는 일수를 갱신
                        days[nz][ny][nx] = days[pos.z][pos.y][pos.x] + 1;
                        // 새로운 위치를 큐에 추가
                        queue.add(new Position(nz, ny, nx));
                    }
                }
            }
        }

        // 결과 계산
        int maxDays = 0;
        boolean allRipe = true;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    // 익지 않은 토마토가 있으면 false
                    if (days[h][n][m] == -1) {
                        allRipe = false;
                    }
                    // 익는데 걸린 최대 일수를 갱신
                    if (days[h][n][m] > maxDays) {
                        maxDays = days[h][n][m];
                    }
                }
            }
        }

        // 모든 토마토가 익었는지 여부에 따라 결과 출력
        if (allRipe) {
            System.out.println(maxDays);
        } else {
            System.out.println(-1);
        }

        sc.close();
    }
}
