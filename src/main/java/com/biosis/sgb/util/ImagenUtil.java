/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.ImageIcon;
import org.apache.log4j.Logger;

/**
 *
 * @author fesquivel
 */
public class ImagenUtil {

    private static final Logger LOG = Logger.getLogger(ImagenUtil.class.getName());

    public static byte[] obtenerBytes(String path) {
        try {
            File file = new File(path);
            return Files.readAllBytes(file.toPath());
        } catch (IOException ex) {
            LOG.error("Error al obtener bytes de imagen", ex);
            return null;
        }
    }

    public static ImageIcon obtenerImagen(byte[] data) {
        ImageIcon imageIcon = new ImageIcon(data);
        return imageIcon;
    }

    public static Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
