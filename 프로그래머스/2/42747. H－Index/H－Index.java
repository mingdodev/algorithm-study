import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] citations) {
        // h번: 인용 횟수를 구하려면 선형 탐색 -> 횟수 줄이려면 정렬
        // 1. 논문 인용 횟수 기준 정렬
        // 2. h = max로 잡고, h >= 총 논문 개수, 인덱스 h - 1의 인용 횟수 >= h인지 확인
        
        citations = Arrays.stream(citations)
                        .boxed()
                        .sorted(Comparator.reverseOrder())
                        .mapToInt(Integer::intValue)
                        .toArray();
        
        int h = citations.length;
        for (; h > 0; h--) {
            if (citations[h - 1] >= h)
                break;
        }

        return h;
    }
}