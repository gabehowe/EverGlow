package io.github.midnightfury.everglow;

import org.bukkit.plugin.java.JavaPlugin;

public final class EverGlow extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("glow").setExecutor(new GlowCommand());
        this.getCommand("glow").setTabCompleter(new GlowCommand());
    }
}
