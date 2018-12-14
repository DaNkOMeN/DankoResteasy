/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import org.hibernate.validator.HibernateValidator;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.ErrorValidation;
import models.Group;
import models.Student;
import models.University;

/**
 *
 * @author danko
 */
@Path("service")
public class ServiceClass {
   
    private University anyuniverse = new University();
    
    
    @GET
    @Path("hello")
    @Produces("application/json")
    public Object echo() {
        Student kek = new Student("Татьяна", "Потекунова", "tatiana@mail.ru");
        Student lol = new Student("Даниил", "Головкин", "dankogol225@gmail.com");
        Group firstgroup = new Group();
        firstgroup.setStudent(kek);
        firstgroup.setStudent(lol);
        firstgroup.setName("ИПБ-15");
        
        Student validol = new Student("Иван", "Тюляндин", "tyulandin.ivan@mail.ru");
        Student cheburek = new Student("Pidor", "Potapko","pidor@jopa.sru");
        Group secondgroup = new Group();
        secondgroup.setName("ХУЙПОЙМИ-16");
        secondgroup.setStudent(validol);
        secondgroup.setStudent(cheburek);
        
        this.anyuniverse.setName("RGATU");
        this.anyuniverse.setGroup(firstgroup);
        this.anyuniverse.setGroup(secondgroup);
        return this.anyuniverse;
    }

    @POST
    @Path("first")
    @Produces("application/json")
    @Consumes("application/json")
    public University first(Group group) {
        this.anyuniverse.setGroup(group);
        return this.anyuniverse;
    }

    @POST
    @Path("second")
    @Produces("application/json")
    @Consumes("application/json")
    public University second(University university) {
        Student kek = new Student("Tanya", "Potekunova", "24124");
        Student tanya = new Student("Tanya", "Potekunova", "24124");
        Group mnb = new Group();
        mnb.setName("mnb-16");
        List<Student> our = new ArrayList<Student>();
        our.add(kek);
        our.add(tanya);
        mnb.setMygroup(our);
        university.setGroup(mnb);
        return university;
    }

    @POST
    @Path("validateStudent")
    @Produces("application/json")
    @Consumes("application/json")
    public Object validateStudent(Student student) {
        //валидатор
//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//        Validator validator = validatorFactory.getValidator();

        //hibermate validator
        ValidatorFactory hibermateVF = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
        Validator validator = hibermateVF.getValidator();
        Set<ConstraintViolation<Student>> validationErrors = validator.validate(student);

        ErrorValidation errors = new ErrorValidation();
        String errorValidationMessage = " ";
        if (!validationErrors.isEmpty()) {
            for (ConstraintViolation<Student> error : validationErrors) {
                errorValidationMessage = error.getMessageTemplate() + ":: " + error.getPropertyPath() + ":: " + error.getMessage()+ "\n";
                errors.addMessage(errorValidationMessage);
            }
            
            return errors;
        } else return student;
    }
    
    
    
    @POST
    @Path("validateGroup")
    @Produces("application/json")
    @Consumes("application/json")
    public Object validateGroup(Group group) {
        //hibermate validator
        ValidatorFactory hibermateVF = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
        Validator validator = hibermateVF.getValidator();
        Set<ConstraintViolation<Group>> validationErrors = validator.validate(group);

        ErrorValidation errors = new ErrorValidation();
        String errorValidationMessage = " ";
        if (!validationErrors.isEmpty()) {
            for (ConstraintViolation<Group> error : validationErrors) {
                errorValidationMessage = error.getMessageTemplate() + ":: " + error.getPropertyPath() + ":: " + error.getMessage()+ "\n";
                errors.addMessage(errorValidationMessage);
            }
            
            return errors;
        } else return group;
    }

    @POST
    @Path("validateUniversity")
    @Produces("application/json")
    @Consumes("application/json")
    public Object validateUniverse(University university) {
        //hibermate validator
        ValidatorFactory hibermateVF = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
        Validator validator = hibermateVF.getValidator();
        Set<ConstraintViolation<University>> validationErrors = validator.validate(university);

        ErrorValidation errors = new ErrorValidation();
        String errorValidationMessage = " ";
        if (!validationErrors.isEmpty()) {
            for (ConstraintViolation<University> error : validationErrors) {
                errorValidationMessage = error.getMessageTemplate() + ":: " + error.getPropertyPath() + ":: " + error.getMessage()+ "\n";
                errors.addMessage(errorValidationMessage);
            }
            
            return errors;
        } else {
            Student nastya = new Student("Nastya", "Potekunova", "24124");
            Student tanya = new Student("Tanya", "Potekunova", "24124");
            Group mnb = new Group();
            mnb.setName("mnb-16");
            List<Student> our = new ArrayList<Student>();
            our.add(nastya);
            our.add(tanya);
            mnb.setMygroup(our);
            university.setGroup(mnb);
            return university;
        }
    }
    
   
    
}
