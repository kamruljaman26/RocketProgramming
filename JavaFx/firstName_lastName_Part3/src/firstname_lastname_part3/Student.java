package firstname_lastname_part3;

import java.util.HashSet;

public class Student {

    // text field
    private String firstName;
    // text field
    private String lastName;
    // slider
    private Integer age;
    // radio buttons
    private String gender;
    // check boxes
    private HashSet<String> subjects = new HashSet();
    // list view
    private HashSet<String> programmingLanguages = new HashSet();

    public Student() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSubjects(HashSet<String> subjects) {
        this.subjects = subjects;
    }

    public void setProgrammingLanguages(HashSet<String> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }
    
        @Override
    public String toString() {
        
        return "FirstName : "+ firstName + "\n" +
        
               "LastName : "+ lastName + "\n" +
               
               "Age : "+ age + "\n" +
               
               "Gender : "+ gender + "\n" +
                
                "Subject : "+ subjects + "\n" +
                
                "ProgramingLanguage : "+ programmingLanguages + "\n" 
                 
                ;
              
                
    }
}
