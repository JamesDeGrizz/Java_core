package java_base;

class Employee {
    private String name = null;
    private String post = null;
    private String email = null;
    private String phoneNumber = null;
    private int salary = 0;
    private int age = 0;

    public Employee(String name, String post, String email, String phoneNumber, int salary, int age) {
        this.name = name != null ? name : null;
        this.post = post != null ? post : null;
        this.email = email != null ? email : null;
        this.phoneNumber = phoneNumber != null ? phoneNumber : null;
        this.salary = salary;
        this.age = age;
    }

    void PrintInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "employee with name " + name +
                " on post " + post +
                " with email " + email +
                " and phoneNumber " + phoneNumber + ". His(her) " +
                " salary " + salary +
                " and age " + age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class lesson_5 {

    public static void main(String[] args) {
        Employee[] persons = new Employee[5];
        persons[0] = new Employee("Иванов Иван Иванович", "Директор", "director@mail.ru", "84951112233", 100, 35);
        persons[1] = new Employee("Петров Петр Петрович", "Заместитель директора", "zam_director@mail.ru", "84951112234", 95, 45);
        persons[2] = new Employee("Сидоров Сидор Сидорович", "Рабочий", "worker@mail.ru", "84954445566", 30, 30);
        persons[3] = new Employee("Еленова Елена Еленовна", "Бухгалтер", "accountant@mail.ru", "84951234567", 150, 55);
        persons[4] = new Employee("Балаболов Александр Сергеевич", "Охранник", "security@mail.ru", "84957777777", 20, 65);

        for (Employee person : persons) {
            if (person.getAge() > 40) {
                person.PrintInfo();
            }
        }
    }
}
