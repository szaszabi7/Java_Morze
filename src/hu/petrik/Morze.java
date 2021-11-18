package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Morze {
    private HashMap<String, String> betubol;
    private HashMap<String, String> morzebol;

    public Morze() {
        this.betubol = new HashMap<>();
        this.morzebol = new HashMap<>();
        beolvas();
        //kiir();
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
}
