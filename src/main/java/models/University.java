/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author danko
 */
public class University {
    
    @NotNull(message = "Должны быть группы")
    @Valid
    private List<Group> groups;
    
    @NotNull(message = "Дожно быть название")
    @Size(min = 3, max = 40)
    private String name;

    public University(List<Group> groups, String name) {
        this.groups = groups;
        this.name = name;
    }

    public University() {
        this.groups = new ArrayList<Group>();
        this.name = "";
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setGroup(Group group){
        this.groups.add(group);
    }
}
