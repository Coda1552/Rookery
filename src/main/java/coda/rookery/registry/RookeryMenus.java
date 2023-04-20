package coda.rookery.registry;

import coda.rookery.Rookery;
import coda.rookery.common.menus.LetterDestinationMenu;
import coda.rookery.common.menus.LetterMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RookeryMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Rookery.MOD_ID);

    public static final RegistryObject<MenuType<LetterMenu>> LETTER = MENUS.register("letter", () -> new MenuType<>(LetterMenu::new));
    public static final RegistryObject<MenuType<LetterDestinationMenu>> LETTER_DESTINATION = MENUS.register("letter_destination", () -> new MenuType<>(LetterDestinationMenu::new));
}