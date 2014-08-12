package workspace.ListInterface.src;

/**
 * An interface for the ADT list.
 * Entries in the list have positions that begin with 1.
 * @author derrick
 * @date July 2014
 */
public interface ListInterface {
	public void add(Object newEntry);
	
	public boolean add(int newPosition, Object newEntry);
	
	public Object remove(int givenPosition);
	
	public void clear();
	
	public boolean replace(int givenPosition, Object newEntry);
	
	public Object getEntry(int givenPosition);
	
	public boolean contains(Object anEntry);
	
	public int getLength();
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public void display();
	
} // end ListInterface
