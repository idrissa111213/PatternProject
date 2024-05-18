public class PasswordCrackerFactory {
    public enum CrackerType {
        BRUTE_FORCE_LOCAL,
        DICTIONARY_LOCAL,
        BRUTE_FORCE_ONLINE,
        DICTIONARY_ONLINE
    }

    public static PasswordCracker createCracker(CrackerType type) {
        switch (type) {
            case BRUTE_FORCE_LOCAL:
                return new BruteForceLocalPasswordCracker();
            case DICTIONARY_LOCAL:
                return new DictionaryLocalPasswordCracker();
            case BRUTE_FORCE_ONLINE:
                return new BruteForceOnlinePasswordCracker();
            case DICTIONARY_ONLINE:
                return new DictionaryOnlinePasswordCracker();
            default:
                throw new IllegalArgumentException("Unknown cracker type");
        }
    }
}
