package hu.petrik.bejegyzesprojekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Bejegyzes> bejegyzesek1 = new ArrayList<>();
    private static List<Bejegyzes> bejegyzesek2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {

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
        bejegyzesFajlbol("bejegyzesek.csv");

        double likeokSzama=Math.random()*bejegyzesek1.size();
        for (int i = 0; i < bejegyzesek1.size()*20; i++) {
           //bejegyzesek1[likeokSzama].likeok.like;
        }

        System.out.println("Adjon meg egy szöveget: ");
        String egySzoveg=sc.nextLine();
        //bejegyzesek1[1].szoveg=egySzoveg;

    }
    private static void bejegyzesFajlbol(String fajlNev) throws IOException {
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null && !sor.equals("")) {
            String[] adatok = sor.split(";");
            Bejegyzes b2 = new Bejegyzes(adatok[0], adatok[1]);
            bejegyzesek1.add(b2);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }
}
