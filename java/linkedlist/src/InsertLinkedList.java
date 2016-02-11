
public class InsertLinkedList {
	
	Node head = null;
	Node tail = null;

	/**
	 * Node class
	 */
	private class Node {
		Node next = null;
		String value = null;
		
		private void setValue(String v) { value = v;}
		private String getValue() { return value;}
		private Node getNext() { return next; }
		private void setNext(Node n) { next = n; }
	}

	public static void main(String[] args) {
		InsertLinkedList llist= new InsertLinkedList();
		llist.run();
	}
	
	/**
	 * run
	 */
	public void run() {
		insertAfter(head, "bug");
	}
	
	/**
	 * insert after
	 */
	public void insertAfter(Node element, String value) {
		
		Node n = new Node();
		n.setValue(value);
		
		if (element == null) {
			// insert at the beginning of the list. Doesn't matter whether head is null
			n.setNext(head);
			
			if (head == null) {
				// this was the first element in the list, update it
				tail = n;
			}
			
			// update the head of the list
			head = n;
			
		} else {
			// there should be a valid element. Assume head is not null and that the caller
			// is actually calling a node in the list
			
			Node current = head;
			
			while (current != element) {
				current = current.getNext();
			}
			
			// add the new node after current
			Node next = current.getNext();
			current.setNext(n);
			n.setNext(next);
			
			if (next == null) {
				// we just inserted a node into the end. Update tail
				tail = n;
			}
		}
	}
	
	

}
