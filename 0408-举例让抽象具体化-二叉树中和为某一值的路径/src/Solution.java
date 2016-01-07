import java.util.ArrayList;

/**
 * Author: 王俊超
 * Date: 2016-01-07 11:39
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();

        findPath(root, new int[]{0}, target, curr, result);

        return result;
    }

    private void findPath(TreeNode root, int[] s, int target,
                          ArrayList<Integer> curr,
                          ArrayList<ArrayList<Integer>> result) {


        if (root != null) {

            s[0] += root.val;
            curr.add(root.val);

            // 如果是叶结点，并且等于所求的和
            if (s[0] == target && root.left == null && root.right == null) {
                ArrayList<Integer> ai = new ArrayList<>();
                for (int i : curr) {
                    ai.add(i);
                }

                result.add(ai);
            } else {
                findPath(root.left, s, target, curr, result);
                findPath(root.right, s, target, curr, result);

            }

            // 现场还原
            s[0] -= root.val;
            curr.remove(curr.size() - 1);

        }
    }
}
