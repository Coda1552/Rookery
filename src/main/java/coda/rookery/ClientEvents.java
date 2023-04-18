package coda.rookery;

import coda.rookery.client.screen.LetterScreen;
import coda.rookery.registry.RookeryMenus;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Rookery.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e) {
        MenuScreens.register(RookeryMenus.LETTER.get(), LetterScreen::new);
    }
}
