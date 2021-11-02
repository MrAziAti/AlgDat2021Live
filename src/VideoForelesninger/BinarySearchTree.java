package VideoForelesninger;

import javax.management.relation.InvalidRelationIdException;

public class BinarySearchTree {

    public static void main(String[] args) {

        BST tree = new BST();

        int[] values = {9, 7, 1, 3, 5, 11,13, 10, 8};

        for (int i = 0; i < values.length; i++) {
            tree.insert(values[i]);
            tree.print();
            System.out.println("");
        }

        //tree.print();
    }

    /**
     * Node klasse som har alt vi trenger hver eneste node i det binære søketreet.
     */
    public static class Node {
        Node parent;
        Node left_child;
        Node right_child;
        int value;

        /**
         * Lager en node med null som foreldre og banrnepekere
         *
         * @param value - value som kommer inn under opprettelse av Node
         */
        public Node(int value) {
            this.parent = null;
            this.left_child = null;
            this.right_child = null;
            this.value = value;
        }

        public Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
            this.left_child = null;
            this.right_child = null;
        }

        public Node(int value, Node parent, Node left, Node right) {
            this.value = value;
            this.parent = parent;
            this.left_child = left;
            this.right_child = right;
        }
        public void printPreorderRevursive(){
            System.out.print(this.value + " ");
            if(left_child != null){
                left_child.printPreorderRevursive();
            }
            if(right_child!= null){
                right_child.printPreorderRevursive();
            }
        }
        public void printInorderRecursive(){
            if(left_child != null)left_child.printPreorderRevursive();
            System.out.print(this.value + " ");
            if(right_child!= null)right_child.printPreorderRevursive();
        }
        public void printPostorderRecursive(){
            if(left_child != null)left_child.printPreorderRevursive();
            if(right_child!= null)right_child.printPreorderRevursive();
            System.out.print(this.value + " ");
        }
    }

    /**
     * Binary Search Tree som har root noden og annet info om vårt søketre
     * Har oghså metodene for innlegging fjerning og søking
     */
    public static class BST {
        Node root;

        /**
         * Denne funksjonene søker etter verdien i treet.
         * @param value
         * @return null hvis verdien ikke finnes - ellers Noden
         */
        public Node search(int value){
            Node p = root;

            while(p != null || p.value == value){
                //Verdien er større enn p
                if(value > p.value){
                    p = p.right_child;
                //verdien er mindre enn p
                }else if(value < p.value){
                    p = p.left_child;
                //verdien er lik p
                }else{
                    break;
                }
            }
            return p;
        }
        void insert(int value) {
            //Sjekk om treet er tomt
            //vi lager første node
            if (root == null) {
                root = new Node(value);
                return;
            }
            //treet er ikke tomt. Legge in n verdi på riktig plass
            else {
                //Initialiser og sett noden vi ser på som root node
                Node p = root;
                Node q = null; // Parent til p
                while (p != null) {
                    q = p; // Oppdater nåværende p blir nye q
                    if (value >= p.value) {
                        //flytt p ett hakk nedover
                        p = p.right_child;
                    } else {
                        //Flytt p ett hakk nedover
                        p = p.left_child;
                    }
                }
                //Nå har vi funnet hvor den nyte noden skal ligge.
                if (value >= q.value) {
                    q.right_child = new Node(value, q);
                } else {
                    q.left_child = new Node(value, q);
                }

            }
        }
        public void print(){
            this.root.printPreorderRevursive();
        }
    }

}
