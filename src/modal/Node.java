package modal;

public class Node {
    public Planet planet;
    public Node leftNode = null;
    public Node rightNode = null;

    public Node(){

    }

    public Node(Planet p, Node left, Node right){
        planet = p;
        leftNode = left;
        rightNode = right;
    }
}
