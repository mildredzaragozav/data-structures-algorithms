package com.mildred.datastructures;

public class BinarySearchTree {
    public Node root;

    public class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }

    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (true) {
            if (temp.value == newNode.value) return false;

            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;

        while (temp != null) {
            if (value == temp.value) {
                return true;
            } else if (value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }

        }
        return false;
    }

    /**
     * This method is a recursive method designed to search for a specific integer value in the BST.
     * It checks if the given value exists in the BST and returns a boolean indicating the presence of that value.
     * @param value
     * @return
     */
    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    /**
     * The deleteNode method is designed to remove a node with a specific integer value from the binary search tree (BST).
     * @param value
     */
    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;

        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if(value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    /**
     * This method is designed to find the minimum integer value in the BST starting from a specific node.
     * @param currentNode: Starting node
     * @return
     */
    private int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

}
