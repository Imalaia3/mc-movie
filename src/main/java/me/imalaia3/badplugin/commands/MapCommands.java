package me.imalaia3.badplugin.commands;

import me.imalaia3.badplugin.BadMapRenderer;
import me.imalaia3.badplugin.BadPlugin;
import me.imalaia3.badplugin.VideoDrawerAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.net.URL;

public class MapCommands implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if((sender instanceof Player)) {

            //Player-Specific Commands
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("setcoords")) {
                Bukkit.broadcastMessage("New X/Y: " + args[0] + " " + args[1]);
                BadMapRenderer.setxPos(Integer.parseInt(args[0]));
                BadMapRenderer.setyPos(Integer.parseInt(args[1]));
                System.out.println(BadMapRenderer.xPos);
                System.out.println(BadMapRenderer.yPos);

            }
            if (command.getName().equalsIgnoreCase("seturl")) {
                Bukkit.broadcastMessage("New URL is: " + args[0]);
                try {
                    VideoDrawerAPI.setCurrImage(new URL(args[0]));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //Command Block commands
        if (command.getName().equalsIgnoreCase("tickserver")){
            try {
                VideoDrawerAPI.tickVideoServer();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (command.getName().equalsIgnoreCase("tickframe")){
            try {
                VideoDrawerAPI.tickFrameDisplay();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return false;
    }





}
