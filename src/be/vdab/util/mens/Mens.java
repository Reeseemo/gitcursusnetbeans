/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author elvira.iskhakova
 */
public class Mens implements Serializable, Comparable<Mens> {

    String naam;
    Rijbewijs r1;
    Set<Rijbewijs> rijbewijzen = new TreeSet<>();
    

    public Mens(String naam, Rijbewijs... rb) {
        this.naam = naam;
        if (rb.length > 0) {
            rijbewijzen.addAll(Arrays.asList(rb));
        } 
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public int compareTo(Mens m) {
        return naam.compareTo(m.getNaam());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.naam);
        hash = 53 * hash + Objects.hashCode(this.rijbewijzen);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mens other = (Mens) obj;
        if (!Objects.equals(this.naam, other.naam)) {
            return false;
        }
        if (!Objects.equals(this.rijbewijzen, other.rijbewijzen)) {
            return false;
        }
        return true;
    }

    public Rijbewijs[] getRijbewijs() {
        return rijbewijzen.toArray(new Rijbewijs[rijbewijzen.size()]);
    }

    @Override
    public String toString() {
        StringBuilder sb1 = new StringBuilder(naam);
        if (rijbewijzen.size() > 0) {
            sb1.append(rijbewijzen);
            sb1.setCharAt(sb1.toString().indexOf('['), '(');
            sb1.setCharAt(sb1.toString().indexOf(']'), ')');
        }
        return sb1.toString();
    }
    
}
