class BST {
    Node root;
    static int primerjave = 0;
    static boolean brisi = false;
    static int currCounter = 0;



    static class Node {
        int key;
        int counter;
        Node left, right;

        Node(int data){
            key=data;
            left=null;
            right=null;
            counter=0;
        }
    }




    public BST() {
        root = null;
    }

    void insert(int key) {

        root = recInsert(root, key);




    }

    Node recInsert(Node curr, int key) {
        if (curr==null) return new Node(key);
        if (key == curr.key) { primerjave++;curr.counter++;}
        else if (key < curr.key) {primerjave++;curr.left = recInsert(curr.left,key);}
        else if (key > curr.key) {primerjave++;curr.right = recInsert(curr.right,key);}

        return curr;
    }

    boolean find(int key) {
        Node current = root;

        while(current!=null) {
            if (key==current.key) {primerjave++;return true;}
            if (key < current.key) {primerjave++;current = current.left;}
            else if (key > current.key) {primerjave++;current = current.right;}
        }
        primerjave++;
        return false;


    }

    void delete(int key) {
        root = deleteRek(root,key);
    }

    Node deleteRek(Node curr,int key) {
        if (curr == null) return curr;

        if (curr.key == key) {
            primerjave++;

            if (curr.counter>=1 && currCounter==0) {
                curr.counter--;
                return curr;
            }
            else {
                if (curr.left == null && curr.right == null) return null;

                if (curr.left == null) return curr.right;
                if (curr.right == null) return curr.left;

                if(brisi == false) {

                    int zamenjaj = findBig(curr.left);
                    curr.key = zamenjaj;
                    curr.counter=currCounter;
                    curr.left = deleteRek(curr.left,zamenjaj);
                    currCounter=0;
                    brisi = true;
                    primerjave++;

                    return curr;
                }
                else if (brisi == true) {

                    int zamenjaj = findSmall(curr.right);
                    curr.key = zamenjaj;
                    curr.counter=currCounter;
                    curr.right = deleteRek(curr.right,zamenjaj);
                    currCounter=0;
                    primerjave++;
                    brisi = false;
                    return curr;
                }
            }

        }
        else if (key < curr.key) {primerjave++;curr.left = deleteRek(curr.left, key);}
        else if (key > curr.key) {primerjave++;curr.right = deleteRek(curr.right, key);}

        return curr;
    }

    int findBig(Node curr) {
        if (curr.right==null) {
            currCounter=curr.counter;
            return curr.key;}
        else return findBig(curr.right);
    }

    int findSmall(Node curr) {
        if (curr.left==null) {
            currCounter=curr.counter;
            return curr.key;}
        else return findBig(curr.left);
    }

    void printInorder() {
        rekInorder(root);
    }

    void rekInorder(Node curr) {
        if (curr==null) return;

        rekInorder(curr.left);
        System.out.println(curr.key);
        rekInorder(curr.right);
    }

    void printPreorder() {
        rekPreorder(root);
    }

    void rekPreorder(Node curr) {
        if (curr == null) return;

        System.out.println(curr.key);
        rekPreorder(curr.left);
        rekPreorder(curr.right);
    }

    void printPostorder() {
        rekPostorder(root);
    }

    void rekPostorder(Node curr) {
        if (curr==null) return;
        rekPostorder(curr.left);
        rekPostorder(curr.right);
        System.out.println(curr.key);
    }

    void printNodeComparisons() {
        if(primerjave>0) {
            System.out.println(primerjave);
        }
        else
        {System.out.println(primerjave);}
    }
}



public class DN2 {
    public static void main(String[] args){

        BST b5 = new BST();
        b5.insert(29);
        b5.insert(15);
        b5.insert(43);
        b5.insert(7);
        b5.insert(23);
        b5.insert(35);
        b5.insert(51);
        b5.delete(29);
        System.out.println("Preorder --");
        b5.printPreorder();
        System.out.println("Primerjave --");
        b5.printNodeComparisons();
        System.out.println();








    }
}
