module com.example.pr1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pr1 to javafx.fxml;
    exports com.example.pr1;
}