package homework3c;
import java.util.AbstractList;

public class LDLinkedList<E> extends AbstractList<E>
{
    private int  size =0;
    private int numLazilyDeleted = 0;
    private Node<E> head = null;
    private static class Node<E> 
    {
        private E data;
        private Node<E> next;
        private boolean lazilyDeleted;
        /** Creates a new node with a null next field
        @param dataItem The data stored
        */
        private Node(E dataItem) {
        data = dataItem;
        lazilyDeleted = false;
        next = null;
        }
        /** Creates a new node that references another node
        @param dataItem The data stored
        @param nodeRef The node referenced by new node
        */
        private Node(E dataItem, Node<E> nodeRef) {
        lazilyDeleted = false;
        data = dataItem;
        next = nodeRef;
        }
    
    }

    public int size() 
    {
        return size;   
    }

    private void addFirst (E item) 
    {
        head = new Node<E>(item, head);
        size++;
    }

    private void addAfter (Node<E> node, E item) 
    {
        Node<E> temp = new Node<E>(item, node.next);
        node.next = temp;
        size++;
    }

    private E removeAfter (Node<E> node) 
    {
        Node<E> temp = node.next;
        if (temp != null) {
        node.next = temp.next;
        size--;
        return temp.data;
        } else {
        return null;
        }
    }

    private E removeFirst () 
    {
        Node<E> temp = head;
        if (head != null) {
        head = head.next;
        } if (
        temp != null) {
        size--;
        return temp.data;
        } else {
        return null;
        }
    }

    private Node<E> getNode(int index) 
    {
        Node<E> node = head;
        for (int i=0; i<index && node != null; i++) {
        node = node.next;
        } return node;
    }

    /**
     * get the element lives in the given index
     * @exception IndexOutOfBoundsException checks unvalid index
     * @param index position of element to get
     * @return return the element in given index
     */
    public E get (int index) 
    {
        if (index < 0 || index >= size) {
        throw new
        IndexOutOfBoundsException(Integer.toString(index));
        } Node<E> node = getNode(index);
        return node.data;
    }

    /**
     * set the elemnts in given index
     * @exception IndexOutOfBoundsException checks unvalid index
     * @param anEntry new value 
     * @param index position of element setted
     * @return old value
     */
    public E set (int index, E anEntry) 
    {
        if (index < 0 || index >= size) {
        throw new
        IndexOutOfBoundsException(Integer.toString(index));
        } Node<E> node = getNode(index);
        E result = node.data;
        node.data = anEntry;
        return result;
    }

    /** 
     * adds elements given index
     * @exception IndexOutOfBoundsException checks unvalid index
     * @param index position of the list where element added
     * @param item element the added list
    */
    public void add (int index, E item) 
    {
        if (index < 0 || index > size) {
        throw new
        IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
        addFirst(item);
        } else {
        Node<E> node = getNode(index-1);
        addAfter(node, item);
        }
    }

    /**adds the element end of the list
     * @param item element the added list
     * @return if adds return true
     */
    public boolean add (E item) 
    {
        add(size, item);
        return true;
    }

    /**
     * Check the element already marked or not
     * Lazily marked elements number reachs the two, delete marked elements
     * @throws IndexOutOfBoundsException index is unvalid
     * @param index will be removed element in given index
     * @return deleted element data 
     */
    public E remove( int index)
    {
        E temp = null;
        
        if (index < 0 || index > size)
        {   throw new
            IndexOutOfBoundsException(Integer.toString(index));
        }

        if(getNode(index).lazilyDeleted)
        {
            System.out.println("The element is already marked removed");
            return temp;
        }

        if(numLazilyDeleted < 1)
        {    
           getNode(index).lazilyDeleted = true;
            ++ numLazilyDeleted ;  
        }
        else
        {
            getNode(index).lazilyDeleted = true;
             Node<E> search = head;
            //While loop for List, Check elements are lazily delete or not
            //If element lazily deleted, removes it
            //Index move next element, if there is element next and next element was not marked deleted
            while(search.next != null)
            {
                if(search.next.lazilyDeleted)
                {
                   temp = removeAfter(search);
                }
                if(search.next != null)
                {
                    if( !(search.next.lazilyDeleted))
                    search = search.next;
                }
            }
            //Check head because it wasn't checked in loop
            if(head.lazilyDeleted)
            removeFirst();
            //All lazilydeletes are removed, 
            numLazilyDeleted =0;
        }
        return temp;
    }




    /**Checks elment marked removed, Or there is element
     * IF there is two marked deleted element delete them
     * Delete the given element in first occur place
     * @param o delete element
     * @return If tokens are deleted or merked lazily deleted return true,otherwise false
     */
    public boolean remove(Object o ) 
    {
        boolean check= true;
        for (Node<E> x = head; x != null; x = x.next) 
            {
                if (o.equals(x.data)) 
                {
                    check = false;
                    if(x.lazilyDeleted)
                    {
                        System.out.println("The element is already marked removed");
                        return false;
                    }
                    
                }
            }
        if(check)
        {
            System.out.println("The NoSuchThat element in List");
            return false;
        }    

        //Market elements number fewer than two, marked the lazily given element
        if(numLazilyDeleted < 1)
        {    
            for (Node<E> x = head; x != null; x = x.next) 
            {
                if (o.equals(x.data)) 
                {
                    x.lazilyDeleted = true;
                    ++ numLazilyDeleted ;
                    return true;
                }
            }
            return false;
        }
        else // remove all lazily delete elements 
        {
            for (Node<E> x = head; x != null; x = x.next) 
            {
                if (o.equals(x.data)) 
                x.lazilyDeleted = true;
            }

            Node<E> search = head;
            while(search.next != null)
            {
                if( search.next.lazilyDeleted )
                {
                    removeAfter(search);
                }
                if(search.next != null)
                {
                    if( !(search.next.lazilyDeleted ))
                    search = search.next;
                }
            }
            if(head.lazilyDeleted)
            removeFirst();
            numLazilyDeleted =0;
            return true;
        }
        
    }


}