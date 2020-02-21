package net.fabricmc.example;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.ItemEntity;

public class ExampleBlock extends Block{
	public ExampleBlock()
	{
		super(FabricBlockSettings
				.of(Material.METAL)
				.lightLevel(7)
				.breakByTool(FabricToolTags.PICKAXES, 2)
				.hardness(2f)
				.resistance(20f).build());
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockHitResult hit) {
		if (world.isClient) return ActionResult.SUCCESS;
		
		world.spawnEntity(new ItemEntity(world, pos.getX(),pos.getY(),pos.getZ(),new ItemStack(Items.DIAMOND)));
		//player.inventory.offerOrDrop(world, new ItemStack(Items.DIAMOND));
		return ActionResult.SUCCESS;
	}

	@Override
	public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity,
			ItemStack stack) {	
		
		world.spawnEntity(new ItemEntity(world, pos.getX(),pos.getY(),pos.getZ(),new ItemStack(Items.DIAMOND)));
	}
	
	
	
	
}
