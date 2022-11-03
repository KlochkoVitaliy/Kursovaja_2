public class Weekly extends Task {

    public Weekly(String heading, String description, String typeTask, String repeat) throws EmptyStringException {
        super(heading, description, typeTask, repeat);
    }

    @Override
    public void getNextDate() {
        setCreationDay(getCreationDay().plusDays(7));
    }
}