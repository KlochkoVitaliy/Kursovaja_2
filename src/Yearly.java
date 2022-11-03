public class Yearly extends Task {

    public Yearly(String heading, String description, String typeTask, String repeat) throws EmptyStringException {
        super(heading, description, typeTask, repeat);
    }

    @Override
    public void getNextDate() {
        setCreationDay(getCreationDay().plusYears(1));
    }
}