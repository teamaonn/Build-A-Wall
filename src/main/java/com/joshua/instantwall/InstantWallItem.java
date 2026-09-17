package com.joshua.instantwall;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

/**
 * A compact bundle of two cobblestone walls. Using it on the top of a block
 * deploys the two vanilla wall blocks vertically and consumes one bundle.
 */
public final class InstantWallItem extends Item {
	public InstantWallItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		if (context.getClickedFace() != Direction.UP) {
			return InteractionResult.FAIL;
		}

		Level level = context.getLevel();
		BlockPos lowerPos = context.getClickedPos().above();
		BlockPos upperPos = lowerPos.above();

		BlockState lowerState = level.getBlockState(lowerPos);
		BlockState upperState = level.getBlockState(upperPos);

		// Never destroy an existing block to make room for the wall.
		if (!lowerState.isAir() || !upperState.isAir()) {
			return InteractionResult.FAIL;
		}

		if (!level.isClientSide()) {
			BlockState wall = Blocks.COBBLESTONE_WALL.defaultBlockState();

			level.setBlockAndUpdate(lowerPos, wall);
			level.setBlockAndUpdate(upperPos, wall);
			level.playSound(
					null,
					lowerPos,
					SoundEvents.STONE_PLACE,
					SoundSource.BLOCKS,
					1.0F,
					0.8F
			);

			Player player = context.getPlayer();
			if (player == null || !player.getAbilities().instabuild) {
				context.getItemInHand().shrink(1);
			}
		}

		return InteractionResult.SUCCESS;
	}
}
