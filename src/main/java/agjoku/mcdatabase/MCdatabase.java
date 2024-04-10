package agjoku.mcdatabase;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MCdatabase extends JavaPlugin implements Listener, TabCompleter {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if(e.getMessage().equals("hello")){
            e.setMessage("こんにちは" + e.getPlayer().getDisplayName());
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(command.getName().equalsIgnoreCase("hashing")){
            if(args.length >= 2){
                String hash;
                try {
                    hash = HashingCommand.hashingCommand(args);
                    if(hash.equals("false")) return false;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
                sender.sendMessage(hash);
                if(args.length == 3 && args[2].equals("copy")) {
                    clipboard(hash);
                    sender.sendMessage("クリップボードにコピーしました");
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args){
        if(command.getName().equalsIgnoreCase("hashing")){
            if(args.length == 1){
                if (args[0].isEmpty()){
                    return Arrays.asList("md5","sha1","sha256","sha3_256");
                } else if("md5".startsWith(args[0]) && "sha1".startsWith(args[0]) && "sha256".startsWith(args[0]) && "sha3_256".startsWith(args[0])) return Arrays.asList("md5","sha1","sha256","sha3_256");
                 else if("md5".startsWith(args[0])) return Collections.singletonList("md5");
                 else if("sha1".startsWith(args[0])) return Collections.singletonList("sha1");
                 else if("sha256".startsWith(args[0])) return Collections.singletonList("sha256");
                 else if("sha3_256".startsWith(args[0])) return Collections.singletonList("sha3_256");
            }
            if(args.length == 3){
                return Arrays.asList("copy");
            }
        }
        return null;
    }

    public void clipboard(String str){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(str);
        clipboard.setContents(selection,null);
    }
}
