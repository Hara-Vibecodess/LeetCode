class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        int[] unique = new int[n];
        int[] freq = new int[n];

        int size = 0;

        for(int i = 0; i < n; i++){

            boolean found = false;

            for(int j = 0; j < size; j++){

                if(unique[j] == nums[i]){

                    freq[j]++;
                    found = true;
                    break;
                }
            }

            if (!found) {

                unique[size] = nums[i];
                freq[size] = 1;

                size++;
            }
        }

        int[] ans = new int[k];

        for(int i = 0;i < k;i++){

            int maxFreq = -1;
            int index = -1;

            for(int j = 0; j < size; j++){

                if(freq[j] > maxFreq){

                    maxFreq = freq[j];
                    index = j;
                }
            }

            ans[i]= unique[index];

            freq[index] = -1;
        }
        return ans;
    }
}