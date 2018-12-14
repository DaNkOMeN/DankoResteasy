/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author danko
 */
public class Student {
    @NotNull(message = "Name cannot be null")
    @Size(min =1 , max = 15)
 
    private String name;
    
    @NotNull(message = "Family cannot be null")
    @Size(min =1 , max = 15)
    private String family;
    
    @NotNull(message = "Name of group cannot be null")
    @Email
    private String email;

    public Student(String name, String family, String email) {
        this.name = name;
        this.family = family;
        this.email = email;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getEmail() {
        return email;
    }

    public void setGroupname(String email) {
        this.email = email;
    }
    
    
    
}
