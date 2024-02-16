package dijon.org.example.crownsmp.crafting;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CrownItem {

    public static ItemStack get(){
        ItemStack crownItem = new ItemStack(Material.GOLDEN_HELMET);
        ItemMeta crownItemMeta = crownItem.getItemMeta();
        crownItemMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Crown");
        crownItemMeta.addEnchant(Enchantment.BINDING_CURSE,1 , true);
        crownItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        crownItemMeta.setUnbreakable(true);
        crownItemMeta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier("GENERIC_MAX_HEALTH",40, AttributeModifier.Operation.ADD_NUMBER));
        crownItemMeta.setCustomModelData(1919);
        crownItem.setItemMeta(crownItemMeta);
        return crownItem;
    }

}
