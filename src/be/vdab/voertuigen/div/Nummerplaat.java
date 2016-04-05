/*
* @Autor Frank
* Dit is een oefening.
 */
package be.vdab.voertuigen.div;

import java.io.Serializable;
import java.util.Objects;

public final class Nummerplaat implements Serializable, Comparable<Nummerplaat> {

    private final String plaat;

    Nummerplaat(String plaat) {
        this.plaat = plaat;
    }

    public String getPlaat() {
        return plaat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.plaat);
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
        final Nummerplaat other = (Nummerplaat) obj;
        if (!Objects.equals(this.plaat, other.plaat)) {
            return false;
        }
        return true;
    }
      
    @Override
    public String toString() {
        return plaat;
    }

    @Override
    public int compareTo(Nummerplaat n) {
        return plaat.compareTo(n.getPlaat());
    }

}
