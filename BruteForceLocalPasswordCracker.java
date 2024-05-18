import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class BruteForceLocalPasswordCracker extends LocalPasswordCracker {
    private static final List<String> COMMON_PASSWORDS = Arrays.asList(
        "pattern", "idrissa", "factory", "monkey", "linkyo"
    );

    @Override
    protected String crack(String hash) {
        for (String password : COMMON_PASSWORDS) {
            if (hash.equals(md5Hash(password))) {
                return password;
            }
        }
        // Ajoutez ici une logique de génération de combinaisons de caractères si nécessaire
        return null;
    }

    private String md5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
