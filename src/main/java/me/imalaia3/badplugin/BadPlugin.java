package me.imalaia3.badplugin;

import me.imalaia3.badplugin.commands.MapCommands;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.plugin.java.JavaPlugin;

public final class BadPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        MapCommands commands = new MapCommands();
        System.out.println("Called onEnable();");
        getCommand("setcoords").setExecutor(commands);
        getCommand("seturl").setExecutor(commands);
        getCommand("tickserver").setExecutor(commands);
        getCommand("tickframe").setExecutor(commands);
        getServer().getPluginManager().registerEvents(this,this);
        VideoDrawerAPI.init();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent ev){
        Bukkit.broadcastMessage("Welcome " + ev.getPlayer() + "!");
    }

    @EventHandler
    public void onMap(MapInitializeEvent ev){
        MapView m = ev.getMap();
        for(MapRenderer renderer:m.getRenderers()){
            m.removeRenderer(renderer);
        }
        m.addRenderer(new BadMapRenderer());
    }



}
