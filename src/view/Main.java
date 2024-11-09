package view;
//this class using BinaryTree datastructure to maintain the Object planet
import modal.Node;
import modal.Planet;

import java.util.Scanner;

public class Main {
    private Node root;

    public Main(){
        this.root = null;
    }
    public void insertNode(Planet p){
        root = insertRescursive(root, p);
    }

    private Node insertRescursive(Node node, Planet planet){
        if(node == null){
            return new Node(planet, null, null);
        }
        if(planet.getMass() < node.planet.getMass()){
            node.leftNode = insertRescursive(node.leftNode, planet);
        }else if(planet.getMass() > node.planet.getMass()){
            node.rightNode = insertRescursive(node.rightNode, planet);
        }
        return node;
    }


    private Node searchRescursive(Node node, double mass){
        if(node == null || node.planet.getMass() == mass){
            return node;
        }
        if(mass < node.planet.getMass()){
            return searchRescursive(node.leftNode, mass);
        }else{
            return searchRescursive(node.rightNode, mass);
        }
    }

    public void inorderTraversal(){
        inorderRecursive(root);
    }

    private void inorderRecursive(Node node){
        if(node != null){
            inorderRecursive(node.leftNode);
            System.out.println(node.planet);
            inorderRecursive(node.rightNode);
        }
    }

    public void removePlanet(double mass){
        root = removePlanetRecursive(root, mass);
    }

    public Node removePlanetRecursive(Node root, double mass){
    if(root == null){
        return root;
    }
        if(mass < root.planet.getMass()){
        root.leftNode = removePlanetRecursive(root.leftNode, mass);
        }else if(mass > root.planet.getMass()){
        root.rightNode = removePlanetRecursive(root.rightNode, mass);
        }else{
            if(root.leftNode == null && root.rightNode == null){
                root = null;
            }else if(root.leftNode == null){
                return root.rightNode;
            }else if(root.rightNode == null){
                return root.leftNode;
            }
            else{
                Node minNode = findMin(root.rightNode);
                root.planet = minNode.planet;
                root.rightNode = removePlanetRecursive(root.rightNode, mass);
            }
        }
        return root;
    }

    public void PrintResult(double mass){
        Node found = searchRescursive(root, mass);
        if(found != null){
            System.out.println("planet found!"+ found.planet);
        }else{
            System.out.println("not found!");
        }
    }

    private Node findMin(Node node){
        while(node.leftNode != null){
            node = node.leftNode;
        };
        return node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("-------------------------");
        Planet Mercury = new Planet("Mercury", 0.06, 0.383, 0.39, 0.24);
        Planet Venus = new Planet("Venus", 0.81, 0.949, 0.72, 0.62);
        Planet Earth = new Planet("Earth", 1.00, 1.000, 1.00, 1.00);
        Planet Mars = new Planet("Mars", 0.11, 0.532, 1.52,1.88);
        Planet Jupiter = new Planet("Jupiter", 317.83, 11.209, 5.20, 11.86);
        Planet Saturn = new Planet("Saturn", 95.16, 9.449, 9.24, 29.45);
        Planet Uranus = new Planet("Uranus", 14.54, 4.007, 19.19, 84.02);
        Planet Neptune = new Planet("Neptune", 17.15, 3.883, 30.07, 164.79);

        Main m = new Main();

        m.insertNode(Mercury);
        m.insertNode(Venus);
        m.insertNode(Earth);
        m.insertNode(Mars);
        m.insertNode(Jupiter);
        m.insertNode(Saturn);
        m.insertNode(Uranus);
        m.insertNode(Neptune);

        System.out.println("Planets ordered by mass: ");
        m.inorderTraversal();
        System.out.println("-------------------------");
        System.out.println("Enter mass of planet: ");
        double target = sc.nextDouble();
        m.PrintResult(target);
        System.out.println("-------------------------");
        System.out.println("remove planet with mass: ");
        double aim = sc.nextDouble();
        m.removePlanet(aim);
        System.out.println("Done!");
        System.out.println("Planets ordered by mass: ");
        m.inorderTraversal();
    }
}