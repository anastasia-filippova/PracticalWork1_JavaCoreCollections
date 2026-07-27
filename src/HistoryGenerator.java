import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HistoryGenerator {
    static ArrayList<String> characters = new ArrayList<>();
    static ArrayList<String> actions = new ArrayList<>();
    static ArrayList<String> places = new ArrayList<>();

    static ArrayList<String> stories = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        initializeData();

        System.out.println("Добро пожаловать в Генератор случайных историй!");

        boolean isRunning = true;

        while (isRunning) {
            printMenu();

            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.println("Введите имя персонажа: ");
                    String nameCharacters = scanner.nextLine();

                    characters.add(nameCharacters);
                    break;

                case 2:
                    System.out.println("Введите действие: ");
                    String act = scanner.nextLine();

                    actions.add(act);
                    break;

                case 3:
                    System.out.println("Введите место: ");
                    String location = scanner.nextLine();

                    places.add(location);
                    break;

                case 4:
                    if (characters.isEmpty() || actions.isEmpty() || places.isEmpty()) {
                        System.out.println("Недостаточно данных. Невозможно сгенерировать историю");
                        break;
                    }
                    int randomIntCharacters = random.nextInt(characters.size()); //рандомный выбор персонажа
                    String randomCharacter = characters.get(randomIntCharacters);

                    int randomIntActions = random.nextInt(actions.size()); //рандомный выбор действия
                    String randomAction = actions.get(randomIntActions);

                    int randomIntPlaces = random.nextInt(places.size()); //рандомный выбор места
                    String randomPlace = places.get(randomIntPlaces);
                    String story = randomCharacter + " " + randomAction + " " + randomPlace; //акумулирование данных
                    stories.add(story); //добавление сгенерированной истории в хранилище
                    System.out.println("Сгенерированная история: " + story);
                    break;

                case 5:
                    if (stories.isEmpty()) {
                        System.out.println("Историй пока нет. Добавьте персонажа, действие и место");
                    } else {
                        for (int i = 0; i < stories.size(); i++) {
                            System.out.println((i + 1) + ") " + stories.get(i));
                        }
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

    private static void initializeData() {
        characters.add("Кот");
        characters.add("Гном");
        characters.add("Рыцарь");

        actions.add("танцует");
        actions.add("поет");
        actions.add("гуляет");

        places.add("в пруду");
        places.add("на холмах");
        places.add("в таверне");
    }

    private static void printMenu() {
        System.out.println("У нас есть персонажи (" + characters.size() + " шт.), действия (" + actions.size() + " шт.), места (" + places.size() + " шт.) \n" +
                "Выберите пункт:\n" +
                "1 - Добавить персонажа\n" +
                "2 - Добавить действие\n" +
                "3 - Добавить место\n" +
                "4 - Сгенерировать историю\n" +
                "5 - Посмотреть все истории\n" +
                "6 - Выход");
    }
}
