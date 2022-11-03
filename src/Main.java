import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EmptyStringException, InterruptedException {

        DailyPlanner dailyPlanner = new DailyPlanner();

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                print();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, dailyPlanner);
                            break;
                        case 2:
                            deleteTask(scanner, dailyPlanner);
                            break;
                        case 3:
                            findTaskToDate(scanner, dailyPlanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner, DailyPlanner dailyPlanner) throws EmptyStringException {
        System.out.print("Введите название задачи: ");
        String taskHeading = scanner.next();
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.next();
        printTypeTask();
        System.out.print("Выберите тип задачи: ");
        String taskType = null;
        if (scanner.hasNextInt()) {
            int menuTaskType = scanner.nextInt();
            switch (menuTaskType) {
                case 1:
                    taskType = "рабочая";
                    break;
                case 2:
                    taskType = "личная";
                    break;
                case 0:
                    break;
            }
        } else {
            scanner.next();
            System.out.println("Выберите пункт меню из списка!");
            return;
        }
        printRepeatTask();
        System.out.print("Выберите частоту повтора задачи: ");
        String taskRepeat;
        if (scanner.hasNextInt()) {
            int menuTaskRepeat = scanner.nextInt();
            switch (menuTaskRepeat) {
                case 1:
                    taskRepeat = "однократно";
                    Task task = new Single(taskHeading, taskDescription, taskType, taskRepeat);
                    dailyPlanner.addTaskToDailyPlanner(task);
                    break;
                case 2:
                    taskRepeat = "ежедневно";
                    Task task2 = new Daily(taskHeading, taskDescription, taskType, taskRepeat);
                    dailyPlanner.addTaskToDailyPlanner(task2);
                    break;
                case 3:
                    taskRepeat = "еженедельно";
                    Task task3 = new Weekly(taskHeading, taskDescription, taskType, taskRepeat);
                    dailyPlanner.addTaskToDailyPlanner(task3);
                    break;
                case 4:
                    taskRepeat = "ежемесячно";
                    Task task4 = new Monthly(taskHeading, taskDescription, taskType, taskRepeat);
                    dailyPlanner.addTaskToDailyPlanner(task4);
                    break;
                case 5:
                    taskRepeat = "ежегодно";
                    Task task5 = new Yearly(taskHeading, taskDescription, taskType, taskRepeat);
                    dailyPlanner.addTaskToDailyPlanner(task5);
                    break;
                case 0:
                    break;
            }
        } else {
            scanner.next();
            System.out.println("Выберите необходимый пункт из списка!");
        }
    }

    private static void deleteTask(Scanner scanner, DailyPlanner dailyPlanner) {
        System.out.print("Введите номер для удаления задачи: ");
        Integer number = scanner.nextInt();
        dailyPlanner.removeTaskToDailyPlanner(number);
    }

    private static void findTaskToDate(Scanner scanner, DailyPlanner dailyPlanner) throws InterruptedException {
        System.out.print("Введите дату для поиска задачи!");
        System.out.println();
        System.out.print("Укажите год: ");
        int year = scanner.nextInt();
        System.out.print("Укажите месяц: ");
        int month = scanner.nextInt();
        System.out.print("Укажите день: ");
        int day = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, day);
        dailyPlanner.findTheNextTask(date);
    }

    private static void print() {

        System.out.println(" Необходимо указать цифру! ");
        System.out.println(" 1  -  Добавить задачу ");
        System.out.println(" 2  - Удалить задачу ");
        System.out.println(" 3 -  Получить задачу на указанный день ");
        System.out.println(" 0 -  Выход ");
    }

    private static void printTypeTask() {
        System.out.println(" Необходимо указать цифру!  ");
        System.out.println(" 1 -  рабочая ");
        System.out.println(" 2 -  личная ");
        System.out.println(" 0 -  Выход ");
    }

    private static void printRepeatTask() {
        System.out.println(" Необходимо указать цифру!  ");
        System.out.println(" 1 -  однократно ");
        System.out.println(" 2 -  ежедневно ");
        System.out.println(" 3 -  еженедельно ");
        System.out.println(" 4 -  ежемесячно ");
        System.out.println(" 5 -  ежегодно ");
        System.out.println(" 0 -  Выход ");
    }
}