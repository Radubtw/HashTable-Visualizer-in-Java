package mainPackage;

import javax.swing.SwingUtilities;

/**
 * Clasa principala care contine metoda main pentru pornirea aplicatiei.
 * @author Radu
 */
public class Main {
    /**
     * Metoda principala care inițializeaza GUI-ul pentru tabela de dispersie.
     * Este utilizat SwingUtilities.invokeLater pentru a asigura ca crearea GUI-ului are loc pe thread-ul de evenimente Swing.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TabelaDeDispersieGUI();
            }
        });
    }
}
