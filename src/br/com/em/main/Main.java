package br.com.em.main;




import br.com.em.secretaria.JfTelaPrincipalSecretaria;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pablo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
                }
            }
        } catch (ClassNotFoundException ex) {
           
        } catch (InstantiationException ex) {
          
        } catch (IllegalAccessException ex) {
        
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           
        }
        
        JfTelaPrincipalSecretaria tela = new JfTelaPrincipalSecretaria();
        tela.setSize(1060,650);
                tela.setVisible(true);
                
               
                
    }
    
}
