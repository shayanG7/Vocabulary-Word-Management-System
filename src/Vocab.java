
/**Shayan Goldstein - 40229167
COMP249
Assignment 3
April 15, 2024*/

public class Vocab {
	
	private String topic;
	private SinglyLinkedList words;
	
	public Vocab() {
		topic = null;
		words = new SinglyLinkedList();
	}
	
	public Vocab(String t, SinglyLinkedList w) {
		topic = t;
		words = w;
	}
	
	public Vocab(Vocab v) {
		topic = v.topic;
		words = v.words;
	}
	
	//getters / setters
	public String getTopic() {
		return topic;
	}
	
	public SinglyLinkedList getWordList() {
		return words;
	}
	
	//returns all words in String format
	public String getWords() {
		if(words == null) {
			words = new SinglyLinkedList();
		}
		return words.toString();
	}
	
	public String getWord(int x) {
		if(words == null) {
			return null;
		}
		else {
			return words.getWord(x);
		}
	}
	
	
	
	public int getNumOfWords() {
		return words.getSize();
	}
	
	//can maybe do without this setter
	public void setWords(SinglyLinkedList words) {
		this.words = words;
	}
	
	//custom methods
	public void addWordToStart(String word) {
		if(words == null) {
			words = new SinglyLinkedList();
		}
			words.addAtHead(word);
	}
	
	public void addWordToEnd(String word) {
		if(words == null) {
			words = new SinglyLinkedList();
		}
		words.addAtEnd(word);
	}

}
