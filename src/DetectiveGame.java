import java.util.HashSet;
import java.util.Scanner;

public class DetectiveGame {

    static HashSet<String> clueSet = new HashSet<>();
    static HashSet<String> databaseClues = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initializeDatabase();

        boolean isRunning = true;
        while (isRunning) {
            printMenu();

            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.println("Введите название новой улики: ");
                    String clue = scanner.nextLine();

                    if (clueSet.add(clue)) {
                        System.out.println("Улика " + clue + " добавлена.");
                    } else {
                        System.out.println("Такая улика уже существует.");
                    }
                    break;

                case 2:
                    System.out.println("Введите название улики для проверки: ");
                    String clueCheck = scanner.nextLine();

                    if (clueSet.contains(clueCheck)) {
                        System.out.println("Улика найдена.");
                    } else {
                        System.out.println("Такой улики нет");
                    }
                    break;

                case 3:

                    System.out.println("Введите название улики для удаления: ");
                    String clueDelete = scanner.nextLine();

                    clueSet.remove(clueDelete);
                    break;

                case 4:
                    System.out.println("Совпадения с базой данных:");

                    boolean found = false;

                    for (String clueMatch : clueSet) {
                        if (databaseClues.contains(clueMatch)) {
                            System.out.println("- " + clueMatch);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Совпадений не найдено.");
                    }
                    break;

                case 5:
                    if (clueSet.isEmpty()) {
                        System.out.println("Улик пока нет.");
                    } else {
                        System.out.println(clueSet);
                    }
                    break;

                case 6:
                    isRunning = false;
                    break;

                default:
                    System.out.println("Некорректное значение");
            }
        }
    }

    private static void initializeDatabase() {
        databaseClues.add("Отпечаток пальца на двери");
        databaseClues.add("Волосы на кресле");
        databaseClues.add("След обуви");
    }

    private static void printMenu() {
        System.out.println("""
                Добро пожаловать в Детективную игру!
                Выберите действие:
                1 - Добавить улику
                2 - Проверить наличие улики
                3 - Удалить улику
                4 - Сравнить с базой данных
                5 - Показать все найденные улики
                6 - Выход""");
    }
}