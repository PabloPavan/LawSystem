/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.extra;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author pablo
 */
public class JPanelBuscaJtextFild {

    public static void limpaCampo(JPanel jpanel) {
        Component components[] = jpanel.getComponents();

        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            }
            if (component instanceof JTextArea) {
                ((JTextArea) component).setText("");
            }
        }
    }

    public static void liberaCampo(JPanel jpanel, boolean t) {
        Component components[] = jpanel.getComponents();
        if (t) {
            for (Component component : components) {
                if (component instanceof JTextField) {
                    ((JTextField) component).setEnabled(true);
                }
                if (component instanceof JTextArea) {
                    ((JTextArea) component).setEnabled(true);
                }
            }
        } else {
            for (Component component : components) {
                if (component instanceof JTextField) {
                    ((JTextField) component).setEnabled(false);
                }
                if (component instanceof JTextArea) {
                    ((JTextArea) component).setEnabled(false);
                }

            }
        }
    }

}
