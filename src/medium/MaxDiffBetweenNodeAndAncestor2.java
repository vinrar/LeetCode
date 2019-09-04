package medium;

//Bottom up approach.
//Love this problem
//At every node find child nodes with minimum value and max values in both left and right subtree
//Keep a global variable and use this global variable to compute the differences at every point
//Update the global var if the absoulte difference is maximum.
//Pass the minimum (left and right subtree) values to the top.

public class MaxDiffBetweenNodeAndAncestor2 {
    int answer = Integer.MIN_VALUE;

    public int maxAncestorDiff(MaxDiffBetweenNodeAndAncestor.TreeNode root) {
        findMaxAndMinInSubtree(root, root.val, root.val);
        return answer;
    }

    private int[] findMaxAndMinInSubtree(MaxDiffBetweenNodeAndAncestor.TreeNode root, int min, int max) {
        if (root.left == null && root.right == null) {
            return new int[]{root.val, root.val};
        }

        int[] values = new int[]{root.val , root.val};//0 contains min value in subtree. 1 contains max value in subtree.
        if(root.left != null) {
            int[] subTreeMinMax = findMaxAndMinInSubtree(root.left, values[0], values[1]);
            if(subTreeMinMax[0] < values[0]) {
                values[0] = subTreeMinMax[0];
            }

            if(subTreeMinMax[1] > values[1]) {
                values[1] = subTreeMinMax[1];
            }
        }

        if(root.right != null) {
            int[] subTreeMinMax = findMaxAndMinInSubtree(root.right, values[0], values[1]);

            if(subTreeMinMax[0] < values[0]) {
                values[0] = subTreeMinMax[0];
            }

            if(subTreeMinMax[1] > values[1]) {
                values[1] = subTreeMinMax[1];
            }
        }

        answer = Math.max(answer, Math.max(Math.abs(root.val - values[0]), Math.abs(root.val - values[1])));
        return values;
    }
}