package morseCode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException {
		// Create the morse code binary tree with input file
		FileInputStream inputFile = new FileInputStream("Morse_Code.txt");
		Scanner scanner = new Scanner(inputFile);
		Scanner scnr = new Scanner(System.in);
		MorseCode morseCode = new MorseCode();
		morseCode.loadMorseCode(scanner);
		
		// Get users message
		System.out.println("Enter the message you want to encode: ");
		String[] message = scnr.nextLine().trim().split(" ");
		
		
		// Encode and decode message
		String encodedMessage = morseCode.encodeText(message);
		String decodedMessage = morseCode.decodeText(encodedMessage);
		System.out.println("Encoded Message: " + encodedMessage.trim());
		System.out.println("Decoded Message: " + decodedMessage.trim());

		scnr.close();
		scanner.close();
		inputFile.close();
		
	}
}
