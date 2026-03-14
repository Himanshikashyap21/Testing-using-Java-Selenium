package model;

public class CreateEmployee {
    private String name;
    private String durationWorked;
    private String age;
    private String email;
    private String salary;
    private String grade;

    public CreateEmployee(String name, String durationWorked, String age, String email, String salary, String grade) {
        this.name = name;
        this.durationWorked = durationWorked;
        this.age = age;
        this.email = email;
        this.salary = salary;
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDurationWorked(String durationWorked) {
        this.durationWorked = durationWorked;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getDurationWorked() {
        return durationWorked;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSalary() {
        return salary;
    }

    public String getGrade() {
        return grade;
    }
}
