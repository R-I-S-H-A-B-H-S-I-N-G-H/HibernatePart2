package com.example.HibernatePart2.entities.many2many;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String projectname;
    @ManyToMany(mappedBy = "projects")
    private Set<Programmer> programmers;

    public Project() {
    }

    public Project(String projectname) {
        this.projectname = projectname;
    }

    public int getId() {
        return id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public Set<Programmer> getProgrammers() {
        return programmers;
    }

    public void setProgrammers(Set<Programmer> programmers) {
        this.programmers = programmers;
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", projectname=" + projectname + "]";
    }

}
