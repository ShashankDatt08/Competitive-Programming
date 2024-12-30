package Trees;

import java.util.Scanner;

public class BinaryTreeAndAVLTree {

    static class Node {
        int data;
        Node left;
        Node right;
        int height;
        public Node(int data) {
            this.data = data;
        }
    }
    private Node root;

    public BinaryTreeAndAVLTree() {
    }

    public int getHeight() {
        return height(root);
    }

    public int height(Node node) {
        if(node == null) {
            return -1;
        }
        return node.height;
    }


    //this is for inserting or creating binary tree
    public void insert(Scanner scanner) {
        System.out.print("Enter the data: ");
        int data = scanner.nextInt();
        root = new Node(data);
        insert(scanner,root);
    }


    private void insert(Scanner scanner, Node root) {
        System.out.println("Do you want to insert left of " + root.data);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter the data for left : ");
            int data = scanner.nextInt();
            root.left = new Node(data);
            insert(scanner,root.left);

        }

        System.out.println("Do you want to insert right of " + root.data);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter the data for right : ");
            int data = scanner.nextInt();
            root.right = new Node(data);
            insert(scanner,root.right);
        }

    } // till here




    //Binary search tree:
    public void populate(int value){
        root = populate(root , value);
    }

    private Node populate(Node node, int value) {
        if(node == null) {
            node = new Node(value);
            return node;
        }

        if(value < node.data) {
            node.left = populate(node.left, value);
        }
        if(value > node.data) {
            node.right = populate(node.right, value);
        }
        node.height = Math.max(height(node.left),height(node.right)) + 1;
        return rotate(node);
    } //till here




    //for array
    public void populateArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.populate(nums[i]);
        }
    }//till here



    //this is for sorted array taking mid and populating it accordingly
    public void sortedPop(int[] nums){
        sortedPop(nums,0,nums.length-1);
    }

    private void sortedPop(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = start + (end - start)/2;
        this.populate(nums[mid]);
        sortedPop(nums,start,mid);
        sortedPop(nums,mid+1,end);

    } //till here





    public void display() {
        display(this.root , "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.data);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void preOrder() {
        preOrder(this.root);
        System.out.println();
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder() {
        inOrder(this.root);
        System.out.println();

    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder() {
        postOrder(this.root);
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }


    //AVL tree
    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            //if left is more
            if (height(node.left.left) - height(node.left.right) > 0) {
                //left-left case
                return rotateRight(node);
            }

            //left- right case
            if (height(node.left.left) - height(node.left.right) < 0) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }
        if (height(node.left) - height(node.right) < -1) {
            //if right is more
            if (height(node.right.left) - height(node.right.right) < 0) {
                //right - right case
                return rotateLeft(node);
            }

            //left- right case
            if (height(node.right.left) - height(node.right.right) > 0) {
                //right - left case
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }


        return node;

    }

    private Node rotateRight(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return c;
    }

    private Node rotateLeft(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;
    }


    public static void main(String[] args) {
        BinaryTreeAndAVLTree tree = new BinaryTreeAndAVLTree();
//        Scanner scanner = new Scanner(System.in);
//        tree.insert(scanner);
        int[] arr = {9,10,2,1,8,6,4,5,7};
        tree.populateArr(arr);
        tree.display();

//        for(int i=0; i < 1000; i++) {
//            tree.populate(i);
//        }
//        tree.display();

        System.out.println(tree.getHeight());
//        tree.preOrder();
//        tree.inOrder();
//        tree.postOrder();
    }
}

