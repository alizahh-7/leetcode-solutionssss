class Solution {

    public int[] getNoZeroIntegers(int n) {

        for (int a = 1; a < n; a++) {
            int b = n - a;

            if (noZero(a) && noZero(b)) {
                return new int[]{a, b};
            }
        }

        return new int[0]; // will never happen as per problem
    }

    private boolean noZero(int x) {
        while (x > 0) {
            if (x % 10 == 0) return false;
            x /= 10;
        }
        return true;
    }
}
