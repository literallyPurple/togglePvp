package dev.littleprogrammer.togglepvp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }

        Player player = (Player) sender;
        if (label.equalsIgnoreCase("pvpToggle")) {
            if (!sender.isOp() && !sender.hasPermission("pvp.cmd")) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
                return true;
            } else {
                if (pvp.onOff == true) {
                    sender.sendMessage(ChatColor.RED + "Pvp is on!");
                    pvp.onOff = false;
                } else {
                    sender.sendMessage(ChatColor.GREEN + "Pvp is off!");
                    pvp.onOff = true;
                }
            }
        }
        return true;
    }
}
