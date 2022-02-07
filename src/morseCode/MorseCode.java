package morseCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MorseCode {
	//Data Fields
	
		public BTNode morseTreeRoot;
		public ArrayList<BTNode> morseCodeData;
		private BTNode findNode;
		
		//Constructor
		
		public MorseCode() {
			morseTreeRoot = new BTNode();
			morseCodeData = new ArrayList<BTNode>();
			findNode = null;
			
		}
		
		//Methods
		
		/**
		 * All morse code letters from file Morse_Code.txt are added into an ArrayList
		 * @param scanner: reads in the input file
		 * @throws IOException
		 */
		public void loadMorseCode(Scanner scanner) throws IOException {
			BTNode node;
			while(scanner.hasNext()) {
				String temp = scanner.nextLine().trim();
				char letter = temp.charAt(0);
				String code = temp.substring(1);
				node = new BTNode(letter, code);
				morseCodeData.add(node);
			}
			createMorseTree(morseCodeData);
		}

		/**
		 * Creates a morse code binary tree 
		 * @param list: array list storing all the binary tree nodes
		 */
		public void createMorseTree(ArrayList<BTNode> list) {
			// Goes through the list of letters & corresponding code
			for (BTNode node : list) {
				BTNode currentNode = morseTreeRoot; 
				String morse = node.getCode();
				char letter = node.getLetter();
				
				// Go through each value of the morse code to find path
				for (int i = 0; i < morse.length(); i++) {
					
					// If character is '.' go to the left
					if (morse.charAt(i) == '.') {
						
						// If the next left node is null add new node
						if (currentNode.getLeft() == null) {
							BTNode leftNode = new BTNode();
							currentNode.setLeft(leftNode);
							
							// if last character in morse code then add to tree
							if (i == morse.length() - 1) {
								leftNode.setCode(morse); 
								leftNode.setLetter(letter);
							}			
							
							// else set the current node to the next left node
							else { currentNode = leftNode; }
						}
						else {	// if last character in morse code then add to tree
							if (i == morse.length() - 1) {
								currentNode.getLeft().setCode(morse);
								currentNode.getLeft().setLetter(letter);
							}
							else currentNode = currentNode.left;
						}
					}
					// If character is '-' go to the right
					if (morse.charAt(i) == '-') {
						
						// If the next right node is null add new node
						if (currentNode.getRight() == null) {
							BTNode rightNode = new BTNode();
							currentNode.setRight(rightNode);
							
							// if last character morse code then add to tree
							if (i == morse.length() - 1) { 
								rightNode.setCode(morse); 
								rightNode.setLetter(letter);
							}
							
							// else set the current node ot the next left node
							else { currentNode = rightNode; }
						}
						else {	// if last character in morse code then add to tree
							if (i == morse.length() - 1) { 
								currentNode.getRight().setCode(morse);
								currentNode.getRight().setLetter(letter);							
							}
							else currentNode = currentNode.right;
						}
					}
				}
			}
		}
		
		/**
		 * Finds a node in the morse tree based on a char letter
		 * sets variable findNode to the morse tree's found node's value
		 * @param current: current node of the morse tree (initially root)
		 * @param letter: target letter to be found in morse code tree
		 */
		private void find(BTNode current, char letter) {
			if(current == null) { return; }
			
			if(current.letter == letter) { 
				findNode = current;
				return;
			}
			
			find(current.left, letter);
			find(current.right, letter);
			
		}
		
		/**
		 * Returns strings morse code equivalent
		 * @param input: user string to be encoded
		 * @return: morse code encoded string
		 */
		public String encodeText(String[] input) {
			BTNode current = morseTreeRoot;
			String result = "";
			char letter;
			
			for (int i = 0; i < input.length; i++) {
				for (int j = 0; j < input[i].length(); j++) {
					letter = input[i].charAt(j);
					find(current, letter);
					result = result + findNode.morseCode + " ";
				}
				result = result + "    ";
			}
			return result;
		}

		/**
		 * Returns decoded string
		 * @param input: morse code string to be decoded
		 * @return: decoded string
		 */
		public String decodeText(String input) {
				String setter = "";
				StringBuilder result = new StringBuilder("");
				BTNode current = morseTreeRoot;
				
				for(int i = 0; i < input.length(); i++) {
					setter = input.substring(i, i + 1);
					if (setter.equals(".")) {
						if (current.getLeft() != null) {
							current = current.getLeft();
						} else {
							current.setLeft(new BTNode());
							current = current.getLeft();
						}
					}
					else if (setter.equals("-")) {
						if (current.getRight() != null) {
							current = current.getRight();
						} else {
							current.setRight(new BTNode());
							current = current.getRight();
						}
					}
					else {
						result = result.append(current.getLetter());
						current = morseTreeRoot;
					}
				}
				result = result.append(current.getLetter());
				
				return result.toString();
		}
}
