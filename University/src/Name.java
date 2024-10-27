public class Name {
    private String secondName;
    private String name;
    private String patronymic;

    public Name(String secondName, String name, String patronymic) {
        this.secondName = secondName;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Name(String name, String secondName) {
        this.secondName = secondName;
        this.name = name;
        this.patronymic = "";
    }

    public Name(String secondName) {
        this.secondName = secondName;
        this.name = "";
        this.patronymic = "";
    }

    public String toString() {
        return secondName + " " + name + " " + patronymic;
    }
}