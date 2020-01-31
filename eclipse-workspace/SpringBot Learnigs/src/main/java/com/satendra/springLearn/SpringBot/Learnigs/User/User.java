package com.satendra.springLearn.SpringBot.Learnigs.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "Details about User Model")

@Entity
public class User {

    @Id
    @GeneratedValue
    private  int id;

    @Size(min=2, message = "Name shold have atleast 2 characters")
    private  String name;

    @Past()
    private Date birthday;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(int id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @ApiModelProperty(notes = "Name should be atleast 2 characters")
    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(notes = "Birthday should be in past ")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
