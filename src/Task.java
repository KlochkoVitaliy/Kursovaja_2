import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Task {

    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    private final Integer id;
    private String heading;
    private String description;
    private String typeTask;
    private String repeat;
    private boolean checkDeleted;
    private LocalDate creationDay;
    private final LocalDate changeDay;

    public Task(String heading, String description, String typeTask, String repeat) throws EmptyStringException {
        id = COUNTER.getAndIncrement();
        setHeading(heading);
        this.description = description;
        setTypeTask(typeTask);
        setRepeat(repeat);
        this.creationDay = LocalDate.now();
        this.changeDay = LocalDate.now();
        setCheckDeleted(false);
    }

    public int getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) throws EmptyStringException {
        if (heading == null || heading.isEmpty()) {
            throw new EmptyStringException("Заполните поле - заголовок.");
        }
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(String typeTask) throws EmptyStringException {
        if (typeTask == null || typeTask.isEmpty()) {
            throw new EmptyStringException("Заполните поле - тип задачи.");
        }
        this.typeTask = typeTask;
    }

    public LocalDate getCreationDay() {
        return creationDay;
    }

    public LocalDate getChangeDay() {
        return changeDay;
    }

    public void setCreationDay(LocalDate creationDay) {
        this.creationDay = creationDay;
    }

    public String getRepeat() {
        return repeat;
    }

    public boolean isCheckDeleted() {
        return checkDeleted;
    }


    public void setCheckDeleted(boolean checkDeleted) {
        this.checkDeleted = checkDeleted;
    }

    public void setRepeat(String repeat) throws EmptyStringException {
        if (repeat == null || repeat.isEmpty()) {
            throw new EmptyStringException("Заполните поле - тип задачи.");
        }
        this.repeat = repeat;
    }

    public abstract void getNextDate();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task tasks = (Task) o;
        return checkDeleted == tasks.checkDeleted &&
                id.equals(tasks.id) &&
                Objects.equals(heading, tasks.heading) &&
                Objects.equals(description, tasks.description) &&
                Objects.equals(typeTask, tasks.typeTask) &&
                Objects.equals(repeat, tasks.repeat) &&
                Objects.equals(creationDay, tasks.creationDay) &&
                Objects.equals(changeDay, tasks.changeDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                heading,
                description,
                typeTask,
                repeat,
                checkDeleted,
                creationDay,
                changeDay
        );
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", repeat='" + getRepeat() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", typeTask='" + getTypeTask() + '\'' +
                ", dayCreation=" + creationDay.getYear() + " " + creationDay.getMonth() + " " + creationDay.getDayOfMonth() +
                '}';
    }
}