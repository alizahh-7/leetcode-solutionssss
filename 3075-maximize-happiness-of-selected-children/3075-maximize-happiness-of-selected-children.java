import java.util.*;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        int dec = 0;
        for (int i = happiness.length - 1; i >= 0 && k > 0; i--, k--) {
            int val = happiness[i] - dec;
            if (val > 0) sum += val;
            dec++;
        }
        return sum;
    }
}
