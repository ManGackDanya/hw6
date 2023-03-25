package Project_Bugiman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Boogeyman {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\ProjectIT\\Words.txt");
        Scanner scanner = new Scanner(file);
        List<String> Wordlist = new ArrayList<>();
        Random random = new Random();
        List<Character> player_guesses = new ArrayList<>();
        Scanner keyBoard = new Scanner(System.in);

        while (scanner.hasNext()){
            Wordlist.add(scanner.nextLine());
        }

        String random_word = Wordlist.get(random.nextInt(Wordlist.size()));

        System.out.println(random_word);

        int wrongCount = 0;

        int x = 1;

        while (true){

            printBoogieMan(wrongCount);

            if(wrongCount>=6){
                System.out.println("YOU LOOSE!");
            }

            printWordState(random_word,player_guesses);

            getPlayerGuess(keyBoard,random_word,player_guesses);

            if(!getPlayerGuess(keyBoard, random_word, player_guesses)) {
                wrongCount++;
            }

            if(printWordState(random_word,player_guesses)){
                System.out.println("Okey. You won");
                break;
            }

            System.out.println("Is it your last guess?");

            if(keyBoard.nextLine().equals(random_word)){
                System.out.println("You have won! Congratulations");
                break;
            }else {
                System.out.println("Your guess is wrong. U can try again");
            }
        }
    }

    public static void printBoogieMan(Integer wrongCount){
        if(wrongCount >= 1){
            System.out.println(" O");
        }
        if(wrongCount >= 2){
            System.out.print("\\ ");
            if(wrongCount >= 3){
                System.out.println("/");
            }
            else {
                System.out.println("");
            }
        }
        if(wrongCount >= 4){
            System.out.println(" |");
        }
        if(wrongCount >= 5){
            System.out.print("/ ");
            if(wrongCount >= 6){
                System.out.println("\\");
            }
            else {
                System.out.println("");
            }
        }
    }

    public static boolean getPlayerGuess(Scanner keyBoard, String random_word, List<Character> player_guesses){
        System.out.println("Please add letter");
        String letter_guess = keyBoard.nextLine();
        player_guesses.add(letter_guess.charAt(0));
        return random_word.contains(letter_guess);
    }

    public static boolean  printWordState(String random_word, List<Character> player_guesses){

        int correctCount = 0;

        for(int i = 0; i < random_word.length(); i++){
            if(player_guesses.contains(random_word.charAt(i))){
                System.out.print(random_word.charAt(i));
                correctCount++;
            }else{
                System.out.print("_ ");
            }
        }
        System.out.println();
        return (random_word.length()==correctCount);
    }
}