package coda.rookery.registry;

import coda.rookery.Rookery;
import coda.rookery.common.items.LetterItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RookeryItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Rookery.MOD_ID);
    public static final CreativeModeTab GROUP = new CreativeModeTab(Rookery.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(LETTER.get());
        }
    };

    public static final RegistryObject<Item> LETTER = ITEMS.register("letter", () -> new LetterItem(new Item.Properties().tab(GROUP)));
}
