class Solution {
    public int[] decrypt(int[] code, int k) {
          int  n = code.length;
          int[] result = new int[n];

          if (k == 0){
            return result;
          }

          int start = (k > 0) ? 1 : k;
          int end = (k > 0) ? k : -1;

          int windowSum = 0;
          for(int j = start; j <=end; j++){
            windowSum += code[((0 + j) % n + n) % n];
          }
          result[0] = windowSum;

          for(int i = 1; i < n; i++){
            int leaving = ((i - 1 + start) % n + n) % n;
            int entering = ((i + end) % n + n) % n;

            windowSum -= code[leaving];
            windowSum += code[entering];

            result[i] = windowSum;
          }

        return result;
    }
}