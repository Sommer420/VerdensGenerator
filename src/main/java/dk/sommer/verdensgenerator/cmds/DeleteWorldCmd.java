package dk.sommer.verdensgenerator.cmds;

import dk.sommer.verdensgenerator.utils.WorldUtils;
import eu.okaeri.commands.annotation.Arg;
import eu.okaeri.commands.annotation.Command;
import eu.okaeri.commands.annotation.Context;
import eu.okaeri.commands.annotation.Executor;
import eu.okaeri.commands.bukkit.annotation.Permission;
import eu.okaeri.commands.service.CommandService;
import eu.okaeri.injector.annotation.Inject;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@Command(label = "deleteworld", aliases = {"delworld", "dw"})
@Permission("sommer.deleteworld")
public class DeleteWorldCmd implements CommandService {
    private @Inject WorldUtils worldUtils;

    @Executor(pattern = "*")
    public void __(@Context Player sender, @Arg String worldName) {
        if (Bukkit.getWorlds().size() <= 1) {
            sender.sendMessage("§cDu kan ikke slette den sidste verden!");
            return;
        }
        sender.sendMessage("§eForsøger at slette verdenen §b"+worldName+"§e...");
        try {
            worldUtils.deleteWorld(worldName);
            sender.sendMessage("§aVerdenen §b" + worldName + "§a blev slettet!");
        } catch (Exception e) {
            sender.sendMessage("§cVerdenen §b" + worldName + "§c kunne ikke slettes! §8(" + e.getMessage() + ")");
            e.printStackTrace();
        }
    }
}
