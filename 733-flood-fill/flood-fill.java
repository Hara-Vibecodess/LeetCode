class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startingColor = image[sr][sc];

        if (startingColor == newColor) {
            return image;
        }

        paintConnectedPixels(image, sr, sc, startingColor, newColor);
        return image;
    }

    private void paintConnectedPixels(int[][] image, int row, int col, int startingColor, int newColor) {
        boolean outOfBounds = row < 0 || row >= image.length || col < 0 || col >= image[0].length;
        if (outOfBounds) {
            return;
        }

        if (image[row][col] != startingColor) {
            return;
        }

        image[row][col] = newColor;

        paintConnectedPixels(image, row + 1, col, startingColor, newColor);
        paintConnectedPixels(image, row - 1, col, startingColor, newColor);
        paintConnectedPixels(image, row, col + 1, startingColor, newColor);
        paintConnectedPixels(image, row, col - 1, startingColor, newColor);
    }
}