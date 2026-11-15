package dev.redstoneengineering;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RedstoneEngineering implements ModInitializer {
    public static final String MOD_ID = "redstoneengineering";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Block RECEIVER;
    public static Block FREEZER;
    public static Block TELEPORTER;
    public static Block DUPER;
    public static Block DELETER;
    public static Block COMPRESSER;
    public static Block ENTITY_HOPPER;
    public static Item REMOTE;

    private static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    private static Block registerMachine(String name) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id(name));
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id(name));

        Block block = new Block(
                BlockBehaviour.Properties.of()
                        .strength(3.0F)
                        .setId(blockKey)
        );

        Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
        Registry.register(
                BuiltInRegistries.ITEM,
                itemKey,
                new BlockItem(
                        block,
                        new Item.Properties()
                                .setId(itemKey)
                                .useBlockDescriptionPrefix()
                )
        );
        return block;
    }

    private static Item registerItem(String name) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id(name));
        return Registry.register(
                BuiltInRegistries.ITEM,
                key,
                new Item(new Item.Properties().setId(key).stacksTo(1))
        );
    }

    @Override
    public void onInitialize() {
        RECEIVER = registerMachine("receiver");
        FREEZER = registerMachine("freezer");
        TELEPORTER = registerMachine("teleporter");
        DUPER = registerMachine("duper");
        DELETER = registerMachine("deleter");
        COMPRESSER = registerMachine("compresser");
        ENTITY_HOPPER = registerMachine("entity_hopper");
        REMOTE = registerItem("remote");

        ResourceKey<CreativeModeTab> tabKey = ResourceKey.create(
                Registries.CREATIVE_MODE_TAB,
                id("redstone_engineering")
        );

        CreativeModeTab tab = FabricItemGroup.builder()
                .icon(() -> new ItemStack(RECEIVER))
                .title(Component.literal("Redstone Engineering"))
                .displayItems((parameters, output) -> {
                    output.accept(RECEIVER);
                    output.accept(FREEZER);
                    output.accept(TELEPORTER);
                    output.accept(DUPER);
                    output.accept(DELETER);
                    output.accept(COMPRESSER);
                    output.accept(ENTITY_HOPPER);
                    output.accept(REMOTE);
                })
                .build();

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, tabKey, tab);
        LOGGER.info("Redstone Engineering Creative tab registered!");
    }
}
