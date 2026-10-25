package com.blah.coreascension;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(CoreAscension.MODID)
public class CoreAscension {
    public static final String MODID = "coreascension";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CoreAscension(IEventBus modEventBus, ModContainer modContainer) {
    }
}
