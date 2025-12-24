import java.util.*;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int a : apple) totalApples += a;

        Arrays.sort(capacity); // sort ascending

        int used = 0;
        int sum = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            sum += capacity[i];
            used++;
            if (sum >= totalApples) return used;
        }
        return used;
    }
}
