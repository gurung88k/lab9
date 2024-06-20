package org.example.midterm0503;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class StudentViewController {
    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, Integer> studentNumCol;

    @FXML
    private TableColumn<Student, String> firstNameCol;

    @FXML
    private TableColumn<Student, String> lastNameCol;

    @FXML
    private TableColumn<Student, String> telephoneCol;

    @FXML
    private TableColumn<Student, String> addressCol;

    @FXML
    private TableColumn<Student, String> provinceCol;

    @FXML
    private TableColumn<Student, Integer> avgGradeCol;

    @FXML
    private TableColumn<Student, String> majorCol;

    @FXML
    private CheckBox ontarioCheckBox;

    @FXML
    private Label numOfStudentsLabel;

    @FXML
    private CheckBox honourRollCheckBox;

    @FXML
    private ComboBox<String> areaCodeComboBox;

    private ObservableList<Student> students = FXCollections.observableArrayList();

    @FXML
    private void applyFilter() {
        // Apply filter logic here
    }

    private void getAllStudents() {
        String url = "jdbc:mysql://database.c10eksou8rzh.us-east-1.rds.amazonaws.com:3306/yourDatabaseName";
        String user = "admin";
        String password = "Gurung123$";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentNum(resultSet.getInt("studentNum"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setHomeAddress(resultSet.getString("homeAddress"));
                student.setProvince(resultSet.getString("province"));
                student.setTelephone(resultSet.getString("telephone"));
                student.setAvgGrade(resultSet.getInt("avgGrade"));
                student.setMajor(resultSet.getString("major"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        // Populate the ComboBox with distinct sorted area codes
        Set<String> areaCodes = new TreeSet<>();
        for (Student student : students) {
            String telephone = student.getTelephone();
            if (telephone.length() >= 3) {
                areaCodes.add(telephone.substring(0, 3));
            }
        }
        areaCodeComboBox.setItems(FXCollections.observableArrayList(areaCodes));

        // Populate the TableView with all students
        getAllStudents();
        tableView.setItems(students);

        // Set cell value factories for columns
        studentNumCol.setCellValueFactory(cellData -> cellData.getValue().studentNumProperty().asObject());
        firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        telephoneCol.setCellValueFactory(cellData -> cellData.getValue().telephoneProperty());
        addressCol.setCellValueFactory(cellData -> cellData.getValue().homeAddressProperty());
        provinceCol.setCellValueFactory(cellData -> cellData.getValue().provinceProperty());
        avgGradeCol.setCellValueFactory(cellData -> cellData.getValue().avgGradeProperty().asObject());
        majorCol.setCellValueFactory(cellData -> cellData.getValue().majorProperty());

        // Bind numOfStudentsLabel text property to the size of the students list
        numOfStudentsLabel.textProperty().bind(Bindings.createStringBinding(() ->
                "Number of Students: " + students.size(), students));
    }
}
