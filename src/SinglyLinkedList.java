
/**Shayan Goldstein - 40229167
COMP249
Assignment 3
April 15, 2024*/

/**
 * @author shay_
 *
 */
public class SinglyLinkedList {
	
	//Nested inner class
	private class Node{
		
		// the String "word" is the data in each Node
		private String word;
		// the Node "next" is the reference pointing to the next Node in the Linked List
		private Node next;
		private int index;
		
		private Node() {
			next = null;
			word = null;
			index = size;
		}
		
		private Node(String word, Node next) {
			this.word = word;
			this.next = next;
			index = size;
		}		
	}
	
	//Start of the SinglyLinkedList class
	
	private int size;
	private Node head;
	private Node tail;
	
	public SinglyLinkedList() {
		head = null;
		size = 0;
	}
	
	//getters / setters
	public void setHead(Node head) {
		this.head = head;
	}
	
	public void changeWord(String wordToChange, String newWord) {
		Node position = head;
		while(position != null && !(position.word.equals(wordToChange)) ) {
			position = position.next;
		}
		
		if(position != null) {
			position.word = newWord;
		}
		
	}
	
	public String getWord(int indexNum) {
		if(indexNum < 0 || indexNum > tail.index) {
			return null;
		}
		else {
			Node position = head;
			while(position != null) {
				if(position.index == indexNum) {
					return position.word;
				}
				position = position.next;
			}
			return null;
		}
	}
	
	//adding nodes
	public void addAtHead(String newWord) {
		head = new Node(newWord, head);
		if(head.next == null) {
			tail = head;
		}
		size++;
	}
	
	public void addAtEnd(String newWord) {
		
		if(head == null) {
			head = new Node(newWord, head);
			tail = head;
		}
		else {
			Node position = head;
			while(position.next != null) {
				position = position.next;
			}
			position.next = new Node(newWord, null);
			tail = position.next;
		}
		
		size++;
	}
	
	//deleting nodes
	public boolean delete(String wordToRemove) {
		
		Node position = head;
		Node previous = null;
		
		if(head == null) {
			return false;
		}
		else if(head.word.equalsIgnoreCase(wordToRemove)) {
			head = head.next;
			size--;
			return true;
		}
		else {
			while(position.next != null && !(position.next.word.equalsIgnoreCase(wordToRemove))) {
				position = position.next;
			}
			
			if(position.next != null) {
				position.next = position.next.next;
				size--;
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public int getSize() {
		return size;
	}
	
	//toString version of this is below, this method may not be necessary
	public void display() {
		Node position = head;
		
		while(position != null) {
			System.out.println(position.word);
			position = position.next;
		}
	}
	
	@Override
	public String toString() {
		String linkedListString = "";
		Node position = head;
		
		while(position != null) {
			linkedListString = linkedListString + position.word + "\n";
			position = position.next;
		}
		
		return linkedListString;
	}

}
