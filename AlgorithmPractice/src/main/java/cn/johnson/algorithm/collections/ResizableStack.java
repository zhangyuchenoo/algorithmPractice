package cn.johnson.algorithm.collections;

public interface ResizableStack<Item> extends Stack<Item> {

	public void resize(int capacity);
}
