package com.sd.client.app.storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoggedUser {
    private static final java.util.Properties properties = new java.util.Properties();

    static {
        FileInputStream file = null;
        try {
            file = new FileInputStream("tokens.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String UUID(){
        return properties.getProperty("UUID");
    }

    public static String getLoggedEmail(){
        return properties.getProperty("loggedEmail");
    }

    public static String id() { return UUID();}

    public static void save(String token) throws IOException {
        properties.setProperty("UUID", token);
        properties.store(new FileOutputStream("tokens.properties"), null);

    }
    public static void saveEmail(String email) throws IOException {
        properties.setProperty("loggedEmail", email);
        properties.store(new FileOutputStream("tokens.properties"), null);

    }
    public static void clear() {
        properties.remove("UUID");
        properties.remove("loggedEmail");

    }
}
