package timetableapp.dao;

/**
 * Käyttäjienn nimen ja käyttäjänimen sisältävän tekstitiedoston käsittelystä
 * huolehtiva luokka
 */

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import timetableapp.domain.User;

public class FileUserDao implements UserDao {
    private List<User> users;
    private String file;
    
    /**
    * Hakee tiedot tekstitiedostosta tai luo uuden tekstitiedoston, jos sitä ei vielä ole
    * 
    * @param    file    luettavan tai luotavan tiedoston nimi
    * 
    */
    
    public FileUserDao(String file) throws Exception {
        users = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                User u = new User(parts[0], parts[1]);
                users.add(u);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
        
    }
    
    /**
    * Tallentaa käyttäjien oikean nimen ja käyttäjänimen tekstitiedoston riville
    * 
    */
    
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (User user : users) {
                writer.write(user.getRealName() + ";" + user.getUsername() + "\n");
            }
        } 
    }
    
    /**
    * Palauttaa kaikki tietokannan käyttäjät User-olioina
    * 
    * @return   lista käyttäjistä
    * 
    */
    
    @Override
    public List<User> getAll() {
        return users;
    }
    
    /**
    * Hakee käyttäjää tietyllä käyttäjänimellä
    * 
    * @param    username    haettava käyttäjänimi
    * 
    * @return   palauttaa löydetun käyttäjän User-oliona tai null, jos käyttäjänimeä ei löydy
    * 
    */
    
    @Override
    public User findByUsername(String username) {
        return users.stream()
            .filter(u->u.getUsername()
            .equals(username))
            .findFirst()
            .orElse(null);
    }
    
    /**
    * Luo uuden käyttäjän ja tallentaa tämän tiedot tekstitiedostoon
    * 
    * @param    user    uusi käyttäjä User-oliona
    * 
    * @return   user    palauttaa uuden käyttäjän
    * 
    */
    
    @Override
    public User create(User user) throws Exception {
        users.add(user);
        save();
        return user;
    }    
    
}
