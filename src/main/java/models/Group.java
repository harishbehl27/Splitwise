package models;

import java.util.Collection;
import java.util.List;

public class Group {


    private final String name;

    private final String desc;
    private final String imageURL;

    private final List<String> userList;


    public Group(String name, String desc, String imageURL, List<String> userList) {
        this.name = name;
        this.desc = desc;
        this.imageURL = imageURL;
        this.userList = userList;
    }

    public List<String> getUsers() {

        return userList;
    }
}
