import materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree ab = new BinaryTree();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);
        System.out.println("Peso del Arbol: "+ ab.getSize());
        System.out.println("Altura del Arbol: " + ab.getHeight());
        System.out.println("");
        System.out.println("Arbol InOrder:");
        ab.printInOrder();
        System.out.println("Arbol InOrder con alturas:");
        ab.printInOrderWithHeigth();
        System.out.println("Arbol InOrder con factor de equilibrio:");
        ab.printInOrderWithBalanceFactor();
        System.out.println("");
        System.out.println("Arbol está equilibrado: " + ab.isBalanced());
        System.out.println("Existe el valor 15: " + ab.contains(15));
        System.out.println("Agregando el valor: "+ 15);
        ab.insert(15);
        System.out.println("Arbol está equilibrado: " + ab.isBalanced());
        System.out.println("");
        System.out.println("Arbol InOrder con factor de equilibrio:");
        ab.printInOrderWithBalanceFactor();
        System.out.println("Nodos desequilibrados: ");
        ab.getUnbalancedNodesCount();
    }
}
