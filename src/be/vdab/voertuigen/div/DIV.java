package be.vdab.voertuigen.div;

/**
 *
 * @author elvira.iskhakova
 */
public enum DIV {
    INSTANCE;
    private static final int MAXIMUM_NUMMERPLAAT_GETAL = 999;
    private int teller = 0;

    public Nummerplaat getNummerplaat() {
        if (++teller > MAXIMUM_NUMMERPLAAT_GETAL) {
            teller = 1;
        }
        return new Nummerplaat(String.format("AAA%03d", teller));
    }

}
