package me.ArkEssentials.CommandsSpigot.CommandUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface CommandInterface {
    void onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args);
}
