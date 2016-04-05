/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

/**
 *
 * @author elvira.iskhakova
 */
public enum Rijbewijs {
    A, B, BE("B+E"), C, CE("C+E"), D, DE("D+E");

    private String tekstvoorstelling;

    Rijbewijs() {
        tekstvoorstelling = super.toString();
    }

    Rijbewijs(String s) {
        tekstvoorstelling = s;
    }

    @Override
    public String toString() {
        return tekstvoorstelling;
    }

}



