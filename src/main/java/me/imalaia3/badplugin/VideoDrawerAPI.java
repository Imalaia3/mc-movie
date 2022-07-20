package me.imalaia3.badplugin;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class VideoDrawerAPI {
    public static BufferedImage imageToRead;


    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    public static BufferedImage getImageFromWeb(URL url) throws IOException {
        return ImageIO.read(url);
    }

    public static void setCurrImage(URL url) throws IOException {
        BufferedImage orig = getImageFromWeb(url);
        BufferedImage newimg = resizeImage(orig,128,128);
        imageToRead = newimg;

    }

    public static void tickFrameDisplay() throws IOException {
        setCurrImage(new URL("http://127.0.0.1:5000/img")); //localhost. Change if needed
    }

    public static void tickVideoServer() throws IOException {
        URL url = new URL("http://127.0.0.1:5000/tick");//localhost. Change if needed
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int val = con.getResponseCode();
    }




    public static void init(){
        imageToRead=null;
    }
}
