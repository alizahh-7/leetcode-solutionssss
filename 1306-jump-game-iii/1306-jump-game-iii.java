class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];

        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int index, boolean[] visited) {

        // out of bounds or already visited
        if (index < 0 || index >= arr.length || visited[index]) {
            return false;
        }

        // found zero
        if (arr[index] == 0) {
            return true;
        }

        visited[index] = true;

        // jump forward or backward
        return dfs(arr, index + arr[index], visited) ||
               dfs(arr, index - arr[index], visited);
    }
}