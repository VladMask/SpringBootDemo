package MyJavaProject.DemoJava.Entity;


import jakarta.persistence.*;
import lombok.*;

//@Getter
//@Setter
//@RequiredArgsConstructor
//@AllArgsConstructor
@Entity
@Builder
@Table(schema = "candidates")

public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "age")
    private int age;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "skills_description")
    private String skillsDescription;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSkillsDescription() {
        return skillsDescription;
    }

    public void setSkillsDescription(String skillsDescription) {
        this.skillsDescription = skillsDescription;
    }


    public Candidate(){}

    public Candidate(long id) {
        this.id = id;
    }

    public Candidate(long id, int age) {
        this(id);
        this.age = age;
    }

    public Candidate(long id, int age, String name) {
        this(id,age);
        this.name = name;
    }

    public Candidate(long id, int age, String name, String surname){
        this(id, age, name);
        this.surname = surname;
    }

    public Candidate(long id, int age, String name, String surname, String skillsDescription)
    {
        this(id, age, name, surname);
        this.skillsDescription = skillsDescription;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Candidate: ").append(this.name).append(" ").append(this.surname).
                append("\nAge: ").append(this.age).append("\nSkills: ").append(this.skillsDescription);
        return sb.toString();
    }
}
