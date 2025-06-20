package materia.controllers;

import materia.models.Node;

public class BinaryTree {

    private Node root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public void insert(int value) {
        size++;
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }
        if (value < padre.getValue()) {
            Node newNode = insertRec(padre.getLeft(), value);
            padre.setLeft(newNode);
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void imprimirArbol() {
        imprimirArbolRec(root);
    }

    public void imprimirArbolRec(Node node) {
        if (node != null) {
            System.out.println(node.getValue() + " ");
            imprimirArbolRec(node.getLeft());
            imprimirArbolRec(node.getRight());
            return;
        }
    }

    public void printPreOrder() {
        printPreOrderRec(root);
        System.out.println("");
    }

    private void printPreOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            printPreOrderRec(node.getLeft());
            printPreOrderRec(node.getRight());
        }
    }

    public void printPostOrder() {
        printPostOrderRec(root);
        System.out.println("");
    }

    private void printPostOrderRec(Node node) {
        if (node != null) {
            printPostOrderRec(node.getLeft());
            printPostOrderRec(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    public void printInOrder(){
        printInOrderRec(root);
        System.out.println("");
    }

    public void printInOrderRec(Node node){
        if (node != null){
            printInOrderRec(node.getLeft());
            System.out.print(node.getValue() + " ");
            printInOrderRec(node.getRight());
        }
    }

    public void printInOrderWithHeigth(){
        printInOrderWithHeightRec(root);
        System.out.println("");
    }

    public void printInOrderWithHeightRec(Node node){
        if (node != null){
            printInOrderWithHeightRec(node.getLeft());
            int height = getHeightRec(node);
            System.out.print(node.getValue() + "(h="+height+") ");
            printInOrderWithHeightRec(node.getRight());
        }
    }

    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
    }

    public void printInOrderWithBalanceFactor() {
        printInOrderWithBalanceFactorRec(root);
        System.out.println("");
    }

    public void printInOrderWithBalanceFactorRec(Node node) {
        if (node != null) {
            printInOrderWithBalanceFactorRec(node.getLeft());
            int balanceFactor = getBalanceFactor(node);
            System.out.print(node.getValue() + "(bf=" + balanceFactor + ") ");
            printInOrderWithBalanceFactorRec(node.getRight());
        }
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }

    public boolean searchRec(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.getValue() == value) {
            return true;
        }
        if (value < node.getValue()) {
            return searchRec(node.getLeft(), value);
        } else {
            return searchRec(node.getRight(), value);
        }
    }

    public int getHeight() {
        return getHeightRec(root);
    }

    public int getHeightRec(Node node) {
        if (node == null) {
            return 0; 
        }
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalancedRec(node.getLeft()) && isBalancedRec(node.getRight());
    }

    public void getUnbalancedNodesCount() {
        getUnbalancedNodesCountRec(root);
        System.out.println("");
    }

    private void getUnbalancedNodesCountRec(Node node) {
        if (node != null) {
            int balanceFactor = getBalanceFactor(node);
            if (Math.abs(balanceFactor) > 1 || Math.abs(balanceFactor) <-1) {
                System.out.print(node.getValue() + "(bf=" + balanceFactor + ") ");
            }
            getUnbalancedNodesCountRec(node.getLeft());
            getUnbalancedNodesCountRec(node.getRight());
        }
    }

    public boolean contains(int value) {
        return searchRec(root, value);
    }
    

    public int getSize() {
        return size;
    }


}
