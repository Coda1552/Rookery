package coda.rookery;

import coda.rookery.registry.RookeryItems;
import coda.rookery.registry.RookeryMenus;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Rookery.MOD_ID)
public class Rookery {
    public static final String MOD_ID = "rookery";

    public Rookery() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        RookeryItems.ITEMS.register(modBus);
        RookeryMenus.MENUS.register(modBus);
    }

}
