package cn.johnson.algorithm.collections;

/**
 * 
 * @author Johnson
 *
 * @param <Item>
 */

public interface Stack<Item> {

	public int size();

	public void push(Item item);

	public Item pop();

	public boolean isEmpty();
}
