public class Job extends Career  {

    private int salary;
    private Title title; // Intern,junior,senior..

    public Job(int id, String position, String deadline, Company company, String description, Technology technology,
            int salary, Title title) {
        super(id, position, deadline, company, description, technology);
        this.salary = salary;
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Job [id=" + getId() + ", position=" + getPosition() + ", deadline=" + getDeadline() + ", company=" + getCompany() + ", description=" + getDescription() + ", technology=" + getTechnology() + ", salary=" + salary + ", title=" + title + "]";
    }
}

