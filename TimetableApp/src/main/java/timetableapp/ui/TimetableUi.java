package timetableapp.ui;

/**
 * Sovelluslogiikkaa edustava luokka
 */

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import timetableapp.dao.FileTimetableDao;
import timetableapp.dao.FileUserDao;
import timetableapp.domain.TimetableService;

public class TimetableUi extends Application {
    
    private TimetableService timetableService;
    
    @Override
    public void init() throws Exception {
        // Connection to database
        FileUserDao userDao = new FileUserDao("users.txt");
        FileTimetableDao timetableDao = new FileTimetableDao("timetables.txt");

        // Apply application logic
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
        Label timetableTest = new Label("Testitulostelu"); // Test test
        Button refresh = new Button("Päivitä");
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
        weekLayout.getChildren().add(refresh);
        
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
        
        // Empty timetable
        for (int x = 1; x <= 7; x++) {
            for (int y = 1; y <= 13; y++) {
                Rectangle square = new Rectangle(150, 30, Color.BEIGE);
                //square.setArcHeight(10.0d); 
                //square.setArcWidth(10.0d);
                Label squareText = new Label("Tervetuloa!");
                StackPane stack = new StackPane();
                stack.getChildren().addAll(square, squareText);
                
                timetableGrid.add(stack, x, y);
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
        Label subjectAddLabel = new Label("Lisää uusi aihe:");
        Label newEventMessage = new Label("");
        TextField subjectAddText = new TextField();
        Button newEventButton = new Button("Luo uusi");
        Button newEventReturn = new Button("Takaisin");
        Button subjectAddButton = new Button("Lisää");
        
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
        
        HBox addSubjectLayout = new HBox();
        addSubjectLayout.getChildren().add(subjectCombo);
        addSubjectLayout.getChildren().add(subjectAddLabel);
        addSubjectLayout.getChildren().add(subjectAddText);
        addSubjectLayout.getChildren().add(subjectAddButton);
        addSubjectLayout.setSpacing(10);
             
        HBox tpLayout = new HBox();
        tpLayout.getChildren().add(startCombo);
        tpLayout.getChildren().add(new Label("-"));
        tpLayout.getChildren().add(stopCombo);
        tpLayout.getChildren().add(dayCombo);
        tpLayout.setPadding(new Insets(0,0,20,0));
        tpLayout.setSpacing(20);
        
        VBox newEventLayout2 = new VBox();
        newEventLayout2.getChildren().add(subject);
        newEventLayout2.getChildren().add(addSubjectLayout);
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
        
        // 5 Popup window method further down
        
        //6. - 8. Room for something else :)
        
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
                weekCombo.setValue(1);
                timetableTest.setText("        ");
                window.setScene(sceneTimetable);
                loginUsername.setText("");
                loginMessage.setText("");
                refresh.fire();
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
            
            else if (timetableService.checkEventConflicts(startValue, stopValue, dayValue)) {
                newEventMessage.setText("Konflikti: tapahtumat päällekkäin");
            }
            else {
                //Print added event
                newEventMessage.setText("Lisätty " + subjectValue + " klo " + String.valueOf(startValue) 
                    + " - " + String.valueOf(stopValue) + " " + dayValue + "na");
                timetableService.createEvent(subjectValue, startValue, stopValue, dayValue);
                subjectCombo.setValue(null);
                startCombo.setValue(null);
                stopCombo.setValue(null);
                dayCombo.setValue(null);
            }
            
        });
        
        newEventReturn.setOnAction((event) -> {
            window.setScene(sceneTimetable);
            refresh.fire();
            subjectCombo.setValue(null);
            startCombo.setValue(null);
            stopCombo.setValue(null);
            dayCombo.setValue(null);
            newEventMessage.setText("");
        });
        
        subjectAddButton.setOnAction((event) -> {
            String newSubject = subjectAddText.getText();
            if (newSubject.isEmpty()) {
                newEventMessage.setText("Uusi aihe ei voi olla tyhjä");
            }
            else if (newSubject.length() > 15) {
                newEventMessage.setText("Liian pitkä aihe");
            }
            else {
                subjectCombo.getItems().add(newSubject);
                newEventMessage.setText("Aihe lisätty");
            }
            subjectAddText.setText("");
            
        });
        
        // 9.3 ComboBox timetable week set active timetable
        weekCombo.setOnAction((event) -> {
            int week = (int) weekCombo.getValue();
            timetableService.setActivetable(week);
            //Clear table first
            for (int x = 1; x <= 7; x++) {
                for (int y = 1; y <= 13; y++) {
                    Rectangle square = new Rectangle(150, 30, Color.BEIGE);
                    //square.setArcHeight(10.0d); 
                    //square.setArcWidth(10.0d); 
                    Label squareText = new Label("");
                    StackPane stack = new StackPane();
                    stack.getChildren().addAll(square, squareText);
                
                    timetableGrid.add(stack, x, y);
            }
        }        
            //Check for events on timetable
            for (String event2 : timetableService.eventsToString()) {
                String[] parts = event2.split(";");
                Rectangle square2 = new Rectangle(150, 30);
                //square2.setArcHeight(10.0d); 
                //square2.setArcWidth(10.0d);
                if (parts[0].equals("opiskelu")) {
                    square2.setFill(Color.PINK);
                } else if (parts[0].equals("liikunta")) {
                    square2.setFill(Color.SKYBLUE);
                } else if (parts[0].equals("vapaa")) {
                    square2.setFill(Color.OLIVEDRAB);;
                } else {
                    square2.setFill(Color.GOLD);;
                }  
                Label squareText2 = new Label(parts[0]);
                int end2 = Integer.parseInt(parts[3]);
                int y = Integer.parseInt(parts[2])-6;
                int x =1;
                String day2 = (parts[1]); 
                switch (day2) {
                    case "maanantai": x = 1;
                        break;
                    case "tiistai": x = 2;
                        break;
                    case "keskiviikko": x = 3;
                        break;
                    case "torstai": x = 4;
                        break;
                    case "perjantai": x = 5;
                        break;
                    case "lauantai": x = 6;
                        break;
                    case "sunnuntai": x = 7;
                        break;
                }
                
                StackPane stack2 = new StackPane();
                stack2.getChildren().addAll(square2, squareText2);
                timetableGrid.add(stack2, x, y);
                
                // Actions for event tiles - popup window action
                stack2.setOnMouseClicked((MouseEvent t) -> {
                    int x1 = GridPane.getColumnIndex(stack2);
                    int y1 = GridPane.getRowIndex(stack2);
                    int popStart = y1 + 6;
                    String popDay = "";
                    switch (x1) {
                        case 1: popDay = "maanantai";
                            break;
                        case 2: popDay = "tiistai";
                            break;
                        case 3: popDay = "keskiviikko";
                            break;
                        case 4: popDay = "torstai";
                            break;
                        case 5: popDay = "perjantai";
                            break;
                        case 6: popDay = "lauantai";
                            break;
                        case 7: popDay = "sunnuntai";
                            break;
                    }
                    displayPopup(popDay, popStart);
                });
            }
            window.setScene(sceneTimetable); 
        });
        
        // 9.4 Refresh button
        refresh.setOnAction((event) -> {
            weekCombo.fireEvent(event);
            window.setScene(sceneTimetable);   
        });
           
        // 10. App start
        window.setScene(sceneLogin);
        window.setTitle("Lukujärjestys");
        window.show();
    }
    
      // 5. Popup window on mouse-click on timetable event
        
    public void displayPopup(String popDay, int popStart) {
        // 5.1 Components
        Stage popupWindow = new Stage();
        popupWindow.setTitle("Poista tapahtuma");
        Label popupLabel = new Label("Haluatko poistaa tapahtuman " + popDay + "na kello " + popStart + "?");
        Button popupYes = new Button("Poista tapahtuma");
        Button popupNo = new Button("Peruuta");
        
        // 5.2 Actions
        popupNo.setOnAction(e -> popupWindow.close());
        popupYes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timetableService.deleteEvent(popDay, popStart);
                popupWindow.close();
            }
        });
        
        // 5.3 Popup layout and scene
        HBox popButtonsLayout = new HBox();
        popButtonsLayout.getChildren().addAll(popupYes, popupNo);
        popButtonsLayout.setSpacing(10);
        
        VBox popAllLayout = new VBox();
        popAllLayout.getChildren().addAll(popupLabel, popButtonsLayout);
        popAllLayout.setSpacing(20);
        popAllLayout.setAlignment(Pos.CENTER);
        popAllLayout.setPadding(new Insets(50,100,100,100));
        
        Scene popScene = new Scene(popAllLayout);
        
        popupWindow.setScene(popScene);
        popupWindow.showAndWait();
       
    }
        
    public static void main(String[] args) {
        launch(TimetableUi.class);
    }
    
}
