package me.ArkEssentials.CommandsSpigot;

import me.ArkEssentials.CommandsSpigot.CommandUtils.CommandInterface;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandInterface {

    @Override
    public void onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player p = (Player) sender;

        {   // [+] Verifica se o jogador tem permissão para usar o comando.
            if (!p.hasPermission("ArkEssentials.Fly")) {
                sendPlayerMessage(p,"§7(§c!§7) §fVocê não tem acesso a este comando.");
                return;
            }
        }

        if (args.length > 0) {

            {   // [+] Verifica se o jogador tem permissão para alterar o modo de voo de outras pessoas.
                if (!p.hasPermission("ArkEssentials.Fly.Others")) {
                    sendPlayerMessage(p,"§7(§c!§7) §fVocê não tem acesso a esta função.");
                    return;
                }
            }

            {   // [+] Altera o modo de voo do jogador referido.
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    target.setAllowFlight(!target.getAllowFlight());
                    sendPlayerMessage(p, "§7(§e!§7) §a " + p.getName() + " §falterou seu modo de voo.");
                }
                return;
            }

        }

        {   // [+] Altera o seu próprio modo de jogo.
            p.setAllowFlight(!p.getAllowFlight());
            sendPlayerMessage(p, "§7(§e!§7) §fModo de voo " + (p.getAllowFlight() ? "§a§n§lativo." : "§c§n§ldesligado."));
        }


    }

    private void sendPlayerMessage(Player p, String message) {
        p.sendMessage("");
        p.sendMessage(message);
        p.sendMessage("");
    }

}
