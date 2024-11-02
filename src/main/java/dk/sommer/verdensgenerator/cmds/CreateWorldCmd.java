package dk.sommer.verdensgenerator.cmds;

import dk.sommer.verdensgenerator.utils.WorldUtils;
import eu.okaeri.commands.annotation.Arg;
import eu.okaeri.commands.annotation.Command;
import eu.okaeri.commands.annotation.Context;
import eu.okaeri.commands.annotation.Executor;
import eu.okaeri.commands.bukkit.annotation.Async;
import eu.okaeri.commands.bukkit.annotation.Permission;
import eu.okaeri.commands.bukkit.annotation.Sync;
import eu.okaeri.commands.service.CommandService;
import eu.okaeri.injector.annotation.Inject;
import org.bukkit.WorldType;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Command(label = "createworld", aliases = "cw")
@Permission("sommer.createworld")
public class CreateWorldCmd implements CommandService {

    private @Inject WorldUtils worldUtils;
    private List<String> getAvailableWorldTypes() {
        List<String> worldTypes = Arrays.stream(WorldType.values())
                .map(WorldType::name)
                .collect(Collectors.toList());
        worldTypes.remove("FLAT");
        worldTypes.add("VOID");
        worldTypes.add("FLAT");
        return worldTypes;
    }

    @Sync
    @Executor(pattern = "* *")
    public void __(@Context CommandSender sender, @Arg String worldName, @Arg String worldType) {
        sender.sendMessage("§eForsøger at oprette verdenen §b" + worldName + "§e med typen §b" + worldType + "§e...");
        try {
            worldUtils.createWorld(worldName, worldType);
            sender.sendMessage("§aVerdenen §b" + worldName + "§a blev oprettet!");
        } catch (Exception e) {
            sender.sendMessage("§cVerdenen §b" + worldName + "§c kunne ikke oprettes! §8(" + e.getMessage() + ")");
            e.printStackTrace();
        }
    }

    @Async
    @Executor
    public void __(@Context CommandSender sender) {
        sender.sendMessage("§eBrug: §b/createworld <navn> <type>");
        List<String> availableTypes = getAvailableWorldTypes();
        sender.sendMessage("§eTilgængelige verdenstyper:");
        for (String type : availableTypes) {
            sender.sendMessage("§8 - §b" + type);
        }
    }
}
