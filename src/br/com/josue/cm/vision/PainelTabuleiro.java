package br.com.josue.cm.vision;

import br.com.josue.cm.model.Tabuleiro;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;

public class PainelTabuleiro extends JPanel {

    public  PainelTabuleiro(Tabuleiro tabuleiro) {

        setLayout(new GridLayout(
                tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
        tabuleiro.registrarObservador(e -> {

            SwingUtilities.invokeLater(() -> {
                if(e.isGanhou()) {
                    JOptionPane.showMessageDialog(this, "Você ganhou!");
                } else {
                    JOptionPane.showMessageDialog(this, "Você perdeu!");
                }
                tabuleiro.reiniciar();
            });
        });
    }
}
