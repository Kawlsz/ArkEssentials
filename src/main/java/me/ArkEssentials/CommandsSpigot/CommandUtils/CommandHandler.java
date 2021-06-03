package me.ArkEssentials.CommandsSpigot.CommandUtils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static me.ArkEssentials.SpigotMain.getSpigotInstance;

public class
CommandHandler implements CommandExecutor {

    private static final HashMap<List<String>, CommandInterface> commands = new HashMap<>();

    public void register(List<String> name, CommandInterface cmd) {
        commands.put(name, cmd);
    }

    public boolean exists(List<String> name) {
        return  commands.containsKey(name);
    }

    public CommandInterface getExecutor(String name) {
        return commands.get(name);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (sender instanceof Player) {
            commands.forEach( (ls, i) -> {

                for (Map.Entry<List<String>, CommandInterface> entry : commands.entrySet()) {
                    if (entry.getValue().equals(i)) {
                        entry.getKey().forEach( (c) -> {
                            if (c.equals(cmd.getName())) entry.getValue().onCommand(sender, cmd, commandLabel, args);
                        });
                    }
                }

            });
        } else sender.sendMessage("§7(§c!§7) §fYou must be a player to execute this command.");

        return true;
    }

    public void registerMethods() {
        commands.forEach( (ls, i) -> {
            ls.forEach( (c) -> {
                getSpigotInstance().getCommand(c).setExecutor(this);
            });
        });
    }

}
