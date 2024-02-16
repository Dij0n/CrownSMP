package dijon.org.example.crownsmp.crafting;

import dijon.org.example.crownsmp.CrownSMP;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.*;

import static org.bukkit.Bukkit.getServer;

public class CrownCrafting {

    public CrownCrafting(CrownSMP plugin) {

        NamespacedKey recipeKey = new NamespacedKey(plugin, "crown_recipe");

        ItemStack potion = new ItemStack(Material.POTION);
        PotionMeta pMeta = (PotionMeta) potion.getItemMeta();
        pMeta.setBasePotionData(new PotionData(PotionType.STRENGTH));
        potion.setItemMeta(pMeta);

        ItemStack crownItem = CrownItem.get();

        ShapedRecipe crownRec = new ShapedRecipe(recipeKey, crownItem);

        crownRec.shape("GDG", "PHP", "GDG");
        crownRec.setIngredient('G', Material.GOLDEN_APPLE);
        crownRec.setIngredient('D', Material.DIAMOND);
        crownRec.setIngredient('P', new RecipeChoice.ExactChoice(potion));
        crownRec.setIngredient('H', Material.GOLDEN_HELMET);

        try{
            Bukkit.addRecipe(crownRec);
        }catch(Exception e){

        }

    }

}
