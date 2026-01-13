class Solution {
    private double areaDiff(double lineY, int[][] squares) {
        double areaAbove = 0, areaBelow = 0;
        for (int[] sq : squares) {
            int x = sq[0], y = sq[1], size = sq[2];
            double squareArea = (double) size * size;
            if (lineY <= y) {
                areaAbove += squareArea;
            } else if (lineY >= y + size) {
                areaBelow += squareArea;
            } else {
                double aboveHeight = y + size - lineY;
                double belowHeight = lineY - y;
                areaAbove += size * aboveHeight;
                areaBelow += size * belowHeight;
            }
        }
        return areaAbove - areaBelow;
    }

    public double separateSquares(int[][] squares) {
        double low = 0, high = 2e9;
        for (int i = 0; i < 60; i++) {
            double mid = (low + high) / 2.0;
            double diff = areaDiff(mid, squares);
            if (diff > 0) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
}