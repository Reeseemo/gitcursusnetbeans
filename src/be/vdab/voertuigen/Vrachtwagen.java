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
import be.vdab.util.mens.Rijbewijs;
import java.io.Serializable;

/**
 *
 * @author elvira.iskhakova
 */
public class Vrachtwagen extends Voertuig implements Laadbaar, Serializable {

    Volume laadvolume;
    int maximaalToegelatenMassa;
    int aantalAssen;

    public Vrachtwagen(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Volume laadvolume, int massa, int assen, Mens bestuurder, Mens... passagiers) {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, bestuurder, passagiers);
        setAantalAssen(assen);
        setMaximaalToegelatenMassa(massa);
        setLaadvolume(laadvolume);

    }

    @Override
    protected Rijbewijs[] getToegestaneRijbewijzen() {
        return new Rijbewijs[]{Rijbewijs.C, Rijbewijs.CE};
    }

    @Override
    protected int getMAX_ZITPLAATSEN() {
        return 3;
    }

    @Override
    public Volume getLaadvolume() {
        return this.laadvolume;
    }

    @Override
    public final void setLaadvolume(Volume v) {
        this.laadvolume = v;
    }

    public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    public final void setMaximaalToegelatenMassa(int maximaalToegelatenMassa) {
        this.maximaalToegelatenMassa = maximaalToegelatenMassa;
    }

    public final void setAantalAssen(int aantalAssen) {
        this.aantalAssen = aantalAssen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(" assen:" + Integer.toString(getAantalAssen()) + ", "
                + "maximaal toegelaten massa:" + Integer.toString(getMaximaalToegelatenMassa()) + ", "
                + "laadvolume:" + laadvolume.toString());


        return sb.toString();
    }

//    @Override
//    public String toString() {
//        return super.toString() + "assen:" + Integer.toString(getAantalAssen())
//                + "maximaal toegelaten massa:" + Integer.toString(getMaximaalToegelatenMassa())
//                        + "laadvolume:" + laadvolume.toString();
//    }
}
