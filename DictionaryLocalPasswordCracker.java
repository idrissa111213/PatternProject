import java.util.HashMap;
import java.util.Map;

public class DictionaryLocalPasswordCracker extends LocalPasswordCracker {
    private static Map<String, String> dictionary = new HashMap<>();
    
    static {
       
        dictionary.put("c29d3b9a7d0fbbdfa5f3196b62c335d6", "pattern");       
        dictionary.put("e2b7dfad50c297de86b55a04f16a179a", "idrissa");       
        dictionary.put("85f8d12b38e31f287d0225a2112a8d04", "factory");       
        dictionary.put("d0763edaa9d9bd2a9516280e9044d885", "monkey"); 
        dictionary.put("fc5e038d38a57032085441e7fe7010b0", "linkyo");        
        
    }

    @Override
    protected String crack(String hash) {
        return dictionary.getOrDefault(hash, null);
    }
}
