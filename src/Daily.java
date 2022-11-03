public class Daily extends Task {

    public Daily(String heading, String description, String typeTask, String repeat) throws EmptyStringException {
        super(heading, description, typeTask, repeat);
    }
    @Override
    public void getNextDate() {
        setCreationDay(getCreationDay().plusDays(1));
    }
}