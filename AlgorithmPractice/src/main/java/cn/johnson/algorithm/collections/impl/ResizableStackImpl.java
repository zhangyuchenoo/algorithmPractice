package cn.johnson.algorithm.collections.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import cn.johnson.algorithm.collections.ResizableStack;

@SuppressWarnings("unchecked")
public class ResizableStackImpl<Item> implements ResizableStack<Item>,
		Iterable<Item> {

	private int size;
	private Item[] items;

	public ResizableStackImpl() {
		items = (Item[]) new Object[100];
	}

	public ResizableStackImpl(int capacity) {
		items = (Item[]) new Object[capacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void push(Item item) {
		if (size == items.length - 1) {
			resize(items.length * 2);
		}
		items[size++] = item;
	}

	@Override
	public Item pop() {

		if (size > 0 && size == items.length / 4) {
			resize(items.length / 2);
		}

		Item item = items[--size];
		items[size] = null;// release reference

		return item;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void resize(int capacity) {
		System.out.println("changing stack size  from " + items.length + " to "
				+ capacity);
		Item[] items_ = (Item[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			items_[i] = items[i];
		}
		items = items_;

	}

	@Override
	public Iterator<Item> iterator() {

		Iterator<Item> iterator = new Iterator<Item>() {

			private int index = size;

			@Override
			public boolean hasNext() {
				return index > 0;
			}

			@Override
			public Item next() {

				if (!hasNext()) {
					throw new NoSuchElementException();
				}

				return items[--index];
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
			}
		};

		return iterator;
	}

}
