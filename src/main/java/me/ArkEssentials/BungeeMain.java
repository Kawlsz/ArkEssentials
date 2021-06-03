package me.ArkEssentials;

import me.ArkEssentials.CommandsBungee.LobbyCommand;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeMain extends Plugin {

    private static BungeeMain bungeeInstance;

    @Override
    public void onEnable() {
        bungeeInstance = this;

        getLogger().info("System loaded and ready to use.");
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new LobbyCommand());

        super.onEnable();
    }

    @Override
    public void onDisable() {

    }

    public static BungeeMain getBungeeInstance() { return bungeeInstance; }
}
