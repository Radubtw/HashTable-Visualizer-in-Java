package mainPackage;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Clasa TabelaDeDispersie reprezinta o implementare a unei tabele de dispersie
 * cu adresare deschisa. Aceasta utilizeaza o schema de dispersie dubla si
 * permite inserarea, stergerea si verificarea daca tabela este plina.
 * @author Radu
 */
public class TabelaDeDispersie {
    private int dimensiuneTabela;
    private Cheie[] tabela;
    private int h1;
    private int h2;

    /**
     * Constructor pentru initializarea unei tabele de dispersie cu dimensiunea specificata.
     *
     * @param dimensiuneTabela Dimensiunea tabelei de dispersie.
     */
    public TabelaDeDispersie(int dimensiuneTabela) {
        tabela = new Cheie[dimensiuneTabela];
    }

    /**
     * Seteaza parametrii necesari pentru schema de dispersie dubla.
     *
     * @param h1 Parametrul h1 pentru schema de dispersie dubla.
     * @param h2 Parametrul h2 pentru schema de dispersie dubla.
     */
    public void setParams(int h1, int h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    /**
     * Insereaza o cheie in tabela de dispersie, verificand initial daca este sau nu plina. Daca este plina se iese din metoda si se afiseaza
     * un mesaj corespunzator prin intermediul unui messageDialog, iar daca nu se continua. Cheia se insereaza in tabela utilizandu-se
     * schema de dispersie dubla dupa formula: (key % h1 + i * ( key % h2)) % dimensiuneTabela, i fiind initial 0, iar cu fiecare slot
     * ocupat in care se incearca inserarea, acesta creste.
     *
     * @param key Cheia de inserat in tabela.
     */
    public void insert(int key) {
    	
    	if(isFull())
    	{
			JOptionPane.showMessageDialog(null, "Tabela de dispersie este plina. Nu se poate insera cheia.");
	        return;
    	}
        int i = 0;
        int index = (key % h1 + i * ( key % h2)) % dimensiuneTabela;
        i++;
        while (tabela[index] != null) {
            index = (key % h1 + i * ( key % h2)) % dimensiuneTabela;
            i++;
        }

        tabela[index] = new Cheie(key);
    }

    /**
     * Cauta o cheie in tabela de dispersie utilizand schema de dispersie dubla, apoi stocheaza toate slot urile in care a fost gasita,
     * apoi le sterge pe toate.
     *
     * @param key Cheia de sters din tabela.
     */
    public void delete(int key) {
        int i = 0;
        int index = (key % h1 + i * (key % h2)) % dimensiuneTabela;
        i++;

        ArrayList<Integer> keysToDelete = new ArrayList<>();

        while (tabela[index] != null) {
            if (tabela[index].getKey() == key) {
                keysToDelete.add(index);
            }
            index = (key % h1 + i * (key % h2)) % dimensiuneTabela;
            i++;
        }

        for (int deleteIndex : keysToDelete) {
            tabela[deleteIndex] = null;
        }
    }

    /**
     * Verifica daca tabela de dispersie este plina.
     *
     * @return true daca tabela este plina, false altfel.
     */
    public boolean isFull() {
        for (Cheie entry : tabela) {
            if (entry == null) {
                return false; 
            }
        }
        return true; 
    }
    
    /**
     * Seteaza dimensiunea tabelei de dispersie.
     *
     * @param dimensiuneTabela Dimensiunea tabelei de dispersie.
     */
    public void setDimensiuneTabela(int dimensiuneTabela)
    {
    	this.dimensiuneTabela = dimensiuneTabela;
    }

    /**
     * Returneaza tabloul de chei al tabelei de dispersie.
     *
     * @return Tabloul de chei.
     */
    public Cheie[] getTable() {
        return tabela;
    }
}
