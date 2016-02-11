package stack;

public class Stack {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StackInterface aStack = new ArrayStack(5);
		
		StackInterface lStack = new LinkedListStack();
	
		testStack(aStack);
		testStack(lStack);
	}
	
	public static void testStack(StackInterface stack) {
		
		// add to stack
		stack.push("item1");
		
		System.out.println("Stack size is " + stack.getSize());
		
		stack.push("item2");
		
		System.out.println("Stack size is " + stack.getSize());

		System.out.println("First item popped should be item2: " + stack.pop());
		
		System.out.println("Stack size is " + stack.getSize());
		
		System.out.println("First item popped should be item1: " + stack.pop());
		
		System.out.println("Stack size is " + stack.getSize());
		
		System.out.println("No more items, result should be null: " + stack.pop());
		
		System.out.println("Stack size is " + stack.getSize());
		
		System.out.println("No more items, result should be null: " + stack.pop());
		
		System.out.println("Stack size is " + stack.getSize());
	}

}
