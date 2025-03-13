module com.example.interviewtrainer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.interviewtrainer to javafx.fxml;
    exports com.example.interviewtrainer;
}