/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author elvira.iskhakova
 */
public class Boekentas implements Laadbaar, Serializable {

    Volume laadvolume;
    String kleur;

    public Boekentas(String kleur, Volume laadvolume) {
        setKleur(kleur);
        setLaadvolume(laadvolume);
    }

    public String getKleur() {
        return kleur;
    }

    public final void setKleur(String kleur) {
        if (kleur != null && !kleur.isEmpty()) {
            this.kleur = kleur;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Volume getLaadvolume() {
        return this.laadvolume;
    }

    @Override
    public final void setLaadvolume(Volume v) {
        if (v != null) {
            this.laadvolume = v;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.laadvolume);
        hash = 31 * hash + Objects.hashCode(this.kleur);
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
        final Boekentas other = (Boekentas) obj;
        if (!Objects.equals(this.kleur, other.kleur)) {
            return false;
        }
        if (!Objects.equals(this.laadvolume, other.laadvolume)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boekentas " + getKleur() + " " + getLaadvolume();
    }

}
