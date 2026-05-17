import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        // sort meetings by time
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        boolean[] knowSecret = new boolean[n];
        knowSecret[0] = true;
        knowSecret[firstPerson] = true;

        int i = 0;

        while (i < meetings.length) {

            int time = meetings[i][2];

            // graph for same time meetings
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> people = new HashSet<>();

            // collect all meetings at same time
            while (i < meetings.length && meetings[i][2] == time) {

                int x = meetings[i][0];
                int y = meetings[i][1];

                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);

                people.add(x);
                people.add(y);

                i++;
            }

            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            // start BFS from people who already know secret
            for (int person : people) {
                if (knowSecret[person]) {
                    queue.offer(person);
                    visited.add(person);
                }
            }

            // spread secret within same timestamp
            while (!queue.isEmpty()) {

                int curr = queue.poll();

                for (int next : graph.getOrDefault(curr, new ArrayList<>())) {

                    if (!visited.contains(next)) {
                        visited.add(next);
                        knowSecret[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            if (knowSecret[j]) {
                ans.add(j);
            }
        }

        return ans;
    }
}