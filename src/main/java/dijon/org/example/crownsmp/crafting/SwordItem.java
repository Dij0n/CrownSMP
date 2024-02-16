package dijon.org.example.crownsmp.crafting;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SwordItem {

    public static ItemStack get(){
        ItemStack swordItem = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta swordItemMeta = swordItem.getItemMeta();
        swordItemMeta.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Excalibur");
        swordItemMeta.addEnchant(Enchantment.DAMAGE_ALL,10 , true);
        swordItemMeta.setCustomModelData(1920);
        swordItem.setItemMeta(swordItemMeta);
        return swordItem;
    }

}
