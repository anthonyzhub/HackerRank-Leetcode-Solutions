// https://leetcode.com/problems/peeking-iterator/

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    // Declare class variables
    Iterator<Integer> it = null;
    boolean isPeakNull;
    Integer tmpPeek = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
        this.isPeakNull = true;
        this.tmpPeek = 0;
        
        // Update tmpPeek to current peek element
        if (it.hasNext()) {
            tmpPeek = it.next();
            isPeakNull = false;
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return tmpPeek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    
        // Copy old peek element
        if (isPeakNull == true) {return null;}
        int oldPeek = tmpPeek;
        
        // If there are more elements inside of array, update tmpPeek
        if (it.hasNext()) {
            tmpPeek = it.next();
        }
        else {
            isPeakNull = true;
        }
        
        // Return old peek
        return oldPeek;
	}
	
	@Override
	public boolean hasNext() {
	    
        // If tmpPeek isn't null, then there are more elements inside the array
        if (isPeakNull == true) {return false;}
        return true;
	}
}
