/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author elvira.iskhakova
 */
public class Mens implements Comparable<Mens> {

    String naam;
    Rijbewijs r1;
    Set<Rijbewijs> rijbewijzen = new HashSet<>();

    public Mens(String naam, Rijbewijs... rb) {
        this.naam = naam;
        if (rb.length >= 1) {
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

    public Object[] getRijbewijs() {
        Object[] arr1 = rijbewijzen.toArray();
        return arr1;
    }

    @Override
    public String toString() {
        List sortedList = new ArrayList(rijbewijzen);
        Collections.sort(sortedList);

        StringBuilder sb1 = new StringBuilder(naam);

        if (sortedList.size() > 0) {
            sb1.append(sortedList);
            sb1.setCharAt(sb1.toString().indexOf('['), '(');
            sb1.setCharAt(sb1.toString().indexOf(']'), ')');
        }
        return sb1.toString();

    }

}
