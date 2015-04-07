package cn.johnson.algorithm.search;

/**
 * 
 * @author Johnson
 *
 *         <p>
 *         Search misses and insertions in an (unordered) linked-list symbol
 *         table having N key-value pairs both require N compares,and search hit
 *         N compares in the worst case.In particular,inserting N empty
 *         linked-list symbol table uses ~N^2/2 compares.
 *         </p>
 *
 */
public class SequentialSearch<Key, Value> {
	private Node first;

	private class Node {
		Key key;
		Value value;
		Node next;

		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}

	public Value get(Key key) {
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				return x.value;// search hist
			}
		}

		return null;// search miss
	}

	public void put(Key key, Value value) {
		// search for key ,update value if found;grow table if new.
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.value = value;// search hit:update value
			}
		}

		first = new Node(key, value, first);// search miss:add node
	}

}
