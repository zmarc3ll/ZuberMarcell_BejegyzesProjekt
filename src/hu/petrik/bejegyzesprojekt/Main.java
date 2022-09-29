package hu.petrik.bejegyzesprojekt;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Bejegyzes> bejegyzesek1 = new ArrayList<>();
    private static List<Bejegyzes> bejegyzesek2 = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Adjon meg egy darabszámot! ");
        int darabszam=sc.nextInt();
        /*try {
            darabszam = sc.nextInt();
            System.out.println("Adjon meg egy természetes számot!");
            darabszam = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Adjon meg egy természetes számot!");
        } */
        while (darabszam < 0) {
            System.out.println("Adjon meg egy természetes számot!");
            darabszam = sc.nextInt();
        }
        Bejegyzes b;
        String szerzo;
        String tartalom;
        for (int i = 0; i < darabszam; i++) {
            System.out.println("Adjon meg egy szerzőt: ");
            szerzo=sc.nextLine();
            System.out.println("Adja meg a bejegyzése tartalmát: ");
            tartalom=sc.nextLine();
            b=new Bejegyzes(szerzo,tartalom);
            bejegyzesek1.add(b);
        }
    }
}
