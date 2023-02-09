package com.example.HibernatePart2.entities.many2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int salary;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "programmer_project", joinColumns = @JoinColumn(name = "programmer_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    Set<Project> projects;

    public Programmer(String name, int sal) {
        this.name = name;
        this.salary = sal;
    }

    public Programmer() {

    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void addProject(Project project) {
        if (projects == null)
            projects = new HashSet<>();
        projects.add(project);
    }

    @Override
    public String toString() {
        return "Programmer [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }

}
