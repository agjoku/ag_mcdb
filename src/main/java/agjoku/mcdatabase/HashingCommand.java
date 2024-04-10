package agjoku.mcdatabase;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.security.NoSuchAlgorithmException;

public class HashingCommand extends JavaPlugin implements Listener {

    public static String hashingCommand(String[] args) throws NoSuchAlgorithmException {
        Hashing hash = new Hashing();
        String str = "false";

        return switch (args[0]) {
            case "md5" -> hash.md5(args[1]);
            case "sha1" -> hash.sha1(args[1]);
            case "sha256" -> hash.sha256(args[1]);
            case "sha3_256" -> hash.sha3_256(args[1]);
            case "help" -> "md5, sha1, sha256, sha3_256が対応しています";
            default -> str;
        };
    }

}