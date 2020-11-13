package timetableapp;

public class User {
    private String realName;
    private String username;
    
    public User(String realName, String username) {
        this.realName = realName;
        this.username = username;
    }
    
    public String getRealName() {
        return this.realName;
    }
    
    public String getUsername() {
        return this.username;
    }
            
}
