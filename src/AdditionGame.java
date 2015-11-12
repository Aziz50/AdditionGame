import java.util.Scanner;

public class AdditionGame {

//Defining Varialbes or globals
	
	public static int number1;
	public static int number2;
	public static int hardness = 10;
	public static int score;
	public static int input1;
	public static int CorrectAnswer;
	
	public static void main(String[] args) {
		//Call the addition game
		additionGameMethod();
	}//End main

	public static void additionGameMethod() {
		//State game name and rules
		System.out.println ("Welcome to the addition game. Let's start! ");
		System.out.println ("For every correct answer you will get 2 points and for every incorrect answer -1 points.");
				
		for(int i=0;i<4;i=i+1){ //Generates Question
			randomMathProblem();
			
			System.out.println("\nRound #" + (i + 1)); //Outputs the current round in session
			System.out.println("Add these two numbers " + number1 + " + " + number2 + "?"); // Puts question to the user
			Scanner input = new Scanner(System.in); //User inputs the answer here
			
			 do {
				 while (!input.hasNextInt()) {
			           System.out.println("That's not a number! Please enter a number.");
			           input.next(); //User enters a numeric variable
			        }
				 input1 = input.nextInt(); // this is important!
			} while (input1 <= 0);
			 isAnswerCorrect(); //This checks the answer, depending upon the answer it outputs the designated text and answer.
		}//Loop end
		
//Final Results of the current session
		System.out.println ("\nGAME OVER \n");
		System.out.println ("Your final score is : " + score);
	}//End additionGameMethod
	
	public static int randomMathProblem(){
		int result = 0;
		number1 = randomNumber();
		number2 = randomNumber();
		CorrectAnswer = number1 + number2; 
	return result;
	}//End randomNumber
	
	public static int randomNumber(){
		int generatedNumber = (int)(Math.random()*hardness);
		return generatedNumber;
	}//End randomNumber
	
	public static void isAnswerCorrect(){
				if (input1 == CorrectAnswer){
					System.out.println("The answer was correct.");
					System.out.println("\n (+2 Points) Good Job! Difficulity level increased.");
					hardness *= 10;
					score += 2;
					System.out.println("Score: " + score);
					//return;
				}else{
					System.out.println("The answer was incorrect.");
					System.out.println("\n1 point removed and difficulty decreased.");
					if (hardness <= 10){
						hardness = 10;
					}else{
						hardness /= 10;
					}
					score -= 1;
					System.out.println("Score: "+ score);
					System.out.println("To play again! Please run the code again.");
					
					//return
				}//End IF statement
	}//End isAnswerCorrect
}//End main