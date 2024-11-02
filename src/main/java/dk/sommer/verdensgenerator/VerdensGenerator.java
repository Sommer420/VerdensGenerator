package dk.sommer.verdensgenerator;

import eu.okaeri.platform.bukkit.OkaeriBukkitPlugin;
import eu.okaeri.platform.core.annotation.Scan;
import eu.okaeri.platform.core.plan.ExecutionPhase;
import eu.okaeri.platform.core.plan.Planned;
import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.logging.Level;

@Getter
@Scan(exclusions = "dk.sommer.verdensgenerator.libs", deep = true)
public final class VerdensGenerator extends OkaeriBukkitPlugin {
    @Planned(ExecutionPhase.POST_SETUP)
    public void startup() {
        Bukkit.getLogger().info("\n" +
                "░██████╗░█████╗░███╗░░░███╗███╗░░░███╗███████╗██████╗░\n" +
                "██╔════╝██╔══██╗████╗░████║████╗░████║██╔════╝██╔══██╗\n" +
                "╚█████╗░██║░░██║██╔████╔██║██╔████╔██║█████╗░░██████╔╝\n" +
                "░╚═══██╗██║░░██║██║╚██╔╝██║██║╚██╔╝██║██╔══╝░░██╔══██╗\n" +
                "██████╔╝╚█████╔╝██║░╚═╝░██║██║░╚═╝░██║███████╗██║░░██║\n" +
                "╚═════╝░░╚════╝░╚═╝░░░░░╚═╝╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚═╝\n" +
                "\n");
        Bukkit.getLogger().log(Level.FINEST, "VerdensGenerator loaded! (v"+this.getDescription().getVersion()+")");
    }
}
