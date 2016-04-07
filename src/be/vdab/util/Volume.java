/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author elvira.iskhakova
 */
public class Volume implements Serializable, Comparable<Volume> {

    private final int HOOGTE;
    private final int BREEDTE;
    private final int DIEPTE;
    private final Maat MAAT;

    public Volume(int hoogte, int breedte, int diepte, Maat maat) throws VolumeException {
        if (hoogte >= 0) {
            this.HOOGTE = hoogte;
        } else {
            throw new VolumeException();
        }
        if (breedte >= 0) {
            this.BREEDTE = breedte;
        } else {
            throw new VolumeException();
        }
        if (diepte >= 0) {
            this.DIEPTE = diepte;
        } else {
            throw new VolumeException();
        }
        if (maat != null) {
            this.MAAT = maat;
        } else {
            throw new VolumeException();
        }
    }

    public long getVolume() {
        return HOOGTE * BREEDTE * DIEPTE;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.getVolume());
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
        final Volume other = (Volume) obj;
        if (this.HOOGTE != other.HOOGTE) {
            return false;
        }
        if (this.BREEDTE != other.BREEDTE) {
            return false;
        }
        if (this.DIEPTE != other.DIEPTE) {
            return false;
        }
        if (this.MAAT != other.MAAT) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Volume v) {
        int x = 1;
        int y = 1;
        if (v.getMaat().equals(MAAT.decimeter)) {
            x = 10;
        }
        if (v.getMaat().equals(MAAT.meter)) {
            x = 100;
        }
        if (this.getMaat().equals(MAAT.decimeter)) {
            y = 10;
        }
        if (this.getMaat().equals(MAAT.meter)) {
            y = 100;
        }
        return (this.getHoogte() * y - v.getHoogte() * x)+(this.getBreedte()* y - v.getBreedte()* x)+(this.getDiepte()* y - v.getDiepte()* x);

    }

    public int getHoogte() {
        return HOOGTE;
    }

    public int getBreedte() {
        return BREEDTE;
    }

    public int getDiepte() {
        return DIEPTE;
    }

    public Maat getMaat() {
        return MAAT;
    }

    @Override
    public String toString() {
        return HOOGTE + "(h)x" + BREEDTE + "(b)x" + DIEPTE + "(d) " + MAAT;
    }

}
