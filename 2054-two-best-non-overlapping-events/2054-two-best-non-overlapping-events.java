import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort events by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap by end time: [endTime, value]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int maxValueSoFar = 0;
        int result = 0;

        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            int value = event[2];

            // Remove all events that end before current start
            while (!pq.isEmpty() && pq.peek()[0] < start) {
                maxValueSoFar = Math.max(maxValueSoFar, pq.poll()[1]);
            }

            // Combine current event with best previous non-overlapping event
            result = Math.max(result, maxValueSoFar + value);

            // Add current event to heap
            pq.offer(new int[]{end, value});
        }

        return result;
    }
}
