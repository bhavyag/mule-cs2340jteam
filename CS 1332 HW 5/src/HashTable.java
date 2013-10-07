import java.util.Collection;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class will represent a modified linear probing hash table.
 * The modification is specified in the comments for the put method.
 */
public class HashTable<K,V>
{

    /**
     * Constant determining the max load factor
     */
    private final double MAX_LOAD_FACTOR = 0.71;

    /**
     * Constant determining the initial table size
     */
    private final int INITIAL_TABLE_SIZE = 11;

    /**
     * Number of elements in the table
     */
    private int size;

    /**
     * The backing array of this hash table
     */
    private MapEntry[] table;
    private int currentTableSize;
    /**
     * Initialize the instance variables
     * Initialize the backing array to the initial size given
     */
    public HashTable()
    {
        table = new MapEntry[INITIAL_TABLE_SIZE];
        currentTableSize = INITIAL_TABLE_SIZE;
        size = 0;
    }

    /**
     * Add the key value pair in the form of a MapEntry
     * Use the default hash code function for hashing
     * This is a linear probing hash table so put the entry in the table accordingly
     *
     * Make sure to use the given max load factor for resizing
     * Also, resize by doubling and adding one. In other words:
     *
     * newSize = (oldSize * 2) + 1
     *
     * The load factor should never exceed maxLoadFactor at any point. So if adding this element
     * will cause the load factor to be exceeded, you should resize BEFORE adding it. Otherwise
     * do not resize.
     *
     * IMPORTANT Modification: If the given key already exists in the table
     * then set it as the next entry for the already existing key. This means
     * that you will never be replacing values in the hashtable, only adding or removing.
     * This is similar to external chaining
     *
     * @param key This will never be null
     * @param value This can be null
     */
    public void put(K key,V value)
    {
        this.size++;
        double currentLoadFactor = this.getLoad();
        this.size--;

        //if the load factor gets to big, double the size and re-add everything
        if(currentLoadFactor>MAX_LOAD_FACTOR)
        {
            this.size = 0;
            this.currentTableSize = (currentTableSize*2)+1;
            MapEntry[] oldTable = this.table;
            this.table = new MapEntry[currentTableSize];
            for(MapEntry entry : oldTable)
            {
                if(entry != null && !entry.isRemoved())
                {
                    this.put((K)entry.getKey(),(V)entry.getValue());
                    MapEntry current = entry;
                    while(current.getNext()!=null)
                    {
                        current = current.getNext();
                        this.put((K)current.getKey(),(V)current.getValue());
                    }
                }
            }
            this.put(key,value);
            return;
        }

        MapEntry newEntry = new MapEntry<K,V>(key,value);
        int code = key.hashCode() % this.currentTableSize;
        MapEntry here = this.table[code];

        //if there's nothing there
        if(here == null)
        {
            this.table[code] = newEntry;
            this.size++;
            return;
        }

        //if what's there has been removed
        else if(here.isRemoved())
        {
            this.table[code] = newEntry;
            this.size++;
            return;
        }

        //if they have the same key
        else if(newEntry.getKey()==here.getKey())
        {
            MapEntry current = here;
            while(current.getNext() != null)
            {
               current = current.getNext();
            }
            current.setNext(newEntry);
            this.size++;
            return;
        }

        //otherwise linear probe
        else
        {
            MapEntry current = here;
            while(current != null && !current.isRemoved())
            {
                code++;
                if(code==this.table.length)
                {
                    code = 0;
                    current = this.table[0];
                }
                else
                {
                    current = this.table[code];
                }
            }
            this.table[code] = newEntry;
            this.size++;
            return;
        }
    }

    /**
     * Remove the entry with the given key.
     *
     * If there are multiple entries with the same key then remove the last one
     *
     * @param key
     * @return The value associated with the key removed
     */
    public V remove(K key)
    {
        V value=null;
        if(!this.contains(key))
        {
            return null;
        }

        for(MapEntry entry : this.table)
        {
            if(entry != null)
            {
                if(key.equals(entry.getKey()))
                {
                    if(entry.getNext() == null)
                    {
                        value = (V)entry.getValue();
                        entry.setRemoved(true);
                    }

                    else
                    {
                        MapEntry prev = null;
                        MapEntry current = entry;
                        while(current.getNext() != null)
                        {
                            prev = current;
                            current = current.getNext();
                        }
                        value = (V)current.getValue();
                        prev.setNext(null);
                    }

                }
            }
        }
        this.size--;
        return value;
    }

    /**
     * Checks whether an entry with the given key exists in the hash table
     *
     * @param key
     * @return
     */
    public boolean contains(K key)
    {
        for(MapEntry entry : this.table)
        {
            if(entry != null && !entry.isRemoved())
            {
                if(key.equals(entry.getKey()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Return a collection of all the values
     *
     * We recommend using an ArrayList here
     *
     * @return
     */
    public Collection<V> values()
    {
        ArrayList<V> list = new ArrayList<V>();

        for(MapEntry entry : this.table)
        {
            if(entry != null && !entry.isRemoved())
            {
                list.add((V)entry.getValue());
                MapEntry current = entry;
                while(current.getNext()!=null)
                {
                    current = current.getNext();
                    list.add((V)current.getValue());
                }
            }
        }
        return list;
    }

    /**
     * Return a set of all the distinct keys
     *
     * We recommend using a HashSet here
     *
     * Note that the map can contain multiple entries with the same key
     *
     * @return
     */
    public Set<K> keySet()
    {
        HashSet set = new HashSet();

        for(MapEntry entry : this.table)
        {
            if(entry != null && !entry.isRemoved())
            {
                set.add(entry.getKey());
            }
        }
        return set;
    }

    /**
     * Return the number of values associated with one key
     * Return -1 if the key does not exist in this table
     * @param key
     * @return
     */
    public int keyValues(K key)
    {
        if(!this.contains(key))
        {
            return -1;
        }
        int count = 0;
        for(MapEntry entry : this.table)
        {
            if(entry != null && !entry.isRemoved() && key.equals(entry.getKey()))
            {
                count++;
                MapEntry current = entry;
                while(current.getNext()!=null)
                {
                    current = current.getNext();
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Return a set of all the unique key-value entries
     *
     * Note that two map entries with both the same key and value
     * could exist in the map.
     *
     * @return
     */
    public Set<MapEntry<K,V>> entrySet()
    {
        HashSet set = new HashSet();
        for(MapEntry entry : this.table)
        {
            if(entry != null && !entry.isRemoved())
            {
                set.add(entry);
                MapEntry current = entry;
                while(current.getNext()!=null)
                {
                    current = current.getNext();
                    set.add(current);
                }
            }
        }
        return set;
    }

    /**
     * Clears the hash table
     */
    public void clear()
    {
        for(MapEntry entry : this.table)
        {
            if(entry != null && !entry.isRemoved())
            {
                entry.setRemoved(true);
            }
        }
        this.table = new MapEntry[INITIAL_TABLE_SIZE];
    }

    private double getLoad()
    {
        return (double)this.size/this.currentTableSize;
    }

    private void printTable()
    {
        MapEntry[] myTable = this.table;

        for(int i = 0; i<myTable.length; i++)
        {
            MapEntry entry = myTable[i];
            if(entry==null || entry.isRemoved())
            {
                System.out.println(i+" empty");
            }
            else
            {
                System.out.println(i+" KEY: "+entry.getKey()+" VALUE: "+entry.getValue());
                MapEntry current = entry;
                while(current.getNext() != null)
                {
                    current = current.getNext();
                    System.out.println("  KEY: "+current.getKey()+" VALUE: "+current.getValue());
                }
            }
        }
    }

    private void printList(Collection<V> myList)
    {
        for(V val : myList)
        {
            if(val != null)
            {
                System.out.println(val);
            }
        }
    }

    private void printPair(Collection<MapEntry<K,V>> myList)
    {
        for(MapEntry<K,V> entry : myList)
        {
            if(entry != null && !entry.isRemoved())
            {
                System.out.println("KEY: "+entry.getKey()+" VALUE: "+entry.getValue());
            }
        }
    }

	/*
	 * The following methods will be used for grading purposes do not modify them
	 */

    public int size()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public MapEntry<K, V>[] getTable()
    {
        return table;
    }

    public void setTable(MapEntry<K, V>[] table)
    {
        this.table = table;
    }
}
