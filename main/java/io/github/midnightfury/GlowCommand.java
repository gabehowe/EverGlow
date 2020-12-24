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
        if(args.length >= 2){
            if(sender.isOp()){
                Player player = (Player) Bukkit.getPlayer(args[0]);
                if(!player.isOnline()) {
                    sender.sendMessage("§cThat player is Offline!");
                }
                if(args[1].toLowerCase().equals("on")) {
                    if(player.isGlowing()) {
                        sender.sendMessage("§cThat player is already glowing!");
                        return true;
                    }
                    player.setGlowing(true);
                    sender.sendMessage("§a" + player.getDisplayName() + " §ais now glowing");
                    return true;
                }
                if(args[1].toLowerCase().equals("off")) {
                    if(!player.isGlowing()) {
                        sender.sendMessage("§cThat player was never glowing");
                        return true;
                    }
                    player.setGlowing(false);
                    sender.sendMessage("§a" + player.getDisplayName() + " §ais no longer glowing");
                    return true;
                }
                else {
                    sender.sendMessage("§cYou gotta be opped for that!");
                    return true;
                }
            }
        }
        else {
            sender.sendMessage("§cNot enough args!");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = new ArrayList<>();
        if(args.length == 1) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                list.add(p.getDisplayName());
            }
            return list;
        }
        else if (args.length == 2) {
            list.add("on");
            list.add("off");
            return list;
        }
        else {
            return null;
        }

    }
}
