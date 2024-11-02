package dk.sommer.verdensgenerator.cmds;

import eu.okaeri.commands.annotation.Arg;
import eu.okaeri.commands.annotation.Command;
import eu.okaeri.commands.annotation.Context;
import eu.okaeri.commands.annotation.Executor;
import eu.okaeri.commands.bukkit.annotation.Permission;
import eu.okaeri.commands.service.CommandService;
import org.bukkit.entity.Player;

@Command(label = "worldtp", aliases = {"wtp", "tpw"})
@Permission("sommer.worldtp")
public class WorldTpCmd implements CommandService {
    @Executor(pattern = "*")
    public void __(@Context Player sender, @Arg String worldName) {
        sender.sendMessage("§eForsøger at teleportere til verdenen §b"+worldName+"§e...");
        if (sender.getServer().getWorld(worldName) != null) {
            sender.teleport(sender.getServer().getWorld(worldName).getSpawnLocation());
            sender.sendMessage("§aDu blev teleporteret til verdenen §b"+worldName+"§a!");
        } else {
            sender.sendMessage("§cVerdenen §b"+worldName+"§c findes ikke!");
        }
    }
}
