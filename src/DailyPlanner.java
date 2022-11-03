import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DailyPlanner {

    private final Map<Integer, Task> dailyPlanner = new HashMap<>();

    public Map<Integer, Task> getDailyPlanner() {
        return dailyPlanner;
    }

    public void addTaskToDailyPlanner(Task task) {
        if (dailyPlanner.containsKey(task.getId())) {
            for (Map.Entry<Integer, Task> entry : dailyPlanner.entrySet()) {
                if (entry.getKey().equals(task.getId())) {
                    throw new RuntimeException("Такое задание уже есть!!");
                }
            }
        }
        dailyPlanner.put(task.getId(), task);
    }

    public void removeTaskToDailyPlanner(Integer key) {
        if (dailyPlanner.containsKey(key)) {
            for (Map.Entry<Integer, Task> entry : dailyPlanner.entrySet()) {
                if (entry.getKey().equals(key)) {
                    System.out.println("Задача с номером " + key + " успешно удалена.");
                    entry.getValue().setCheckDeleted(true);
                    return;
                }
            }
        }
        System.out.println("Задача с номером " + key + " не была найдена, удаление невозможно.");
    }

    public void findTheNextTask(LocalDate date) throws InterruptedException {
        System.out.println("На дату " + date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth() +
                " запланированы следующие события: ");
        long start = System.nanoTime();
        for (Map.Entry<Integer, Task> entry : dailyPlanner.entrySet()) {
            while (entry.getValue().getCreationDay().isBefore(date) ||
                    entry.getValue().getCreationDay().isEqual(date)) {
                if (entry.getValue().getCreationDay().isEqual(date) && !entry.getValue().isCheckDeleted()) {
                    System.out.println(entry.getValue().getHeading());
                }
                entry.getValue().getNextDate();
            }
            entry.getValue().getCreationDay();
        }
    }

    @Override
    public String toString() {
        return "DailyPlanner{" +
                "dailyPlanner=" + getDailyPlanner() +
                '}';
    }
}