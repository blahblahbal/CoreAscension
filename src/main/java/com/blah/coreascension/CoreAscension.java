package com.blah.coreascension;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(CoreAscension.MOD_ID)
public class CoreAscension {
    public static final String MOD_ID = "coreascension";
    public static final Logger LOGGER = LogUtils.getLogger();

    // Create a deferred register to hold blocks which will all be registered under the "coreascension" namespace.
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);

    public CoreAscension(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        
        BLOCKS.register(modEventBus);
    }
}
