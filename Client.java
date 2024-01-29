import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static Scanner scanner = new Scanner(System.in);
    public static Teknokent teknokent = Teknokent.getInstance();

    public static void main(String[] args) {

        int choice;

        do {

            showStartMenu();

            System.out.print("Enter your choice: ");
            choice = getInt(scanner);

            if (choice == 1) {

                Person person;

                do {

                    System.out.print("Username: ");
                    String userName = scanner.nextLine();

                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    person = teknokent.logIn(userName, password);

                    if (person != null)
                        personMenu(person);
                    else
                        System.out.println("Wrong username or password");

                } while (person == null);

            } else if (choice == 2) {

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("City: ");
                String city = scanner.nextLine();

                System.out.print("Username: ");
                String userName = scanner.nextLine();

                System.out.print("Password: ");
                String password = scanner.nextLine();

                teknokent.signUp(name, city, userName, password);

            } else if (choice != 0)
                System.out.println("Invalid choice!");

        } while (choice != 0);

    }

    public static void showStartMenu() {
        System.out.println("1 -> Log In");
        System.out.println("2 -> Sign Up");
        System.out.println("0 -> Exit");
    }

    public static void personMenu(Person person) {

        System.out.println("Welcome " + person.getName());

        int choice1;
        int choice2;

        do {

            showPersonMenu();

            System.out.print("Enter your choice: ");
            choice1 = getInt(scanner);

            switch (choice1) {

                case 1 -> {
                    System.out.println("Companies:");
                    teknokent.printCompanies();
                }

                case 2 -> {
                    System.out.println("Careers:");
                    teknokent.printAllCareers();
                }

                case 3 -> {

                    showCompaniesMenu(teknokent.getCompanies());

                    System.out.println("Enter your choice: ");
                    choice2 = getInt(scanner);

                    if (choice2 <= teknokent.getCompanies().size() && choice2 > 0) {

                        Company company = teknokent.getCompanies().get(choice2 - 1);
                        teknokent.addMemberToCompany(person, company);

                        System.out.println(person.getName() + " joined " + company.getName());

                    } else
                        System.out.println("Invalid choice!");

                }

                case 4 -> {

                    showAllCareersMenu();

                    System.out.println("Enter your choice: ");
                    choice2 = getInt(scanner);

                    if (choice2 <= teknokent.getAllCareers().size() && choice2 > 0) {

                        Career career = teknokent.getAllCareers().get(choice2 - 1);
                        teknokent.joinCareer(person, career);

                        System.out.println(person.getName() + " joined " + career.toString());

                    } else
                        System.out.println("Invalid choice!");

                }

                case 5 -> createCompanyMenu(person);

                case 6 -> {

                    List<Company> companies = teknokent.getCompaniesByCreator(person);

                    if (companies.size() != 0) {

                        showCompaniesMenu(companies);

                        System.out.println("Enter your choice: ");
                        choice2 = getInt(scanner);

                        if (choice2 <= teknokent.getCompaniesByCreator(person).size() && choice2 > 0) {

                            Company company = teknokent.getCompaniesByCreator(person).get(choice2 - 1);
                            showCareerMenu();
                            System.out.println("Enter your choice: ");
                            int choice = getInt(scanner);
                            if( choice == 1){
                                createJobMenu(company);
                            }
                            else if(choice == 2){
                                createBootcampMenu(company);
                            }
                            else{
                                System.out.println("Invalid choice!");
                            }

                        } else
                            System.out.println("Invalid choice!");

                    } else {
                        System.out.println("You don't have any companies!");
                    }

                }

                case 7 -> {
                    System.out.println("Your Joined Companies:");
                    teknokent.printCompaniesByPerson(person);
                }

                case 8 -> {
                    System.out.println("Your applied Careers:");
                    teknokent.printCareersByPerson(person);
                }

                case 9 -> {
                    System.out.println("Your Created Companies:");
                    teknokent.printCompaniesByCreator(person);
                }

                case 10 -> {

                    List<Company> companies = teknokent.getCompaniesByPerson(person);

                    if (companies.size() != 0) {

                        showCompaniesMenu(companies);

                        System.out.println("Enter your choice: ");
                        choice2 = getInt(scanner);

                        if (choice2 <= teknokent.getCompaniesByPerson(person).size() && choice2 > 0) {

                            Company company = teknokent.getCompaniesByPerson(person).get(choice2 - 1);
                            teknokent.removeMemberFromCompany(person, company);

                            System.out.println(person.getName() + " left " + company.getName());

                        } else
                            System.out.println("Invalid choice!");

                    } else
                        System.out.println("You are not a member of any company!");

                }

                case 11 -> {

                    System.out.println("Your Notifications:");
                    teknokent.printNotificationsByPerson(person);
                }

                case 12 -> {

                     System.out.println("Your Notifiers");
                    teknokent.printNotifiersByPerson(person);

                }

                case 13 -> {
                    List<String> allNotifier = teknokent.getAllNotifier();
                    List<String> personNotifier = teknokent.getNotifierByPerson(person);

                    List<String> notifiers = new ArrayList<>();

                    for (String notifier : allNotifier)
                        if (!personNotifier.contains(notifier))
                            notifiers.add(notifier);

                    if (notifiers.size() != 0) {
                        showNotifiersMenu(notifiers);

                        System.out.println("Enter your choice: ");
                        choice2 = getInt(scanner);

                        if (choice2 <= notifiers.size() && choice2 > 0) {

                            String notifier = notifiers.get(choice2 - 1);
                            teknokent.addNotifierToPerson(person, notifier);

                            System.out.println(person.getName() + " subscribed to " + notifier);

                        } else
                            System.out.println("Invalid choice!");

                    } else
                        System.out.println("You have no will be added notifier!");
                }

                case 14 -> {
                   List<String> notifiers = teknokent.getNotifierByPerson(person);

                    if (notifiers.size() != 0) {

                        showNotifiersMenu(notifiers);

                        System.out.println("Enter your choice: ");
                        choice2 = getInt(scanner);

                        if (choice2 <= notifiers.size() && choice2 > 0) {

                            String notifier = notifiers.get(choice2 - 1);
                            teknokent.removeNotifierFromPerson(person, notifier);

                            System.out.println(person.getName() + " unsubscribed from " + notifier);

                        } else
                            System.out.println("Invalid choice!");

                    } else
                        System.out.println("You have no will be removed notifier!");
                }

                case 15 -> {

                    System.out.println("Your Information :");
                    showInformationMenu(person);

                    System.out.println("Enter your choice: ");
                    choice2 = getInt(scanner);

                    if (choice2 <= 4 && choice2 > 0) {

                        switch (choice2) {

                            case 1 -> {
                                System.out.println("Enter the new name: ");
                                String newName = scanner.nextLine();
                                person.setName(newName);
                            }
                            case 2 -> {
                                System.out.println("Enter the new city: ");
                                String newCity = scanner.nextLine();
                                person.setCity(newCity);
                            }
                            case 3 -> {
                                System.out.println("Enter the new username : ");
                                String newUsername = scanner.nextLine();
                                person.setUsername(newUsername);
                            }
                            case 4 -> {
                                System.out.println("Enter the new password: ");
                                String newPassword = scanner.nextLine();
                                person.setPassword(newPassword);
                            }

                        }

                    } else{
                        System.out.println("Invalid choice!");
                    }

                }

                case 0 -> System.out.println("Logging out...");

            }

        } while (choice1 != 0);

    }

    public static void showPersonMenu() {
        System.out.println("1. Show Companies");
        System.out.println("2. Show Careers");
        System.out.println("3. Join Company");
        System.out.println("4. Apply Career");
        System.out.println("5. Create Company");
        System.out.println("6. Create Career");
        System.out.println("7. Show My Joined Companies");
        System.out.println("8. Show My Applied Careers");
        System.out.println("9. Show My Owned Companies");
        System.out.println("10. Leave Company");
        System.out.println("11. Show Notifications");
        System.out.println("12. Show Notifiers");
        System.out.println("13. Add Notifier");
        System.out.println("14. Remove Notifier");
        System.out.println("15. Change Information");
        System.out.println("0. Log out");
    }

    public static void showCompaniesMenu(List<Company> companies) {

        for (int i = 0; i < companies.size(); i++)
            System.out.println((i + 1) + ". " + companies.get(i).getName());

    }

    public static void showCareerMenu() {

       System.out.println("1. Job  ");
        System.out.println("2. Bootcamp  ");
    }


    public static void showAllCareersMenu() {

        for (int i = 0; i < teknokent.getAllCareers().size(); i++)
            System.out.println((i + 1) + ". " + teknokent.getAllCareers().get(i).toString());
    }

    public static void showCareersMenu(List<Career> careers) {

        for (int i = 0; i < careers.size(); i++)
            System.out.println((i + 1) + ". " + careers.get(i).toString());

    }

    public static void createCompanyMenu(Person person) {

        System.out.print("Enter company name: ");
        String name = scanner.nextLine();

        teknokent.createCompany(name, person);

    }

    public static void createJobMenu(Company company) {

        System.out.print("Enter job position: ");
        String position = scanner.nextLine();

        System.out.println("Enter job deadline: ");
        String deadline = scanner.nextLine();

        System.out.println("Enter job description: ");
        String description = scanner.nextLine();

        System.out.println("Enter job salary: ");   
        int salary = scanner.nextInt();

        System.out.println("Choose job title: ");
        for (Title title : Title.values()) {
            System.out.println(title.ordinal() + ". " + title);
        }
        int title = scanner.nextInt(); //enum

        if (title < 0 || title > Title.values().length) {
            System.out.println("Invalid choice!");
        } 

        System.out.println("Choose Technology: ");
        for (Technology technology : Technology.values()) {
            System.out.println(technology.ordinal() + ". " + technology);
        }
        int technology = scanner.nextInt(); //enum

        if (technology < 0 || technology > Technology.values().length) {
            System.out.println("Invalid choice!");
        } 
        
        //enum
        teknokent.createJob(position, deadline, company, description, Technology.values()[technology], salary, Title.values()[title]);

    }

    public static void createBootcampMenu(Company company) {

        System.out.print("Enter Bootcamp position: ");
        String position = scanner.nextLine();

        System.out.println("Enter Bootcamp deadline: ");
        String deadline = scanner.nextLine();

        System.out.println("Enter Bootcamp description: ");
        String description = scanner.nextLine();

        System.out.println("Enter Bootcamp instructor: ");
        String instructor = scanner.nextLine();

        System.out.println("Enter Bootcamp period: ");
        String period = scanner.nextLine();

        System.out.println("Choose Technology: ");
        for (Technology technology : Technology.values()) {
            System.out.println(technology.ordinal() + ". " + technology);
        }
        int technology = scanner.nextInt(); //enum

        if (technology < 0 || technology > Technology.values().length) {
            System.out.println("Invalid choice!");
        } 
        //enum
        teknokent.createBootcamp(position, deadline, company, description, Technology.values()[technology],instructor, period );

    }


    public static void showInformationMenu(Person person) {

        System.out.println("1. Change Name : " + person.getName());
        System.out.println("2. Change City : " + person.getCity());
        System.out.println("3. Change Username : " + person.getUsername());
        System.out.println("4. Change Password : ********");

    }

    public static void showNotifiersMenu(List<String> notifiers) {

        for (int i = 0; i < notifiers.size(); i++)
            System.out.println((i + 1) + ". " + notifiers.get(i));

    }

    public static int getInt(Scanner scanner) {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

}
