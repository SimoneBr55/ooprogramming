package org.nbicocchi.objectoriented.exercises;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementare una classe Rational che rappresenta un numero razionale in
 * maniera esatta.
 * <p>
 * Il costruttore accetta numeratore e denominatore. Se il denominatore è
 * negativo,viene lanciata una eccezione.
 * <p>
 * Il metodo plus()prende un altro Rational x come argomento e restituisce la
 * somma di this e x. Il metodo times()prende un altro Rational x come argomento
 * e restituisce il prodotto di this e x.
 * <p>
 * La classe Rational deve inoltre implementare l’interfaccia
 * Comparable<Rational>, in base al normale ordinamento tra
 * razionali(crescente).
 * <p>
 * Fornire infine la classe di metodo main dimostrativo.
 *
 * @author Nicola Bicocchi
 */

public class Rational implements Comparable<Rational> {
    int numerator;
    int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational plus(Rational o) {
        int num = this.numerator * o.denominator + o.numerator * this.denominator;
        int den = this.denominator * o.denominator;
        return new Rational(num, den);
    }

    public Rational times(Rational o) {
        int num = this.numerator * o.numerator;
        int den = this.denominator * o.denominator;
        return new Rational(num, den);
    }

    @Override
    public int compareTo(Rational o) {
        return Double.compare(numerator / (double) denominator, o.numerator / (double) o.denominator);
    }

    @Override
    public String toString() {
        return "Rational{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    public static void main(String[] args) {
        // Rational r4 = new Rational(1, 0);
        ArrayList<Rational> l = new ArrayList<>();
        l.add(new Rational(1, 3));
        l.add(new Rational(1, 9));
        l.add(new Rational(1, 2).plus(new Rational(1, 2)));
        l.add(new Rational(1, 2).times(new Rational(1, 2)));

        System.out.println(l);
        Collections.sort(l);
        System.out.println(l);
    }
}
