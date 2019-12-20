package me.Maximilian1021.FileManager;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;


public class filemanager {

    public static void createLangFile() {
        File file = new File("plugins/SimplePlugins", "SimpleNightvisionLang.yml");

        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

        if(!file.exists()) {
            yamlConfiguration.set("Language", "German");

            yamlConfiguration.set("German.Prefix", "§f[§bNV§f]");
            yamlConfiguration.set("German.NoPerm", " §c Du hast nicht genügend Permission");
            yamlConfiguration.set("German.NoPlayer", " §CDu musst ein Spieler sein, um den Command auszuführen");
            yamlConfiguration.set("German.NotOn", " §cDieser Speieler ist nicht online!");
            yamlConfiguration.set("German.NVON", " §bNachtsicht §aaktiviert");
            yamlConfiguration.set("German.NVOFF", " §bNachtsicht §cdeaktiviert");


            yamlConfiguration.set("English.Prefix", "§f[§bNV§f]");
            yamlConfiguration.set("English.NoPerm", "You don't have the permission to do this!");
            yamlConfiguration.set("English.NoPlayer", " §cYou have to be a player to use this command!");
            yamlConfiguration.set("English.NotOn", " §cThe selected Player isn´t online!");
            yamlConfiguration.set("English.NVON", " §bNightvision §aenabled");
            yamlConfiguration.set("English.NVOFF", " §bNightvision §cdisabled");

//           yamlConfiguration.set("English.Prefix", "§f[§bNV§f]");
//           yamlConfiguration.set("English.NoPerm", "You don't have the permission to do this!");
//           yamlConfiguration.set("English.NoPlayer", "You have to be a player to use this command!");
//           yamlConfiguration.set("English.NotOn", " §cThe selected Player isn´t online!");
//           yamlConfiguration.set("English.NVON", "§bNightvision §aenabled");
//           yamlConfiguration.set("English.NVOFF", "§bNightvision §cdisabled");
        }
        try {
            yamlConfiguration.save(file);
        } catch (IOException e) {
            System.out.println("Fehler in der Configuration SimpleNightvisionlang.yml");
            e.printStackTrace();
        }
    }

    public static File getNVLangFile() {
        return new File("plugins/SimplePlugins", "SimpleNightvisionLang.yml");
    }
}