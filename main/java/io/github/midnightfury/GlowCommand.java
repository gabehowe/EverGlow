package io.github.midnightfury.everglow;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GlowCommand implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("§cNot enough args!");
            // Return false because usage was incorrect
            // https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/command/CommandExecutor.html#onCommand(org.bukkit.command.CommandSender,org.bukkit.command.Command,java.lang.String,java.lang.String%5B%5D)
            return false;
        }

        if (!sender.isOp()) {
            sender.sendMessage("§cYou gotta be opped for that!");
            return true;
        }

        Player player = (Player) Bukkit.getPlayer(args[0]);
        if (player == null || !player.isOnline()) {
            sender.sendMessage("§c" + args[0] + " is offline or does not exist");
            return true;
        }

        String glowStateArgument = args[1].toLowerCase();
        if (glowStateArgument.equals("on")) {
            if (player.isGlowing()) {
                sender.sendMessage("§c" + player.getDisplayName() + " is already glowing");
                return true;
            }

            player.setGlowing(true);
            sender.sendMessage("§a" + player.getDisplayName() + " is now glowing");
            return true;
        }

        if (glowStateArgument.equals("off")) {
            if (!player.isGlowing()) {
                sender.sendMessage("§c" + player.getDisplayName() + " isn't glowing");
                return true;
            }

            player.setGlowing(false);
            sender.sendMessage("§a" + player.getDisplayName() + " is no longer glowing");
            return true;
        }

        // Arguments must have been invalid
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                list.add(p.getDisplayName());
            }
            return list;
        }

        if (args.length == 2) {
            list.add("on");
            list.add("off");
            return list;
        }

        return null;
    }
}
