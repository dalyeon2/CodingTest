package solution04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*
         * 시간 복잡도

            최대 힙 사용 시 시간 복잡도는
            입력된 숫자를 모두 힙에 추가하는 과정에서 O(N² log N) 시간 복잡도를 가진다.
            이때 각 숫자를 힙에 추가하는 데 O(log N)의 시간이 필요하며,
            N²개의 숫자를 추가하기 때문에 총 O(N² log N))의 시간 복잡도를 가진다.

            최대 힙을 사용한 방법은 메모리 사용 측면에서 효율적일 수 있으며, 많은 수를 처리할 때 성능이 더 좋을 수 있다.
            하지만 힙에 추가하는 과정에서 수의 개수가 많아질수록 O(N² log N)으로 비효율적일 수 있다.
         */

        // BufferedReader를 사용하여 데이터를 효율적으로 읽기 위한 초기 설정을 한다.
        // InputStreamReader는 바이트 스트림을 문자 스트림으로 변환하고
        // BufferedReader는 이를 버퍼링하여 더 빠르고 효율적으로 읽을 수 있다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최대 힙을 생성
        // Java의 PriorityQueue를 사용하여 최대 힙을 생성한다. 최대 힙은 가장 큰 수를 쉽게 추출할 수 있게 해준다.
        // 이때, PriorityQueue는 기본적으로 최소 힙이므로, Collections.reverseOrder()를 사용하여 최대 힙으로 동작하도록 설정한다.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 모든 수를 힙에 추가
        //주어진 N×N 표의 모든 수를 힙에 추가한다. 이때 힙의 특성상 추가할 때마다 자동으로 정렬된다.
        // 첫 번째 줄에서 N의 값을 입력받습니다. N은 표의 크기를 의미한다.
        int N = Integer.parseInt(br.readLine()); // N의 값을 입력받습니다.

        // N개의 줄에 걸쳐 숫자를 입력받는다.
        for (int i = 0; i < N; i++) {
            // 각 줄의 숫자를 공백을 기준으로 분리하여 배열에 저장한다.
            String[] numbers = br.readLine().split(" ");

            // 분리된 문자열 배열을 정수로 변환하여 최대 힙에 추가한다
            for (String number : numbers) {
                maxHeap.add(Integer.parseInt(number));
            }
        }

        // N번째 큰 수 찾기
        // 최대 힙에서는 가장 큰 수가 루트에 위치하므로, 루트에서 N-1번 제거하면 N번째로 큰 수가 남는다.
        for (int i = 0; i < N - 1; i++) {
            maxHeap.poll(); // 가장 큰 수를 N-1번 제거
        }

        // 현재 힙의 루트는 N번째로 큰 수
        System.out.println(maxHeap.poll());

        // BufferedReader를 닫는다.
        br.close();


        /*

            정렬 사용 시 시간 복잡도:

            새로운 코드는 모든 숫자를 배열에 저장한 후, Arrays.sort()를 사용하여 정렬한다.
            Java의 정렬 알고리즘은 최악의 경우 O(N log N)로 동작합니다.
            그러나 이 경우에는 O(N^2 log(N^2))로 볼 수 있습니다.
            하지만 이 알고리즘은 효율적인 정렬 알고리즘을 사용하므로 일반적인 경우 O(N log N)으로 빠르게 작동합니다.
            이후 N번째 큰 수를 찾는 과정은 O(1)입니다.
            결론:

            원래 코드: O(N^2 log N)
            개선된 코드: O(N^2 log(N^2)) → 사실상 O(N log N)으로 효율적
            이 코드가 더욱 간단하고 직관적이며, 입력이 많을수록 성능 차이가 더 크게 나타납니다.

            시간 복잡도
            입력 처리: O(N²)
            정렬: O(N² log(N²)) (N²개의 수를 정렬)
            결과 출력: O(1)
            총 시간 복잡도: O(N² log(N²))

            두 방법의 비교
            정렬 방법:

            구현이 간단하고 직관적입니다.
            정렬을 통해 모든 수를 한 번에 정리할 수 있어 N번째 큰 수를 쉽게 찾을 수 있습니다.
            성능 면에서는 N이 클 경우 비효율적일 수 있습니다.
            힙 방법:

            이 두 방법 모두 N번째 큰 수를 찾는 문제를 해결할 수 있습니다.
            상황에 따라 사용자의 요구에 맞는 방법을 선택할 수 있습니다.
            정렬 방법은 단순하고 직관적이며, 힙 방법은 더 많은 데이터를 처리할 때 더 효율적일 수 있습니다.
         */

        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 N을 입력받습니다. (N x N의 크기를 가진 표)
        int N = Integer.parseInt(br.readLine());

        // N*N 크기의 배열을 생성하여 모든 수를 저장한다.
        int[] numbers = new int[N * N];  // N*N 크기의 배열 생성

        // 표의 각 행을 반복하여 숫자를 배열에 저장합니다.
        for (int i = 0; i < N; i++) {
            // 한 줄의 숫자를 공백으로 분리하여 배열에 저장합니다.
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                // 1차원 배열에 2차원 배열처럼 저장하기 위해 인덱스를 계산합니다.
                numbers[i * N + j] = Integer.parseInt(line[j]);
            }
        }

        // 배열을 정렬합니다. 이 단계에서 시간 복잡도는 O(N^2 log(N^2))입니다.
        Arrays.sort(numbers);

        // 정렬된 배열에서 N번째로 큰 수를 출력합니다.
        // 배열의 마지막 N번째 요소는 N번째로 큰 수입니다.
        System.out.println(numbers[numbers.length - N]);

        // BufferedReader를 닫습니다. (자원 해제)
        br.close();
        */

    }
}
