def SelectionSort(array):
  for i in range(len(array)):
    minimum = GetMinimum(array, i)
    Swap(array, i, minimum)
  
  return array

def GetMinimum(array, i):
  minimum = i 

  for j in range(i, len(array)):
    if(array[j] < array[minimum]):
      minimum = j 
  
  return minimum 

def Swap(array, i, j):
  aux = array[i]
  array[i] = array[j]
  array[j] = aux
