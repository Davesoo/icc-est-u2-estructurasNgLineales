package materia.controllers;

import materia.models.Node;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
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
}
