import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Min-heap of rooms currently in use: [endTime, roomNumber]
        PriorityQueue<long[]> used = new PriorityQueue<>((a, b) -> 
            a[0] == b[0] ? (int)(a[1] - b[1]) : Long.compare(a[0], b[0])
        );

        // Free rooms available – always pick smallest index
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0; i < n; i++) free.offer(i);

        int[] count = new int[n];

        for (int[] m : meetings) {
            int start = m[0], end = m[1];

            // Free rooms whose end time <= current meeting start
            while (!used.isEmpty() && used.peek()[0] <= start) {
                free.offer((int)used.poll()[1]);
            }

            if (!free.isEmpty()) {
                int room = free.poll();
                count[room]++;
                used.offer(new long[]{end, room});
            } else {
                long[] earliest = used.poll();
                long finishTime = earliest[0];
                int room = (int)earliest[1];
                count[room]++;
                used.offer(new long[]{finishTime + (end - start), room});
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) ans = i;
        }
        return ans;
    }
}
