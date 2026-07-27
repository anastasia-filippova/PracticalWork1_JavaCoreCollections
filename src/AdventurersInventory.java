import java.util.LinkedHashMap;
import java.util.Scanner;

public class AdventurersInventory {
    static Scanner scanner = new Scanner(System.in);

    static LinkedHashMap<String, Integer> inventory = new LinkedHashMap<>();
    static String itemName;
    static int quantity;

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            printMenu();

            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    addItem();
                    break;

                case 2:
                    changeNumberItems();
                    break;

                case 3:
                    removeItem();
                    break;

                case 4:
                    findItem();
                    break;

                case 5:
                    showInventory();
                    break;

                case 6:
                    isRunning = false;
                    break;

                default:
                    System.out.println("Некорректное значение");
            }
        }

    }


    private static void showInventory() { //метод для отображения инвентаря
        for (String item : inventory.keySet()) {
            System.out.println(item + " - " + inventory.get(item));
        }
    }

    private static void findItem() { //метод для поиска предмета в инвентаре
        System.out.println("Укажите название предмета: ");
        itemName = scanner.nextLine();

        if(inventory.containsKey(itemName)) {
            System.out.println(itemName + " - " + inventory.get(itemName));
        } else {
            System.out.println("Такого предмета не существует.");
        }

    }

    private static void removeItem() { //удаление предмета из инвентаря
        System.out.println("Какой предмет вы хотите убрать?");
        itemName = scanner.nextLine();

        if(inventory.containsKey(itemName)) {
            inventory.remove(itemName);
            System.out.println("Предмет удален");
        } else {
            System.out.println("Такого предмета не существует.");
        }
    }

    private static void changeNumberItems() { //изменения количества предметов, сохраненного в инвентаре
        System.out.println("Введите название предмета: ");
        itemName = scanner.nextLine();
        if(inventory.containsKey(itemName)) {
            System.out.println("Сейчас в инвентаре: " + inventory.get(itemName));

            System.out.println("""
                            Изменить количество предметов?
                            1 - Увеличить.\s
                            2 - Уменьшить.\s""");
            int value = scanner.nextInt();

            if (value == 1) {
                System.out.println("На какое количество увеличить?");
                quantity = scanner.nextInt();
                scanner.nextLine();
                inventory.put(itemName, (quantity + inventory.get(itemName)));
                System.out.println("Количество предметов " + inventory.get(itemName) + " шт.");
            } else {
                System.out.println("На какое количество уменьшить?");
                quantity = scanner.nextInt();
                scanner.nextLine();
                if ( quantity <= inventory.get(itemName)) {
                    inventory.put(itemName, ( inventory.get(itemName) - quantity));
                    System.out.println("Количество предметов " + inventory.get(itemName) + " шт.");

                } else {
                    System.out.println("Введите число не превышающее количество предметов в инвентаре.");
                }
            }

        } else {
            System.out.println("Такого предмета не существует.");
        }



    }

    private static void addItem() { //добавление предмета в инвентарь
        System.out.println("Введите название предмета: ");
        itemName = scanner.nextLine();
        System.out.println("Введите количество: ");
        quantity = scanner.nextInt();
        scanner.nextLine();

        inventory.put(itemName, quantity);

        System.out.println("Предмет " + itemName + " успешно добавлен");
    }


    private static void printMenu() { //вывод меню
        System.out.println("""
                Добро пожаловать в Инвентарь приключенца!
                 Выберите действие:
                 1 - Добавить новый предмет
                 2 - Изменить количество предметов
                 3 - Удалить предмет
                 4 - Найти предмет по названию
                 5 - Показать весь инвентарь
                 6 - Выход""");
    }
}
