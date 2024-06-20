module org.example.midterm0503 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.midterm0503 to javafx.fxml;
    exports org.example.midterm0503;
}