class S108 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);

    }

    /**
     * 将有序数组转换为高度平衡的二叉搜索树
     * 高度平衡的二叉搜索树是一棵满足每个节点的左子树和右子树的高度差的绝对值不超过1的二叉搜索树
     *
     * @param nums 有序整数数组
     * @return 返回构造的高度平衡的二叉搜索树的根节点
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        // 调用辅助函数buildBST来构建二叉搜索树，初始传入数组和数组的起始和结束索引
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // 中间位置
        int mid = (start + end) / 2;
        // 创建当前层的节点
        TreeNode node = new TreeNode(nums[mid]);
        // 递归创建左子树
        node.left = buildBST(nums, start, mid - 1);
        // 递归创建右子树
        node.right = buildBST(nums, mid + 1, end);
        return node;
    }
}