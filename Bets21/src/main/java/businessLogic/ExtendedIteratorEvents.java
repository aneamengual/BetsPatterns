package businessLogic;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import domain.Event;

public class ExtendedIteratorEvents implements ExtendedIterator<Event>{
	
	private List<Event> it;
	private int pos = -1;
	
	@Override
	public boolean hasNext() {
		if(pos >= it.size()) {
			return false;
		}else {
			return true;}
	}

	@Override
	public Event next() {
		if(!hasNext()) {
			return null;
		}else {
			int actual = pos;
			pos++;
			return it.get(actual);}	
	}

	@Override
	public Event previous() {
		if(!hasPrevious()) {
			return null;
		}else {
			
			Event e= it.get(pos);
			pos--;
			return e;}
	}

	@Override
	public boolean hasPrevious() {
		if(pos<0) {
			return false;
		}
		return true;}

	@Override
	public void goFirst() {
		pos = 0;
		
	}

	@Override
	public void goLast() {
		pos = it.size()-1;
		
	}

	public void setIt(List<Event> it) {
		this.it = it;
	}
	
	
}
