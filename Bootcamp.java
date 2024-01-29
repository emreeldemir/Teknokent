public class Bootcamp extends Career {

    private String instructor;
    private String period;

    public Bootcamp(int id, String position, String deadline, Company company, String description,
            Technology technology, String instructor, String period) {
        super(id, position, deadline, company, description, technology);
        this.instructor = instructor;
        this.period = period;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Bootcamp [id=" + getId() + ", position=" + getPosition() + ", deadline=" + getDeadline() + ", company=" + getCompany() + ", description=" + getDescription() + ", technology=" + getTechnology() + ", instructor=" + instructor + ", period=" + period + "]";
    }

}
