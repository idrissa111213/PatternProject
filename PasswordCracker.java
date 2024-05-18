public interface PasswordCracker {
    String crack(String hashOrUrl, String login);
}
