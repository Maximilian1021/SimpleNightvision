package me.Maximilian1021.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.Maximilian1021.FileManager.filemanager;

import java.io.File;

public class cmdNV implements CommandExecutor {
    private File file = filemanager.getNVLangFile();
    private FileConfiguration NVLang = (FileConfiguration) YamlConfiguration.loadConfiguration(this.file);
    private String language = this.NVLang.getString("Language");


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                if (p.hasPermission("SimpleNightvision.NV.self") || p.hasPermission("SimpleNightvision.NV.*")) {
                    if (!p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999, 255), true);
                        p.sendMessage(String.valueOf(this.NVLang.getString(String.valueOf(this.language) + ".Prefix")) + this.NVLang.getString(String.valueOf(this.language) + ".NVON"));
                        return true;
                    } else {
                        p.removePotionEffect(PotionEffectType.NIGHT_VISION);
                        p.sendMessage(String.valueOf(this.NVLang.getString(String.valueOf(this.language) + ".Prefix")) + this.NVLang.getString(String.valueOf(this.language) + ".NVOFF"));
                        return true;
                    }
                } else {
                    p.sendMessage(String.valueOf(this.NVLang.getString(String.valueOf(this.language) + ".Prefix")) + this.NVLang.getString(String.valueOf(this.language) + ".NoPerm"));
                    return true;
                }

            } else if (args.length == 1) {
                if (p.hasPermission("SimpleNightvision.NV.others") || p.hasPermission("SimpleNightvision.NV.*")) {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {
                        if (!target.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                            target.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999, 255), true);
                            target.sendMessage(String.valueOf(this.NVLang.getString(String.valueOf(this.language) + ".Prefix")) + this.NVLang.getString(String.valueOf(this.language) + ".NVON"));
                            return true;
                        } else {
                            target.removePotionEffect(PotionEffectType.NIGHT_VISION);
                            target.sendMessage(String.valueOf(this.NVLang.getString(String.valueOf(this.language) + ".Prefix")) + this.NVLang.getString(String.valueOf(this.language) + ".NVOFF"));
                            return true;                        }
                    } else {
                        p.sendMessage(String.valueOf(this.NVLang.getString(String.valueOf(this.language) + ".Prefix")) + this.NVLang.getString(String.valueOf(this.language) + ".NotOn"));
                        return true;
                    }
                } else {

                    p.sendMessage(String.valueOf(this.NVLang.getString(String.valueOf(this.language) + ".Prefix")) + this.NVLang.getString(String.valueOf(this.language) + ".NoPerm"));
                    return true;}
            } else {
                p.sendMessage(String.valueOf(this.NVLang.getString(String.valueOf(this.language) + ".Prefix")) + "USAGE: /NV ");
                return true;
            }
        } else {
            sender.sendMessage(String.valueOf(this.NVLang.getString(String.valueOf(this.language) + ".Prefix")) + this.NVLang.getString(String.valueOf(this.language) + ".NoPlayer"));
            return true;
        }

        //return false;
    }
}
