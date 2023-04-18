package coda.rookery.common.items;

import coda.rookery.common.menus.LetterMenu;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LetterItem extends Item {

    public LetterItem(Properties builder) {
        super(builder);
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        pPlayer.openMenu(new SimpleMenuProvider((windowId, inv, owner) -> new LetterMenu(windowId, inv, itemstack), itemstack.getDisplayName()));
        pPlayer.awardStat(Stats.ITEM_USED.get(this));

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}
