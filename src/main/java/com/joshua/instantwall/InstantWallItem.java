package com.joshua.instantwall;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/**
 * A compact bundle of blocks that deploys vertically from the top of a block.
 */
public final class InstantWallItem extends Item {
	private final Block placedBlock;
	private final int height;
	private final boolean replaceWater;

	public InstantWallItem(Properties properties, Block placedBlock, int height, boolean replaceWater) {
		super(properties);
		this.placedBlock = placedBlock;
		this.height = height;
		this.replaceWater = replaceWater;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		if (context.getClickedFace() != Direction.UP) {
			return InteractionResult.FAIL;
		}

		Level level = context.getLevel();
		BlockPos startPos = context.getClickedPos().above();

		for (int i = 0; i < height; i++) {
			BlockState targetState = level.getBlockState(startPos.above(i));
			if (!canReplace(targetState)) {
				return InteractionResult.FAIL;
			}
		}

		if (!level.isClientSide()) {
			BlockState placedState = placedBlock.defaultBlockState();
			for (int i = 0; i < height; i++) {
				level.setBlockAndUpdate(startPos.above(i), placedState);
			}

			level.playSound(
					null,
					startPos,
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

	private boolean canReplace(BlockState state) {
		return state.isAir() || (replaceWater && state.getFluidState().is(FluidTags.WATER));
	}
}
