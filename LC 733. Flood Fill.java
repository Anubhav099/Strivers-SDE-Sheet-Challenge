class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }
    void fill(int[][] img, int sr, int sc, int orig, int mod) {
        if (sr < 0 || sr >= img.length || sc < 0 || sc >= img[0].length || img[sr][sc] != orig) return;

        img[sr][sc] = mod;
        fill(img, sr + 1, sc, orig, mod);
        fill(img, sr, sc - 1, orig, mod);
        fill(img, sr - 1, sc, orig, mod);
        fill(img, sr, sc + 1, orig, mod);
    }
}