package medium;

//The code fails for the last test case: MemoryLimitExceeded. Bad recursion. I knew it would fail, but there were no mentions on the problem page about time and space complexity.

public class MaxDiffBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        int size = ((int)Math.pow(2, heightOfTree(root))) - 1;
        int [] bSTArray = new int [size];
        for(int i = 0; i < size; i++) {
            bSTArray[i] = -1;
        }

        makeArray(root, 0, bSTArray);
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < size; i++) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;
            int rootVal = bSTArray[i];

            int val = findDiff(bSTArray, leftChildIndex, size - 1, rootVal);

            if(val > max) {
                max = val;
            }
        }
        return max;
    }

    public static int findDiff(int[] array, int leftIndex, int lastIndex, int root) {
        int leftTreeMaxDiff = 0;
        int rightTreeMaxDiff = 0;

        if(leftIndex <= lastIndex && array[leftIndex] != -1) {
            leftTreeMaxDiff = Math.max(Math.abs(root - array[leftIndex]), findDiff(array, 2 * leftIndex + 1, lastIndex, root));
        }

        if(leftIndex + 1 <= lastIndex && array[leftIndex + 1] != -1) {
            rightTreeMaxDiff = Math.max(Math.abs(root - array[leftIndex + 1]), findDiff(array, 2 * (leftIndex + 1) + 1, lastIndex, root));
        }

        return Math.max(leftTreeMaxDiff, rightTreeMaxDiff);
    }

    public static int heightOfTree(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    public static void makeArray(TreeNode node, int i, int [] bSTArray) {
        if (node != null) {
            bSTArray[i] = node.val;
            makeArray(node.left, 2*i+1, bSTArray);
            makeArray(node.right, 2*i+2, bSTArray);
        }
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
