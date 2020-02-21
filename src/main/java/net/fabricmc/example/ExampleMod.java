package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExampleMod implements ModInitializer {
	@Override
	public void onInitialize() {
		Registry.register(
				Registry.BLOCK,
				new Identifier("rcos:example_block"),
				new ExampleBlock()
				);
	}
}
