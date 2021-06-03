package me.ArkEssentials.CommandsSpigot;

import me.ArkEssentials.CommandsSpigot.CommandUtils.CommandInterface;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameModeCommand implements CommandInterface {


    @Override
    public void onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;

        {   // [+] Verifica se o jogador tem permissão para usar o comando.
            if (!p.hasPermission("ArkEssentials.ChangeGamemode")) {
                sendPlayerMessage(p,"§7(§c!§7) §fVocê não tem acesso a este comando.");
                return;
            }
        }

        if (args.length > 0) {
            {   // [+] Altera o modo de jogo.
                GameMode gameMode = getGameMode(args[0]);
                if (gameMode != null) {
                    p.setGameMode(gameMode);
                    sendPlayerMessage(p, "§7(§e!§7) §fModo de jogo alterado para §a§n§l" + gameMode.name() + "§f.");
                    return;
                }
            }
        }

        if (args.length > 1) {

            {   // [+] Verifica se o jogador tem permissão para alterar o modo de jogo de outros jogadores.
                if (!p.hasPermission("ArkEssentials.ChangeGamemode.Others")) {
                    sendPlayerMessage(p,"§7(§c!§7) §fVocê não tem acesso a esta função.");
                    return;
                }
            }

            {   // Altera o modo de jogo do jogador referido.
                Player target = Bukkit.getPlayer(args[0]);
                GameMode gameMode = getGameMode(args[1]);
                if (target != null) {
                    if (gameMode != null) {
                        p.setGameMode(gameMode);
                        sendPlayerMessage(p, "§7(§e!§7) §a " + p.getName() + " §falterou seu modo de jogo para §a§n§l" + gameMode.name().toUpperCase() + "§f.");
                        return;
                    }
                    sendPlayerMessage(p, "§7(§c!§7) §fArgumentos incorretos, use §e\"/gm [player] [1-3]\"§f.");
                }
            }
        }

    }

    private GameMode getGameMode(String arg) {
        HashMap<List<String>, GameMode> gameMode = new HashMap<>();

        gameMode.put(Arrays.asList("survival", "sobrevivencia", "0"), GameMode.SURVIVAL);
        gameMode.put(Arrays.asList("creative", "creativo", "1"), GameMode.CREATIVE);
        gameMode.put(Arrays.asList("adventure", "aventura", "2"), GameMode.ADVENTURE);
        gameMode.put(Arrays.asList("spectator", "espectador", "3"), GameMode.SPECTATOR);

        for (Map.Entry<List<String>, GameMode> entry : gameMode.entrySet()) {

            for (String s : entry.getKey()) {
                if (s.equals(arg)) return entry.getValue();
            }

        }

        return null;

    }

    private void sendPlayerMessage(Player p, String message) {
        p.sendMessage("");
        p.sendMessage(message);
        p.sendMessage("");
    }

}
