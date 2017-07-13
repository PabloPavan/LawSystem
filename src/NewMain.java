


import br.com.em.secretaria.TelaPrincipalSecretaria;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pablo
 */
public class NewMain {

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
        
        TelaPrincipalSecretaria tela = new TelaPrincipalSecretaria();
        tela.setSize(1060,650);
                tela.setVisible(true);
                
               
                
    }
    
}
