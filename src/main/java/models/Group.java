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
public class Group {
    @NotNull(message = "Группа не может быть  пустой")
    @Valid
    private List<Student> mygroup;
    
      
    @NotNull(message = "Нету у группы имени")
    @Size(min =3 , max = 7)
    private String name;

    public Group(List<Student> mygroup, String name) {
        this.mygroup = mygroup;
        this.name = name;
    }

    public Group() {
        this.mygroup = new ArrayList<Student>();
        this.name = "mygroup";
    }

    public List<Student> getMygroup() {
        return mygroup;
    }

    public void setMygroup(List<Student> mygroup) {
        this.mygroup = mygroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setStudent(Student student){
        this.mygroup.add(student);
    }
    
    
}
