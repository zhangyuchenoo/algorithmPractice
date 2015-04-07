package cn.johnson.algorithm.test;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import org.junit.Test;

import cn.johnson.algorithm.collections.impl.FixedCapacityStackImpl;
import cn.johnson.algorithm.collections.impl.ResizableStackImpl;
import cn.johnson.algorithm.stdlib.StdIn;
import cn.johnson.algorithm.stdlib.StdOut;

public class TestClient {

	@Test
	public void testFixedCapacityStack() {
		FixedCapacityStackImpl<String> s = new FixedCapacityStackImpl<String>(
				100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}

	@Test
	public void testResizableStack() {

		ResizableStackImpl<String> s = new ResizableStackImpl<String>(2);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
	}

	@Test
	public void testIterableStack() {
		ResizableStackImpl<String> s = new ResizableStackImpl<String>(2);

		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if ("iter_".equals(item)) {
				for (String element : s) {
					System.out.print(element + " ");
				}
			} else if (!item.equals("-")) {
				s.push(item);
			} else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
	}

	@Test
	public void testAsm() {
		Short short1 = 99;
		char c = 'C';
	}

	@Test
	public void testClassLoader() {
	}

	public static void main(String[] args) {
		String[] array = { "1", "2", "3" };
		listAll(Arrays.asList(array), "");
	}

	private static void listAll(List<String> asList, String prefix) {
		if (asList.isEmpty())
			System.out.println(prefix);

		for (int i = 0; i < asList.size(); i++) {
			List<String> temp = new LinkedList<String>(asList);

			listAll(temp, prefix + temp.remove(i));
		}
	}
}
