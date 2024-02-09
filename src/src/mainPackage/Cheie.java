package mainPackage;

/**
 * Clasa Cheie reprezinta o cheie intreaga utilizata intr-o tabela de dispersie.
 * Aceasta clasa ofera metode pentru a accesa si obtine valoarea cheii.
 * @author Radu
 */
public class Cheie {

    /**
     * Valoarea cheii.
     */
    private int key;

    /**
     * Constructor pentru initializarea unei chei cu o valoare data.
     *
     * @param key Valoarea cheii de initializat.
     */
    public Cheie(int key) {
        this.key = key;
    }

    /**
     * Returneaza valoarea cheii.
     *
     * @return Valoarea cheii.
     */
    public int getKey() {
        return key;
    }
}
