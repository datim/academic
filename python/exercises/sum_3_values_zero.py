# return true if 3 values of a list equal zero

def is_zero(array):
  """  # return true if three element equal zero """
  if not array: 
    return False

  sum = {}

  # O(n squared) time, O(n) memory
  for i in range(0, len(array)):
    for j in range(i+1, len(array)):
      target = -1 * (array[i] + array[j])
      #print 'i: %d, j %d, target: %d, sum: %s' % (i, j, target, sum)

      if target in sum:
        return True
      else:
        sum[array[j]] = True
    
    sum[array[i]] = True
      
  return False

def print_is_zero(array):
  success = 'has' if is_zero(array) else 'does not have'
  print '%s %s 3 values that equal zero' % (array, success)

def main():
  print_is_zero([1, 3, 5, -3, 0])
  print_is_zero([1, 2, 4, -1, -1])
  print_is_zero([1, 2, 3, -6])
  print_is_zero([1, 50, 12, -2])

if __name__ == '__main__':
  main()