#include <cstdio>
#include <string.h>
#include <iostream>

char * strdup(char * x) {

	// check for empty string
	if (!x)
	{
		return NULL;
	}

	// create a pointer to the beginning of the array so we can iterate it
	// to find length
	char *z = x;
	int size = 0;

	// get size of string. Don't use strlen(x).
	while (*z != '\0')
	{
		size++;
		z++;
	}

	// add an extra character for the null terminator 
	size++;

	// create a copy of the array
	char *copy = new char[size];

	// copy the string, character by character
	for (int i = 0; i < size; i++)
	{
		copy[i] = x[i];
	}

	// copy the string deliminator
	copy[size] = '\0';

	return copy;
}

int main(int argc, char ** argv) {

	// merge sort
	char x[] = "how are you";
	char *duplicate = strdup(x);

	if (duplicate != NULL)
	{
		std::cout << "original string: '" << x << "', copy: '" << duplicate << "'" << std::endl;
		std::cout << "lenght original is " << strlen(x) << ", length duplicate: " << strlen(duplicate) << std::endl;
	}
	else
	{
		std::cout << "copy is null" << std::endl;
	}

	return 0;
};
