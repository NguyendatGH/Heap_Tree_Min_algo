package view;
//this class using Heap data structure to maintain and track the object base on their equatorialDiameter

import modal.Planet;
import modal.HeapTree;

import java.util.Scanner;

public class MainHeap {
    private HeapTree heap;

    public MainHeap() {
        this.heap = new HeapTree(10);  //max heap is 10
    }

    public void insertNode(Planet planet) {
        heap.insert(planet);
    }

    public void processByEquatorialDiameter() {
        System.out.println("Processing planets by equatorial diameter:");
        while (!heap.isEmpty()) {
            Planet p = heap.extractMin();
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------------");

        Planet Mercury = new Planet("Mercury", 0.06, 0.383, 0.39, 0.24);
        Planet Venus = new Planet("Venus", 0.81, 0.949, 0.72, 0.62);
        Planet Earth = new Planet("Earth", 1.00, 1.000, 1.00, 1.00);
        Planet Mars = new Planet("Mars", 0.11, 0.532, 1.52, 1.88);
        Planet Jupiter = new Planet("Jupiter", 317.83, 11.209, 5.20, 11.86);
        Planet Saturn = new Planet("Saturn", 95.16, 9.449, 9.24, 29.45);
        Planet Uranus = new Planet("Uranus", 14.54, 4.007, 19.19, 84.02);
        Planet Neptune = new Planet("Neptune", 17.15, 3.883, 30.07, 164.79);


        MainHeap m = new MainHeap();
        m.insertNode(Mercury);
        m.insertNode(Venus);
        m.insertNode(Earth);
        m.insertNode(Mars);
        m.insertNode(Jupiter);
        m.insertNode(Saturn);
        m.insertNode(Uranus);
        m.insertNode(Neptune);

        System.out.println("Planets ordered by equatorial diameter: ");
        m.processByEquatorialDiameter();

    }
}
