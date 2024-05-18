public abstract class LocalPasswordCracker implements PasswordCracker {
    @Override
    public String crack(String hash, String login) {
        return crack(hash);
    }
    
    protected abstract String crack(String hash);
}
