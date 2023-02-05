module com.himanshu.workshop11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens com.himanshu.workshop11 to javafx.fxml;
    exports com.himanshu.workshop11;
}