import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		

		Scanner input = new Scanner(System.in);

		
		String guessWord = ("test"); 
		guessWord = guessWord.trim(); 
		guessWord = guessWord.replaceAll(" ", "  ");
		guessWord = guessWord.toUpperCase();
		String guessWord1 = guessWord.replaceAll("[A-Z]", "_ ");
		
		
		

		int attempts = 0;
		int incorrect = 0;
		String guess;
		char letter;
		boolean guessescontainsguess;
		String guesses = "";
		boolean phrasecontainsguess;

	

		while (incorrect < 5 && guessWord1.contains("_")) {

			System.out.println(guessWord1);
			System.out.print("\n");
			System.out.println("You have " + incorrect + " incorrect guesses so far.");
			System.out.print("\n");
			if (incorrect == 1) { 
				System.out.println("         ____________");
				System.out.println("        |      |     |");
				System.out.println("        |      O     |");
				System.out.println("        |            |");
				System.out.println("        |            |");
				System.out.println("       	|            |");
				System.out.println("         ____________");
				System.out.print("\n");
			} else if (incorrect == 2) { 
				System.out.println("         ____________");
				System.out.println("        |      |     |");
				System.out.println("        |      O     |");
				System.out.println("        |      |     |");
				System.out.println("        |            |");
				System.out.println("       	|            |");
				System.out.println("         ____________");
				System.out.print("\n");
			} else if (incorrect == 3) { 
				System.out.println("         ____________");
				System.out.println("        |      |     |");
				System.out.println("        |      O     |");
				System.out.println("        |     -|-    |");
				System.out.println("        |            |");
				System.out.println("       	|            |");
				System.out.println("         ____________");
				System.out.print("\n");
			} else if (incorrect == 4) { 
				System.out.println("         ____________");
				System.out.println("        |      |     |");
				System.out.println("        |      O     |");
				System.out.println("        |     -|-    |");
				System.out.println("        |      |     |");
				System.out.println("       	|            |");
				System.out.println("         ____________");
				System.out.print("\n");
			}

			System.out.println("Guess a letter:");
			guess = input.nextLine(); 
			guess = guess.toUpperCase(); 
			letter = guess.charAt(0); 

			guessescontainsguess = (guesses.indexOf(letter)) != -1;
			guesses += letter; 

			letter = Character.toUpperCase(letter); 
			System.out.print("\n");
			if (guessescontainsguess == true) { 
				System.out.println("You already guessed " + letter + ".");
				System.out.print("\n");
				if (incorrect > 0) { 
					incorrect--;
				} 

			} 

			phrasecontainsguess = (guessWord.indexOf(letter)) != -1;
			if (phrasecontainsguess == true) { 
				System.out.println(letter + " is in the word.");
				System.out.print("\n");
				for (int position = 0; position < guessWord.length(); position++) { 
					if (guessWord.charAt(position) == letter && guessWord.charAt(position) != letter) {
						
						guessWord1 = guessWord1.replaceAll("_ ", "_");
						String guessWord2;
						guessWord2 = guessWord1.substring(0, position) + letter + guessWord1.substring(position + 1);
						guessWord2 = guessWord2.replaceAll("_", "_ ");
						guessWord1 = guessWord2;
					} 
				} 
			} else { 
				System.out.print("\n");
				System.out.println(letter + " is in not the word."); 
				System.out.print("\n");
				incorrect++; 
			}

			attempts++; 

		} 

		if (incorrect == 5) { 
			System.out.println("         ____________");
			System.out.println("        |      |     |");
			System.out.println("        |      O     |");
			System.out.println("        |     -|-    |");
			System.out.println("        |      |     |");
			System.out.println("       	|     / \\   |");
			System.out.println("         ____________");
			System.out.print("\n");
			System.out.println("GAME OVER!");
		} else {

			System.out.println("The word is:"); 
			System.out.println(guessWord1);
			System.out.println("Congratz, you won!");
		}

		input.close();  
	}

}


