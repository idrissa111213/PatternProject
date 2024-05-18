public abstract class OnlinePasswordCracker implements PasswordCracker {
    @Override
    public abstract String crack(String url, String login);
}
