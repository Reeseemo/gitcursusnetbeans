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
     */
    public static void main(String[] args) {

     Mens m1 = new Mens("Andree", A, B);
        System.out.println(m1.toString());
        for (Object o : m1.getRijbewijs()){
        System.out.println(Arrays.toString(m1.getRijbewijs()));
        }
        
        

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
