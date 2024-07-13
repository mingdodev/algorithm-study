class Solution {
    public void duplicateZeros(int[] arr) {
        // 0의 개수 세기
        int zeroCnt = 0;
        for (int i : arr) {
            if (i == 0) {
                zeroCnt++;
            }
        }
        
        int s = arr.length;
        
        for (int i = s - 1, j = s + zeroCnt - 1; i >= 0; i--, j--) {
            if (arr[i] != 0) {
                if (j < s) {
                    arr[j] = arr[i];
                }
            } else {
                if (j < s) {
                    arr[j] = 0;
                }
                j--;
                if (j < s) {
                    arr[j] = 0;
                }
            }
        }
    }
}