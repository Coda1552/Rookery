package coda.rookery;

import coda.rookery.registry.RookeryItems;
import coda.rookery.registry.RookeryMenus;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
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

        forgeBus.addListener(this::blockInteract);
    }

    private void blockInteract(PlayerInteractEvent.RightClickBlock e) {
        Player player = e.getEntity();

        if (player.getItemInHand(player.getUsedItemHand()).is(RookeryItems.LETTER.get()) && e.getLevel().getBlockState(e.getPos()).is(Blocks.CARTOGRAPHY_TABLE)) {
            e.setUseBlock(Event.Result.DENY);
        }
    }
}
