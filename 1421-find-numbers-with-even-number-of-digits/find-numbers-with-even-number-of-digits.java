class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            int digits = 0;
            int n = num;
            do {
                digits++;
                n /= 10;
            } while (n != 0);
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}