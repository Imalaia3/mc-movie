package me.imalaia3.badplugin;

import me.imalaia3.badplugin.commands.MapCommands;
import org.bukkit.entity.Player;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.map.MinecraftFont;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class BadMapRenderer extends MapRenderer {

    public static int xPos = 2;
    public static int yPos = 2;
    public static String url = "https://www.seekpng.com/png/detail/334-3345964_error-icon-download-attention-symbol.png"; //Not Needed But idc



    public static void setxPos(int nPos){
        BadMapRenderer.xPos = nPos;
    }
    public static void setyPos(int nPos){
        BadMapRenderer.yPos = nPos;
    }
    public static void setUrl(String nurl){
        BadMapRenderer.url = nurl;
    }



    @Override
    public void render(MapView map, MapCanvas canvas, Player player) {
        if (VideoDrawerAPI.imageToRead==null){
            canvas.drawText(0,0, new MinecraftFont(),"");
        }
        else
        {
            canvas.drawImage(xPos,yPos, VideoDrawerAPI.imageToRead);
        }
    }


}
