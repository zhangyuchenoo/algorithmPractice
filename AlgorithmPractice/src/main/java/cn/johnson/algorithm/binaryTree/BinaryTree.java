package cn.johnson.algorithm.binaryTree;

import cn.johnson.algorithm.collections.Stack;
import cn.johnson.algorithm.collections.impl.ResizableStackImpl;

public class BinaryTree<T> {
	private TreeNode<T> rootNode;
	private int nodeCount;
	private int level;

	public TreeNode<T> getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode<T> rootNode) {
		this.rootNode = rootNode;
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@SuppressWarnings("unchecked")
	public void addNode(TreeNode<T> node) {
		if (rootNode == null) {
			rootNode = node;
			return;
		}
		TreeNode<T> current = rootNode;
		TreeNode<T> lastNode = rootNode;
		int larger = 0;
		while (current != null) {
			Comparable<T> dataToBeComparaed = (Comparable<T>) current.getData();
			larger = dataToBeComparaed.compareTo((T) node.getData());
			lastNode = current;
			if (larger <= 0) {
				current = current.getRightNode();
			} else {
				current = current.getLefNode();
			}
		}

		if (larger <= 0) {
			lastNode.setRightNode(node);
		} else {
			lastNode.setLefNode(node);
		}

	}

	public void preOrderTraverse(TreeNode<T> root) {
		if (root != null) {
			System.out.print(root.getData());
			preOrderTraverse(root.getLefNode());
			preOrderTraverse(root.getRightNode());
		}
	}

	public void middleOrderTraverse(TreeNode<T> root) {
		if (root != null) {
			middleOrderTraverse(root.getLefNode());
			System.out.print(root.getData());
			middleOrderTraverse(root.getRightNode());
		}

	}

	public void afterOrderTraverse(TreeNode<T> root) {
		if (root != null) {
			afterOrderTraverse(root.getLefNode());
			afterOrderTraverse(root.getRightNode());
			System.out.print(root.getData());
		}
	}

	public void preOrderTraverseWithStack(TreeNode<T> root) {

		Stack<TreeNode<T>> stack = new ResizableStackImpl<TreeNode<T>>();

		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				System.out.print(root.getData());
				stack.push(root);
				root = root.getLefNode();
			}
			
			root = stack.pop();
			root = root.getRightNode();
		}


	}
	public void postOrderTraverseWithStack(TreeNode<T> root) {
		
		Stack<TreeNode<T>> stack = new ResizableStackImpl<TreeNode<T>>();
		Stack<TreeNode<T>> stack2 = new ResizableStackImpl<TreeNode<T>>();
		stack.push(root);
		
		TreeNode<T> node=null;
		while (!stack.isEmpty()) {
			node=stack.pop();
			stack2.push(node);
			if(null!=node.getLefNode()){
				stack.push(node.getLefNode());
			}
			if(null!=node.getRightNode()){
				stack.push(node.getRightNode());
			}
		}
		
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().getData());
		}
	}

	public void middleOrderTraverseWithStack(TreeNode<T> root) {
		Stack<TreeNode<T>> stack = new ResizableStackImpl<TreeNode<T>>();

		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.getLefNode();
			}

			root = stack.pop();
			System.out.print(root.getData());
			root = root.getRightNode();
		}

	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();

		tree.addNode(new TreeNode<Integer>(4));
		tree.addNode(new TreeNode<Integer>(5));
		tree.addNode(new TreeNode<Integer>(5));
		tree.addNode(new TreeNode<Integer>(2));
		tree.addNode(new TreeNode<Integer>(3));
		tree.addNode(new TreeNode<Integer>(1));
		tree.addNode(new TreeNode<Integer>(6));

		tree.preOrderTraverse(tree.getRootNode());
		System.out.println();
		tree.middleOrderTraverse(tree.getRootNode());
		System.out.println();
		tree.afterOrderTraverse(tree.getRootNode());
		System.out.println();
		tree.preOrderTraverseWithStack(tree.getRootNode());
		System.out.println("----");
		tree.middleOrderTraverseWithStack(tree.getRootNode());
		System.out.println("------");
		tree.postOrderTraverseWithStack(tree.getRootNode());
	}
}
