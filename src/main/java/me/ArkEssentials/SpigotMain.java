package me.ArkEssentials;

import me.ArkEssentials.CommandsSpigot.CommandUtils.CommandRegister;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotMain extends JavaPlugin {

    private static SpigotMain spigotInstance;

    @Override
    public void onEnable() {
        spigotInstance = this;

        new CommandRegister();

    }

    public void onDisable() {

    }

    public static SpigotMain getSpigotInstance() {
        return spigotInstance;
    }

}
