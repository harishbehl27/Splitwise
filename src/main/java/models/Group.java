package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name="group")
public class Group {

    @Id
    @GeneratedValue
    private Integer id;

    private final String name;

    private final String desc;

    private final String imageURL;

    private final List<String> userList;

    public Group(String name, String desc, String imageUrl, ArrayList<String> userList) {
        this.name = name;
        this.desc = desc;
        this.imageURL = imageUrl;
        this.userList = userList;
    }



    public List<String> getUsers() {

        return userList;
    }
}
