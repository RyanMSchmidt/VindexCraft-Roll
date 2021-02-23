package com.ryanschmidt.vcroll;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Random;
import org.bukkit.Bukkit;

public class VCRoll extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getLogger().info("VindexCraft Roll - Created by _Echoplayz__");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Goodbye!");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("roll")) {
            Random rand = new Random();
            int rolledNumber = rand.nextInt(100) + 1;
            if (sender instanceof Player) {
                Player player = (Player)sender;
                ArrayList<Entity> nearByEntities = (ArrayList)player.getNearbyEntities(25,25,25);

                for(int x = 0; x < nearByEntities.size(); ++x) {
                    if (nearByEntities.get(x) instanceof Player) {
                        Player otherplayer = (Player)nearByEntities.get(x);
                        otherplayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&2Vindex&aCraft &7Roll&8] &2" +player.getPlayer().getDisplayName() + " &arolled a " + rolledNumber));
                    }
                }
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&2Vindex&aCraft &7Roll&8] &2" +player.getPlayer().getDisplayName() + " &arolled a " + rolledNumber));
            } else {
                this.getLogger().info("Command must be ran by a player!");
            }
        }
     return true;
    }
}

