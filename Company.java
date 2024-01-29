import java.util.ArrayList;
import java.util.List;

public class Company implements Subject {

    private int id;
    private String name;
    private Person admin;
    private final List<Person> members;
    private final List<Career> careers;
    private final List<Observer> observers;

    public Company(int id, String name, Person admin) {
        this.id = id;
        this.name = name;
        this.admin = admin;
        members = new ArrayList<>();
        careers = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getAdmin() {
        return admin;
    }

    public void setAdmin(Person admin) {
        this.admin = admin;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void addMember (Person person) {
        members.add(person);
        registerObserver(person);
    }

    public void addCareer (Career career) {
        careers.add(career);
        notifyObservers(career);
    }

    public List<Career> getCareers() {
        return careers;
    }

    public void removeMember(Person person) {
        members.remove(person);
        removeObserver(person);
    }
    
    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Career career) {
        observers.forEach(observer -> observer.update(career));
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", name=" + name + ", members count=" + members.size() + ", careers count=" + careers.size() + '}';
    }
}
