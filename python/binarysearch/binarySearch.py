
#/bin/python
# 
# Implement a basic binary search algorithm
#

def binarySearch(array, low, high, value):
    ''' Search for an array using a recursive binary search '''

    if (low > high):
        # not found
        return -1

    mid = (low + high) / 2

    if array[mid] < value:
        # search upper half of array
        return binarySearch(array, mid+1, high, value)
    elif array[mid] > value:
        # search lower half of array
        return binarySearch(array, low, mid-1, value)
    else:
        return mid

def startSearch(array, x):
    ''' Search for value x in array using a binary search '''

    size = len(array)

    if (binarySearch(array, 0, size - 1, x) != -1):
        print 'value %d found' % x
    else:
        print 'value %d not found' % x


def main():
    array1 = [1, 2, 3, 4, 5, 12, 50, 55, 57, 60, 79, 1000, 9000, ]
    startSearch(array1, 4)
    startSearch(array1, 7)
    startSearch(array1, 12)
    startSearch(array1, 13)

if __name__ == '__main__':
    main()