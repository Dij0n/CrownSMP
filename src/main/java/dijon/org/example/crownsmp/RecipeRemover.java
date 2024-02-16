package dijon.org.example.crownsmp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import java.util.Iterator;

import static org.bukkit.Bukkit.getServer;

public class RecipeRemover {

    public RecipeRemover(CrownSMP plugin){

        NamespacedKey recipeKey = new NamespacedKey(plugin, "crown_recipe");
        Bukkit.removeRecipe(recipeKey);

    }

}
