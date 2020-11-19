package timetableapp.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TimetableUi extends Application {
    
    @Override
    public void start(Stage window) {
        
        // Tietokannan alustus tässä tai mieluummin 
        // vielä mainin puolella
        // Luo ylätason asettelua, ettei tule toistoa
        
        // 1. Login screen
        
        // 1.1 login components
        Label loginText = new Label("Käyttäjätunnus:");
        TextField loginUsername = new TextField();
        Button loginButton = new Button("Kirjaudu sisään");
        Button loginCreateUserButton = new Button("Luo uusi käyttäjä");
        
        // 1.2 login layout
        BorderPane loginLayout = new BorderPane();
        
        VBox loginLayout2 = new VBox();
        loginLayout2.getChildren().add(loginText);
        loginLayout2.getChildren().add(loginUsername);
        loginLayout2.getChildren().add(loginButton);
        loginLayout2.getChildren().add(loginCreateUserButton);
        
        // 1.3 styling 
        loginLayout2.setSpacing(10);
        loginLayout.setCenter(loginLayout2 );
        loginLayout.setPadding(new Insets(50,100,100,100));
        
        // 1.4. set scene
        Scene sceneLogin = new Scene(loginLayout);
        
        // 2. Create new user screen
        
        // 2.1. components
        Label createUserText = new Label("Anna nimesi ja uusi käyttäjätunnus");
        Label createUserRealText = new Label("Etu- ja sukunimi:");
        Label createUsername = new Label("Uusi käyttäjätunnus:");
        TextField createUserRealField = new TextField();
        TextField createUsernameField = new TextField();
        Button createUserButton = new Button("Luo käyttäjä");
        
        // 2.2 login layout
        BorderPane createUserLayout = new BorderPane();
        
        VBox createUserLayout2 = new VBox();
        createUserLayout2.getChildren().add(createUserText);
        createUserLayout2.getChildren().add(createUserRealText);
        createUserLayout2.getChildren().add(createUserRealField);
        createUserLayout2.getChildren().add(createUsername);
        createUserLayout2.getChildren().add(createUsernameField);
        createUserLayout2.getChildren().add(createUserButton);
        
        // 2.3 styling 
        createUserLayout2.setSpacing(10);
        createUserLayout.setCenter(createUserLayout2);
        createUserLayout.setPadding(new Insets(50,100,100,100));
        
        // 2.4. set scene
        Scene sceneCreateUser = new Scene(createUserLayout);
        

        // 3. Timetable screen
        
        // 3.1 components
        Label timetableWeek = new Label("Viikko XX");
        Label monday = new Label("Maanantai");
        Label tuesday = new Label("Tiistai");
        Label wednesday = new Label("Keskiviikko");
        Label thursday = new Label("Torstai");
        Label friday = new Label("Perjantai");
        Label saturday = new Label("Lauantai");
        Label sunday = new Label("Sunnuntai");
        Button timetableNewButton = new Button("Lisää uusi");
        Button logoutButton = new Button("Kirjaudu ulos");
        
        // 3.2 timetable screen layout
        BorderPane timetableLayout = new BorderPane();
        
        HBox timeButtonLayout = new HBox();
        timeButtonLayout.getChildren().add(timetableNewButton);
        timeButtonLayout.getChildren().add(logoutButton);
        timeButtonLayout.setSpacing(50);
        
        GridPane timetableGrid = new GridPane();
        timetableGrid.add(monday, 1, 0);
        timetableGrid.add(tuesday, 2, 0);
        timetableGrid.add(wednesday, 3, 0);
        timetableGrid.add(thursday, 4, 0);
        timetableGrid.add(friday, 5, 0);
        timetableGrid.add(saturday, 6, 0);
        timetableGrid.add(sunday, 7, 0);
        
        for (int x = 1; x <= 7; x++) {
            for (int y = 1; y <= 13; y++) {
                timetableGrid.add(new Label(" [tyhjä] "), x, y);
            }
        }
        
        for (int y = 1; y <= 13; y++) {
            int time = y+6;
            timetableGrid.add(new Label(String.valueOf(time)), 0, y);
        }
            
        // 3.3 styling 
        timetableGrid.setHgap(10);
        timetableGrid.setVgap(10);
        timetableGrid.setPadding(new Insets(20,20,20,50));
        timetableLayout.setPadding(new Insets(50,100,100,100));
        
        timetableLayout.setTop(timetableWeek);
        timetableLayout.setCenter(timetableGrid);
        timetableLayout.setBottom(timeButtonLayout);
        
        // 3.4. set scene
        Scene sceneTimetable = new Scene(timetableLayout);
         
        // 4. New event screen
        
        // 4.1 components
        Label subject = new Label("Aihe:");
        Label time = new Label("Aika:");
        Button newEventButton = new Button("Luo uusi");
        
        ObservableList<String> example = 
            FXCollections.observableArrayList(
                "tyhjä 1",
                "tyhjä 2",
                "tyhjä 3"
            );
        ComboBox subjectCombo = new ComboBox(example);
        ComboBox startCombo = new ComboBox(example);
        ComboBox stopCombo = new ComboBox(example);
        ComboBox dayCombo = new ComboBox(example);
        
        // 4.2 layout
        BorderPane newEventLayout = new BorderPane();
        
        HBox tpLayout = new HBox();
        tpLayout.getChildren().add(startCombo);
        tpLayout.getChildren().add(stopCombo);
        tpLayout.getChildren().add(dayCombo);
        tpLayout.setSpacing(20);
        
        VBox newEventLayout2 = new VBox();
        newEventLayout2.getChildren().add(subject);
        newEventLayout2.getChildren().add(subjectCombo);
        newEventLayout2.getChildren().add(time);
        newEventLayout2.getChildren().add(tpLayout);
        newEventLayout2.getChildren().add(newEventButton);
        
        // 4.3 styling
        newEventLayout2.setSpacing(10);
        newEventLayout.setCenter(newEventLayout2);
        newEventLayout.setPadding(new Insets(50,100,100,100));
        
        // 4.4 set scene
        Scene sceneNewEvent = new Scene(newEventLayout);
        
        // 9. Actions
        
        // 9.1 Buttons login - create user - login
        loginCreateUserButton.setOnAction((event) -> {
            window.setScene(sceneCreateUser);
        });
        
        createUserButton.setOnAction((event) -> {
            window.setScene(sceneLogin);
        });
        
        // 9.2 Buttons sign in - sign out
        loginButton.setOnAction((event) -> {
            window.setScene(sceneTimetable);
        });
        
        logoutButton.setOnAction((event) -> {
            window.setScene(sceneLogin);
        });
        
        // 9.2 Buttons timetable <--> new event
        timetableNewButton.setOnAction((event) -> {
            window.setScene(sceneNewEvent);
        });
        
        newEventButton.setOnAction((event) -> {
            window.setScene(sceneTimetable);
        });
        
        // 10. App start
        window.setScene(sceneLogin);
        window.setTitle("Lukujärjestys");
        window.show();
    }   

    public static void main(String[] args) {
        launch(TimetableUi.class);
    }
    
}
