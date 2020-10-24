package DataStructures.Tree;

import DataStructures.Tree.Node.Regular;

public class BinarySearch {
    Regular root;
    static int size;
    public BinarySearch () {
        root = null;
        size = 0;
    }

    public void insert (int item) {
        root = insertNode(item, root);
    }

    public static void main (String[] args) {
        BinarySearch tree = new BinarySearch();
        tree.insert(2);
        System.out.println(tree.root.val);
    }

    static Regular insertNode (int item, Regular node) {
        if (node == null) {
            return new Regular(0);
        } else {
            if (item == node.val) {
                return node;
            } else if (node.val < item) {
                node.right = insertNode(item, node.right);
                size++;
            } else {
                node.left = insertNode(item, node.left);
                size++;
            }
        }
        return node;
    }
}
