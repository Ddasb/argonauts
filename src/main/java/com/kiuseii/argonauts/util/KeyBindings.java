package com.kiuseii.argonauts.util;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBindings {
        public static final String KEY_BINDINGS_CATEGORY = "key.category.argonauts.bindings";
        public static final String KEY_SPELL_ONE = "key.argonauts.spell_one";
        public static final String KEY_SHOW_STATS = "key.argonauts.show_stats";

        public static final KeyMapping SPELL_ONE_KEY = new KeyMapping(KEY_SPELL_ONE, KeyConflictContext.IN_GAME,
                        InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, KEY_BINDINGS_CATEGORY);

        public static final KeyMapping SHOW_STATS_KEY = new KeyMapping(KEY_SHOW_STATS, KeyConflictContext.IN_GAME,
                        InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_A, KEY_BINDINGS_CATEGORY);
}
