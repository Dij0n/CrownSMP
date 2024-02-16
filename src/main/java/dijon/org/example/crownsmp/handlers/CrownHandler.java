package dijon.org.example.crownsmp.handlers;

import dijon.org.example.crownsmp.CrownSMP;
import dijon.org.example.crownsmp.RecipeRemover;
import dijon.org.example.crownsmp.crafting.CrownCrafting;
import dijon.org.example.crownsmp.crafting.CrownItem;
import dijon.org.example.crownsmp.crafting.SwordItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import javax.naming.Name;

public class CrownHandler implements Listener {

    public static Player currentRuler = Bukkit.getPlayer("2be5a150-e0b4-4c03-a314-750762185fcb");
    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    CrownSMP plugin;
    public CrownHandler(CrownSMP plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onInvEquip (InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        //Bukkit.getLogger().info("Inventory Clicked: Cursor: " + e.getCursor().getType().toString() + ", Item: " + e.getCurrentItem().getType().toString() + ", Slot: " + e.getSlot());
        if (e.getCurrentItem().hasItemMeta()){
            if (e.getCurrentItem().getItemMeta().hasCustomModelData()){

                if (e.getCurrentItem().getItemMeta().getCustomModelData() == 1920){
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().getItemMeta().getCustomModelData() == 1919 && e.getSlot() == 39){
                    newCrown(p);
                }

                if (e.isShiftClick() && e.getCurrentItem().getItemMeta().getCustomModelData() == 1919){
                    if (p.getInventory().getHelmet() == null){
                        newCrown(p);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onRightEquip (PlayerInteractEvent e){
        if (e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
                int helmetRData = e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData();
                if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && (helmetRData == 1919)){
                    if (e.getPlayer().getInventory().getHelmet() == null){
                        newCrown(e.getPlayer());
                    }
                }
            }
        }
        if (e.getPlayer().getInventory().getItemInOffHand().hasItemMeta()) {
            if (e.getPlayer().getInventory().getItemInOffHand().getItemMeta().hasCustomModelData()) {
                int helmetLData = e.getPlayer().getInventory().getItemInOffHand().getItemMeta().getCustomModelData();
                if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && (helmetLData == 1919)){
                    if (e.getPlayer().getInventory().getHelmet() == null){
                        newCrown(e.getPlayer());
                    }
                }
            }
        }
    }

    public void newCrown(Player p){
        //Bukkit.getLogger().info("RULER PICKUP!!!!!!!!");
        if (currentRuler != p){
            ItemStack swordItem = SwordItem.get();
            String command = "tellraw @a [\"\",{\"text\":\"" + p.getName() + " \",\"bold\":true,\"italic\":true,\"color\":\"#FFFF00\"},{\"text\":\"has worn the crown...\",\"italic\":true,\"color\":\"red\"},\"\\n\",{\"text\":\"...they are now the \",\"italic\":true,\"color\":\"red\"},{\"text\":\"RULER\",\"bold\":true,\"italic\":true,\"color\":\"#FF0000\"}]";
            Bukkit.dispatchCommand(console, "playsound minecraft:entity.ender_dragon.growl master @a ~ ~ ~ 10 0.5");
            Bukkit.dispatchCommand(console, command);
            currentRuler = p;
            new RecipeRemover(plugin);
            p.getInventory().addItem(swordItem);
        }
    }

    @EventHandler
    public void onKill(PlayerDeathEvent e){
        if (e.getEntity().getKiller() instanceof Player){

            Player killer = e.getEntity().getKiller().getPlayer();
            if (killer.getInventory().getItemInMainHand().hasItemMeta()){
                if(killer.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()){
                    if (killer.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1920){
                        Bukkit.dispatchCommand(console, "ban " + e.getEntity().getName() + " You were killed by the Ruler!");
                        Bukkit.dispatchCommand(console, "playsound minecraft:entity.experience_orb.pickup master " + killer.getName() + " ~ ~ ~ 10 0.5");
                        Bukkit.dispatchCommand(console, "particle minecraft:totem_of_undying ~ ~1 ~ 0.1 0.1 0.1 0.7 100 normal");
                        Bukkit.dispatchCommand(console, "tellraw @a [\"\",{\"text\":\"" + e.getEntity().getName() + " \",\"bold\":true,\"italic\":true,\"color\":\"#FFFF00\"},{\"text\":\"has been \",\"italic\":true,\"color\":\"red\"},{\"text\":\"KILLED \",\"bold\":true,\"italic\":true,\"color\":\"#FF0000\"},{\"text\":\"by the Ruler\",\"italic\":true,\"color\":\"red\"}]");
                    }
                }
            }
        }


        for (ItemStack i : e.getDrops()){
            if (i.hasItemMeta()){
                if (i.getItemMeta().hasCustomModelData()){
                    if (i.getItemMeta().getCustomModelData() == 1920){
                        e.getDrops().remove(i);
                        currentRuler = Bukkit.getPlayer("699a3e16-2f2c-4459-8ec1-7220be18119d");
                        break;
                    }
                }
            }
        }

    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        ItemStack swordItem = SwordItem.get();
        if (e.getItemDrop().getItemStack().equals(swordItem)){
            e.setCancelled(true);
        }
    }

}
