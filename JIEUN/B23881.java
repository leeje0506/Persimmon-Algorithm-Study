import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B23881 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // 두 번째 줄 입력 처리
        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        
        // K번째 교환을 찾는 선택 정렬 실행
        int result = selectionSortWithKthSwap(n, k, array);
        
        // 결과 출력
        if (result == -1) {
            System.out.println(result);
        }
    }

    public static int selectionSortWithKthSwap(int n, int k, int[] array) {
        int swapCount = 0;
        for (int last = n - 1; last > 0; last--) {
            int maxIndex = 0;
            for (int i = 1; i <= last; i++) {
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            
            if (maxIndex != last) {
                // 교환 수행
                int temp = array[maxIndex];
                array[maxIndex] = array[last];
                array[last] = temp;
                swapCount++;
                
                if (swapCount == k) {
                    // 교환된 두 수를 오름차순으로 출력
                    if (array[maxIndex] < array[last]) {
                        System.out.println(array[maxIndex] + " " + array[last]);
                    } else {
                        System.out.println(array[last] + " " + array[maxIndex]);
                    }
                    return swapCount;
                }
            }
        }
        return -1;
    }
}
