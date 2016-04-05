/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author elvira.iskhakova
 */
public final class Datum implements Serializable, Comparable<Datum> {

    private final int dag;
    private final int maand;
    private final int jaar;

    public Datum(int dag, int maand, int jaar) throws DatumException {

        if (jaar >= 1583 && jaar <= 4099) {
            this.jaar = jaar;
        } else {
            throw new DatumException("Ongeldig jaar");
        }

        if (maand >= 1 && maand <= 12) {
            this.maand = maand;
        } else {
            throw new DatumException("Ongeldige maand");
        }

        if (dag >= 1 && dag <= 31) {
            if (Arrays.asList(1, 3, 5, 7, 8, 10, 12).contains(maand)) {
                this.dag = dag;

            } else if ((dag <= 30) && (Arrays.asList(4, 6, 9, 11).contains(maand))) {
                this.dag = dag;

            } else if ((dag <= 28 && maand == 2)
                    || ((dag == 29) && (((jaar % 4 == 0) && (jaar % 100 != 0)) || (jaar % 400 == 0)))) {
                this.dag = dag;

            } else {
                throw new DatumException("Ongeldige dag");
            }
        } else {
            throw new DatumException("Ongeldige dag");
        }

    }

    public int getDag() {
        return dag;
    }

    public int getMaand() {
        return maand;
    }

    public int getJaar() {
        return jaar;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dag, maand, jaar);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.jaar);
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
        final Datum other = (Datum) obj;
        if (this.dag != other.dag) {
            return false;
        }
        if (this.maand != other.maand) {
            return false;
        }
        if (this.jaar != other.jaar) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Datum o) {
        if (jaar < o.getJaar()) {
            return -1;
        } else if (jaar > o.getJaar()) {
            return 1;
        }
        if (maand < o.getMaand()) {
            return -1;
        } else if (maand > o.getMaand()) {
            return 1;
        }
        if (dag < o.getDag()) {
            return -1;
        } else if (dag > o.getDag()) {
            return 1;
        }
        return 0;
    }

}
