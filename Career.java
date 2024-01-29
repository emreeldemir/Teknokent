import java.util.ArrayList;
import java.util.List;

public class Career {

    private int id;
    private String position; // online,hybrid,office
    private Technology technology;
    private String deadline;
    private String description;
    private Company company;
    private final List<Person> applicants;

    public Career(int id, String position, String deadline, Company company, String description,
            Technology technology) {
        this.id = id;
        this.position = position;
        this.deadline = deadline;
        this.company = company;
        this.description = description;
        this.technology = technology;
        applicants = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public List<Person> getApplicants() {
        return applicants;
    }

    public void addApplicants(Person person) {
        applicants.add(person);
    }

    public void removeApplicants(Person person) {
        applicants.remove(person);
    }

    @Override
    public String toString() {
        return "Career{" + "id=" + id + ", Position=" + position + ", deadline=" + deadline + "," + company + ", applicants=" + applicants.size() + '}';
    }

}