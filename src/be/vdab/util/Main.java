/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import be.vdab.util.mens.Mens;
import static be.vdab.util.mens.Rijbewijs.B;
import static be.vdab.util.mens.Rijbewijs.BE;
import static be.vdab.util.mens.Rijbewijs.C;
import static be.vdab.util.mens.Rijbewijs.CE;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Vrachtwagen;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import java.util.TreeSet;

/**
 *
 * @author elvira.iskhakova
 */
public class Main {

    public static void main(String[] args) throws DatumException, VolumeException, FileNotFoundException {
        TreeSet<Voertuig> vset = new TreeSet<>();
        TreeSet<Voertuig> vset2 = new TreeSet<>(Voertuig.getAankoopprijsComparator());
        TreeSet<Voertuig> vset3 = new TreeSet<>(Voertuig.getMerkComparator());
        TreeSet<Voertuig> vset4 = new TreeSet<>();

        Datum datum = new Datum(1, 2, 3456);
        Mens BESTUURDER_BBECCE = new Mens("Ammelie", B, BE, C, CE);
        Volume VOLUME10 = new Volume(10, 10, 10, Maat.decimeter);
        Personenwagen v1 = new Personenwagen("Fiat", datum, 21000, 4, Color.RED, BESTUURDER_BBECCE);
        Personenwagen v2 = new Personenwagen("Toyota", datum, 18000, 5, Color.BLACK, BESTUURDER_BBECCE);
        Pickup v3 = new Pickup("Cadilac", datum, 21000, 5, Color.DARK_GRAY, VOLUME10, BESTUURDER_BBECCE);
        Pickup v4 = new Pickup("Toyota", datum, 19000, 5, Color.ORANGE, VOLUME10, BESTUURDER_BBECCE);
        Vrachtwagen v5 = new Vrachtwagen("Man", datum, 68000, 3, VOLUME10, 7500, 2, BESTUURDER_BBECCE);
        Vrachtwagen v6 = new Vrachtwagen("Scania", datum, 58000, 3, VOLUME10, 20000, 2, BESTUURDER_BBECCE);

        vset.add(v1);
        vset.add(v2);
        vset.add(v3);
        vset.add(v4);
        vset.add(v5);
        vset.add(v6);

        vset2.addAll(vset);
        vset2 = (TreeSet) vset2.descendingSet();
        vset3.addAll(vset);

        System.out.println("Natural:");
        for (Voertuig v : vset) {
            System.out.println(v);
        }

        System.out.println("\nAankoopprijs in omgekeerde volgorde:");
        for (Voertuig v : vset2) {
            System.out.println(v);
        }

        System.out.println("\nMerk:");
        for (Voertuig v : vset3) {
            System.out.println(v);
        }

        try (FileOutputStream fos = new FileOutputStream("F:\\Main\\JPF\\AutoWorld\\wagenpark.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            for (Voertuig v : vset3) {
                oos.writeObject(v);
            }
        } catch (IOException e) {
        }
        try (FileInputStream fis = new FileInputStream("F:\\Main\\JPF\\AutoWorld\\wagenpark.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            while (true) {
                vset4.add((Voertuig) ois.readObject());
            }

        } catch (ClassNotFoundException | IOException e) {
        }

        System.out.println("\nIngelezen set:");
        for (Voertuig v : vset4) {
            System.out.println(v);
        }
    }

}
