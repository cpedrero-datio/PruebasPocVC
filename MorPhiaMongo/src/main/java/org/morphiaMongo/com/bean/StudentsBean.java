package org.morphiaMongo.com.bean;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


@Entity("mongoStudents")
public class StudentsBean {
    @Id
    private int id;
    private String center;
    private String qualified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getQualified() {
        return qualified;
    }

    public void setQualified(String qualified) {
        this.qualified = qualified;
    }

    @Override
    public String toString() {
        return "StudentsBean{" +
                "id=" + id +
                ", center='" + center + '\'' +
                ", qualified='" + qualified + '\'' +
                '}';
    }
}
