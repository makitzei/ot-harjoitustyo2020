package timetableapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class TimetableUi extends Application {
    
    @Override
    public void start(Stage ikkuna) {
        ikkuna.setTitle("Hei Lukujärjestyssovellus!");
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(TimetableUi.class);
    }
    
}
