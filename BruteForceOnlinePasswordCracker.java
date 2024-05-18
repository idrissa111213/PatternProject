public class BruteForceOnlinePasswordCracker extends OnlinePasswordCracker {
    @Override
    public String crack(String url, String login) {
        // Implémentation du brute-force pour cracker le mot de passe en ligne
        // Cette partie est simplifiée pour l'exemple
        if ("http://example.com/login".equals(url) && "user".equals(login)) {
            return "password123";
        }
        return null;
    }
}
