/**
 * Pushdown Stack (linked-list implementation)
 */

package BagsStacksQs;

import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private int N;
	private Node first;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public int size() { return N; }
	public boolean isEmpty() { return first == null; }
	
	public Item pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public Item peek() {
		Item item = first.item;
		return item;
	}
	
	private class StackIterator implements Iterator<Item> {
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}	
	}

	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
}
