import java.util.ArrayList;
import java.util.Collection;

/**
 * CS 1332 Fall 2013
 * AVL Tree
 * 
 * In this class, you will program an AVL Tree (Adelson Veskii-Landis Tree).
 * This is like a better version of a binary search tree in that it 
 * tries to fill out every level of the tree as much as possible. It
 * accomplishes this by keeping track of each node's height and balance
 * factor. As you recurse back up from operations that modify the tree
 * (like add or remove), you will update the height and balance factor
 * of the current node, and perform a rotation on the current node if 
 * necessary. Keeping this in mind, let's get started!
 * 
 * **************************NOTE*************************************
 * please please please  treat null as positive infinity!!!!!!!!
 * PLEASE TREAT NULL AS POSITIVE INFINITY!!!!
 * *************************NOTE**************************************
 * 
 * I STRONLY RECOMMEND THAT YOU IMPLEMENT THIS DATA STRUCTURE RECURSIVELY!
 * 
 * Please make any new internal classes, instance data, and methods private!!
 * 
 * DO NOT CHANGE ANY OF THE PUBLIC METHOD HEADERS
 */
public class AVL<T extends Comparable<T>>
{
	
	private AVLNode<T> root;
	private int size;
	private ArrayList<T> dataList;
	private ArrayList<Integer> heightList;
    private ArrayList<Integer> balanceList;
	
	/**
	 * I promise you, this is just like the add() method you coded
	 * in the BST part of the homework! You will start off at the
	 * root and find the proper place to add the data. As you 
	 * recurse back up the tree, you will have to update the
	 * heights and balance factors of each node that you visited
	 * while reaching the proper place to add your data. Immediately
	 * before you return out of each recursive step, you should update
	 * the height and balance factor of the current node and then
	 * call rotate on the current node. You will then return the node
	 * that comes from the rotate(). This way, the re-balanced subtrees
	 * will properly be added back to the whole tree. Also, don't forget
	 * to update the size of the tree as a whole.
	 * 
	 * PLEASE TREAT NULL AS POSITIVE INFINITY!!!!
	 * 
	 * @param data The data do be added to the tree.
	 */
	public void add(T data) 
	{
		AVLNode<T> newNode = new AVLNode<T>(data);
		if(root == null)
		{   //Make this the root
			root = newNode;
			size++;
			this.updateHeightAndBF(root);
			return;
		}
		AVLNode<T> current = root;
		boolean isAdded = false;

        //iterate through until you find an empty place to put the data
		while(isAdded != true)
		{
			T currentData = current.getData();
			if(data.compareTo(currentData) < 0)
			{
				if(current.getLeft() == null)
				{   //add to the left of the current node
					current.setLeft(newNode);
					size++;
					isAdded = true;
					this.updateHeightAndBF(root);
                    this.rotateAll(root);
					return;
				}
				current = current.getLeft();
			}
			
			else if(data.compareTo(currentData) > 0)
			{
				if(current.getRight() == null)
				{
					current.setRight(newNode);
					size++;
					isAdded = true;
					this.updateHeightAndBF(root);
                    this.rotateAll(root);
					return;
				}
				current = current.getRight();
			}
		}
        //Remember, when you call rotate, send in node.NEXT so that you can set what it returns as the NEXT of node
        //(you need to save a reference to the parent)
	}
	
	/**
	 * This is a pretty simple method. All you need to do is to get
	 * every element in the collection that is passed in into the tree.
	 * 
	 * Try to think about how you can combine a for-each loop and your
	 * add method to accomplish this.
	 * 
	 * @param c A collection of elements to be added to the tree.
	 */
	public void addAll(Collection<? extends T> c)
    {
		for(T t: c)
        {
            this.add(t);
        }
	}
	
	/**
	 * All right, now for the remove method. Just like in the vanilla BST, you
	 * will have to traverse to find the data the user is trying to remove. 
	 * 
	 * You will have three cases:
	 * 
	 * 1. Node to remove has zero children.
	 * 2. Node to remove has one child.
	 * 3. Node to remove has two children.
	 * 
	 * For the first case, you simply return null up the tree. For the second case,
	 * you return the non-null child up the tree. 
	 * 
	 * Just as in add, you'll have to updateHeightAndBF() as well as rotate() just before
	 * you return out of each recursive step.
	 * 
	 * FOR THE THIRD CASE USE THE PREDECESSOR OR YOU WILL LOSE POINTS
	 * 
	 * @param data The data to search in the tree.
	 * @return The data that was removed from the tree.
	 */
    public T remove(T data)
    {
        //if the list is already empty
        if(!this.contains(data))
        {
            return null;
        }

        AVLNode<T> current = this.getNode(data);

        //if the node to remove is the head
        if(current.equals(this.root))
        {
            //if the node we want to remove has no left or right
            if(current.getLeft() == null && current.getRight() == null)
            {
                this.clear();
                return data;
            }

            //if the node we want to remove has only a right
            else if(current.getLeft() == null && current.getRight() != null)
            {
                this.root = current.getRight();
                this.size--;
                this.updateHeightAndBF(root);
                this.rotateAll(root);
                return data;
            }

            //if the node we want to remove has only a left
            else if(current.getLeft() != null && current.getRight() == null)
            {
                this.root = current.getLeft();
                this.size--;
                this.updateHeightAndBF(root);
                this.rotateAll(root);
                return data;
            }

            //if the node we want to remove has both a left and a right
            AVLNode<T> replacement = this.getClosestLeft(current.getLeft());
            T replaceData = replacement.getData();
            this.remove(replacement.getData());
            current.setData(replaceData);
            this.size--;
            this.updateHeightAndBF(root);
            this.rotateAll(root);
            return data;
        }

        AVLNode<T> prev = this.getPrev(data);

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
            this.updateHeightAndBF(root);
            this.rotateAll(root);
            return data;
        }

        //if the node we want to remove has only a right
        if(current.getLeft() == null && current.getRight() != null)
        {
            AVLNode<T> right = current.getRight();
            current.setData(right.getData());
            current.setLeft(right.getLeft());
            current.setRight(right.getRight());
            this.size--;
            this.updateHeightAndBF(root);
            this.rotateAll(root);
            return data;
        }

        //if the node we want to remove has only a left
        if(current.getLeft() != null && current.getRight() == null)
        {
            AVLNode<T> left = current.getLeft();
            current.setData(left.getData());
            current.setLeft(left.getLeft());
            current.setRight(left.getRight());
            this.size--;
            this.updateHeightAndBF(root);
            this.rotateAll(root);
            return data;
        }

        //if the node we want to remove has both a left and a right
        AVLNode<T> replacement = this.getClosestLeft(current.getLeft());
        T replaceData = replacement.getData();
        this.remove(replacement.getData());
        current.setData(replaceData);
        this.size--;
        this.updateHeightAndBF(root);
        this.rotateAll(root);
        return data;

    }
	
	/**
	 * This method should be pretty simple, all you have to do is recurse
	 * to the left or to the right and see if the tree contains the data.
	 * 
	 * @param data The data to search for in the tree.
	 * @return The boolean flag that indicates if the data was found in the tree or not.
	 */
	public boolean contains(T data)
    {
        boolean isFound = false;
        AVLNode<T> current = root;
        while(isFound != true)
        {
            T currentData = current.getData();
            if(data.compareTo(currentData) == 0)
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
	 * Again, simply recurse through the tree and find the data that is passed in.
	 * 
	 * @param data The data to fetch from the tree.
	 * @return The data that the user wants from the tree. Return null if not found.
	 */
	public T get(T data)
    {

        boolean isFound = false;
        AVLNode<T> current = root;
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
	 * Test to see if the tree is empty.
	 * 
	 * @return A boolean flag that is true if the tree is empty.
	 */
	public boolean isEmpty()
    {
		return (this.root == null);
	}
	
	/**
	 * Return the number of data in the tree.
	 * 
	 * @return The number of data in the tree.
	 */
	public int size()
    {
		return this.size;
	}
	
	/**
	 * Reset the tree to its original state. Get rid of every element in the tree.
	 */
	public void clear()
    {
		this.root = null;
        this.size = 0;
    }
	
	// The below methods are all private, so we will not be directly grading them,
	// however we strongly recommend you not change them, and make use of them.

    private AVLNode<T> getNode (T data)
    {
        boolean isFound = false;
        AVLNode<T> current = root;
        while(isFound != true)
        {	T currentData = current.getData();
            if(data.compareTo(currentData) == 0)
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

    private AVLNode<T> getClosestLeft (AVLNode<T> node)
    {
        AVLNode<T> current = node;

        while(current.getRight() != null)
        {
            current = current.getRight();
        }

        return current;
    }

    private void updateHeight(AVLNode<T> node)
    {
        //if both left and right are null, height is 0
        if(node.getLeft()==null && node.getRight()==null)
        {
            node.setHeight(0);
            return;
        }

        //if left is null, height is right +1
        else if(node.getLeft() == null)
        {
            this.updateHeight(node.getRight());
            node.setHeight(node.getRight().getHeight() + 1);
        }

        //if right is null, height is left +1
        else if(node.getRight() == null)
        {
            this.updateHeight(node.getLeft());
            node.setHeight(node.getLeft().getHeight() + 1);
        }

        //otherwise look at which height is bigger and use that one
        else
        {
            this.updateHeight(node.getLeft());
            this.updateHeight(node.getRight());
            if(node.getLeft().getHeight() >= node.getRight().getHeight())
            {
                node.setHeight(node.getLeft().getHeight() + 1);
            }

            else
            {
                node.setHeight(node.getRight().getHeight() + 1);
            }
        }
    }

    private void updateBF(AVLNode<T> node)
    {
        //if both left and right are null, set bf = 0
        if(node.getLeft()==null && node.getRight()==null)
        {
            node.setBF(0);
            return;
        }

        //if left is null, bf = -1 - right
        else if(node.getLeft() == null)
        {
            this.updateBF(node.getRight());
            node.setBF(-1-node.getRight().getHeight());
        }

        //if right is null, bf = left - -1
        else if(node.getRight() == null)
        {
            this.updateBF(node.getLeft());
            node.setBF(node.getLeft().getHeight() - -1);
        }

        //otherwise bf = left - right
        else
        {
            this.updateBF(node.getLeft());
            this.updateBF(node.getRight());
            node.setBF(node.getLeft().getHeight()-node.getRight().getHeight());
        }
    }

    private void rotateAll(AVLNode<T> node)
    {
        if(node == null)
        {
            return;
        }
        this.rotateAll(node.getLeft());
        this.rotateAll(node.getRight());
        this.rotate(node);
        this.updateHeightAndBF(root);
    }

	/**
	 * Use this method to update the height and balance factor for a node.
	 * 
	 * @param node The node whose height and balance factor need to be updated.
	 */
	private void updateHeightAndBF(AVLNode<T> node)
    {
        updateHeight(node);
        updateBF(node);
	}
	
	/**
	 * In this method, you will check the balance factor of the node that is passed in and
	 * decide whether or not to perform a rotation. If you need to perform a rotation, simply
	 * call the rotation and return the new root of the balanced subtree. If there is no need
	 * for a rotation, simply return the node that was passed in.
	 * 
	 * @param node - a potentially unbalanced node
	 * @return The new root of the balanced subtree.
	 */
	private AVLNode<T> rotate(AVLNode<T> node) 
	{
        AVLNode<T> newRoot = node;
        // check if rotation is necessary
		if(node.getBf() > 1 || node.getBf() < -1)
		{
			//do something-right rotation
			if(node.getBf() > 0 )
			{
                //do right rotation
                if(node.getLeft().getBf() > 0)
                {
                    this.rightRotate(node);
                }
                //do left-right rotation
		        else if(node.getLeft().getBf() < 0)
                {
                    this.leftRightRotate(node);
                }
			}
			//do something-left rotation
			else if(node.getBf() < 0)
			{
                //do left rotation
                if(node.getRight().getBf()<0)
                {
                    this.leftRotate(node);
                }
                //do right-left rotation
                else if(node.getRight().getBf()>0)
                {
                    this.rightLeftRotate(node);
                }
			}
        }
		return newRoot;
	}
	
	/**
	 * In this method, you will perform a left rotation. Remember, you perform a 
	 * LEFT rotation when the sub-tree is RIGHT heavy. This moves more nodes over to
	 * the LEFT side of the node that is passed in so that the height differences
	 * between the LEFT and RIGHT subtrees differ by at most one.
	 * 
	 * HINT: DO NOT FORGET TO RE-CALCULATE THE HEIGHT OF THE NODES
	 * WHOSE CHILDREN HAVE CHANGED! YES, THIS DOES MAKE A DIFFERENCE!
	 * 
	 * @param node - the current root of the subtree to rotate.
	 * @return The new root of the subtree
	 */
	private AVLNode<T> leftRotate(AVLNode<T> node) {
		AVLNode<T> nodeA = node;
        AVLNode<T> nodeB = nodeA.getRight();
        AVLNode<T> nodeBL = nodeB.getLeft();
        AVLNode<T> nodeAL = nodeA.getLeft();
        AVLNode<T> nodeC = nodeB.getRight();
        T dataA = nodeA.getData();
        T dataB = nodeB.getData();

        nodeA.setLeft(nodeB);
        nodeB.setLeft(nodeAL);
        nodeB.setRight(nodeBL);
        nodeA.setRight(nodeC);

        nodeA.setData(dataB);
        nodeB.setData(dataA);

		return nodeA;
	}
	
	/**
	 * In this method, you will perform a right rotation. Remember, you perform a
	 * RIGHT rotation when the sub-tree is LEFT heavy. THis moves more nodes over to
	 * the RIGHT side of the node that is passed in so that the height differences
	 * between the LEFT and RIGHT subtrees differ by at most one.
	 * 
	 * HINT: DO NOT FORGET TO RE-CALCULATE THE HEIGHT OF THE NODES
	 * WHOSE CHILDREN HAVE CHANGED! YES, THIS DOES MAKE A DIFFERENCE!
	 * 
	 * @param node - The current root of the subtree to rotate.
	 * @return The new root of the rotated subtree.
	 */
	private AVLNode<T> rightRotate(AVLNode<T> node)
    {
        AVLNode<T> nodeA = node;
        AVLNode<T> nodeB = nodeA.getLeft();
        AVLNode<T> nodeBR = nodeB.getRight();
        AVLNode<T> nodeAR = nodeA.getRight();
        AVLNode<T> nodeC = nodeB.getLeft();
        T dataA = nodeA.getData();
        T dataB = nodeB.getData();

        nodeA.setRight(nodeB);
        nodeB.setRight(nodeAR);
        nodeB.setLeft(nodeBR);
        nodeA.setLeft(nodeC);

        nodeA.setData(dataB);
        nodeB.setData(dataA);

		return nodeB;
	}
	
	/**
	 * In this method, you will perform a left-right rotation. You can simply use
	 * the left and right rotation methods on the node and the node's child. Remember
	 * that you must perform the rotation on the node's child first, otherwise you will
	 * end up with a mangled tree (sad face). After rotating the child, remember to link up
	 * the new root of the that first rotation with the node that was passed in.
	 * 
	 * The whole point of heterogeneous rotations is to transform the node's 
	 * subtree into one of the cases handled by the left and right rotations.
	 * 
	 * @param node
	 * @return The new root of the subtree.
	 */
	private AVLNode<T> leftRightRotate(AVLNode<T> node)
    {
        AVLNode<T> nodeA = node;
        AVLNode<T> nodeB = nodeA.getLeft();

        this.leftRotate(nodeB);
		return this.rightRotate(nodeA);
	}
	
	/**
	 * In this method, you will perform a right-left rotation. You can simply use your
	 * right and left rotation methods on the node and the node's child. Remember
	 * that you must perform the rotation on the node's child first, otherwise
	 * you will end up with a mangled tree (super sad face). After rotating the node's child,
	 * remember to link up the new root of that first rotation with the node that was
	 * passed in.
	 * 
	 * Again, the whole point of the heterogeneous rotations is to first transform the
	 * node's subtree into one of the cases handled by the left and right rotations.
	 * 
	 * @param node
	 * @return The new root of the subtree.
	 */
	private AVLNode<T> rightLeftRotate(AVLNode<T> node)
    {
        AVLNode<T> nodeA = node;
        AVLNode<T> nodeB = nodeA.getRight();

        this.rightRotate(nodeB);
		return this.leftRotate(nodeA);
	}

	public void setRoot(AVLNode<T> node) 
	{
		this.root = node;
	}
	
	public AVLNode<T> getRoot() 
	{
		return this.root;
	}
	
	public void setSize(int i) 
	{
		this.size = i;
	}

    /**
     * Create A List of the nodes, their heights and balance factors
     * @return
     */
	private void AVLinOrder()
	{
		dataList= new ArrayList<T>();
        heightList = new ArrayList<Integer>();
        balanceList = new ArrayList<Integer>();
		this.AVLinOrderHelp(root);
	}

	private void AVLinOrderHelp(AVLNode<T> node)
	{
		if(node == null)
		{
			return;
		}

        AVLinOrderHelp(node.getLeft());
		dataList.add(node.getData());
        heightList.add(node.getHeight());
        balanceList.add(node.getBf());
		AVLinOrderHelp(node.getRight());
	}

	private void AVLprintList()
	{
		for(int i = 0; i<size; i++)
		{
            System.out.println("Data: "+dataList.get(i)+" Height: "+heightList.get(i)+" Balance: "+balanceList.get(i));

		}
	}

    private AVLNode<T> getPrev(T data)
    {
        boolean isFound = false;
        AVLNode<T> prev = null;
        AVLNode<T> current = root;
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
}

