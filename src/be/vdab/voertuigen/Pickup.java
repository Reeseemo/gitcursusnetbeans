/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author elvira.iskhakova
 */
public class Pickup extends Personenwagen implements Laadbaar, Serializable{

    Volume laadvolume;

    public Pickup(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Color kleur, Volume laadvolume, Mens bestuurder, Mens... passagiers) {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, kleur, bestuurder, passagiers);

        setLaadvolume(laadvolume);

    }

    @Override
    public Volume getLaadvolume() {
        return this.laadvolume;
    }

    @Override
    public final void setLaadvolume(Volume v) {
        this.laadvolume = v;
    }

    @Override
    public String toString() {
        return super.toString() + " " + laadvolume.toString();
    }

}
