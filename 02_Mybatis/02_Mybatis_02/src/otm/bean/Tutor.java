package otm.bean;

import oto.bean.Addresses;

import java.util.List;

public class Tutor{
    private Integer tutorId; 
    private String name; 
    private String email;
    private Addresses addresses;
    private List<Course> courses;
    public Tutor(){}
    public Tutor(Integer tutorId, String name, String email, Addresses addresses, List<Course> courses) {
        this.tutorId = tutorId;
        this.name = name;
        this.email = email;
        this.addresses = addresses;
        this.courses = courses;
    }

    public Integer getTutorId() {
        return tutorId;
    }

    public void setTutorId(Integer tutorId) {
        this.tutorId = tutorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "tutorId=" + tutorId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", addresses=" + addresses +
                ", courses=" + courses +
                '}';
    }
}