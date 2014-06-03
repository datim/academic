#include <cstdio>
#include <string.h>
#include <iostream>

void printArray(int *array, const int low, const int high) 
{

	std::cout << "[ ";
    for (int x = low; x < high; x++)
	{
		std::cout << array[x] << " ";
	}
	std::cout << "] low:" << low << ", high: " << high << std::endl;
}

void merge(int theArray[], const int low, const int mid, const int high)
{
	std::cout << "merge array, low: " << low << ", mid: " << mid << ", high: " << high << " ";
	printArray(theArray, low, high);

	// create a temporary array to merge the two arrays
	const int tempArraySize = high - low;
	int *tempArray = new int[tempArraySize];
	int tempIndex = 0;

	// now sort through the two arrays and place the results in tempArray

	int firstArrayCount = low;
	int secondArrayCount = mid; 

	while (tempIndex < tempArraySize)
	{
		if (theArray[firstArrayCount] < theArray[secondArrayCount])
		{
			tempArray[tempIndex++] = theArray[firstArrayCount++];
		}
		else if (theArray[firstArrayCount] > theArray[secondArrayCount])
		{
			tempArray[tempIndex++] = theArray[secondArrayCount++];
		}
		else
		{
			// the arrays are equal
			tempArray[tempIndex++] = theArray[firstArrayCount++];
			tempArray[tempIndex++] = theArray[secondArrayCount++];
		}

		// now check to see if one of the arrays has been maxed out. In this case
		// just fill in with the other array
		if (firstArrayCount == mid) 
		{
			// we've used all the values from the first array. Fill in with second
			for (; secondArrayCount < high; secondArrayCount++)
			{	
				tempArray[tempIndex++] = theArray[secondArrayCount];
			}
		}
		else if (secondArrayCount == high)
		{
			// we've used al lthe values from the second array. Fill in with the first

			for (; firstArrayCount < mid; firstArrayCount++)
			{	
				tempArray[tempIndex++] = theArray[firstArrayCount];
			}
		}
	}

	// copy the temp array back to the master array
	tempIndex = 0;
	for (int i = low; i < high; i++)
	{
		theArray[i] = tempArray[tempIndex++];
	}


	// delet ethe temporary array
	delete tempArray;
}

void mergeSort(int theArray[], const int low, const int high)
{
	std::cout << "MergeSort: low: " << low << ", high: " << high << " ";
	printArray(theArray, low, high);

	const int arraySize = high - low;

	if (arraySize > 1)
	{
		// array is greater than one in length.  recursively call
		// merge sort
		const int mid = (low + high) / 2;
		mergeSort(theArray, low, mid);
		mergeSort(theArray, mid, high);

		// merge the two arrays, in place
		merge(theArray, low, mid, high);

		std::cout << "After merge sort, array is now:";
		printArray(theArray, low, high);
	}
	else
	{
		// array is one item in length, nothing to sort
	}
}
			
// Start the merge sort program
int startMergeSort() {

	// create an unsorted array with random numbers
	const int size = 8;
	int unsortedArray[size] = {1, 55, 123, 23, 99, 404, 122, 10 };

	mergeSort(unsortedArray, 0, size);
}

int main(int argc, char ** argv) {

	// merge sort
	startMergeSort();
};
