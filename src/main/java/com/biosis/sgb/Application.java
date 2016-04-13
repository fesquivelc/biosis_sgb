package com.biosis.sgb;

import com.biosis.sgb.vistas.Principal;
import com.biosis.sgb.vistas.dialogos.Login;
import com.personal.utiles.ImagenFondo;
import com.personal.utiles.PropertiesUtil;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;

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
    public static File IMG_FONDO_APP;
    public static File REPORTE_LIBRO;
    public static File REPORTE_EJEMPLAR;
    public static File REPORTE_PRESTAMO;
    public static File REPORTE_LIBRO_USO;
    public static ImagenFondo BORDE_FONDO;
    public static DateFormat FORMATO_HMS;
    public static DateFormat FORMATO_HM;
    public static DateFormat FORMATO_DM;
    public static DateFormat FORMATO_DMY;
    public static DateFormat FORMATO_TIMESTAMP;
    private static final Logger LOG = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        //Cargamos estilo 1
        Properties props_interfaz = PropertiesUtil.cargarProperties("configuracion/interfaz.properties");
        Properties props_recursos = PropertiesUtil.cargarProperties("configuracion/recursos.properties");
        ESTILO1 = new Font(props_interfaz.getProperty("estilo1_font", "SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo1_style", "0")), Integer.parseInt(props_interfaz.getProperty("estilo1_size", "13")));
        ESTILO2 = new Font(props_interfaz.getProperty("estilo2_font", "SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo2_style", "0")), Integer.parseInt(props_interfaz.getProperty("estilo2_size", "14")));
        ESTILO3 = new Font(props_interfaz.getProperty("estilo3_font", "SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo3_style", "0")), Integer.parseInt(props_interfaz.getProperty("estilo3_size", "15")));
        ESTILO4 = new Font(props_interfaz.getProperty("estilo4_font", "SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo4_style", "0")), Integer.parseInt(props_interfaz.getProperty("estilo4_size", "15")));
        ESTILO5 = new Font(props_interfaz.getProperty("estilo5_font", "SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo5_style", "1")), Integer.parseInt(props_interfaz.getProperty("estilo5_size", "18")));
        ESTILO6 = new Font(props_interfaz.getProperty("estilo6_font", "SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo6_style", "1")), Integer.parseInt(props_interfaz.getProperty("estilo6_size", "18")));
        ESTILO7 = new Font(props_interfaz.getProperty("estilo7_font", "SansSerif"), Integer.parseInt(props_interfaz.getProperty("estilo7_style", "1")), Integer.parseInt(props_interfaz.getProperty("estilo7_size", "18")));

        REPORTE_LIBRO = new File(props_recursos.getProperty("reporte_libro"));
        REPORTE_EJEMPLAR = new File(props_recursos.getProperty("reporte_ejemplar"));
        REPORTE_PRESTAMO = new File(props_recursos.getProperty("reporte_prestamo"));
        REPORTE_LIBRO_USO = new File(props_recursos.getProperty("reporte_libro_uso"));
        IMG_LOGO_REPORTE = new File(props_recursos.getProperty("img_logo_reporte"));
        IMG_FONDO_APP = new File(props_recursos.getProperty("img_fondo_app"));

        REPORTE_INSTITUCION = props_interfaz.getProperty("reporte_institucion");
        REPORTE_RUC = props_interfaz.getProperty("reporte_ruc");

        FORMATO_DM = new SimpleDateFormat(props_interfaz.getProperty("formato_dm"));
        FORMATO_DMY = new SimpleDateFormat(props_interfaz.getProperty("formato_dmy"));
        FORMATO_HM = new SimpleDateFormat(props_interfaz.getProperty("formato_hm"));
        FORMATO_HMS = new SimpleDateFormat(props_interfaz.getProperty("formato_hms"));
        FORMATO_TIMESTAMP = new SimpleDateFormat(String.format("%s %s", props_interfaz.getProperty("formato_dmy"), props_interfaz.getProperty("formato_hms")));

        try {
            BORDE_FONDO = new ImagenFondo(ImageIO.read(IMG_FONDO_APP));
        } catch (IOException ex) {
            LOG.error("Error al inicializar borde", ex);
        }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Login login = new Login(null, true);
        login.setVisible(true);
////
////        Principal principal = new Principal();
////        principal.setVisible(true);
////        principal.setExtendedState(principal.getExtendedState() | JFrame.MAXIMIZED_BOTH);

    }
}
