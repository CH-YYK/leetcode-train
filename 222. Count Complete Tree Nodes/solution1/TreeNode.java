/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public int countNodes(TreeNode root) {
    // As a complete Binary Tree,
    // 1. a level starts being formed only when the last level is full.
    // 2. all nodes at the last level was positioned as far left as possible.
    //
    // Algo:
    // 1. after knowing that h levels are full -> 2^0 + 2^1 + ... + 2^(h-1)
    // 2. by geometric series, the (1) gave 2^h - 1.
    // 3. Find the position at the last level from the left where it's not full.
    //
    // Let the tree's height defined by its max depth, i.e. the left substrees.
    // 1. For each subtree, we examine left height and right height.
    // 2. If height_left == height_right, the incompleteness happened to right
    // substree.
    // 3. Else if height_left > height_right, the incompleteness happened to the
    // left subtree.
    if (root == null)
      return 0;
    int h_l = height(root.left);
    int h_r = height(root.right);

    // navigate to right sub-tree
    if (h_l == h_r)
      return (1 << h_l) + countNodes(root.right);
    // navigate to left sub-tree
    return (1 << h_r) + countNodes(root.left);
  }

  private int height(TreeNode root) {
    return root == null ? 0 : height(root.left) + 1;
  }
}