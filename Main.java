import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*********************************************************************************");
        System.out.println("******Bienvenue Dans notre système de Hashage et de Crackage de mot de passe*****");
        System.out.println("*********************************************************************************");

        while (true) {
            System.out.println("Choisissez le type de PasswordCracker :");
            System.out.println("1 - BruteForceLocalPasswordCracker");
            System.out.println("2 - DictionaryLocalPasswordCracker");
            System.out.println("3 - BruteForceOnlinePasswordCracker");
            System.out.println("4 - DictionaryOnlinePasswordCracker");
            System.out.println("5 - Quitter");

            System.out.print("Votre choix : ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consomme la nouvelle ligne

            if (choice == 5) {
                System.out.println("Au revoir !");
                break;
            }

            PasswordCrackerFactory.CrackerType crackerType = null;
            switch (choice) {
                case 1:
                    crackerType = PasswordCrackerFactory.CrackerType.BRUTE_FORCE_LOCAL;
                    break;
                case 2:
                    crackerType = PasswordCrackerFactory.CrackerType.DICTIONARY_LOCAL;
                    break;
                case 3:
                    crackerType = PasswordCrackerFactory.CrackerType.BRUTE_FORCE_ONLINE;
                    break;
                case 4:
                    crackerType = PasswordCrackerFactory.CrackerType.DICTIONARY_ONLINE;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    continue;
            }

            PasswordCracker cracker = PasswordCrackerFactory.createCracker(crackerType);

            if (cracker instanceof LocalPasswordCracker) {
                System.out.print("Entrez le hash du mot de passe : ");
                String hash = scanner.nextLine();
                String password = cracker.crack(hash, null);
                if (password != null) {
                    System.out.println("Mot de passe trouvé : " + password);
                } else {
                    System.out.println("Mot de passe non trouvé.");
                }
            } else if (cracker instanceof OnlinePasswordCracker) {
                System.out.print("Entrez l'URL du formulaire de connexion : ");
                String url = scanner.nextLine();
                System.out.print("Entrez le login : ");
                String login = scanner.nextLine();
                String password = cracker.crack(url, login);
                if (password != null) {
                    System.out.println("Mot de passe trouvé : " + password);
                } else {
                    System.out.println("Mot de passe non trouvé.");
                }
            }
        }

        scanner.close();
    }
}
