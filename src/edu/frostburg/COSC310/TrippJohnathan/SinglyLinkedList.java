package edu.frostburg.COSC310.TrippJohnathan;

/**
 * Class representing a Singly-Linked List data structure and its Node component
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @param <E> Generic type declaration for the Singly-Linked List
 */
public class SinglyLinkedList<E> {
    
    class Node <E>{
    
    private E element;
    private Node<E> next;
    
    public Node(E element, Node<E> next){
        this.element = element;
        this.next = next;
    }
    
    /**
     * Get the next node
     * @return the next Node
     */
    public Node<E> getNext(){return next;}
    
    /**
     * Get the element of the node
     * @return the element of the Node
     */
    public E getElement(){return element;}
    
    /**
     * set the next Node
     * @param n the next node
     */
    public void setNext(Node<E> n){next = n;}
    
    public boolean hasNext() {return next != null;}
}
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    /**
     * Gets the size of the list
     * @return the size of the list
     */
    public int size(){return size;}
    /**
     * Checks if the list is empty
     * @return whether or not the list is empty
     */
    public boolean isEmpty(){return size==0;}
    /**
     * Gets the first element of the list from the head node
     * @return the first element of the list
     */
    public E first() {
        if(isEmpty()) return null;
        return head.getElement();
    }
    /**
     * Gets the last element of the list from the tail node
     * @return the last element of the list
     */
    public E last() {
        if(isEmpty()) return null;
        return tail.getElement();
    }
    /**
     * Adds the specified element at the beginning of the list
     * @param e the element to be added to the list
     */
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if(size==0)
            tail = head;
        size++;
    }
    /**
     * Adds the specified element at the end of the list
     * @param e the element to be added to the list
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if(isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }
    /**
     * Removes the head node from the list
     * @return the head node
     */
    public E removeFirst() {
        if(isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size==0)
            tail = null;
        return answer;
    }
    /**
     * Checks to determine if the specified element is contained within the list
     * @param e the element to search for in the list
     * @return whether or not the element was found in the list
     */
    public boolean contains(E e){
        if(isEmpty()) return false;
        if(size == 1){
            if(first().equals(e)) return true;
        }
        if(tail.element.equals(e)) return true;
        Node n = head;
        while(n.hasNext()){
            if(n.element.equals(e)) return true;
            n = n.next;
        }
        return false;
    }
}
