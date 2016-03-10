#include <cstdio>
#include <string.h>
#include <iostream>

// merge two linked lists together
// Example:
//  list 1: A, B, C
//  list 2: 5, 6, 7, 8, 9
//  result: A, 5, B, 6, 7, C, 8, 9

class Node
{
 public:
	Node(const int value)
	{
		_value = value;
		_next = NULL;
	}

	~Node() {}

	const int getValue()
	{
		return _value;
	}

	void setNext(Node *next)
	{
		_next = next;
	}

	Node * getNext(void)
	{
		return _next;
	}

 private:
	
	Node * _next;
	int _value;

};

Node * constructLinkedList(int seed, int num_nodes)
{
	// helper method to construct a linked list

	int tempSeed = seed;
	Node * head = new Node(tempSeed);
	Node * n = head;

	for (int i =0; i < num_nodes; i++)
	{
		tempSeed += 2;
		n->setNext(new Node(tempSeed));
		n = n->getNext();
	}

	return head;
}

void printNodes(Node * head)
{
	// helper method to print out a linked list
	Node *n = head;

	while (n != NULL)
	{
		std::cout << n->getValue() << "->";
		n = n->getNext();
	}

	std::cout << "NULL" << std::endl;
}

Node * mergeLists(Node *list1, Node *list2)
{
	if (!list1 && !list2)
	{
		std::cout << "both lists are empty" << std::endl;
	}

	// check if just one list is empty
	if (!list1)
	{
		return list2;
	}

	// check if just one list is empty
	if (!list2)
	{
		return list1;
	}

	// initialize each index to the head of their respective lists
	Node * indexOne = list1;
	Node * indexTwo = list2;

	// always start with list one.  Initialize the head to the start of list one
	Node * returnNodeHead = new Node(list1->getValue());
	Node * returnNodeIndex = returnNodeHead;

	// loop through the lists. First attempt to add a node from list 2, then list1.
	// if either list is empty, then we just add the remaining items from the other list
	while (indexOne != NULL && indexTwo != NULL)
	{
		if (indexTwo != NULL)
		{
			returnNodeIndex->setNext(new Node(indexTwo->getValue()));
			returnNodeIndex = returnNodeIndex->getNext();
			indexTwo = indexTwo->getNext();
		}

		if (indexOne != NULL)
		{
			returnNodeIndex->setNext(new Node(indexOne->getValue()));
			returnNodeIndex = returnNodeIndex->getNext();
			indexOne = indexOne->getNext();
		}
	}

	return returnNodeHead;
}

int main(int argc, char ** argv) {

	Node * list1 = constructLinkedList(10, 10);
	Node * list2 = constructLinkedList(100, 5);

	std::cout << "linked list 1: ";
	printNodes(list1);

	std::cout << "linked list 2: ";
	printNodes(list2);

	Node * mList = mergeLists(list1, list2);

	std::cout << "result: ";
	printNodes(mList);
};
