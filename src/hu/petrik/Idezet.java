package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Idezet {
    private String szerzo;
    private String idezet;
    private List<Idezet> adatok;

    public Idezet(String szerzo, String idezet) {
        this.szerzo = szerzo;
        this.idezet = idezet;
    }

    public Idezet() {
        beolvasSzoveg();
        kiir();
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getIdezet() {
        return idezet;
    }

    private void beolvasSzoveg(){
        adatok = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("morze.txt"));
            String sor = br.readLine();
            while (sor != null) {
                String[] st = sor.split(";");
                adatok.add(new Idezet(st[0].toString(), st[1].toString()));

                sor = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void kiir() {
        for (Idezet item: adatok) {
            System.out.println(item.getSzerzo());
        }
    }
}
