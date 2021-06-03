package me.ArkEssentials.CommandsSpigot.CommandUtils;

import me.ArkEssentials.CommandsSpigot.FlyCommand;
import me.ArkEssentials.CommandsSpigot.GameModeCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.defaults.BukkitCommand;

import java.lang.reflect.Field;
import java.util.Arrays;

public class CommandRegister {

    public CommandRegister() {
        CommandHandler handler = new CommandHandler();

        handler.register(Arrays.asList("gamemode", "gm"), new GameModeCommand());

        handler.register(Arrays.asList("fly", "voar"), new FlyCommand());

        handler.registerMethods();
    }


}
