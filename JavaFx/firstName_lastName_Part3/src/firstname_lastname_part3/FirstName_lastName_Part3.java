/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstname_lastname_part3;

import java.util.ArrayList;
import java.util.HashSet;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Hp
 */
public class FirstName_lastName_Part3 extends Application {

    private TextField firstNameTextField;
    private TextField lastNametTextField;
    private Button addStudent;
    private Button resetScence;
    private CheckBox sub1;
    private CheckBox sub2;
    private CheckBox sub3;
    private CheckBox sub4;
    private Slider age;
    int Age;
    private String subject1, subject2, subject3, subject4;

    RadioButton genderMale = new RadioButton("Male");
    RadioButton genderFemale = new RadioButton("Female");
    ListView<String> listView = new ListView<>();
    // students list
    ArrayList<Student> students = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        // students list 
        students = new ArrayList<>();

        //lebel and text Field for first name and last name
        Label first_name = new Label("First Name");
        Label last_name = new Label("Last Name");
        firstNameTextField = new TextField();
        lastNametTextField = new TextField();

        //lebel and Slider for Age
        Label ageSlider = new Label("Age");
        age = new Slider(1, 10, 20);

        // age.setShowTickMarks(true);
        age.setShowTickLabels(true);
        age.setMajorTickUnit(1);
        age.setBlockIncrement(1);

        age.valueProperty().addListener(
                new ChangeListener<Number>() {

                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                        Age = newValue.intValue();

                    }
                });

        //lebel and Button  for Add student and reset screen 
        addStudent = new Button("Add Student");

        resetScence = new Button("Reset");

        //lebel and Radio Button  for gender
        Label genderlLabel = new Label("Gender");
        genderMale = new RadioButton("Male");
        genderFemale = new RadioButton("Female");
        ToggleGroup group = new ToggleGroup();
        genderFemale.setToggleGroup(group);
        genderMale.setToggleGroup(group);

        //lebel and Cheakbox for Completed Subject
        Label subjectCheckBox = new Label("Completed Subject :");
        sub1 = new CheckBox("Math");
        sub2 = new CheckBox("Physics");
        sub3 = new CheckBox("CSE2021");
        sub4 = new CheckBox("CSE0221");

        sub1.requestFocus();
        sub2.requestFocus();
        sub3.requestFocus();
        sub4.requestFocus();

        sub1.setOnAction(action -> {
            subject1 = sub1.getText();
            sub2.setSelected(false);
            sub3.setSelected(false);
            sub4.setSelected(false);

        });

        sub2.setOnAction(action -> {
            subject2 = sub2.getText();
            sub1.setSelected(false);
            sub3.setSelected(false);
            sub4.setSelected(false);
        });
        sub3.setOnAction(action -> {
            subject3 = sub3.getText();
            sub2.setSelected(false);
            sub1.setSelected(false);
            sub4.setSelected(false);
        });
        sub4.setOnAction(action -> {
            subject4 = sub4.getText();
            sub2.setSelected(false);
            sub3.setSelected(false);
            sub1.setSelected(false);
        });

        GridPane gridPane = new GridPane();

        //lebel and ListView  for Liked Programing Language 
        Label programingLanguage = new Label("Programing Language U like :");
        /*
        listView.getItems().add("Java");
        listView.getItems().add("C");
        listView.getItems().add("C++");
        listView.getItems().add("PHP");
         */
        ObservableList<String> items = FXCollections.observableArrayList("Java", "C", "C++", "PHP");

        HashSet<String> language = new HashSet<>();
        listView.setItems(items);
        listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            int index = listView.getSelectionModel().getSelectedIndex();
            language.add(selectedItem);

        });


        // add the student to student list
        addStudent.setOnAction((ActionEvent event) -> {
            String firstname = firstNameTextField.getText();
            String lastName = lastNametTextField.getText();
            int getage = Age;
            String gender = getGender();

            HashSet<String> subject = new HashSet<>();
            String subjectStr = null;

            if (sub1.isSelected()) {
                subjectStr = subject1;
            }
            if (sub2.isSelected()) {
                subjectStr = subject2;
            }
            if (sub3.isSelected()) {
                subjectStr = subject3;
            }

            if (sub4.isSelected()) {
                subjectStr = subject4;
            }
            subject.add(subjectStr);

            Student studentdetails = new Student();
            studentdetails.setFirstName(firstname);
            studentdetails.setLastName(lastName);
            studentdetails.setGender(gender);
            studentdetails.setAge(getage);
            studentdetails.setSubjects(subject);
            studentdetails.setProgrammingLanguages(language);
            students.add(studentdetails);
            System.out.println(studentdetails);
        });

        resetScence.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                FieldClear();
            }
        });

        //GridPnae Layout for set All scence 
        gridPane.addRow(0, first_name, firstNameTextField);
        gridPane.addRow(1, last_name, lastNametTextField);
        gridPane.addRow(2, subjectCheckBox, sub1, sub2, sub3, sub4);
        gridPane.addRow(3, programingLanguage, listView);
        gridPane.addRow(4, ageSlider, age);
        gridPane.addRow(5, genderlLabel, genderMale, genderFemale);
        gridPane.addRow(6, addStudent, resetScence);
        gridPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridPane, 700, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);
    }

    String getGender() {
        if (genderMale.isSelected()) {
            return "Male";
        } else if (genderFemale.isSelected()) {
            return "Female";
        } else {
            return null;
        }
    }

    public void FieldClear() {

        firstNameTextField.clear();
        lastNametTextField.clear();
        sub1.setSelected(false);
        sub2.setSelected(false);
        sub2.setSelected(false);
        sub2.setSelected(false);
        students.clear();


    }

}
