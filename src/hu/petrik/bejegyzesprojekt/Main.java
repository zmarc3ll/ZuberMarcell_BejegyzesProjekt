package hu.petrik.bejegyzesprojekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.util.Objects.isNull;

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
        sc.close();

        Random rnd=new Random();

        int likeokSzama;
        for (int i = 0; i < bejegyzesek1.stream().count()*20; i++) {
            likeokSzama = rnd.nextInt((int)bejegyzesek1.stream().count());
            bejegyzesek1.get(likeokSzama).like();
        }

        Scanner scc = new Scanner(System.in);
        System.out.println("Adjon meg egy szöveget: ");
        String bekertSzoveg = scc.nextLine();
        bejegyzesek1.get(1).setTartalom(bekertSzoveg);
        scc.close();


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

        for (Bejegyzes b2 : bejegyzesek1){
            System.out.println(b2);
        }
        int legtobbLike = 0;
        for (Bejegyzes b : bejegyzesek1){
            if (b.getLikeok() > legtobbLike){
                legtobbLike = b.getLikeok();
            }
        }
        System.out.println("A legtöbb like: " + legtobbLike);

        Bejegyzes tobbMint35 = null;
        for (Bejegyzes b : bejegyzesek1){
            if (b.getLikeok() > 35){
                tobbMint35 = b;
            }
        }
        System.out.println(isNull(tobbMint35) ? "Nincs olyan bejegyzés, mely több, mint 35 likeot kapott"
                : tobbMint35);

        int kevesebbMint15 = 0;
        for (Bejegyzes b : bejegyzesek1){
            if (b.getLikeok() < 15){
                kevesebbMint15++;
            }
        }
        System.out.println(kevesebbMint15 + " bejegyzés kapott kevesebb, mint 15 likeot");



    }
}
