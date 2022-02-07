package morseCode;

public class BTNode {
	// Data fields
    public String morseCode;
    public char letter;
    public BTNode left, right;
    
    // Constructors
    public BTNode() {
    	left = null;
    	right = null;
    }
    
    public BTNode(char letterVal, String morseVal) { 
    	letter = letterVal;
    	morseCode = morseVal; 
    	left = null;
    	right = null;
    }
    
    public BTNode(char letterVal, String morseVal, BTNode leftChild, BTNode rightChild) {
        letter = letterVal;
        morseCode = morseVal;
        left = leftChild;
        right = rightChild;
    }
    
    // Getters
    
    public char getLetter() { return letter; }
    public String getCode() { return morseCode; }
    public BTNode getLeft() { return left; }
    public BTNode getRight() { return right; }
    
    // Setters
    
    public void setLetter(char letterVal) { letter = letterVal; }
    public void setCode(String codeVal) { morseCode = codeVal; }
    public void setLeft(BTNode leftChild) { left = leftChild; }
    public void setRight(BTNode rightChild) { right = rightChild; }
	

}
