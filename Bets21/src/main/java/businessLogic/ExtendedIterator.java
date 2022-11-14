package businessLogic;

import java.util.Iterator;
import java.util.List;

import domain.Event;

public interface ExtendedIterator<Object> extends Iterator<Object> {
	// return the actual element and go to the previous
	public Object previous();

	// true if ther is a previous element
	public boolean hasPrevious();

	// It is placed in the first element
	public void goFirst();

	// It is placed in the last element
	public void goLast();

	public void setIt(List<Event> it);
}
