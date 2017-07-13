/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.log;



import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

/**
 *
 * @author pablo
 */
public class Logs {

    public static Properties getLogConf() {
        Properties conf = new Properties();

        conf.setProperty("arquivo", "log_sistema.log");
        conf.setProperty("acrescentar", "true");
      conf.setProperty("format-saida", "SIMPLE");
        // conf.setProperty("format-saida", "XML");

        return conf;
    }

    public static void log() {
        Properties conf = Logs.getLogConf();

        Handler handler = null;
        try {
            handler = new FileHandler(conf.getProperty("arquivo"), Boolean.parseBoolean(conf.getProperty("acrescentar")));
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
        }
        Logger.getLogger("").addHandler(handler);

        // define o formato de saída  
        if (conf.getProperty("format-saida").equalsIgnoreCase("XML")) {
            handler.setFormatter(new XMLFormatter());
        } else if (conf.getProperty("format-saida").equalsIgnoreCase("SIMPLE")) {
            handler.setFormatter(new SimpleFormatter());
        }
    }
}
