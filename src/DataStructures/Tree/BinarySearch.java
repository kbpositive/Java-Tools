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

    public void remove (int item) {
        removeNode(item, root);
    }

    public void traversal (String order) {
        traverseTree(root, order);
    }

    public Regular find (int item) {
        return findNode (item, root);
    }

    static Regular insertNode (int item, Regular node) {
        if (node == null) {
            return new Regular(item);
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

    static Regular removeNode (int item, Regular node) {
        if (node == null) {
            return node;
        } else if (node.val > item) {
            node.left = removeNode(item, node.left);
        } else if (node.val < item) {
            node.right = removeNode(item, node.right);
        } else {
            if (node.left == null) {
                Regular temp = node.right;
                node = null;
                size--;
                return temp;
            } else if (node.right == null) {
                Regular temp = node.left;
                node = null;
                size--;
                return temp;
            }
            Regular temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            node.val = temp.val;
            temp = null;
            size--;
        }
        return node;
    }

    static void traverseTree (Regular node, String order) {
        if (node != null) {
            if (order.equals("pre")) {
                System.out.println(node.val);
            }
            traverseTree(node.left, order);
            if (order.equals("in")) {
                System.out.println(node.val);
            }
            traverseTree(node.right, order);
            if (order.equals("post")) {
                System.out.println(node.val);
            }
        }
    }

    static Regular findNode (int item, Regular node) {
        if (node == null) {
            return null;
        } else if (node.val != item) {
            if (item < node.val) {
                return findNode(item, node.left);
            } else {
                return findNode(item, node.right);
            }
        } else {
            return node;
        }
    }
}
