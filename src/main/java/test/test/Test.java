package test.test;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Test extends JavaPlugin {

    private CommandSender sender;
    private Command command;
    private String label;
    private String[] args;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("プラグインが有効になったよ!");
        System.out.println("プラグインが有効になりました。");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("プラグインが無効になった...");
        System.out.println("プラグインが無効になりました。");

    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("test")) {
            sender.sendMessage("command enter");
        }

        return true;
    }





    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage("こんにちは: " + e.getPlayer().getName() + "さん");
    }
    @EventHandler
    public void onPlayerJoin(BlockBreakEvent e) {
        Block b = e.getBlock();
        if (((org.bukkit.block.Block) b).getType() == Material.SAND) {
            e.setCancelled(true);
            ((org.bukkit.block.Block) b).setType(Material.GLASS);
        }
    }
}
