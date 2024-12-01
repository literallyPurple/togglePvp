package dev.littleprogrammer.togglepvp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class pvp implements Listener {

    public static boolean onOff = false;

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        if (onOff == true) {
            if (event.getDamager()  instanceof Player) {
                if (event.getEntity() instanceof Player) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
