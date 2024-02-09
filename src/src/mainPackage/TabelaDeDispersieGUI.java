package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interfata grafica pentru vizualizarea si manipularea unei tabele de dispersie.
 * @author Radu
 */
public class TabelaDeDispersieGUI {
    private JFrame frame;
    private TabelaDeDispersie tabelaDeDispersie;
    private JTextField h1Field;
    private JTextField h2Field;
    private JTextArea slotsArea;

    /**
     * Constructorul clasei TabelaDeDispersieGUI.
     * Inițializeaza și afișeaza fereastra GUI.
     */
    public TabelaDeDispersieGUI() {
        frame = new JFrame("Vizualizator pentru Tabela de dispersie");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);

        h1Field = new JTextField(5);
        h2Field = new JTextField(5);
        JButton setHashParamsButton = new JButton("Seteaza h1 si h2");

        // Listener pentru butonul de setare a parametrilor de dispersie.
        setHashParamsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int h1 = Integer.parseInt(h1Field.getText());
                    int h2 = Integer.parseInt(h2Field.getText());
                    tabelaDeDispersie = new TabelaDeDispersie(h2);
                    tabelaDeDispersie.setDimensiuneTabela(h2);
                    tabelaDeDispersie.setParams(h1, h2);
                    updateResultTextArea();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Input invalid. Trebuie introduse numere intregi!");
                }
            }
        });

        JButton insertButton = new JButton("Insert");
        JButton deleteButton = new JButton("Delete");
        slotsArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(slotsArea);

        // Listener pentru butonul de inserare a cheii.
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Introduceti cheia pentru inserare:");
                if (input != null && !input.isEmpty()) {
                    try {
                        int key = Integer.parseInt(input);
                        tabelaDeDispersie.insert(key);
                        updateResultTextArea();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Input invalid. Trebuie introduse numere intregi!");
                    }
                }
            }
        });

        // Listener pentru butonul de ștergere a cheii.
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Introduceti cheia pentru stergere:");
                if (input != null && !input.isEmpty()) {
                    try {
                        int key = Integer.parseInt(input);
                        tabelaDeDispersie.delete(key);
                        updateResultTextArea();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Input invalid. Trebuie introduse numere intregi!");
                    }
                }
            }
        });

        JPanel paramsPanel = new JPanel();
        paramsPanel.add(new JLabel("h2 defineste si dimensiunea tabelei!   h1:"));
        paramsPanel.add(h1Field);
        paramsPanel.add(new JLabel("h2:"));
        paramsPanel.add(h2Field);
        paramsPanel.add(setHashParamsButton);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(insertButton);
        buttonsPanel.add(deleteButton);

        // Configurarea layout-ului si adaugarea componentelor în fereastra principala.
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(BorderLayout.NORTH, paramsPanel);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonsPanel);

        frame.setVisible(true);
    }

    /**
     * Actualizeaza zona de afisare cu continutul curent al tabelei de dispersie.
     */
    private void updateResultTextArea() {
    	slotsArea.setText("");
        Cheie[] table = tabelaDeDispersie.getTable();
        for (int i = 0; i < table.length; i++) {
        	slotsArea.append("Index " + i + ": ");
            if (table[i] == null) {
            	slotsArea.append("null\n");
            } else {
            	slotsArea.append(String.valueOf(table[i].getKey()) + "\n");
            }
        }
    }
}
