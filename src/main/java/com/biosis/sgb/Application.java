package com.biosis.sgb;

import com.biosis.sgb.vistas.Principal;
import com.personal.utiles.PropertiesUtil;
import java.awt.Font;
import java.io.File;
import java.util.Properties;
import javax.swing.JFrame;

public class Application {
    /**
     * @param args the command line arguments
     */
    public static Font ESTILO1;
    public static Font ESTILO2;
    public static Font ESTILO3;
    public static Font ESTILO4;
    public static Font ESTILO5;
    public static Font ESTILO6;
    public static Font ESTILO7;
    
    public static String REPORTE_INSTITUCION;
    public static String REPORTE_RUC;
    
    public static File IMG_LOGO_REPORTE;
    public static File REPORTE_LIBRO;
    public static void main(String[] args) {
        //Cargamos estilo 1
        Properties props_interfaz = PropertiesUtil.cargarProperties("configuracion/interfaz.properties");
        Properties props_recursos = PropertiesUtil.cargarProperties("configuracion/recursos.properties");
        ESTILO1 = new Font(props_interfaz.getProperty("estilo1_font","SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo1_style","0")), Integer.parseInt(props_interfaz.getProperty("estilo1_size","13")));
        ESTILO2 = new Font(props_interfaz.getProperty("estilo2_font","SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo2_style","0")), Integer.parseInt(props_interfaz.getProperty("estilo2_size","14")));
        ESTILO3 = new Font(props_interfaz.getProperty("estilo3_font","SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo3_style","0")), Integer.parseInt(props_interfaz.getProperty("estilo3_size","15")));
        ESTILO4 = new Font(props_interfaz.getProperty("estilo4_font","SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo4_style","0")), Integer.parseInt(props_interfaz.getProperty("estilo4_size","15")));
        ESTILO5 = new Font(props_interfaz.getProperty("estilo5_font","SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo5_style","1")), Integer.parseInt(props_interfaz.getProperty("estilo5_size","18")));
        ESTILO6 = new Font(props_interfaz.getProperty("estilo6_font","SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo6_style","1")), Integer.parseInt(props_interfaz.getProperty("estilo6_size","18")));
        ESTILO7 = new Font(props_interfaz.getProperty("estilo7_font","SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo7_style","1")), Integer.parseInt(props_interfaz.getProperty("estilo7_size","18")));
        
        REPORTE_LIBRO = new File(props_recursos.getProperty("reporte_libro"));
        IMG_LOGO_REPORTE = new File(props_recursos.getProperty("img_logo_reporte"));
        
        REPORTE_INSTITUCION = props_interfaz.getProperty("reporte_institucion");
        REPORTE_RUC = props_interfaz.getProperty("reporte_ruc");
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        Principal principal = new Principal();
        principal.setVisible(true);
        principal.setExtendedState(principal.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        
    }
}
