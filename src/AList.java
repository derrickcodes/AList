/**
 * // Length of zero is empty, therefore the list starts at 1 (one).
 * @author derrick
 *
 */
public class AList implements ListInterface{
	private Object[] items;			// array of list entries
	private int numItems;			// current number of entries in list
	private static final int INIT_SIZE = 50;	// max length of list
	
	public AList()
	{
		numItems = 0;
		items = new Object[INIT_SIZE];
	} // end default constructor
	
	public AList(int maxSize)
	{
		numItems = 0;
		items = new Object [maxSize];
	} // end constructor
	
	public boolean add(Object ob) {
		boolean isSuccessful = true;
		
		/**
		 * if array is full, get new array of double size,
		 * and copy items from old array to new array
		 */
	    if (isFull()) 
	    {
	    	expandArray();
	    } 
	    else if (!isFull())
	    {
	    	// add new item; update numItems
	    	items[numItems] = ob;
	    	numItems++;	    	
	    }
	    else
	    	isSuccessful = false;
	    
	    return isSuccessful;	    	
	} // end add
	
	
	public boolean add(int givenPosition, Object ob) {
		
		boolean isSuccessful = true;
		
	    if (!isFull() && (givenPosition >= 1) && (givenPosition <= numItems +1))
	    {
	    	makeRoom(givenPosition);
	    	items[givenPosition -1] = ob;
	    	numItems++;
	    }
	    else if (isFull())
	    {
	    	expandArray();
	    }
	    else
	    	isSuccessful = false;
	    
	    return isSuccessful;
	} // end add
	
	public Object remove(int givenPosition)
	{
		Object result = null;		// return value
		if ((givenPosition >= 1) && (givenPosition <= numItems))
		{
			result = items[givenPosition - 1];  // get entry to be removed
			
			// move subsequent entries toward entry to be removed
			// unless it is last in the list
			if (givenPosition < numItems) 
			{
				removeGap(givenPosition);
			}
			numItems--;			
		} // end if
		return result;	// return reference to removed entry or null if invalid
	} // end remove
	
	public void clear()
	{
		for (int index = 0; index < numItems; index++)
		{
			items[index] = null;
		}
	} // end clear
	
	public boolean replace(int givenPosition, Object newEntry)
	{
		boolean isSuccessful = true;
		
		if ((givenPosition >= 1) && (givenPosition <= numItems))
		{
			items[givenPosition -1] = newEntry;
		}
		else
		{
			isSuccessful = false;
		}
		
		return isSuccessful;
	} // end replace
	
	public Object getEntry(int givenPosition)
	{
		Object result = null;		// result to return
		
		if ((givenPosition >= 1) && (givenPosition <= numItems))
		{
			result = items[givenPosition - 1];
		}
		
		return result;
	} // end getEntry
	
	public boolean contains(Object anEntry)
	{
		boolean found = false;
		
		for (int index = 0; !found && (index < numItems); index++)
		{
			if (anEntry.equals(items[index]))
			{
				found = true;
			} // end if
		} // end for
		
		return found;
	} // end contains
	
	public int getLength()
	{
		return numItems;
	} // end getLength
	
	/**
	 * // Length of zero is empty, therefore the list starts at 1 (one).
	 */
	public boolean isEmpty()
	{
		return numItems == 0;
	} // end isEmpty
	
	public boolean isFull()
	{
		return numItems == items.length;
	} // end isFull
	
	public void display()
	{
		for (int index = 0; index < numItems; index++)
		{
			System.out.println(items[index]);
		}
			System.out.println();
	} // end display
	
	private void expandArray() {
	    Object[] newArray = new Object[numItems*2];
	    for (int k=0; k<numItems; k++) {
	        newArray[k] = items[k];
	    }
	    items = newArray;
	} // end expandArray
	
	private void makeRoom(int givenPosition) 
	{
		for (int index = numItems; index >= givenPosition; index--)
		{
			items[index] = items[index-1];
		}
	}
	
	private void removeGap(int givenPosition)
	{
		for (int index = givenPosition; index < numItems; index++)
		{
			items[index-1] = items[index];
		}
	} // end removeGap
	
	public static void main(String args[]) {
		AList mylist = new AList(6);
		mylist.add("apple");
		mylist.add("pear");
		mylist.add("banana");
		mylist.add("strawberry");
		mylist.add("blueberry");
		mylist.display();
		mylist.add(3, "melon");
		mylist.display();
	}
	
} // end AList