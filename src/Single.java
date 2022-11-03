public class Single extends Task {

    public Single(String heading, String description, String typeTask, String repeat) throws EmptyStringException {
        super(heading, description, typeTask, repeat);
    }

    @Override
    public void getNextDate() {
        setCreationDay(getCreationDay().plusDays(Integer.MAX_VALUE));
    }
}