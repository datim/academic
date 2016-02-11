package stack;

public class ArrayStack implements StackInterface {
	
	String [] stack = null;
	int size = 0;
	int index = 0;
	
	// initialize a stack
	public ArrayStack(int size) {
		
		this.size = size;
		stack = new String[size];
	}
	
	// get the size of the stack
	public int getSize() {
		return index;
	}
	
	// push a value onto the stack
	public boolean push(String item) {
				
		// adjust the stack if required
		if (index == (size - 1)) {
			// stack is full. Can't add new items
			return false;	
		}
		
		// add the item to the stack
		stack[index++] = item;	
		return true;
	}

	// pop a value off the stack
	public String pop() {
		
		if (index == 0) {
			// nothing to pop
			return null;
			
		} else {
			// return the stack element
			return stack[--index];
		}
	}
}
