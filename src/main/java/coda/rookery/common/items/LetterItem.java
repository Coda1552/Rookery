package coda.rookery.common.items;

import coda.rookery.common.menus.LetterDestinationMenu;
import coda.rookery.common.menus.LetterMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class LetterItem extends Item {

    public LetterItem(Properties builder) {
        super(builder);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        Player player = pContext.getPlayer();
        ItemStack itemstack = player.getItemInHand(player.getUsedItemHand());


        if (blockstate.is(Blocks.CARTOGRAPHY_TABLE)) {
            player.openMenu(new SimpleMenuProvider((windowId, inv, owner) -> new LetterDestinationMenu(windowId, inv), itemstack.getDisplayName()));
            player.awardStat(Stats.ITEM_USED.get(this));
        }
        else {
            player.openMenu(new SimpleMenuProvider((windowId, inv, owner) -> new LetterMenu(windowId, inv), itemstack.getDisplayName()));
            player.awardStat(Stats.ITEM_USED.get(this));
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player player, InteractionHand pUsedHand) {
        ItemStack stack = player.getItemInHand(pUsedHand);

        player.openMenu(new SimpleMenuProvider((windowId, inv, owner) -> new LetterMenu(windowId, inv), stack.getDisplayName()));
        player.awardStat(Stats.ITEM_USED.get(this));

        return InteractionResultHolder.sidedSuccess(stack, pLevel.isClientSide);
    }
}
