
/**Shayan Goldstein - 40229167
COMP249
Assignment 3
April 15, 2024*/

import java.util.ArrayList;

public class DoublyLinkedList {
	
	private class Node {
		
		private Vocab item;
		private Node previous;
		private Node next;
		private int index;		// index numbers for each node
		
		private Node() {
			item = null;
			previous = null;
			next = null;
			index = size;
		}
		
		private Node(Vocab data, Node previous, Node next) {
			item = new Vocab(data);
			this.previous = previous;
			this.next = next;
			index = size;
		}
		
	}
	
	// Start of the DoublyLinkedList class
	
	private int size;
	private Node head;
	private Node tail;
	
	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	// ALL METHODS RELATED TO VOCAB TOPICS
	
	// Adds a node with the topic at the head of the DLL
	public void addTopicToStart(String vocabTopic) {
		if(head == null) {
			Vocab newVocab = new Vocab(vocabTopic, null);
			Node newHead = new Node(newVocab, null, head);
			head = newHead;
			tail = newHead;
		}
		else {
			Vocab newVocab = new Vocab(vocabTopic, null);
			Node newHead = new Node(newVocab, null, head);
			head.previous = newHead;
			head = newHead;
		}
		
		size++;
	}
	
	public void addTopicToEnd(String vocabTopic) {
		Vocab newVocab = new Vocab(vocabTopic, null);
		
		if(head == null) {
			Node newHead = new Node(newVocab, null, head);
			head = newHead;
			tail = newHead;
		}
		else {
			Node position = head;
			while(position.next != null) {
				position = position.next;
			}
			
			position.next = new Node(newVocab, position, null);
			tail = position.next;
		}
		
		size++;
	}
	
	public void addTopicBeforeIndex(int index, String vocabTopic) {		
		Node position = head;
		
		while(position != null && position.index != index) {
			position = position.next;
		}
		if(position != null) {
			Node temp = new Node(new Vocab(vocabTopic, null), position.previous, position); 
			
			position.previous.next = temp;
			position.previous = temp;
			
			position = temp;
			int x = 0;
			while(position != null) {
				position.index = index + x;
				position = position.next;
				x++;
			}

			size++;
		}
		
	}
	
	public void addTopicAfterIndex(int index, String vocabTopic) {
		Node position = head;
		
		while(position != null && position.index != index) {
			position = position.next;
		}
		if(position != null) {
			Node temp = new Node(new Vocab(vocabTopic, null), position, position.next);
			
			position.next.previous = temp;
			position.next = temp;
			
			position = position.next;
			int x = 1;
			while(position != null) {
				position.index = index + x;
				position = position.next;
				x++;
			}
			
			size++;
		}
		
	}
	
	//deleting nodes
	public void deleteTopic(int index) {
		
		Node position = head;
		while(position != null && position.index != index) {
			position = position.next;
		}
		
		if(index == 0) {
			position.next.previous = null;
			head = position.next;
			
			position = position.next;
			int x = 1;
			while(position != null) {
				position.index = index - x;
				position = position.next;
			}
			
			size--;
		}
		//position is null when it tries to enter here only after deletion of another node
		//do this part without referencing the tail node
		else if(index == (size - 1)) {
			tail = position.previous;
			position.previous.next = null;
			
			size--;
		}
		
		else if(position != null) {
			position.previous.next = position.next;
			position.next.previous = position.previous;
			
			position = position.next;
			int x = 1;
			while(position != null) {
				position.index = index - x;
				position = position.next;
			}
			
			size--;
		}
	}
	
	// ALL METHODS RELATED TO WORDS THAT RELATE TO THE TOPICS
	
	// Sifts through all of the Nodes Vocab items, and if the Vocab's topic is the same as the 
	// topic inserted in the method, the word in the method is added to the start of that Vocab object's words
	public void addWord(String vocabWord, String vocabTopic) {
		
		if(head == null) {
			
		}
		else if(head.next == null) {
			 if(head.item.getTopic().equalsIgnoreCase(vocabTopic)) {
				 head.item.addWordToStart(vocabWord);
			 }
		}
		
		else {
			Node position = head;
			while(position.next != null) {
				if(position.item.getTopic().equals(vocabTopic)) {
					position.item.addWordToStart(vocabWord);
				}
				position = position.next;
			}
		}
	}
	
	
	public void addWordToEnd(String vocabWord, String vocabTopic) {
		if(head == null) {
			
		}
		else if(head.next == null) {
			if(head.item.getTopic().equalsIgnoreCase(vocabTopic)) {
				head.item.addWordToEnd(vocabWord);
			}
		}
		else {
			Node position = head;
			while(position != null) {
				if(position.item.getTopic().equalsIgnoreCase(vocabTopic)) {
					position.item.addWordToEnd(vocabWord);
				}
				position = position.next;
			}
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public void displayTopics() {
		Node position = head;
		int x = 1;
		if(head == null) {
			
		}
		else {
			while(position != null) {
				System.out.println(x + " " + position.item.getTopic());
				position = position.next;
				x++;
			}
		}
	}
	
	public Vocab getVocabFromIndex(int indexNum) {
		if(indexNum < 0 || indexNum > tail.index) {
			return null;
		}
		else {
			Node position = head;
			while(position != null) {
				if(position.index == indexNum) {
					return position.item;
				}
				position = position.next;
			}
			return null;
		}
	}
	
	public Vocab getVocabFromTopic(String topicName) {
		
		Node position = head;
		while(position != null) {
			if((position.item.getTopic()).equalsIgnoreCase(topicName)) {
				return position.item;
			}
			position = position.next;
		}
		return null;
		
	}
	
	public ArrayList<String> wordsStartingWithSpecificLetter(String letter){
		ArrayList<String> output = new ArrayList<>();
		
		if(letter.length() != 1) {
			return null;
		}
		
		Node position = head;
		while(position != null) {
			int wordsIndex = 0;
			while(position.item.getWord(wordsIndex) != null) {
				if(!(position.item.getWord(wordsIndex).isEmpty()) && 
						(position.item.getWord(wordsIndex).substring(0, 1)).equalsIgnoreCase(letter)) {
					output.add(position.item.getWord(wordsIndex));
				}
				wordsIndex++;
			}
			position = position.next;
		}
		
		return output;
	}
	
	// Outputs the title and the words to String
	@Override
	public String toString() {
		String output = "";
		
		if(head == null) {
			return "There are no vocabulary items";
		}
		//currently not outputting the title
		else if(head.next == null) {
			return head.item.getTopic() + ":\n" + head.item.getWords();
		}
		else {
			Node position = head;
			while(position != null) {
				output = output + "#" + position.item.getTopic() + "\n";
				output = output + position.item.getWords();
				position = position.next;
			}
			return output;
		}
		
	}

}
