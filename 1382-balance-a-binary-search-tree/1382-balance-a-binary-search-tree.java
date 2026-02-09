import java.util.*;

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return build(list, 0, list.size() - 1);
    }
    
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
    
    private TreeNode build(List<Integer> list, int l, int r) {
        if (l > r) return null;
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(list.get(m));
        root.left = build(list, l, m - 1);
        root.right = build(list, m + 1, r);
        return root;
    }
}
