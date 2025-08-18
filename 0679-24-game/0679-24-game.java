class Solution {
    private static final double EPS = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<List<Integer>> perms = new ArrayList<>();
        permute(cards, 0, perms);
        for (List<Integer> p : perms) {
            double a = p.get(0), b = p.get(1), c = p.get(2), d = p.get(3);
            if (isvalid(a, b, c, d)) return true;
        }
        return false;
    }

    private void permute(int[] arr, int idx, List<List<Integer>> res) {
        if (idx == arr.length) {
            List<Integer> temp = new ArrayList<>();
            for (int x : arr) temp.add(x);
            res.add(temp);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            permute(arr, idx + 1, res);
            swap(arr, i, idx);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public boolean isvalid(double a, double b, double c, double d) {
        return isvalid(a + b, c, d) || isvalid(a - b, c, d) || isvalid(a * b, c, d) || (Math.abs(b) > EPS && isvalid(a / b, c, d))
            || isvalid(a, b + c, d) || isvalid(a, b - c, d) || isvalid(a, b * c, d) || (Math.abs(c) > EPS && isvalid(a, b / c, d))
            || isvalid(a, b, c + d) || isvalid(a, b, c - d) || isvalid(a, b, c * d) || (Math.abs(d) > EPS && isvalid(a, b, c / d));
    }

    public boolean isvalid(double a, double b, double c) {
        return isvalid(a + b, c) || isvalid(a - b, c) || isvalid(a * b, c) || (Math.abs(b) > EPS && isvalid(a / b, c))
            || isvalid(a, b + c) || isvalid(a, b - c) || isvalid(a, b * c) || (Math.abs(c) > EPS && isvalid(a, b / c));
    }

    public boolean isvalid(double a, double b) {
        return Math.abs(a + b - 24) < EPS || Math.abs(a - b - 24) < EPS || Math.abs(b - a - 24) < EPS
            || Math.abs(a * b - 24) < EPS
            || (Math.abs(b) > EPS && Math.abs(a / b - 24) < EPS)
            || (Math.abs(a) > EPS && Math.abs(b / a - 24) < EPS);
    }
}
