package me.ArkEssentials.CommandsBungee;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.Arrays;

public class LobbyCommand extends Command {

    public LobbyCommand() {
        super("Lobby", "ArkEssentials.Lobby", "hub");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if ((commandSender instanceof ProxiedPlayer)) {
            ProxiedPlayer p = (ProxiedPlayer) commandSender;

            {   // [+] Informa ao jogador que ele já está conectado ao Lobby.
                if (p.getServer().getInfo().getName().equalsIgnoreCase("lobby")) {
                    Arrays.asList(
                            "",
                            "§7(§c!§7) §fVocê já está conectado ao Lobby.",
                            ""
                    ).forEach((m) -> p.sendMessage(new ComponentBuilder(m).create()));
                    return;
                }
            }

            {   // [+] Conecta o jogador ao Lobby.
                Arrays.asList(
                        "",
                        "§7(§c!§7) §fConectando você ao Lobby...",
                        ""
                ).forEach((m) -> p.sendMessage(new ComponentBuilder(m).create()));
                p.connect(ProxyServer.getInstance().getServerInfo("lobby"));
            }

        }
    }
}
