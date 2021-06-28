package Algorithms;

import DataStructures.Tree.BinarySearch;
import DataStructures.Tree.Node.Regular;

public class DepthFirstSearch {
    static void search(BinarySearch tree) {
        Regular root = tree.root;
        dfs(root);
    }

    static void dfs(Regular node) {
        System.out.println(node.val);
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
    }
}
