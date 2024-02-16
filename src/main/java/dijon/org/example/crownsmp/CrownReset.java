package dijon.org.example.crownsmp;

import dijon.org.example.crownsmp.crafting.CrownCrafting;
import dijon.org.example.crownsmp.handlers.CrownHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;

public class CrownReset implements CommandExecutor {

    CrownSMP plugin;

    public CrownReset(CrownSMP plugin){
        this.plugin = plugin;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        sender.sendMessage(ChatColor.GREEN + "Success!");
        if (sender.isOp()) {
            if (sender instanceof Player) {
                CrownHandler.currentRuler = Bukkit.getPlayer("2be5a150-e0b4-4c03-a314-750762185fcb");
                new CrownCrafting(plugin);
                sender.sendMessage(ChatColor.GREEN + "Crafting recipe reset (Make sure to clear players as well!)");
            }
        }else{
            sender.sendMessage(ChatColor.RED + "You do not have permission to run this command!");
        }

        return true;
    }
}
