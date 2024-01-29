import java.util.ArrayList;
import java.util.List;

public class Teknokent {

    private final static Teknokent teknokent = new Teknokent(); // Eager initialization
    private final List<Company> companies;
    private final List<Person> persons;
    private final List<String> notifier;

    private Teknokent() {
        companies = new ArrayList<>();
        persons = new ArrayList<>();
        notifier = new ArrayList<>();
        addTeknokentDefaultData();
    }

    public static Teknokent getInstance() {
        return teknokent;
    }

    private void addTeknokentDefaultData() {

        Person person1 = new Person(1, "Ece Gokdemir", "Manisa", "ece", "123456");
        Person person2 = new Person(2, "Emre Eldemir", "Mardin", "emre", "123456");
        Person person3 = new Person(4, "Alper Bilge", "Antalya", "alper", "123456");
        Person person4 = new Person(3, "Ali Veli", "Istanbul", "ali", "123456");
        Person person5 = new Person(5, "Ayse Fatma", "Izmir", "ayse", "123456");
       
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        
        Company Company1 = new Company(1, "TAI", person1);
        Company Company2 = new Company(2, "ASELSAN", person2);
        Company Company3 = new Company(3, "Mavi Arge", person3);
        Company Company4 = new Company(4, "Softalya", person4);
        Company Company5 = new Company(5, "Teknodev", person5);

        companies.add(Company1);
        companies.add(Company2);
        companies.add(Company3);
        companies.add(Company4);
        companies.add(Company5);

        Career career = new Job(1,"Online","19/12/2022 18:00",Company3,"Desc",Technology.ANDROID,11402,
        Title.JUNIOR);
        Career career1 = new Bootcamp(2,"Hybrid","20/12/2022 19:00",Company5,"Desc",Technology.CLOUD_COMPUTING,"Alper Bilge", "6 Months");
        Career career2 = new Job(3,"Office","21/12/2022 20:00",Company1,"Desc",Technology.FULL_STACK, 10000, Title.SENIOR);
        Career career3 = new Bootcamp(4,"Online","22/12/2022 21:00",Company4,"Desc",Technology.MACHINE_LEARNING,"Emre Eldemir", "3 Months");
        Career career4 = new Job(5,"Hybrid","23/12/2022 22:00",Company2,"Desc",Technology.BACK_END, 15000, Title.SENIOR);

        Company5.addCareer(career1);
        Company1.addCareer(career2);
        Company4.addCareer(career3);
        Company2.addCareer(career4);
        Company3.addCareer(career);

        notifier.add("Email");
        notifier.add("SMS");
        notifier.add("LınkdIn");
    }

    public Person logIn(String username, String password) {

        for (Person person : persons)
            if (person.getUsername().equals(username) && person.getPassword().equals(password))
                return person;

        return null;

    }

    public void signUp(String name, String city, String username, String password) {
        Person person = new Person(persons.size() + 1, name, city, username, password);
        persons.add(person);
    }
    
    public List<Company> getCompanies() {
        return companies;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<String> getAllNotifier() {
        return notifier;
    }

    public List<Career> getCareersByCompany(Company Company) {
        return Company.getCareers();
    }

    public List<Company> getCompaniesByPerson(Person person) {

        List<Company> companies = new ArrayList<>();

        for (Company company : this.companies)
            if (company.getObservers().contains(person))
                companies.add(company);

        return companies;
    }

    public List<Career> getCareersByPerson(Person person) {
        return new ArrayList<>(person.getCareers());
    }

    public List<Company> getCompaniesByCreator(Person person) {

        List<Company> companies = new ArrayList<>();

        for (Company Company : this.companies)
            if (Company.getAdmin().equals(person))
                companies.add(Company);

        return companies;

    }

    public List<Career> getAllCareers() {

        List<Career> careers = new ArrayList<>();

        for (Company company : companies)
            careers.addAll(company.getCareers());

        return careers;
    }

    public List<String> getNotifierByPerson(Person person) {
        return person.getNotifiers();
    }

    public int getCompanyCount() {
        return companies.size();
    }

    public void createCompany(String name, Person person) {
        Company Company = new Company(companies.size() + 1, name, person);
        companies.add(Company);
    }

    // public void createCareer(String position, String deadline, Company company, String description,
    // Technology technology) {
    //     Career career = new Career(getAllCareers().size() + 1, position, deadline, company, description, technology);
    //     company.addCareer(career);
    // }
     public void createJob(String position, String deadline, Company company, String description,
    Technology technology,int salary, Title title) {
        Career career  = new Job(getAllCareers().size() + 1, position, deadline, company, description, technology, salary, title);
        company.addCareer(career);
    }
     public void createBootcamp(String position, String deadline, Company company, String description,
    Technology technology,String instructor, String period) {
        Career career = new Bootcamp(getAllCareers().size() + 1, position, deadline, company, description, technology ,instructor, period );
        company.addCareer(career);
    }

    public void printCompanies() {
        companies.forEach(Company -> System.out.println("    " + Company));
    }

    public void printPersons() {
        persons.forEach(person -> System.out.println("    " + person));
    }

    public void printAllCareers() {
        companies.forEach(this::printCareersByCompany);

    }

    public void printCareersByCompany(Company Company) {

        System.out.print(Company.getName());

        if (Company.getCareers().size() == 0)
            System.out.println("    There is no career opportunity in this Company");
        else
            Company.getCareers().forEach(career -> System.out.println(" : " + career+"\n"));

    }

    public void printCareersByPerson(Person person) {

        if (person.getCareers().size() == 0)
            System.out.println("    There is no career opportunity in this Company");
        else
            person.getCareers().forEach(career -> System.out.println("    " + career));

    }

    public void printCompaniesByPerson(Person person) {

        if (getCompaniesByPerson(person).size() == 0)
            System.out.println("    You are not a member of any Company");
        else
            person.getCompanies().forEach(company -> System.out.println("    " + company));

    }

    public void printCompaniesByCreator(Person person) {

        if (getCompaniesByCreator(person).size() == 0)
            System.out.println("    You are not a creator of any Company");
        else
            getCompaniesByCreator(person).forEach(Company -> System.out.println("    " + Company));

    }

    public void printNotificationsByPerson(Person person) {
        if (person.getNotifications().size() == 0)
            System.out.println("    There is no notification");
        else
            person.getNotifications().forEach(notification -> System.out.println("    " + notification.getNotify()));
    }

    public void addMemberToCompany(Person person, Company Company) {
        Company.registerObserver(person);
        person.joinCompany(Company);
    }

    public void joinCareer(Person person, Career career) {
        career.addApplicants(person);
        person.joinCareer(career);
    }

    public void removeMemberFromCompany(Person person, Company Company) {
        Company.removeObserver(person);
        person.leaveCompany(Company);
    }

    public void printNotifiersByPerson(Person person) {
        if (person.getNotifiers().size() == 0)
            System.out.println("    There is no notifier");
        else
            person.getNotifiers().forEach(notifier -> System.out.println("    " + notifier));
    }

    public void addNotifierToPerson(Person person, String notifier) {
        person.addNotifier(notifier);
    }

    public void removeNotifierFromPerson(Person person, String notifier) {
        person.removeNotifier(notifier);
    }

}
