// Programmer: Russell Vanderveen
// class: CS 145 Hybrid
// Date: 1/29/2021
// Assignment: Lab #4 DeckOfCards
// This program will construct an interactive SlapJack card game
// for extra credit, see lines 20-24 for switch/case
// for extra credit, see lines 35 for printf

import java.util.*;

public class main {
    public static void main(String[] args) {
        startMenu();
    }// end of main

    //this method creates an opening menu
    public static void startMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("welcome to SlapJack!");
        System.out.println("Please select an option");
        System.out.println("[A] instructions [B] play SlapJack [C] quit");
        char choice = input.next().charAt(0);
        switch (choice) {
            case 'A' -> instructions();
            case 'B' -> playGame(input);
            case 'C' -> gameEnd();
            default -> {
                System.out.println("invalid option, please select again");
                startMenu();
            }
        }// end of switch/case
    }// end of startMenu

    //this method gives the user instructions to the game
    public static void instructions(){
        System.out.printf("%s", "SlapJack is a simple card game. " +
                "Each player receives 5 cards from\n" +
                "the deck facing down. Each turn, a player will " +
                "choose a card from their hand and\n" +
                "place (slap) it in the center facing up, if the card is " +
                "not a Jack, this process is\n" +
                "repeated. The goal of the game is to be the first " +
                "player to find a Jack. Once a \n" +
                "Jack is found and placed (slapped), the game is finished " +
                "with the finding player winning the game.\n");
        System.out.println();
        startMenu();
    }// end of instructions

    //this method creates the SlapJack game
    public static void playGame(Scanner input){
        DeckOfCards myDeckOfCards = new DeckOfCards();
        String[] player = new String[5];// player's hand
        String[] opponent = new String[5];// opponent's hand
        String currentCard = "";// placeholder for player's hand
        Scanner input2 = new Scanner(System.in);
        myDeckOfCards.shuffle(); //shuffles deck
        Stack<String> cardDeck = new Stack<String>();// stack for deck of cards

        for(int i = 1; i <= 52; i++) {//populates stack with deck
           cardDeck.add(String.valueOf(myDeckOfCards.dealCard()));
        }// end of for loop

        for(int i = 0; i <=4; i++){//populates player's hand from stack
            player[i] = cardDeck.pop();
            opponent[i] = cardDeck.pop();
        }// end of for loop

        System.out.println("what card you like to put down?");
        System.out.println("[1] [2] [3] [4] [5]");
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> {// first card in hand
                System.out.println(player[0]);
                currentCard = player[0];
                player[0] = cardDeck.pop();
            }// end of case 1
            case 2 -> {// second card in hand
                System.out.println(player[1]);
                currentCard = player[1];
                player[1] = cardDeck.pop();
            }// end of case 2
            case 3 -> {// third card in hand
                System.out.println(player[2]);
                currentCard = player[2];
                player[2] = cardDeck.pop();
            }// end of case 3
            case 4 -> {// fourth card in hand
                System.out.println(player[3]);
                currentCard = player[3];
                player[3] = cardDeck.pop();
            }// end of case 4
            case 5 -> {// fifth card in hand
                System.out.println(player[4]);
                currentCard = player[4];
                player[4] = cardDeck.pop();
            }// end of case 5
            default -> {
                System.out.println("invalid choice, pick again");
                System.out.println();
                playGame(input);
            }// end of default
        }// end of switch/case

        System.out.println("SlapJack? (yes/no)");
        String ask = input2.nextLine();

        switch(ask) {
            case "yes":
                if (currentCard.charAt(0) == 'J') {
                    System.out.println("you won!");
                    System.out.println("returning to menu");
                    System.out.println();
                    startMenu();
                } else {
                    System.out.println("not a jack, keep playing");
                    opponentsTurn(opponent, cardDeck, input);
                    playGame(input);
                }// end of if/else
                break;
            case "no":
                opponentsTurn(opponent, cardDeck, input);
                playGame(input);
                break;
            default:
                System.out.println("invalid selection, you missed your chance to slap");
                opponentsTurn(opponent, cardDeck, input);
                playGame(input);
        }// end of switch case
    }// end of playGame

    //this method acts as a Non-Playable Character (NPC) opponent
    public static void opponentsTurn(String[] opponent, Stack<String> cardDeck,
        Scanner input) {
        Random rand = new Random();
        String opponentCard = "";
        int opponentChoice = rand.nextInt(5)+1;

        switch (opponentChoice) {
            case 1 -> {// first card in opponent's hand
                System.out.println(opponent[0]);
                opponentCard = opponent[0];
                opponent[0] = cardDeck.pop();
            }// end of case 1
            case 2 -> {// second card in opponent's hand
                System.out.println(opponent[1]);
                opponentCard = opponent[1];
                opponent[1] = cardDeck.pop();
            }// end of case 2
            case 3 -> {// third card in opponent's hand
                System.out.println(opponent[2]);
                opponentCard = opponent[2];
                opponent[2] = cardDeck.pop();
            }// end of case 3
            case 4 -> {// fourth card in opponent's hand
                System.out.println(opponent[3]);
                opponentCard = opponent[3];
                opponent[3] = cardDeck.pop();
            }// end of case 4
            case 5 -> {// fifth card in opponent's hand
                System.out.println(opponent[4]);
                opponentCard = opponent[4];
                opponent[4] = cardDeck.pop();
            }// end of case 5
        }// end of switch/case

        if (opponentCard.charAt(0) == 'J') {
            System.out.println("your opponent won!");
            System.out.println("returning to menu");
            System.out.println();
            startMenu();
        } else {
            System.out.println("your opponent did not find a jack");
            System.out.println();
            playGame(input);
        }// end of if/else
    }// end of opponent

    //this method ends the game
    public static void gameEnd(){
        System.out.println();
        System.out.println("shutting down");
        System.out.println("Thanks for playing SlapJack!");
    }// end of gameEnd
}// end of main class
