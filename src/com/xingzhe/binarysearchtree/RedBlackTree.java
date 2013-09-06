package com.xingzhe.binarysearchtree;

public class RedBlackTree extends BinarySearchTree {
	public final TreeNode NIL = new TreeNode();
	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	// 左旋操作
	public void left_rotate(TreeNode x) {
		TreeNode y = (TreeNode) x.getRightChild();
		x.setRightChild(y.getLeftChild());
		if (y.getLeftChild() != this.NIL)
			y.getLeftChild().setParent(x);
		y.setParent(x.getParent());
		if (x.getParent() == this.NIL)
			this.root = y;
		else if (x == x.getParent().getLeftChild())
			x.getParent().setLeftChild(y);
		else
			x.getParent().setRightChild(y);
		y.setLeftChild(x);
		x.setParent(y);
	}

	// 右旋操作
	public void right_rotate(TreeNode y) {
		TreeNode x = (TreeNode) y.getLeftChild();
		y.setLeftChild(x.getRightChild());
		if (x.getRightChild() != this.NIL)
			x.getRightChild().setParent(y);
		x.setParent(y.getParent());
		if (y.getParent() == this.NIL)
			this.root = x;
		else if (y == y.getParent().getLeftChild())
			y.getParent().setLeftChild(x);
		else
			y.getParent().setRightChild(x);
		x.setRightChild(y);
		y.setParent(x);
	}

	// 插入操作
	public void tree_insert(TreeNode z) {
		TreeNode y = this.NIL;
		TreeNode x = this.root;
		while (x != this.NIL) {
			y = x;
			if (z.getElement() < x.getElement())
				x = (TreeNode) x.getLeftChild();
			else
				x = (TreeNode) x.getRightChild();
		}
		z.setParent(y);
		if (y == this.NIL)
			this.root = z;
		else if (z.getElement() < y.getElement())
			y.setLeftChild(z);
		else
			y.setLeftChild(z);
		z.setLeftChild(this.NIL);
		z.setRightChild(NIL);
		z.setColor(Color.RED);
		rb_insert_fixup(z);
	}

	// 插入操作后的修正
	private void rb_insert_fixup(TreeNode z) {
		while (((TreeNode) z.getParent()).color == Color.RED) {
			if (z.getParent() == z.getParent().getParent().getLeftChild()) {
				TreeNode y = (TreeNode) z.getParent().getParent().getRightChild();
				if (y.color == Color.RED) {
					((TreeNode) z.getParent()).color = Color.BLACK;
					y.color = Color.BLACK;
					((TreeNode) y.getParent().getParent()).color = Color.RED;
					z = (TreeNode) z.getParent().getParent();
				} else if (z == z.getParent().getRightChild()) {
					z = (TreeNode) z.getParent();
					left_rotate(z);
				}
				((TreeNode) z.getParent()).color = Color.BLACK;
				((TreeNode) z.getParent().getParent()).color = Color.RED;
				right_rotate((TreeNode) z.getParent().getParent());
			} else {// TODO
				
			}
		}
	}

	class TreeNode extends BinarySearchTree.TreeNode {
		private Color color;

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}
	}

	enum Color {
		RED, BLACK
	}

	public static void main(String[] args) {
		RedBlackTree rbt = new RedBlackTree();

		TreeNode n = rbt.new TreeNode();
		n.setColor(Color.BLACK);

		rbt.tree_insert(n);
		rbt.inorder_tree_walk();
	}

}
