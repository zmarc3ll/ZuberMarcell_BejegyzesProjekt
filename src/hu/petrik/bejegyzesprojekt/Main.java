package hu.petrik.bejegyzesprojekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Bejegyzes> bejegyzesek1 = new ArrayList<>();
    private static List<Bejegyzes> bejegyzesek2 = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Adjon meg egy darabszámot! ");
        int darabszam = sc.nextInt();
        while (darabszam < 0) {
            System.out.println("Adjon meg egy természetes számot!");
            darabszam = sc.nextInt();
        }
    }
}
