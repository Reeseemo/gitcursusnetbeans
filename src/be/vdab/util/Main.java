/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import static be.vdab.util.mens.Rijbewijs.A;
import static be.vdab.util.mens.Rijbewijs.B;
import static be.vdab.util.mens.Rijbewijs.BE;
import static be.vdab.util.mens.Rijbewijs.C;
import static be.vdab.util.mens.Rijbewijs.CE;
import be.vdab.voertuigen.Voertuig;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elvira.iskhakova
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws be.vdab.util.DatumException
     */
    public static void main(String[] args) throws DatumException {
        Datum datum = new Datum(1, 2, 3456);
        final int AANTAL_INZITTENDEN = 3;
        final int MAX_ZITPLAATSEN = 3;
        Mens BESTUURDER_BBECCE = new Mens("Ammelie", B, BE, C, CE);
        Mens INGEZETENE_A = new Mens("Anita");
        Mens INGEZETENE_B = new Mens("Bert");
        String datumString = "01/02/3456";
        
        
        Voertuig tv = new Voertuig("auto", datum, 18300, AANTAL_INZITTENDEN, BESTUURDER_BBECCE, INGEZETENE_A, INGEZETENE_B);
        System.out.println(tv.toString());
        
        Voertuig tv3 = new Voertuig("auto", datum, 18300, AANTAL_INZITTENDEN, BESTUURDER_BBECCE);
        System.out.println(tv3.toString());
        

        //     Mens m1 = new Mens("Andree", A, B);
        //        System.out.println(m1.toString());
        //        for (Object o : m1.getRijbewijs()){
        //        System.out.println(Arrays.toString(m1.getRijbewijs()));
        //        }
        //        try {
        //            Datum d1 = new Datum(22, 4, 1988);
        //
        //            System.out.println(d1.toString());
        //        } catch (DatumException ex) {
        //            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        //        }
        //        
        //        
    }

}
