#/bin/python
#
# implement quicksort in Python

def quick_sort(array, low, high):
  """ main quicksort algorithm """

  if not array:
    return

  if (low < high):

    # choose pivot to be highest value
    middle = (low + high) / 2
    pivot = array[middle]

    # move all values smaller than pivot to left, all values greater than pivot to right
    iLow = low
    iHigh = high

    while (iLow <= iHigh):
      
      # advance left side until we reach a value that needs to be moved to other side of pivot
      while(array[iLow] < pivot):
        iLow += 1

      # advance right side until we reach a value that needs to be moved to other side of pivot
      while (array[iHigh] > pivot):
        iHigh -= 1

      if (iLow <= iHigh):
        # swap low and high values to get them on right side of pivot
        tmp = array[iLow]
        array[iLow] = array[iHigh]
        array[iHigh] = tmp
        iLow +=1 
        iHigh -=1 

    if (low < iHigh):
      # there are remaining left side values to sort
      quick_sort(array, low, iHigh)
    
    if (high > iLow):
      # there are remaining right side values to sort
      quick_sort(array, iLow, high)

def quick_sort_start(array):
  quick_sort(array, 0, len(array)-1)
  return array

def main():
  array_to_sort = [59, 1, 36, 12, 88, 10, 19]
  print quick_sort_start(array_to_sort)
  array_to_sort2 = [18, 57, 9, 5000, 301, 12, 18]
  print quick_sort_start(array_to_sort2)

if __name__ == '__main__':
    main()