package dijon.org.example.crownsmp;

import dijon.org.example.crownsmp.crafting.CrownCrafting;
import dijon.org.example.crownsmp.handlers.CrownHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class CrownSMP extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new CrownCrafting(this);
        new CrownHandler(this);
        this.getCommand("crownreset").setExecutor(new CrownReset(this));

        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "gamerule sendCommandFeedback false");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
