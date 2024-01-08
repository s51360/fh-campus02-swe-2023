package at.campus02.swe.Uebung1_Modulo;

import java.util.Scanner;

public class Modulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Gib den Wert für zahl1 ein: ");
        int zahl1 = scanner.nextInt();

        System.out.print("Gib den Wert für zahl2 ein: ");
        int zahl2 = scanner.nextInt();

        int ergebnis = zahl1 % zahl2; // Modulo-Operation

        System.out.println("Der Rest der Division von " + zahl1 + " durch " + zahl2 + " ist: " + ergebnis);

        scanner.close();
    }
}
