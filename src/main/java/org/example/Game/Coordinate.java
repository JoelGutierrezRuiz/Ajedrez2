package org.example.Game;

public class Coordinate {

    private char letter;
    private int number;

    public Coordinate(char letter, int number) {
        this.letter = Character.toUpperCase(letter);
        this.number = number;
    }

    public Coordinate up() {
        return new Coordinate(letter, number - 1);
    }

    public Coordinate down() {
        return new Coordinate(letter, number + 1);
    }

    public Coordinate left() {
        return new Coordinate((char) (letter - 1), number);
    }

    public Coordinate right() {
        return new Coordinate((char) (letter + 1), number);
    }

    public char getLetter() {
        return letter;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Coordinate)) return false;
        Coordinate c = (Coordinate) o;
        return c.letter == letter && c.number == number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "(" + letter + "," + number + ")";
    }
}
