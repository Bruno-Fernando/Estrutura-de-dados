def BubbleSort(array):

  for i in range(len(array)):

    for j in range(len(array) - 1):

      if(array[i] < array[j]):
        Swap(array, i, j)
  
  return array

def Swap(array, i, j):
  aux = array[i]
  array[i] = array[j]
  array[j] = aux
