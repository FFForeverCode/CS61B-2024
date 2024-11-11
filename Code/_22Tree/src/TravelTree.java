/**
 * @author KiKidog
 * @date 2024/8/10
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**树的遍历方式
 *深度优先搜素:前序、中序、后序
 * 前序遍历
 * preOrder(BSTNode x)
 */
public class TravelTree {
    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int val;

        public TreeNode() {
        }

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        /**
         * 获取
         * @return left
         */
        public TreeNode getLeft() {
            return left;
        }

        /**
         * 设置
         * @param left
         */
        public void setLeft(TreeNode left) {
            this.left = left;
        }

        /**
         * 获取
         * @return right
         */
        public TreeNode getRight() {
            return right;
        }

        /**
         * 设置
         * @param right
         */
        public void setRight(TreeNode right) {
            this.right = right;
        }

        /**
         * 获取
         * @return val
         */
        public int getVal() {
            return val;
        }

        /**
         * 设置
         * @param val
         */
        public void setVal(int val) {
            this.val = val;
        }

        public String toString() {
            return "TreeNode{left = " + left + ", right = " + right + ", val = " + val + "}";
        }
    }
    /**
     * 深度优先搜素
     */

    /**
     * 前序遍历
     * @param x
     */
    public void preOrder(TreeNode x){
        if(x == null) return;
        System.out.println(x.val);
        preOrder(x.left);
        preOrder(x.right);
    }
    /**
     * 中序遍历
     */
    public void inOrder(TreeNode x){
        if(x == null) return;
        inOrder(x.left);
        System.out.println(x.val);
        inOrder(x.right);
    }
    /**
     * 后序遍历
     */
    public void postOrder(TreeNode x){
        if(x == null) return;
        postOrder(x.left);
        postOrder(x.right);
        System.out.println(x.val);
    }
    /**
     * 广度优先搜素
     */
    /**
     * 层序遍历 利用队列
     */
    public void  levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            queue.add(top.left);
            queue.add(top.right);
        }
        System.out.println(Arrays.toString(queue.toArray()));
    }

}