import java.util.NoSuchElementException;

public class DeliveryQueue {
  private static final int INITIAL_CAPACITY = 20;
  private Delivery[] heap;
  private int size;

  public DeliveryQueue() {
    this.heap = new Delivery[INITIAL_CAPACITY];
    this.size = 0;
  }

  public void offerDelivery(Delivery delivery) {
    // If heap has reached maximum capacity
    if (getSize() >= this.heap.length) {
      Delivery[] newHeap = new Delivery[this.heap.length * 2]; // Creates new heap

      for (int i = 0; i < this.heap.length; i++) { // Copies old contents
        newHeap[i] = this.heap[i];
      }

      this.heap = newHeap;
    }

    heapify();
    this.size++;
    this.heap[getSize() - 1] = delivery; // Adds to the heap
    percolateUp(getSize() - 1);

    return;
  }

  public Delivery pollBestDelivery() {
    if (getSize() <= 0) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }

    Delivery toRet = this.heap[0];
    this.heap[0] = this.heap[size - 1];
    this.size--;

    Delivery[] newHeap = new Delivery[getSize()];

    for (int i = 0; i < newHeap.length; i++) {
      if (this.heap[i].equals(toRet)) {
        this.size--;
        continue;
      }

      newHeap[i] = this.heap[i];
    }

    this.heap = newHeap;

    percolateDown(0);

    return toRet;
  }

  public Delivery peek() {
    if (getSize() <= 0) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }

    heapify();
    return this.heap[0];
  }

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    if (this.size <= 0) {
      return true;
    } else {
      return false;
    }
  }

  private void percolateUp(int index) {
    if (getSize() <= 1) {
      return;
    }
    if ((index - 1 / 2) < 0) { // If parent index is out of bounds
      return;
    }

    if (this.heap[index].compareTo(this.heap[(index - 1) / 2]) == 1) {
      return;
    } else {
      Delivery temp = this.heap[index];
      this.heap[index] = this.heap[(index - 1) / 2];
      this.heap[(index - 1) / 2] = temp;

      percolateUp(index);

      return;
    }
  }

  private void percolateDown(int index) {
    if (getSize() <= 1) {
      return;
    }
    if ((index * 2) + 1 >= getSize() || (index * 2) + 2 >= getSize()) { // If children index is out
                                                                        // of
      // bounds
      return;
    } else if (this.heap[index].compareTo(this.heap[(index * 2) + 1]) == -1
        && this.heap[index].compareTo(this.heap[(index * 2) + 2]) == -1) { // Left child and right
                                                                           // child respectively
      return;
    }

    // If left child is more than parent
    if (this.heap[index].compareTo(this.heap[(index * 2) + 1]) == 1) {
      Delivery temp = this.heap[index];
      this.heap[index] = this.heap[(index * 2) + 1];
      this.heap[(index * 2) + 1] = temp;

      percolateDown(index);

      return;
    } else { // If right child is more than parent
      Delivery temp = this.heap[index];
      this.heap[index] = this.heap[(index * 2) + 2];
      this.heap[(index * 2) + 2] = temp;

      percolateDown(index);

      return;
    }
  }

  private void heapify() {
    if (getSize() >= 1) {
      return;
    }

    for (int i = this.size / 2; i >= 0; i--) {
      percolateDown(i);
    }
  }

  @Override
  public String toString() {
    String string = "This DeliveryQueue contains " + size + " elements";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    for (int i = 0; i < size; i++)
      string += "\n" + heap[i].toString();
    string += " ]\n";
    return string;
  }
}
