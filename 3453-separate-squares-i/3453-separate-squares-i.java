class Solution {
    public double separateSquares(int[][] squares) {
        double low = 0, high = 0;
        for (int[] s : squares) high = Math.max(high, s[1] + s[2]);

        for (int it = 0; it < 80; it++) {
            double mid = (low + high) / 2;
            double below = 0, above = 0;

            for (int[] s : squares) {
                double y = s[1], l = s[2];
                double top = y + l;

                if (mid <= y) {
                    above += l * l;
                } else if (mid >= top) {
                    below += l * l;
                } else {
                    double h1 = mid - y;
                    double h2 = top - mid;
                    below += h1 * l;
                    above += h2 * l;
                }
            }
            if (below < above) low = mid;
            else high = mid;
        }
        return low;
    }
}
