package models;

import java.util.List;

public class User {
    private Integer id;
    private Integer age;
    private String firstname;
    private String lastname;
    private List<Car> cars;


    public User(){}


    public User(Integer id, String firstname, String lastname, List<Car> cars) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.cars = cars;
    }

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }


    public User(String firstname, String lastname, Integer age) {
        this.age = age;
        this.firstname = firstname;
        this.lastname = lastname;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    @Override
    public String toString() {
        return this.id + " " + this.firstname + " " + this.lastname;
    }
}
