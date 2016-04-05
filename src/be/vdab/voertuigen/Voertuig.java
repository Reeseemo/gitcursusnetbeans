/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.MensException;
import be.vdab.util.mens.Rijbewijs;
import be.vdab.voertuigen.div.DIV;
import be.vdab.voertuigen.div.Nummerplaat;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author elvira.iskhakova
 */
public abstract class Voertuig implements Serializable, Comparable<Voertuig> {

    final Nummerplaat nplaat = DIV.INSTANCE.getNummerplaat();
    String merk;
    Datum DatumEersteIngebruikname;
    int aankoopprijs;
    final int MAX_ZITPLAATSEN;
    Mens bestuurder;
    Set<Mens> inzittenden = new HashSet<>();

    public Voertuig(String merk, Datum datumEersteIngebruikname,
            int aankoopprijs, int zitplaatsen, Mens bestuurder, Mens... passagiers) {

        setMerk(merk);
        setDatumEersteIngebruikname(datumEersteIngebruikname);
        setAankoopprijs(aankoopprijs);
        setBestuurder(bestuurder);

        if (zitplaatsen > 0) {
            this.MAX_ZITPLAATSEN = zitplaatsen;
        } else {
            throw new IllegalArgumentException();
        }

        if (passagiers.length >= 1 && passagiers.length < zitplaatsen) {
            inzittenden.addAll(Arrays.asList(passagiers));
            
        } else {
            throw new MensException();
        }
    }

    public String getMerk() {
        return merk;
    }

    public final void setMerk(String merk) {
        if (merk != null && !merk.isEmpty()) {
            this.merk = merk;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Datum getDatumEersteIngebruikname() {
        return DatumEersteIngebruikname;
    }

    public final void setDatumEersteIngebruikname(Datum datumEersteIngebruikname) {
        if (datumEersteIngebruikname != null) {
            this.DatumEersteIngebruikname = datumEersteIngebruikname;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getAankoopprijs() {
        return aankoopprijs;
    }

    public final void setAankoopprijs(int aankoopprijs) {
        if (aankoopprijs > 0) {
            this.aankoopprijs = aankoopprijs;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Mens getBestuurder() {
        return bestuurder;
    }

    public final void setBestuurder(Mens bestuurder) {
        if (bestuurder != null) {
            this.bestuurder = bestuurder;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Set<Mens> getInzittenden() {
        inzittenden.add(bestuurder);
        return inzittenden;
    }

    public void setInzittenden(Set<Mens> inzittenden) {
        this.inzittenden = inzittenden;
    }

    public Nummerplaat getNummerplaat() {
        return nplaat;
    }

    protected int getMAX_ZITPLAATSEN() {
        return MAX_ZITPLAATSEN;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nplaat);
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
        final Voertuig other = (Voertuig) obj;
        if (!Objects.equals(this.nplaat, other.nplaat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder(getNummerplaat().toString());
        sb.append(String.join(" ", merk, DatumEersteIngebruikname.toString(), 
                String.valueOf(aankoopprijs), bestuurder.toString(), inzittenden.toString()));

        //sb.append(String.join(", ", sortedList.toString()));
//        sb.setCharAt(sb1.toString().indexOf('['), '(');
//        sb.setCharAt(sb1.toString().indexOf(']'), ')');
        return sb.toString();

        //return nplaat + merk + DatumEersteIngebruikname + aankoopprijs + bestuurder + inzittenden;
    }

    @Override
    public int compareTo(Voertuig v) {
        return nplaat.compareTo(v.getNummerplaat());
    }

    protected Rijbewijs[] getToegestaneRijbewijzen() {
        return new Rijbewijs[]{Rijbewijs.B, Rijbewijs.BE};
    }

    static Comparator<Voertuig> getMerkComparator() {
        return (Voertuig one, Voertuig two) -> one.getMerk().compareTo(two.getMerk());
    }

    static Comparator<Voertuig> getAankoopprijsComparator() {
        return (Voertuig one, Voertuig two) -> one.getAankoopprijs() - two.getAankoopprijs();
    }

    public void addIngezetene(Mens m) {
        if (inzittenden.size() < MAX_ZITPLAATSEN) {
            inzittenden.add(m);
        } else {
            throw new MensException();
        }
    }

    public Set getIngezetenen() {
        return inzittenden;
    }

    public boolean isIngezetene(Mens m) {
        return inzittenden.contains(m);
    }

    public Set getIngezeteneExclusiefBestuurder() {
        return inzittenden;
    }
}
