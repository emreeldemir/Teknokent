import java.util.ArrayList;
import java.util.List;

public class Person implements Observer {

    private int id;
    private String name;
    private String city;
    private String username;
    private String password;
    private final List<Company> companies;
    private final List<Career> careers;
    private final List<Notification> notifications;
    private final List<String> notifiers;

    public Person(int id, String name, String city, String username, String password) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.username = username;
        this.password = password;
        companies = new ArrayList<>();
        careers = new ArrayList<>();
        notifications = new ArrayList<>();
        notifiers = new ArrayList<>();
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public List<Career> getCareers() {
        return careers;
    }

    public List<String> getNotifiers() {
        return notifiers;
    }

    public void joinCompany(Company company) {
        companies.add(company);
    }

    public void joinCareer(Career career) {
        careers.add(career);
    }

    public void leaveCompany(Company company) {
        companies.remove(company);
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void addNotifier(String notifier) {
        notifiers.add(notifier);
    }

    public void removeNotifier(String notifier) {
        notifiers.remove(notifier);
    }

    @Override
    public void update(Career career) {

        Notification notification = new TeknokentNotification("You have a new career opportunity in your company: "
                + career.getCompany().getName() + " : " + career);


        notification = decorateNotification(notification);

        notifications.add(notification);

    }

    private Notification decorateNotification(Notification notification) {

        if (notifiers.contains("Email"))
            notification = new EmailNotification(notification);

        if (notifiers.contains("SMS"))
            notification = new SMSNotification(notification);

        if (notifiers.contains("LinkedIn"))
            notification = new SMSNotification(notification);

        return notification;

    }

    @Override
    public String toString() {
        return name;
    }

}
