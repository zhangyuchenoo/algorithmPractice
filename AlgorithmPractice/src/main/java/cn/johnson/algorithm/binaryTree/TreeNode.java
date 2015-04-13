package cn.johnson.algorithm.binaryTree;

public class TreeNode<T> {
	private TreeNode<T> lefNode;
	private TreeNode<T> rightNode;

	private T data;

	public TreeNode() {

	}

	public TreeNode(T data) {
		this.data = data;
	}

	public TreeNode<T> getLefNode() {
		return lefNode;
	}

	public void setLefNode(TreeNode<T> lefNode) {
		this.lefNode = lefNode;
	}

	public TreeNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
