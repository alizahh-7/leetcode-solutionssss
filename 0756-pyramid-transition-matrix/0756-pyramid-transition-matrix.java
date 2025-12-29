class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();

        // Build mapping: "AB" -> ['C', 'D', ...]
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }

        return dfs(bottom, map);
    }

    private boolean dfs(String bottom, Map<String, List<Character>> map) {
        if (bottom.length() == 1) return true;

        return buildNextRow(bottom, 0, new StringBuilder(), map);
    }

    private boolean buildNextRow(String bottom, int idx, StringBuilder next,
                                 Map<String, List<Character>> map) {
        if (idx == bottom.length() - 1) {
            return dfs(next.toString(), map);
        }

        String key = bottom.substring(idx, idx + 2);
        if (!map.containsKey(key)) return false;

        for (char c : map.get(key)) {
            next.append(c);
            if (buildNextRow(bottom, idx + 1, next, map)) return true;
            next.deleteCharAt(next.length() - 1);
        }
        return false;
    }
}
