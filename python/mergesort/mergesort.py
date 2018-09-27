#/bin/python
# 
# Implement a basic merge-sort algorithm
#
import pdb



def mergeSortArray(array):
    """ Call Merge Sort on the provided array """
    print 'merg sort %s' % array
    high = len(array) - 1
    mergeSort(array, 0, high)
    return

def mergeSort(array, low, high):
    """ Recursively merge sort an array
        array: array to sort
        low: lower bounds of the array index to sort
        high: higher bounds of the array index to sort
    """
    if (low < high):
        middle = (high + low) / 2

        mergeSort(array, low, middle)
        mergeSort(array,middle+1, high)
        merge(array, low, middle, high)

    return

# merge two sorted arrays
def merge(array, low, middle, high):
    """ Combine sorted arrays: array[low - middle] and array [middle+1 - high]
        array: array to sort
        low: lower bounds of the array index to sort
        high: higher bounds of the array index to sort
    """
    sortedArray = []

    leftIndex = 0
    rightIndex = 0
    index = low

    # copy left and right portions of the array into their own lists
    left = array[low:middle+1]
    leftLen = len(left)
    right = array[middle+1:high+1]
    rightLen = len(right)

    # copy both sorted halfs back into the array
    while ((leftIndex < leftLen) or (rightIndex < rightLen)):

        candidateNum = None

        if (leftIndex == leftLen):
            # array 1 is complete, just add array 2
            array[index] = right[rightIndex]
            rightIndex += 1

        elif (rightIndex == rightLen):
          # array 2 is complete, just add array 1
            array[index] = left[leftIndex]
            leftIndex += 1

        elif left[leftIndex] < right[rightIndex]:
            # both arrays have elements left. Array 1 is smaller
            array[index] = left[leftIndex]
            leftIndex += 1

        else:
            # both arrays have elements left. Array 2 is smaller
            array[index] = right[rightIndex]
            rightIndex += 1

        index += 1

    return

def main():
    toSort = [ 1, 590, 87, 4 ]
    mergeSortArray(toSort)
    print 'Sorted algorithm is %s' % toSort

    toSort2 = [ 5, 12, 57, 99, 590, 80, 12, 3 ]
    mergeSortArray(toSort2)
    print 'Sorted algorithm is %s' % toSort2

if __name__ == '__main__':
    main()