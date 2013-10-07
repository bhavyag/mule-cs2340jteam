import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * CS 1332 Fall 2013
 * Binary Search Tree
 * 
 * In this assignment, you will be coding methods to make a functional
 * binary search tree. If you do this right, you will save a lot of time
 * in the next two assignments (since they are just augmenting the BST to 
 * make it efficient). Let's get started!
 * 
 * **************************NOTE************************
 * YOU WILL HAVE TO HANDLE NULL DATA IN THIS ASSIGNMENT!!
 * PLEASE TREAT NULL AS POSITIVE INFINITY!!!!
 * **************************NOTE************************
 * 
 * DO NOT CHANGE ANY OF THE PUBLIC METHOD HEADERS
 * 
 * Please make any extra inner classes, instance fields, and methods private
 */

public class BST<T extends Comparable<T>> {
	
	private Node<T> root;
	private int size;
	private ArrayList<T> list;

	/**
	 * Add data to the binary search tree. Remember to adhere to the BST Invariant:
	 * All data to the left of a node must be smaller and all data to the right of
	 * a node must be larger. Don't forget to update the size. 
	 * 
	 * For this method, you will need to traverse the tree and find the appropriate
	 * location of the data. Depending on the data's value, you will either explore
	 * the right subtree or the left subtree. When you reach a dead end (you have 
	 * reached a null value), simply return a new node with the data that was passed
	 * in.
	 * 
	 * PLEASE TREAT NULL DATA AS POSITIVE INFINITY!!!!
	 * 
	 * @param data A comparable object to be added to the tree.
	 */
	public void add(T data) 
	{
		Node<T> newNode = new Node<T>(data);
		
		if(root == null)
		{
			this.root = newNode;
			this.size++;
			return;
		}
		
		Node<T> current = root;
		boolean isAdded = false;
		while(isAdded != true)
		{
			T currentData = current.getData();
            if(currentData == null)
            {
                if(current.getLeft() == null)
                {
                    current.setLeft(newNode);
                    this.size++;
                    isAdded = true;
                    return;
                }
                current = current.getLeft();
            }
            else if(data == null)
            {
                if(current.getRight() == null)
                {
                    current.setRight(newNode);
                    this.size++;
                    isAdded = true;
                    return;
                }
                current = current.getRight();
            }
			else if( data.compareTo(currentData) < 0)
			{
				if(current.getLeft() == null)
				{
					current.setLeft(newNode);
					this.size++;
					isAdded = true;
					return;
				}
				current = current.getLeft();
			}
			
			else if(data.compareTo(currentData) > 0 )
			{
				if(current.getRight() == null)
				{
					current.setRight(newNode);
					this.size++;
					isAdded = true;
					return;
				}
				current = current.getRight();
			}
		}
	}
	
	/**
	 * Add the contents of the collection to the BST. To do this method, notice that
	 * most every collection in the java collections API implements the iterable 
	 * interface. This means that you can iterate through every element in these 
	 * structures with a for-each loop. Don't forget to update the size.
	 * 
	 * @param c A collection of data to be added to the tree.
	 */
	public void addAll(Collection<? extends T> c) 
	{
		for( T t : c)
		{
			this.add(t);
		}
	}
	
	/**
	 * Remove the data element from the tree. 
	 * 
	 * There are three cases you have to deal with:
	 * 1. The node to remove has no children
	 * 2. The node to remove has one child
	 * 2. The node to remove has two children
	 * 
	 * In the first case, return null. In the second case, return the non-null 
	 * child. The third case is where things get interesting. Here, you have two 
	 * you will have to find the successor or predecessor and then copy their data 
	 * into the node you want to remove. You will also have to fix the successor's
	 * or predecessor's children if necessary. Don't forget to update the size.
	 *  
	 * PLEASE TREAT NULL DATA AS POSITIVE INFINITY!
	 *  
	 * @param data The data element to be searched for.
	 * @return retData The data that was removed from the tree. Return null if the
	 * data doesn't exist.
	 */
	public T remove(T data) 
	{
		//if the list is already empty
		if(!this.contains(data))
		{
			return null;
		}

		Node<T> current = this.getNode(data);

        //if the node to remove is the head
        if(current.equals(this.root))
        {
            //if the node we want to remove has no left or right
            if(current.getLeft() == null && current.getRight() == null)
            {
                this.clear();
                this.size =0;
                return data;
            }

            //if the node we want to remove has only a right
            else if(current.getLeft() == null && current.getRight() != null)
            {
                this.root = current.getRight();
                this.size--;
                return data;
            }

            //if the node we want to remove has only a left
            else if(current.getLeft() != null && current.getRight() == null)
            {
                this.root = current.getLeft();
                this.size--;
                return data;
            }

            //if the node we want to remove has both a left and a right
            Node<T> replacement = this.getClosestLeft(current.getLeft());
            T replaceData = replacement.getData();
            this.remove(replacement.getData());
            current.setData(replaceData);
            this.size--;
            return data;
        }

        Node<T> prev = this.getPrev(data);

		//if the node we want to remove has no left or right
		if(current.getLeft() == null && current.getRight() == null)
		{   //the node is on the left of prev
            if(current.equals(prev.getLeft()))
            {
                prev.setLeft(null);
            }
            //the node is on the right of prev
            else if(current.equals(prev.getRight()))
            {
                prev.setLeft(null);
            }
            this.size--;
			return data;
		}

		//if the node we want to remove has only a right
		if(current.getLeft() == null && current.getRight() != null)
		{
			Node<T> right = current.getRight();
            current.setData(right.getData());
            current.setLeft(right.getLeft());
            current.setRight(right.getRight());
            this.size--;
			return data;
		}

		//if the node we want to remove has only a left
		if(current.getLeft() != null && current.getRight() == null)
		{
            Node<T> left = current.getLeft();
            current.setData(left.getData());
            current.setLeft(left.getLeft());
            current.setRight(left.getRight());
            this.size--;
            return data;
		}

		//if the node we want to remove has both a left and a right
		Node<T> replacement = this.getClosestLeft(current.getLeft());
        T replaceData = replacement.getData();
		this.remove(replacement.getData());
        current.setData(replaceData);
		this.size--;
		return data;
		
	}
	
	/**
	 * Get the data from the tree.
	 * 
	 * This method simply returns the data that was stored in the tree.
	 * 
	 * TREAT NULL DATA AS POSITIVE INFINITY!
	 * 
	 * @param data The datum to search for in the tree.
	 * @return The data that was found in the tree. Return null if the data doesn't
	 * exist.
	 */
	public T get(T data) 
	{
		boolean isFound = false;
		Node<T> current = root;
		while(isFound != true)
		{	T currentData = current.getData();
			if(data.compareTo(currentData) == 0)
			{
				isFound = true;
				return currentData;
			}
			else if(data.compareTo(currentData) < 0)
			{
				if(current.getLeft() == null)
				{
					isFound = true;
					return null;
				}
				current = current.getLeft();
			}
			else if(data.compareTo(currentData) > 0)
			{
				if(current.getRight() == null)
				{
					isFound = true;
					return null;
				}
				current = current.getRight();
			}
		}
		
		return null;
	}
	
	/**
	 * See if the tree contains the data.
	 * 
	 * TREAT NULL DATA AS POSITIVE INFINITY!
	 * 
	 * @param data The data to search for in the tree.
	 * @return Return true if the data is in the tree, false otherwise.
	 */
	public boolean contains(T data) 
	{
		boolean isFound = false;
		Node<T> current = root;
		while(isFound != true)
		{
			T currentData = current.getData();

            if(currentData == null)
            {
                if(current.getLeft() == null)
                {
                    isFound = true;
                    return false;
                }
                current = current.getLeft();
            }

            else if(data == null)
            {
                if(current.getRight() == null)
                {
                    isFound = true;
                    return false;
                }
                current = current.getRight();
            }

			else if(data.compareTo(currentData) == 0)
			{
				isFound = true;
				return true;
			}
			else if(data.compareTo(currentData) < 0)
			{
				if(current.getLeft() == null)
				{
					isFound = true;
					return false;
				}
				current = current.getLeft();
			}
			else if(data.compareTo(currentData) > 0)
			{
				if(current.getRight() == null)
				{
					isFound = true;
					return false;
				}
				current = current.getRight();
			}
		}
		return false;
	}
	
	/**
	 * Linearize the tree using the pre-order traversal.
	 * 
	 * @return A list that contains every element in pre-order.
	 */
	public List<T> preOrder() 
	{
		list= new ArrayList<T>();
		this.preOrderHelp(root);
		return list;
	}
	
	/**
	 * Linearize the tree using the in-order traversal.
	 * 
	 * @return A list that contains every element in-order.
	 */
	public List<T> inOrder() 
	{
		list= new ArrayList<T>();
		this.inOrderHelp(root);
		return list;
	}
	
	/**
	 * Linearize the tree using the post-order traversal.
	 * 
	 * @return A list that contains every element in post-order.
	 */
	public List<T> postOrder() 
	{
		list= new ArrayList<T>();
		this.postOrderHelp(root);
		return list;
	}
	
	/**
	 * Test to see if the tree is empty.
	 * 
	 * @return Return true if the tree is empty, false otherwise.
	 */
	public boolean isEmpty() 
	{
		return (root == null);
	}
	
	/**
	 * 
	 * @return Return the number of elements in the tree.
	 */
	public int size() 
	{
		return this.size;
	}
	
	/**
	 * Clear the tree. (ie. set root to null and size to 0)
	 */
	public void clear() 
	{
		this.root = null;
		this.size = 0;
	}
	
	/**
	 * Clear the existing tree, and rebuilds a unique binary search tree 
	 * with the pre-order and post-order traversals that are passed in.
	 * Draw a tree out on paper and generate the appropriate traversals.
	 * See if you can manipulate these lists to generate the same tree.
	 * 
	 * TL;DR - at the end of this method, the tree better have the same
	 * pre-order and post-order as what was passed in.
	 * 
	 * @param preOrder A list containing the data in a pre-order linearization.
	 * @param postOrder A list containing the data in a post-order linearization.
	 */
	public void reconstruct(List<? extends T> preOrder, List<? extends T> postOrder) 
	{
        int mySize = preOrder.size();
        this.clear();
        int preIndex = 0;
        this.root = this.reconstructHelper(preOrder, postOrder, preIndex, 0, this.size - 1, mySize);
	}

    private Node<T> reconstructHelper(List<? extends T> preOrder, List<? extends T> postOrder,int preCounter,int postLow, int postHigh, int size)
    {
        if (preCounter >= size || postLow > postHigh)
        {
            return null;
        }

        Node<T> newNode = new Node<T>( preOrder.get(preCounter));
        ++preCounter;

        if (postLow == postHigh)
        {
            return newNode;
        }

        int i;
        for ( i = postLow; i <= postHigh; ++i)
        {
            if (preOrder.get(preCounter).equals(postOrder.get(i)))
            {
                break;
            }
        }

        if (i <= postHigh)
        {
            newNode.setLeft(reconstructHelper(preOrder, postOrder, preCounter, postLow, i, size));
            newNode.setRight(reconstructHelper(preOrder, postOrder, preCounter, i + 1, postHigh - 1, size));
        }

        return newNode;
    }
	
	private Node<T> getClosestLeft (Node<T> node)
    {
        Node<T> current = node;

        while(current.getRight() != null)
        {
            current = current.getRight();
        }

        return current;
    }
	
	private Node<T> getNode (T data) 
	{
		boolean isFound = false;
		Node<T> current = root;
		while(isFound != true)
		{	T currentData = current.getData();

            if(currentData == null)
            {
                if(current.getLeft() == null)
                {
                    isFound = true;
                    return null;
                }
                current = current.getLeft();
            }

            if(data == null)
            {
                if(current.getRight() == null)
                {
                    isFound = true;
                    return null;
                }
                current = current.getRight();
            }

			else if(data.compareTo(currentData) == 0)
			{
				isFound = true;
				return current;
			}
			else if(data.compareTo(currentData) < 0)
			{
				if(current.getLeft() == null)
				{
					isFound = true;
					return null;
				}
				current = current.getLeft();
			}
			else if(data.compareTo(currentData) > 0)
			{
				if(current.getRight() == null)
				{
					isFound = true;
					return null;
				}
				current = current.getRight();
			}
		}
		
		return null;
	}

    private Node<T> getPrev(T data)
    {
        boolean isFound = false;
        Node<T> prev = null;
        Node<T> current = root;
        while(isFound != true)
        {	T currentData = current.getData();
            if(data.compareTo(currentData) == 0)
            {
                isFound = true;
                return prev;
            }
            else if(data.compareTo(currentData) < 0)
            {
                if(current.getLeft() == null)
                {
                    isFound = true;
                    return null;
                }
                prev = current;
                current = current.getLeft();
            }
            else if(data.compareTo(currentData) > 0)
            {
                if(current.getRight() == null)
                {
                    isFound = true;
                    return null;
                }
                prev = current;
                current = current.getRight();
            }
        }
        return null;
    }
	
	private void preOrderHelp(Node<T> node)
	{
		if(node == null)
		{
			return;
		}
		
		list.add(node.getData());
		preOrderHelp(node.getLeft());
		preOrderHelp(node.getRight());
	}
	
	private void inOrderHelp(Node<T> node)
	{
		if(node == null)
		{
			return;
		}
		
		inOrderHelp(node.getLeft());
		list.add(node.getData());
		inOrderHelp(node.getRight());
	}
	
	private void postOrderHelp(Node<T> node)
	{
		if(node == null)
		{
			return;
		}
		
		postOrderHelp(node.getLeft());
		postOrderHelp(node.getRight());
		list.add(node.getData());
	}
	
	private void printList(List<T> list)
	{
		for(T t : list)
		{
			System.out.println(t);
		}
	}
	
	public void setRoot(Node<T> node) {
			root = node;
		}
		
		public Node<T> getRoot() {
			return root;
		}
		
		public void setSize(int i) {
			size = i;
		}
}
