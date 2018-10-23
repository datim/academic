# Return true if a substring of numbers in a list equals value k


def hasSubString(array, k):

  if not array:
    return False

  i = 0
  j = 0
  sum = array[i]

  # do loop
  while True:

    if (sum == k):
      return True  # sub string found

    elif sum > k and j < i:
      # shrink size of substring
      sum -= array[j]
      j += 1
  
    elif i < (len(array) - 1):
      # increment substring length
      i += 1
      sum += array[i]

    else:
      # reached end of substring
      break

  return False

def main():
  array = [1, 3, 7, 5, 5, 2, 10]

  for i in range(1, 25):
    success = 'has' if hasSubString(array, i) else 'does not have'
    print '%s %s substring sum of %d' % (array, success, i)

if __name__ == '__main__':
  main()