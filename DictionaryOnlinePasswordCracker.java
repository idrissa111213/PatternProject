import java.util.HashMap;
import java.util.Map;

public class DictionaryOnlinePasswordCracker extends OnlinePasswordCracker {
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("http://example.com/login/user", "password123");
        dictionary.put("http://example.com/login/admin", "admin123");
        dictionary.put("http://example.com/login/guest", "guest123");
        dictionary.put("http://mywebsite.com/login/idrissa", "idrissapass");
        dictionary.put("http://mywebsite.com/login/user1", "user1pass");
        
    }

    @Override
    public String crack(String url, String login) {
        return dictionary.getOrDefault(url + "/" + login, null);
    }
}
