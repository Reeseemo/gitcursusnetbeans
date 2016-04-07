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
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.collections4.CollectionUtils;

/**
 *
 * @author elvira.iskhakova
 */
public abstract class Voertuig implements Serializable, Comparable<Voertuig> {

    final Nummerplaat nplaat = DIV.INSTANCE.getNummerplaat();
    String merk;
    Datum DatumEersteIngebruikname;
    int aankoopprijs;
    final int ZITPLAATSEN;
    Mens bestuurder;
    Set<Mens> inzittenden = new TreeSet<>();

    public Voertuig(String merk, Datum datumEersteIngebruikname,
            int aankoopprijs, int zitplaatsen, Mens bestuurder, Mens... passagiers) {

        setMerk(merk);
        setDatumEersteIngebruikname(datumEersteIngebruikname);
        setAankoopprijs(aankoopprijs);

        if (zitplaatsen > 0  && zitplaatsen <= getMAX_ZITPLAATSEN()) {
            this.ZITPLAATSEN = zitplaatsen;
        } else {
            throw new IllegalArgumentException();
        }

        Set<Mens> passagiersSet = new TreeSet<>(Arrays.asList(passagiers));
        passagiersSet.remove(bestuurder);
        if (passagiersSet.size()<zitplaatsen) {
            inzittenden.addAll(passagiersSet);
        }else{
            throw new MensException();
        }

        setBestuurder(bestuurder);

    }

    public Mens getBestuurder() {
        return bestuurder;
    }

    public final void setBestuurder(Mens bestuurder) {
        if (bestuurder != null && bestuurder.getRijbewijs() != null
                && CollectionUtils.containsAny(Arrays.asList(bestuurder.getRijbewijs()), Arrays.asList(getToegestaneRijbewijzen()))) {

            if (inzittenden.contains(bestuurder)) {
                this.bestuurder = bestuurder;
            } else if (inzittenden.size() < ZITPLAATSEN) {
                this.bestuurder = bestuurder;
                inzittenden.add(bestuurder);
            } else {
                throw new MensException();
            }
        } else {
            throw new MensException();
        }
    }

    public Set getIngezeteneExclusiefBestuurder() {
        Set<Mens> passagiers = new TreeSet<>();
        passagiers.addAll(inzittenden);
        passagiers.remove(bestuurder);
        return passagiers;
    }

    public void addIngezetene(Mens m) {
        if (inzittenden.size() < ZITPLAATSEN || inzittenden.contains(m)) {
            inzittenden.add(m);
        } else {
            throw new MensException();
        }
    }

    public Set getIngezetenen() {
        return inzittenden;
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

    public Nummerplaat getNummerplaat() {
        return nplaat;
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
        StringBuilder sb = new StringBuilder(getNummerplaat().toString() + " ");

        sb.append(String.join(" ", merk, DatumEersteIngebruikname.toString(),
                String.valueOf(aankoopprijs), bestuurder.toString()));
        if (getIngezeteneExclusiefBestuurder() != null && !getIngezeteneExclusiefBestuurder().isEmpty()) {
            sb.append(" " + getIngezeteneExclusiefBestuurder().toString());
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Voertuig v) {
        return nplaat.compareTo(v.getNummerplaat());
    }

    protected abstract Rijbewijs[] getToegestaneRijbewijzen();

    protected abstract int getMAX_ZITPLAATSEN();
    
    public interface SerializableComparator<T> extends Serializable,Comparator<T>{}

    public static Comparator<Voertuig> getMerkComparator() {
        return (SerializableComparator < Voertuig>)(Voertuig one, Voertuig two) -> one.getMerk().compareTo(two.getMerk());
    }

    public static Comparator<Voertuig> getAankoopprijsComparator() {
        return (SerializableComparator < Voertuig>)(Voertuig one, Voertuig two) -> one.getAankoopprijs() - two.getAankoopprijs();
    }

    public boolean isIngezetene(Mens m) {
        return inzittenden.contains(m);
    }

}
