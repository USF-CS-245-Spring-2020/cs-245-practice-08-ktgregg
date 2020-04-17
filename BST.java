public class BST<T extends Comparable>
{
	// root node
	private BSTNode rootNode;

	// constructor
	public BST()
	{
		rootNode = null;
	}

	// find. returns true if found, false otherwise
	public boolean find(T item)
	{
		return find(rootNode, item);
	}

	private boolean find(BSTNode node, T data)
	{
		if(node == null)
		{
			return false;
		}
		if(data.compareTo(node.data) == 0)
		{
			return true;
		}
		else if(data.compareTo(node.data) < 0)
		{
			return find(node.left, data);
		}
		else
		{
			return find(node.right, data);
		}
	}

	// inserts a node
	public void insert(T item)
	{
		rootNode = insert(rootNode, item);
	}

	// returns a node thats been inserted
	private BSTNode insert(BSTNode node, T item)
	{
		if(node == null)
		{
			return new BSTNode(item);
		}
		if(item.compareTo(node.data) < 0)
		{
			node.left = insert(node.left, item);
		}
		else
		{
			node.right = insert(node.right, item);
		}
		return node;
	}

	// prints BST data
	public void print()
	{
		print(rootNode);
	}

	// prints BST data in sorted order, separating each value with a comma and space to easily see the different data
	private void print(BSTNode node)
	{
		if(node != null)
		{
			print(node.left);
			System.out.print(node.data + ", ");
			print(node.right);
		}
	}

	// deleles a node
	public void delete(T item)
	{
		rootNode = delete(rootNode, item);
	}

	// returns the node thats deleted
	private BSTNode delete(BSTNode node, T item)
	{
		if(node == null)
		{
			return null;
		}
		if(node.data.compareTo(item) < 0)
		{
			node.right = delete(node.right, item);
		}
		else if (node.data.compareTo(item) > 0)
		{
			node.left = delete(node.left, item);
		}
		else
		{
			if(node.left == null)
			{
				return node.right;
			}
			else if(node.right == null)
			{
				return node.left;
			}
			else
			{
				if(node.right.left == null)
				{
					node.data = node.right.data;
					node.right = node.right.right;
				}
				else if (node.left.right == null)
				{
					node.data = node.left.data;
					node.left = node.left.left;
				}
			}
		}
		return node;
	}

	// BSTNode class
	class BSTNode<T extends Comparable>
	{
		// data
		private T data;
		// left and right nodes
		private BSTNode left;
		private BSTNode right;

		// constructor to make new nodes
		public BSTNode(T data)
		{
			this.data = data;
			this.right = null;
			this.left = null;
		}
	}
}

