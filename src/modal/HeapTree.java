package modal;

import java.util.HashMap;
import java.util.Map;

public class HeapTree {
    private Planet[] heap;
    private int size;
    private int capacity;
    private Map<String, Integer> planetsMap;

    public boolean isEmpty() {
        return size == 0;
    }


    public HeapTree(int capacity) {
        this.capacity = capacity;
        heap = new Planet[capacity + 1];
        size = 0;
        planetsMap = new HashMap<>();
    }

    public void insert(Planet planet) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }

        heap[++size] = planet;
        planetsMap.put(planet.getName(), size);
        bubbleUp(size);
    }

    public Planet extractMin() {
        if (size == 0) {
            return null;
        }
        Planet minPlanet = heap[1];
        heap[1] = heap[size--];

        planetsMap.put(heap[1].getName(), 1);
        planetsMap.remove(minPlanet.getName());

        bubbleDown(1);
        return minPlanet;
    }


    private void bubbleUp(int index) {
        while (index > 1 && heap[index].getEquatorialDiameter() < heap[index / 2].getEquatorialDiameter()) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    private void bubbleDown(int index) {
        while (2 * index <= size) {
            int leftChild = 2 * index;
            int rightChild = 2 * index + 1;
            int smallest = index;

            if (leftChild <= size && heap[leftChild].getEquatorialDiameter() < heap[smallest].getEquatorialDiameter()) {
                smallest = leftChild;
            }
            if (rightChild <= size && heap[rightChild].getEquatorialDiameter() < heap[smallest].getEquatorialDiameter()) {
                smallest = rightChild;
            }

            if (smallest == index) {
                break;
            }
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int index1, int index2) {
        Planet temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;


        planetsMap.put(heap[index1].getName(), index1);
        planetsMap.put(heap[index2].getName(), index2);
    }
}
