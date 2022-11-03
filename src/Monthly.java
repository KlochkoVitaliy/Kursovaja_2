public class Monthly extends Task {

    public Monthly(String heading, String description, String typeTask, String repeat) throws EmptyStringException {
        super(heading, description, typeTask, repeat);
    }

    @Override
    public void getNextDate() {
        setCreationDay(getCreationDay().plusMonths(1));
    }
}