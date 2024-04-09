package agjoku.mcdatabase;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCdatabase extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("プラグインが起動しました");
//        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

//    @EventHandler
//    public void onChat(AsyncPlayerChatEvent e){
//        if(e.getMessage().equals("hello")){
//            e.setMessage("こんにちは" + e.getPlayer().getDisplayName());
//        }
//    }

}
