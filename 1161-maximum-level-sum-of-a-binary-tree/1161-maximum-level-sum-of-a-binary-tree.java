class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 1, bestLevel = 1;
        long bestSum = Long.MIN_VALUE;

        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                sum += cur.val;
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }

            if (sum > bestSum) {
                bestSum = sum;
                bestLevel = level;
            }
            level++;
        }
        return bestLevel;
    }
}
