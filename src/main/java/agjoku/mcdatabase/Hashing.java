package agjoku.mcdatabase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {

    private String hash;

    public String md5(String str) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] md5_byte = md5.digest(str.getBytes());
        hash = Hex(md5_byte);

        return hash;
    }

    public String sha1(String str) throws NoSuchAlgorithmException {
        MessageDigest sha1 = MessageDigest.getInstance("sha1");
        byte[] sha1_byte = sha1.digest(str.getBytes());
        hash = Hex(sha1_byte);

        return hash;
    }

    public String sha256(String str) throws NoSuchAlgorithmException {
        MessageDigest sha256 = MessageDigest.getInstance("sha256");
        byte[] sha256_byte = sha256.digest(str.getBytes());
        hash = Hex(sha256_byte);

        return hash;
    }

    public String sha3_256(String str) throws NoSuchAlgorithmException {
        MessageDigest sha3_256 = MessageDigest.getInstance("sha3-256");
        byte[] sha3_256_byte = sha3_256.digest(str.getBytes());
        hash = Hex(sha3_256_byte);

        return hash;
    }

    public String Hex(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (byte i : b) {
            sb.append(String.format("%02x", i));
        }

        return sb.toString();
    }
}
