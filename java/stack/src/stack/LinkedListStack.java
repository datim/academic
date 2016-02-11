package stack;

import java.sql.Struct;

/**
 * Implement a stack as a linked list
 * @author roecks
 *
 */
public class LinkedListStack implements StackInterface {
	
	private class Node {
		Node next = null;
		String value = null;
		
		private void setValue(String v) { value = v;}
		private String getValue() { return value;}
		private Node getNext() { return next; }
		private void setNext(Node n) { next = n; }
	}
	
	Node head = null;
	Node current = null;

	@Override
	public String pop() {
		
		String result = null;
		
		if (head != null) {
			if (current != null && head == current) {
				
				// there is one item in the list
				result = current.getValue();

				// reset the node list
				current = null;
				head = null;

			} else {
				
				result = current.getValue();
				
				// find the node current - 1.  This is not a doubly linked list,
				// so we need to start from head
				Node x = head;
				while(true) {
					if (x.getNext() == current) {
						current = x;
						break;
					} else {
						x = x.getNext();
					}	
				}
			}
		}
		
		
		return result;
	}

	@Override
	public boolean push(String item) {
		
		if (head == null) {
			// first value
			head = new Node();
			head.setValue(item);
			current = head;
			
		} else {
			
			// add to the end of the list
			Node n = new Node();
			n.setValue(item);
			current.setNext(n);
			current = n;
		}
		
		return true;
	}

	@Override
	public int getSize() {
	
		
		if (head == null) {
			return 0;
		} else {
			
			Node x = head;
			
			int count = 1;
			
			while (x != current) {
				count++;
				x = x.getNext();
			}
			
			return count;
		}
	}
}
