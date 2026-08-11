class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for(int[] idx : indices){
            rowCount[idx[0]]++;
            colCount[idx[1]]++;
        }

        int oddRows = 0;
        for(int r : rowCount){
            if(r % 2 == 1) oddRows++;
        }

        int oddCols = 0;
        for(int c : colCount){
            if(c % 2 == 1) oddCols++;
        }

        return oddRows * (n - oddCols) + (m - oddRows) * oddCols;
    }
}