// Programmer: Russell Vanderveen
// class: CS 145 Hybrid
// Date: 1/29/2021
// Assignment: Lab #4 DeckOfCards
// Card.java
// Card class represents a playing Card

public class Card {
    private final String face; //face o card ("Ace", "Deuce", ...)
    private final String suit; // suit of card ("Hearts", "diamonds", etc)

    // two-argument constructor initializes card's face and suit
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace; // initialize face of card
        this.suit = cardSuit; // initialize suit of card
    } // end of Card constructor

    // return String representation of Card
    public String toString(){
        return face + " of " + suit;
    }// end of toString method
}// end of class Card
