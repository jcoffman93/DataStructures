public class LinkedList<T> {
	private LinkedList<T> next;
	private LinkedList<T> prev;
	public T data;

	public LinkedList (T newData, LinkedList<T> nextNode, LinkedList<T> prevNode) {
		this.data = newData;
		this.next = nextNode;
		this.prev = prevNode;
	}

	public int getSize() {
		int size = 0;
		LinkedList<T> current = this;
		while (current != null) {
			current = current.next;
			size += 1;
		}
		return size;
	}

	public void append(LinkedList<T> node) {
		LinkedList<T> current = this;
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;
		node.prev = current;
	}

	public LinkedList<T> deleteFromList(int index) {
		LinkedList<T> current = this;
		for(int i = 0; i < index - 1; i++) {
			current = current.next;
		}
		if (current == null) {
			System.out.println("Index out of bounds");
			break;
		}
		LinkedList<T> temp = this.next; // Node to be deleted
		this.next = temp.next;
		if (this.next != null) this.next.prev = this;
		return temp;
	}

	public LinkedList<T> deleteFromList(LinkedList<T> node) {
		LinkedList<T> current = this;
		while (current.next != node) {
			current = current.next;
		}
		LinkedList<T> temp = this.next; // Node to be deleted
		this.next = temp.next;
		if (this.next != null) this.next.prev = this;
		return temp;
	}

	public LinkedList<T> deleteDouble() {
		this.next.prev = this.prev;
		this.prev.next = this.next;
		return this;
	}

	public void printList() {
		LinkedList<T> current = this;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
}