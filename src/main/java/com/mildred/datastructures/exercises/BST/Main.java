package com.mildred.datastructures.exercises.BST;

import com.mildred.datastructures.BinarySearchTree;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();
        //4, 2, 6, 1, 3, 5, 7
        myBST.insert(4);
        myBST.insert(2);
        myBST.insert(6);
        myBST.insert(1);
        myBST.insert(3);
        myBST.insert(5);
        myBST.insert(7);

        System.out.println("Root: " + myBST.root.value);
        System.out.println("Root->Left: " + myBST.root.left.value);
        System.out.println("Root->Right: " + myBST.root.right.value);

        System.out.println("\nRoot: " + myBST.root.left.value);
        System.out.println("Root->Left: " + myBST.root.left.left.value);
        System.out.println("Root->Right: " + myBST.root.left.right.value);

        System.out.println("\nRoot: " + myBST.root.right.value);
        System.out.println("Root->Left: " + myBST.root.right.left.value);
        System.out.println("Root->Right: " + myBST.root.right.right.value);

        myBST.invert();

        System.out.println("\nRoot: " + myBST.root.value);
        System.out.println("Root->Left: " + myBST.root.left.value);
        System.out.println("Root->Right: " + myBST.root.right.value);

        System.out.println("\nRoot: " + myBST.root.left.value);
        System.out.println("Root->Left: " + myBST.root.left.left.value);
        System.out.println("Root->Right: " + myBST.root.left.right.value);

        System.out.println("\nRoot: " + myBST.root.right.value);
        System.out.println("Root->Left: " + myBST.root.right.left.value);
        System.out.println("Root->Right: " + myBST.root.right.right.value);

        myBST = new BinarySearchTree();
        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);

        /*
            THE LINES ABOVE CREATE THIS TREE:
                         2
                        / \
                       1   3
        */

        System.out.println("Root: " + myBST.root.value);
        System.out.println("\nRoot->Left: " + myBST.root.left.value);
        System.out.println("\nRoot->Right: " + myBST.root.right.value);


        /*
            EXPECTED OUTPUT:
            ----------------
            Root: 2

            Root->Left: 1

            Root->Right: 3

        */

        myBST.insert(17);

        System.out.println("BST Contains 27:");
        System.out.println(myBST.contains(27));

        System.out.println("\nBST Contains 17:");
        System.out.println(myBST.contains(17));
    }
}
