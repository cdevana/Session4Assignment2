package session4;

public class InsertAndSortArray {
	
	/*
	 * Input Array: 45 2 89 5 67 13 
	 * Sorted Array: 2 5 13 45 67 89 
	 * Element to insert: 55
	 * Array after insert: 2 5 13 45 55 67 89 
	 */

	public static int[] sort(int[] integers1) { //Use this method to sort an integer array
		int[] integers = {45, 2, 89, 5, 67, 13};
		int countOfInputArray = integers.length;
		int[] sortedArray = new int[countOfInputArray];
		int index = 0;
		int element = integers[0]; //Assign element value
		
		for (int count = 0; count < countOfInputArray; count++) {			
			for (int i = 0; i < integers.length; i++) {		
				if (i < integers.length -1) {		
					if (element > integers[i+1]) {
						
						element = integers[i+1];
						index = i + 1;
					} 
				} else {
					sortedArray[count] = element;
					
					//Create a new array to copy values
					int[] newArray = new int[integers.length -1];
					
					if (newArray.length > 0) {				
						if (element == integers[0]) {							
							for (int j = 0; j < newArray.length; j++) {
								newArray[j] = integers[j+1];
							}
						} else {
							for (int j = 0; j < index; j++) {
								newArray[j] = integers[j];
							}
								
							for (int j = index; j < newArray.length; j++) {
								newArray[j] = integers[j+1];
							}
						}
	
						
						integers = new int[newArray.length];
						integers = newArray;	
						
						element = integers[0];
					}
				}
			}
		}		
		return sortedArray;
	}
	
	public static int[] insert(int[] integers, int element) { //Use this method to insert an integer into an integer array
		int countOfInputArray = integers.length;
		int[] insertedArray = new int[countOfInputArray+1];
		int insertAtIndex = -1;
		
		for(int i = 0; i < countOfInputArray; i++) {
			if (element < integers[i]) {
				insertAtIndex = i;
				break;
			} else 
				insertAtIndex = i+1;
		}
			
		for (int i = 0; i < insertAtIndex; i++) 
			insertedArray[i] = integers[i];

		
		insertedArray[insertAtIndex] = element;
		
		for (int i = insertAtIndex + 1; i < countOfInputArray; i++) 
			insertedArray[i] = integers[i-1];
		
		if (insertAtIndex < countOfInputArray)
			insertedArray[countOfInputArray] = integers[countOfInputArray-1];
		else
			insertedArray[countOfInputArray] = element;
		
		return insertedArray;
	}
	
	public static void main(String[] args) {
		int[] intArray = {45, 2, 89, 5, 67, 13};
		int elementToInsert = 55;
		
		// Call sort method first to sort the given integer array
		int[] sortedArray = sort(intArray);
		
		//Print the sorted array
		System.out.print("Input Array: ");
		for (int i = 0; i < intArray.length; i++)
			System.out.print(intArray[i] + " ");
		
		System.out.print("\nSorted Array: ");
		for(int i = 0; i < sortedArray.length; i++) 
			System.out.print(sortedArray[i] + " ");
		
		System.out.print("\nElement to insert: " + elementToInsert);
		// Call insert method next to insert an integer into the sorted integer array
		int[] insertIntoSortedArray = insert(sortedArray, elementToInsert);
		
		//Print the inserted and sorted array
		System.out.print("\nArray after insert: ");
		for(int i = 0; i <insertIntoSortedArray.length; i++) 
			System.out.print(insertIntoSortedArray[i] + " ");
	}
}
