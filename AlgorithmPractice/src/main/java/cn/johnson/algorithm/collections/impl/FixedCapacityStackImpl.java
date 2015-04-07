package cn.johnson.algorithm.collections.impl;

import cn.johnson.algorithm.collections.FixedCapacityStack;

/**
 * 
 * @author Johnson
 *
 * @param <Item>
 */

@SuppressWarnings("unchecked")
public class FixedCapacityStackImpl<Item> implements FixedCapacityStack<Item> {

	private Item[] elements;

	private int size;

	public FixedCapacityStackImpl(int size) {

		elements = (Item[]) new Object[size];
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void push(Item item) {
		elements[size++] = item;
	}

	@Override
	public Item pop() {
		return elements[--size];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
