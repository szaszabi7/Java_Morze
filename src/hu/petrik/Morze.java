package hu.petrik;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Morze {
    private HashMap<String, String> betubol;
    private HashMap<String, String> morzebol;

    public Morze() {
        this.betubol = new HashMap<>();
        this.morzebol = new HashMap<>();
        beolvas();
        //kiir();
        System.out.printf("3. feladat: A morze abc %d db karakter kódját tartalmazza\n", betubol.size());
        benneVanE();
        Idezet i = new Idezet();
    }

    private void beolvas(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("morzeabc.txt"));
            String sor = br.readLine();
            sor = br.readLine();
            while (sor != null) {
                String[] st = sor.split("\\t");
                String betu = st[0];
                String morze = st[1];

                betubol.putIfAbsent(betu, morze);
                morzebol.putIfAbsent(morze, betu);

                sor = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private void kiir() {
        for (Map.Entry<String, String> entry: betubol.entrySet()) {
            System.out.printf("%-6s%s%n", entry.getKey(), entry.getValue());
        }
        System.out.println();
        for (Map.Entry<String, String> entry: betubol.entrySet()) {
            System.out.printf("%-8s%s%n", entry.getValue(), entry.getKey());
        }
    }

    public void benneVanE() {
        Scanner sc = new Scanner(System.in);
        System.out.print("4. feladat: Kérek egy karaktert: ");
        String karakter = sc.nextLine().toUpperCase();
        if (betubol.containsKey(karakter)) {
            System.out.printf("\t\tA(z) %s karakter morze kódja: %s\n", karakter, betubol.get(karakter));
        } else {
            System.out.println("\t\tNem található a kódtárban ilyen karakter!");
        }
    }
}
