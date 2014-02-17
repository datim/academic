#include <cstdio>
#include <string.h>
#include <iostream>

// look for the frequency of a particular node value, using depth first search.
// This example is incomplete because the BST to test isn't initialized

class Node 
{
 public:
	Node(const int inValue)
	{
		right = NULL:
		left = NULL;
		content = inValue;
	}

	const int getContent(void)
	{
		return content;
	}
	Node * getRight(void)
	{
		return right;
	}

	Node * getLeft(void)
	{
		return left;
	}

	~Node(void) {}

 private:

	Node * right;
	Node * left;
	int content;
};

void searchFrequency(Node * n, const int searchValue, int &frequency)
{

	// depth first search. For each node, search all its left 
	// nodes, then its right nodes

	if (!n) 
	{
		return;
	}

	// if the value matches the one we're looking for, increase 
	// the value
	if (n.getContent() == searchValue)
	{
		frequency++;
	}

	// depth first search. Search all left leafs, then all right leafes

	searchFrequency(n.getLeft(), searchValue, frequency);
	searchFrequency(n.getRight(), searchValue, frequency);
}

int main(int argc, char **argv) 
{
	// check for the frequency of a node using depth first search


	// assume node passed in
	Node head;

	// value to search for
	int value = 12;
	int frequency = 0;

	searchFrequency(node, value, frequency);

};
