package io.github.midnightfury.everglow;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import io.github.midnightfury.everglow.GlowCommand;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Listeners implements Listener {
    public void onDeath(PlayerDeathEvent event) {
        if(event.getEntity().isGlowing()) {
            event.getEntity().setGlowing(true);
        }
    }
}
