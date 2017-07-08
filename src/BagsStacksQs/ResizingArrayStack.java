/**
 * Algorithm 1.1
 * 
 * Pushdown (LIFO) stack (resizing array implementation)
 */

package BagsStacksQs;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
	private Item[] s = (Item[]) new Object[1];
	private int N;
	
	public int size() { return N; }
	public boolean isEmpty() { return N == 0; }
	
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < s.length; i++) {
			temp[i] = s[i];
		}
		s = temp;
	}
	
	public void push(Item item) {
		if (N == s.length) resize(2 * s.length);
		s[N++] = item;
	}
	
	public Item pop() {
		Item item = s[--N];
		s[N] = null;
		if (N > 0 && N == s.length / 4) 
			resize(s.length/2);
		return item;	
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {
		int i = N;
		
		@Override
		public boolean hasNext() {
			return N > 0;
		}

		@Override
		public Item next() {
			return s[--i];
		}
		
		public void remove() {}
	}
}
