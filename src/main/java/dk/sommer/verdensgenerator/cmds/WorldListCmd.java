package dk.sommer.verdensgenerator.cmds;

import eu.okaeri.commands.annotation.Command;
import eu.okaeri.commands.annotation.Context;
import eu.okaeri.commands.annotation.Executor;
import eu.okaeri.commands.bukkit.annotation.Async;
import eu.okaeri.commands.bukkit.annotation.Permission;
import eu.okaeri.commands.service.CommandService;
import org.bukkit.command.CommandSender;

@Command(label = "worldlist", aliases = {"wl"})
@Permission("sommer.worldlist")
public class WorldListCmd implements CommandService {
    @Async
    @Executor
    public void __(@Context CommandSender sender) {
        sender.sendMessage("§eVerdener: §b");
        sender.getServer().getWorlds().stream().forEach(world -> { sender.sendMessage("§8- §b"+world.getName());});
    }
}
