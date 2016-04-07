/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import java.awt.Color;

/**
 *
 * @author elvira.iskhakova
 */
public class Personenwagen extends Voertuig {

    Color kleur;

    public Personenwagen(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Color kleur, Mens bestuurder, Mens... passagiers) {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, bestuurder, passagiers);
        this.kleur = kleur;
    }

    @Override
    protected Rijbewijs[] getToegestaneRijbewijzen() {
        return new Rijbewijs[]{Rijbewijs.B, Rijbewijs.BE};
    }

    @Override
    protected int getMAX_ZITPLAATSEN() {
        return 8;
    }

    public int getZitplaatsen() {
        return super.ZITPLAATSEN;
    }

    public Color getKleur() {
        return kleur;
    }

    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getZitplaatsen();
    }
}
