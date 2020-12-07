package timetableapp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import timetableapp.dao.FileTimetableDao;
import timetableapp.dao.FileUserDao;
import timetableapp.domain.TimetableService;

public class TimetableUi extends Application {
    
    private TimetableService timetableService;
    
    @Override
    public void init() throws Exception {
        //Luodaan tietokanta tai yhteys siihen
        FileUserDao userDao = new FileUserDao("users.txt");
        FileTimetableDao timetableDao = new FileTimetableDao("timetables.txt");

        // alustetaan sovelluslogiikka
        timetableService = new TimetableService(userDao, timetableDao);
    }
    
    @Override
    public void start(Stage window) {
        
        // 0. Background
        Background background = new Background(new BackgroundFill(Color.THISTLE, CornerRadii.EMPTY, Insets.EMPTY));
        
        // 1. Login screen
        
        // 1.1 login components
        Label loginText = new Label("Käyttäjätunnus:");
        TextField loginUsername = new TextField();
        Button loginButton = new Button("Kirjaudu sisään");
        Button loginCreateUserButton = new Button("Luo uusi käyttäjä");
        Label loginMessage = new Label("");
        
        // 1.2 login layout
        BorderPane loginLayout = new BorderPane();
        
        VBox loginLayout2 = new VBox();
        loginLayout2.getChildren().add(loginText);
        loginLayout2.getChildren().add(loginUsername);
        loginLayout2.getChildren().add(loginButton);
        loginLayout2.getChildren().add(loginCreateUserButton);
        loginLayout2.getChildren().add(loginMessage);
        
        // 1.3 styling 
        loginLayout2.setSpacing(10);
        loginLayout.setCenter(loginLayout2 );
        loginLayout.setPadding(new Insets(50,100,100,100));
        loginLayout.setBackground(background);
        
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
        Button createUserReturn = new Button("Takaisin");
        Label createUserMessage = new Label("");
        
        // 2.2 login layout
        BorderPane createUserLayout = new BorderPane();
        
        VBox createUserLayout2 = new VBox();
        createUserLayout2.getChildren().add(createUserText);
        createUserLayout2.getChildren().add(createUserRealText);
        createUserLayout2.getChildren().add(createUserRealField);
        createUserLayout2.getChildren().add(createUsername);
        createUserLayout2.getChildren().add(createUsernameField);
        createUserLayout2.getChildren().add(createUserButton);
        createUserLayout2.getChildren().add(createUserReturn);
        createUserLayout2.getChildren().add(createUserMessage);
        
        // 2.3 styling 
        createUserLayout2.setSpacing(10);
        createUserLayout.setCenter(createUserLayout2);
        createUserLayout.setPadding(new Insets(50,100,100,100));
        createUserLayout.setBackground(background);
        
        // 2.4. set scene
        Scene sceneCreateUser = new Scene(createUserLayout);
        
        // 3. Timetable screen
        
        // 3.1 components
        ArrayList<Integer> weekList= new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            weekList.add(i);
        }
        ObservableList<Integer> weeks = FXCollections.observableArrayList(weekList);
        ComboBox weekCombo = new ComboBox(weeks);
        weekCombo.setPromptText("1");
        Label timetableWeek = new Label("Viikko ");
        //Pieni testi
        Label timetableTest = new Label("Testiviesti olen");
        //
        Label monday = new Label("maanantai");
        Label tuesday = new Label("tiistai");
        Label wednesday = new Label("keskiviikko");
        Label thursday = new Label("torstai");
        Label friday = new Label("perjantai");
        Label saturday = new Label("lauantai");
        Label sunday = new Label("sunnuntai");
        Button timetableNewButton = new Button("Lisää uusi");
        Button logoutButton = new Button("Kirjaudu ulos");
        
        // 3.2 timetable screen layout
        BorderPane timetableLayout = new BorderPane();
        
        HBox weekLayout = new HBox();
        weekLayout.getChildren().add(timetableWeek);
        weekLayout.getChildren().add(weekCombo);
        weekLayout.getChildren().add(timetableTest);
        
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
                Pane cell = new Pane();
                cell.setPrefSize(100, 20);
                cell.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
                timetableGrid.add(cell, x, y);
                
                //Label cell = new Label("");
                //timetableGrid.add(cell, x, y);
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
        //timetableGrid.setGridLinesVisible(true);
        timetableLayout.setPadding(new Insets(50,100,100,100));
        
        timetableLayout.setTop(weekLayout);
        timetableLayout.setCenter(timetableGrid);
        timetableLayout.setBottom(timeButtonLayout);
        timetableLayout.setBackground(background);
        
        // 3.4. set scene
        Scene sceneTimetable = new Scene(timetableLayout);
         
        // 4. New event screen
        
        // 4.1 components
        Label subject = new Label("Aihe:");
        Label time = new Label("Aika:");
        Label newEventMessage = new Label("");
        Button newEventButton = new Button("Luo uusi");
        Button newEventReturn = new Button("Takaisin");
        
        ObservableList<String> subjects = 
            FXCollections.observableArrayList(
                null,"opiskelu", "liikunta", "vapaa"
            );
        ObservableList<Integer> starts = 
            FXCollections.observableArrayList(
                null,7,8,9,10,11,12,13,14,15,16,17,18
            );
        ObservableList<Integer> stops = 
            FXCollections.observableArrayList(
                null,8,9,10,11,12,13,14,15,16,17,18,19
            );
        
        ObservableList<String> days = 
            FXCollections.observableArrayList(
                null,"maanantai","tiistai","keskiviikko", "torstai", 
                "perjantai", "lauantai", "sunnuntai"
            );
        
        ComboBox subjectCombo = new ComboBox(subjects);
        String defaultSubjectText = "Valitse";
        subjectCombo.setPromptText(defaultSubjectText);
        ComboBox startCombo = new ComboBox(starts);
        String defaultStartText = "Alku";
        startCombo.setPromptText(defaultStartText);
        ComboBox stopCombo = new ComboBox(stops);
        String defaultStopText = "Loppu";
        stopCombo.setPromptText(defaultStopText);
        ComboBox dayCombo = new ComboBox(days);
        String defaultDayText = "Päivä";
        dayCombo.setPromptText(defaultDayText);
        
        // 4.2 layout
        BorderPane newEventLayout = new BorderPane();
        
        HBox tpLayout = new HBox();
        tpLayout.getChildren().add(startCombo);
        tpLayout.getChildren().add(new Label("-"));
        tpLayout.getChildren().add(stopCombo);
        tpLayout.getChildren().add(dayCombo);
        tpLayout.setPadding(new Insets(0,0,20,0));
        tpLayout.setSpacing(20);
        
        VBox newEventLayout2 = new VBox();
        newEventLayout2.getChildren().add(subject);
        newEventLayout2.getChildren().add(subjectCombo);
        newEventLayout2.getChildren().add(time);
        newEventLayout2.getChildren().add(tpLayout);
        newEventLayout2.getChildren().add(newEventButton);
        newEventLayout2.getChildren().add(newEventReturn);
        newEventLayout2.getChildren().add(newEventMessage);
        
        // 4.3 styling
        newEventLayout2.setSpacing(10);
        newEventLayout.setCenter(newEventLayout2);
        newEventLayout.setPadding(new Insets(50,100,100,100));
        newEventLayout.setBackground(background);
        
        // 4.4 set scene
        Scene sceneNewEvent = new Scene(newEventLayout);
        
        //5. - 8. Room for something else :)
        
        // 9. Actions
        
        // 9.1 Buttons login - create user - login
        loginCreateUserButton.setOnAction((event) -> {
            window.setScene(sceneCreateUser);
        });
        
        createUserButton.setOnAction((event) -> {
            String name = createUserRealField.getText();
            String username = createUsernameField.getText();
            if (username.length() < 4 || name.length() < 4) {
                createUserMessage.setText("Nimi tai käyttäjätunnus liian lyhyt");
            } else if (timetableService.createUser(name, username)){
                window.setScene(sceneLogin);
                createUserRealField.setText("");
                createUsernameField.setText("");
                createUserMessage.setText("");
            } else {
                createUserMessage.setText("Käyttäjätunnus on jo käytössä");
            }
        });
        
        createUserReturn.setOnAction((event) -> {
            window.setScene(sceneLogin);
            createUserRealField.setText("");
            createUsernameField.setText("");
            createUserMessage.setText("");
        });
        
        // 9.2 Buttons sign in - sign out
        loginButton.setOnAction((event) -> {
            String username = loginUsername.getText();
            if (timetableService.login(username)) {
                window.setScene(sceneTimetable);
                loginUsername.setText("");
                loginMessage.setText("");
            }
            else {
                loginMessage.setText("Käyttäjätunnusta ei löydy");
            }
        });
        
        logoutButton.setOnAction((event) -> {
            timetableService.logout();
            window.setScene(sceneLogin);
        });
        
        // 9.3 Buttons timetable - new event
        timetableNewButton.setOnAction((event) -> {           
            window.setScene(sceneNewEvent);
        });
        
        newEventButton.setOnAction((event) -> {
            String subjectValue = (String) subjectCombo.getValue();
            Integer startValue = (Integer) startCombo.getValue();
            Integer stopValue = (Integer) stopCombo.getValue();
            String dayValue = (String) dayCombo.getValue();
            if ((subjectValue == null) || (startValue == null)
                    ||(stopValue == null) || (dayValue == null)) {
                newEventMessage.setText("Jokin valinnoista on tyhjä");
            }
            else if (stopValue <= startValue) {
                newEventMessage.setText("Tarkista alku- ja loppuaika");
            }            
            else {
                //Testitulostus vielä tässä vaiheessa
                newEventMessage.setText(subjectValue + " klo " + String.valueOf(startValue) 
                    + " - " + String.valueOf(stopValue) + " " + dayValue + "na");
                timetableService.createEvent(subjectValue, startValue, stopValue, dayValue);
                subjectCombo.setValue(null);
                startCombo.setValue(null);
                stopCombo.setValue(null);
                dayCombo.setValue(null);
            //window.setScene(sceneTimetable);    
            }
            
        });
        
        newEventReturn.setOnAction((event) -> {
            window.setScene(sceneTimetable);
            subjectCombo.setValue(null);
            startCombo.setValue(null);
            stopCombo.setValue(null);
            dayCombo.setValue(null);
            newEventMessage.setText("");
        });
        
        // 9.3 ComboBox timetable week
        weekCombo.setOnAction((event) -> {
            int week = (int) weekCombo.getValue();
            timetableService.setActivetable(week);
            // 9.3.1 Add events to timetable, won't work yet
            /*
            ArrayList<String> events = timetableService.eventsToString();
            if (events != null) {
                for (String eventString : events) {
                    String[] parts = eventString.split(";");
                    Label subjectLabel = new Label(parts[0]);
                    int start = Integer.parseInt(parts[2]);
                    int stop = Integer.parseInt(parts[3]);
                    int dayCode = 0;
                    String dayString = parts[1];
                    if (dayString.equals("maanantai")) {
                        dayCode = 1;
                    }
                    else if (dayString.equals("tiistai")) {
                        dayCode = 2;
                    }
                    else if (dayString.equals("keskiviikko")) {
                        dayCode = 3;
                    }
                    else if (dayString.equals("torstai")) {
                        dayCode = 4;
                    }
                    else if (dayString.equals("perjantai")) {
                        dayCode = 5;
                    }
                    else if (dayString.equals("lauantai")) {
                        dayCode = 6;
                    }
                    else {
                        dayCode = 7;
                    }
                    while (start < stop) {
                        timetableGrid.add(subjectLabel, dayCode, start-6);
                        start ++;
                    }

                }
            }
            */
            timetableTest.setText("Aktiivinen viikko on nyt " + String.valueOf(timetableService.getActivetableWeek()));
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
