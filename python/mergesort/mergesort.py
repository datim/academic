#/bin/python
# 
# Implement a basic merge-sort algorithm
#

def startMergeSort(array):
  """ Start merge sort """
  mergeSort(array, 0, len(array))

def mergeSort(array, start, end):
  """ recursively sort and merge array """
  if (start < end):
    middle = (start + end) / 2
    mergeSort(array, start, middle)
    mergeSort(array, middle+1, end)
    merge(array, start, middle, end)

def merge(array, start, middle, end):
  """ Merge two halves of provided array """

  # make a copy of the right side
  left = array[start:middle+1]

  # make a copy of the right side
  right = array[middle+1:end+1]

  iLeft = 0
  iRight = 0
  index = start

  # iterate through both arrays, copying the smaller number back to the array
  while (iLeft < len(left) and iRight < len(right)):
    if (left[iLeft] < right[iRight]):
      array[index] = left[iLeft]
      iLeft += 1
    else:
      array[index] = right[iRight]
      iRight += 1

    index += 1

  # copy remaining left values
  while iLeft < len(left):
      array[index] = left[iLeft]
      iLeft += 1
      index += 1

  # copy remaining right values
  while iRight < len(right):
      array[index] = right[iRight]
      iRight += 1
      index += 1


def main():
  array = [1, 50, 12, 39, 18, 7, 6]
  startMergeSort(array)
  print 'sorted array is %s' % array

  array2 = [ 5, 12, 57, 99, 590, 80, 12, 3 ]
  startMergeSort(array2)
  print 'sorted array is %s' % array2

if __name__ == '__main__':
    main()
