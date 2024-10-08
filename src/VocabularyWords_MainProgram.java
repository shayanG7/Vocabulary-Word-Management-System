
/**Shayan Goldstein - 40229167
COMP249
Assignment 3
April 15, 2024*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class VocabularyWords_MainProgram {

	public static void main(String[] args) {
		
		DoublyLinkedList vocab_list = new DoublyLinkedList();
		Scanner kb = new Scanner(System.in);		
		
		int choice = -1;
		while(choice != 0) {
			System.out.print("-----------------------------\r\n"
					+ "  Vocabulary Control Center\r\n"
					+ "-----------------------------\r\n"
					+ "1 browse a topic\r\n"
					+ "2 insert a new topic before another one\r\n"
					+ "3 insert a new topic after another one\r\n"
					+ "4 remove a topic\r\n"
					+ "5 modify a topic\r\n"
					+ "6 search topics for a word\r\n"
					+ "7 load from a file\r\n"
					+ "8 show all words starting with a given letter\r\n"
					+ "9 save to file\r\n"
					+ "0 exit\r\n"
					+ "-----------------------------\r\n"
					+ "Enter Your Choice: ");
			choice = kb.nextInt();
			
			/** option to browse topics */
			if(choice == 1) {
				
				int option1;
				System.out.print("------------------------------\r\n"
						+ "       Pick a topic\r\n"
						+ "------------------------------\r\n");
				vocab_list.displayTopics();
				System.out.println("0 Exit");
				System.out.print("------------------------------\r\n"
						+ "Enter your choice: ");
						
				option1 = kb.nextInt();
				while(option1 != 0 && option1 < vocab_list.getSize() + 1) {
					int x = 0;					
					
					while(vocab_list.getVocabFromIndex(option1 - 1).getWord(x) != null) {
						// this if statement should only happen at the tail node of the SLL
						if((vocab_list.getVocabFromIndex(option1 - 1).getWord(x)).equals("")
								|| (vocab_list.getVocabFromIndex(option1 - 1).getWord(x)).equals(null)) {
							break;
						}
						System.out.print( (x+1) + ": " + vocab_list.getVocabFromIndex(option1 - 1).getWord(x) +
								"        ");
						if((x+1)%4 == 0 && x != 0) {
							System.out.println();
						}
						
						x++;
					}
					System.out.println();
					option1 = kb.nextInt();
				}
				
				
				
			}
			
			/** option to insert a new topic before a pre-existing topic */
			else if(choice == 2) {
				
				int option2 = -1;
				while(option2 != 0) {
					System.out.print("------------------------------\r\n"
						+ "       Pick a topic\r\n"
						+ "------------------------------\r\n");
						vocab_list.displayTopics();
						System.out.println("0 Exit");
						System.out.print("------------------------------\r\n"
						+ "Enter your choice: ");
						
				option2 = kb.nextInt();
				
				String topicName;
				String wordToAdd;
				if(option2 != 0 && option2 < vocab_list.getSize() + 1) {
					System.out.println("Enter a topic name: ");
					kb.nextLine();		//consumes the \n from when the user input option2 using .nextInt()
					topicName = kb.nextLine();
					
					vocab_list.addTopicBeforeIndex(option2 - 1, topicName);
					
					System.out.println("Enter a word - to quit press Enter:");					
					while(true) {
						wordToAdd = kb.nextLine();
						if(wordToAdd.isEmpty()) {
							break;
						}
						vocab_list.addWordToEnd(wordToAdd, topicName);
					}
					
				}
				}
			}
			
			/** option to insert a new topic after a pre-existing topic */
			else if(choice == 3) {
				
				int option3 = -1;
				while(option3 != 0) {
					System.out.print("------------------------------\r\n"
						+ "       Pick a topic\r\n"
						+ "------------------------------\r\n");
						vocab_list.displayTopics();
						System.out.println("0 Exit");
						System.out.print("------------------------------\r\n"
						+ "Enter your choice: ");
						
						option3 = kb.nextInt();
						
						String topicName;
						String wordToAdd;
						if(option3 != 0 && option3 < vocab_list.getSize() + 1) {
							System.out.print("Enter a topic name: ");
							kb.nextLine();
							topicName = kb.nextLine();
							
							vocab_list.addTopicAfterIndex(option3 - 1, topicName);
							
							System.out.println("Enter a word - to quit press Enter:");
							while(true) {
								wordToAdd = kb.nextLine();
								if(wordToAdd.isEmpty()) {
									break;
								}
								vocab_list.addWordToEnd(wordToAdd, topicName);
							}
						}
				}
				
				
			}
			
			/** option to delete a topic */
			else if(choice == 4) {
				
				int option4 = -1;
				while(option4 != 0) {
					System.out.print("------------------------------\r\n"
							+ "       Pick a topic\r\n"
							+ "------------------------------\r\n");
							vocab_list.displayTopics();
							System.out.println("0 Exit");
							System.out.print("------------------------------\r\n"
							+ "Enter your choice: ");
							
							option4 = kb.nextInt();
							
							if(option4 > 0 && option4 < vocab_list.getSize() + 1) {
								
								vocab_list.deleteTopic(option4 - 1);
								System.out.println("Item " + option4 + " deleted");
							}
							
				}
				
			}
			
			/** option to modify a topic */
			else if(choice == 5) {
				int option5 = -1;
				while(option5 != 0) {
					System.out.print("------------------------------\r\n"
							+ "       Pick a topic\r\n"
							+ "------------------------------\r\n");
							vocab_list.displayTopics();
							System.out.println("0 Exit");
							System.out.print("------------------------------\r\n"
							+ "Enter your choice: ");
							
							option5 = kb.nextInt();
							
					if(option5 > 0 && option5 < vocab_list.getSize() + 1) {
						
						System.out.print("------------------------------\r\n"
								+ "       Modify Topics Menu\r\n"
								+ "------------------------------\r\n");
						System.out.print("a  add a word\n"
								+ "r  remove a word\n"
								+ "c  change a word\n"
								+ "0  Exit\n"
								+ "------------------------------\r\n"
								+ "Enter your choice: ");
						
						String option = kb.next();
						kb.nextLine();
						
						if(option.equals("a")) {
							System.out.println("Type a word and press Enter, or press Enter to end input:");
							String addWord = "random content";
							while(!(addWord.isEmpty())) {
								boolean wordExists = false;
								addWord = kb.nextLine();
								for(int i = 0; i < vocab_list.getVocabFromIndex(option5 - 1).getNumOfWords(); i++) {
									if(vocab_list.getVocabFromIndex(option5 - 1).getWord(i).equalsIgnoreCase(addWord)) {
										System.out.println("sorry, the word: '" + addWord + "' already exists");
										wordExists = true;
										break;
									}
								}
								if(!wordExists) {
									vocab_list.getVocabFromIndex(option5 - 1).getWordList().addAtEnd(addWord);
									System.out.println(addWord + " added to chosen topic");
								}
							}
							
						}
						
						else if(option.equals("r")) {
							System.out.println("Type a word and press Enter, or press Enter to end input:");
							String deleteWord = "random content";
							while(!(deleteWord.isEmpty())) {
								boolean wordExists = false;
								deleteWord = kb.nextLine();
								for(int i = 0; i < vocab_list.getVocabFromIndex(option5 - 1).getNumOfWords(); i++) {
									if(vocab_list.getVocabFromIndex(option5 - 1).getWord(i).equalsIgnoreCase(deleteWord)) {
										wordExists = true;
										vocab_list.getVocabFromIndex(option5 - 1).getWordList().delete(deleteWord);
										System.out.println(deleteWord + " deleted from chosen topic");
									}
								}
								if(!wordExists) {
									System.out.println("sorry, the word: '" + deleteWord + "' could not be found");
									wordExists = false;
									break;
								}
							}
						}
						
						else if(option.equals("c")) {
							String wordToChange = "random content";
							while(!(wordToChange.isEmpty())) {
								boolean wordExists = false;
								System.out.println("Type a word to change and press Enter, or press Enter to end input:");
								wordToChange = kb.nextLine();
								if(wordToChange.isEmpty()) {
									break;
								}
								for(int i = 0; i < vocab_list.getVocabFromIndex(option5 - 1).getNumOfWords(); i++) {
									if(vocab_list.getVocabFromIndex(option5 - 1).getWord(i).equalsIgnoreCase(wordToChange)) {
										wordExists = true;
										System.out.println("Enter the word to replace the previously typed word:");
										String newWord = kb.nextLine();
										vocab_list.getVocabFromIndex(option5 - 1).getWordList().changeWord(wordToChange, newWord);
										System.out.println(wordToChange + " changed to " + newWord);
										break;
									}
								}
								if(!wordExists) {
									System.out.println("sorry, the word: '" + wordToChange + "' could not be found");
									wordExists = false;
									break;
								}
							}
							
						}
						else if(option.equals("0")) {
							break;
						}
					}
				}
			}
			
			else if(choice == 6) {
				String wordToFind = "random content";
				kb.nextLine();
				while(!(wordToFind.isEmpty())) {
					boolean stop = false;
					System.out.print("------------------------------\r\n"
							+ "     Pick a word to find\r\n"
							+ "------------------------------\r\n"
							+ "Enter a word - Press Enter to stop: ");
							
							wordToFind = kb.nextLine();
					
							if(!(wordToFind.isEmpty())) {
								
								for(int i = 0; i < vocab_list.getSize() && !stop; i++) {
									for(int j = 0; j < vocab_list.getVocabFromIndex(i).getNumOfWords() && !stop; j++) {
										if(wordToFind.equalsIgnoreCase(vocab_list.getVocabFromIndex(i).getWord(j))) {
											System.out.println(vocab_list.getVocabFromIndex(i).getWord(j) + 
													" exists in topic " + vocab_list.getVocabFromIndex(i).getTopic());
											stop = true;
										}
									}
								}
								if(!stop) {
									System.out.println(wordToFind + " couldn't be found");
								}
							}
				}
			}
			
			/** option to load vocab objects from a file */
			else if(choice == 7) {
				String inputFileName;
				System.out.println("Enter the name of the input file: ");
				inputFileName = kb.next();
				
				try {
					BufferedReader fileRead = new BufferedReader(new FileReader(inputFileName));
					Scanner fileScan = new Scanner(new FileInputStream(inputFileName));
					
					String title = "";
					while(fileScan.hasNextLine()) {
						
						if((fileRead.read() == '#')) {
							title = fileScan.nextLine().substring(1);		// using the .substring(1) method so that the '#' is omitted from the Vocab title/topic
							vocab_list.addTopicToEnd(title);
							fileRead.readLine();
						}
						else {
							//store the word inside the SLL which is inside the Vocab class which is inside the DLL
							String word = fileScan.nextLine();
							vocab_list.addWordToEnd(word, title);
							fileRead.readLine();
						}
					}
					System.out.println("Done loading");
					fileRead.close();
				} 
				catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
				catch(IOException e) {
					System.out.println(e.getMessage());
				}
			}
			
			/** Shows all words in all topics that start with a given letter */
			else if(choice == 8) {
				System.out.println("Letter to display all words beginning with that letter: ");
				String letter = kb.next();
				
				ArrayList<String> result = vocab_list.wordsStartingWithSpecificLetter(letter);
				Collections.sort(result);
				System.out.println(result);
			}
			
			/** Saves the content in vocab_list to a given file */
			else if (choice == 9) {
				System.out.println("Enter the name of the file to save to: ");
				String fileToWriteTo = kb.next();
				try {
					PrintWriter fileOutput = new PrintWriter(new FileOutputStream(fileToWriteTo));
					fileOutput.print(vocab_list); 
					
					fileOutput.close();
				}
				catch(IOException e) {
					System.out.println(e.getMessage());
				}
				
			}
			
		}
		
		System.out.println("\nTerminating program...");
	}

}
