package com.sd.client.app.storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoggedEmpresa {
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
        return properties.getProperty("UUIDEmpresa");
    }

    public static String getLoggedEmail(){
        return properties.getProperty("loggedEmailEmpresa");
    }

    public static String id() { return UUID();}

    public static void save(String token) throws IOException {
        properties.setProperty("UUIDEmpresa", token);
        properties.store(new FileOutputStream("tokens.properties"), null);

    }
    public static void saveEmail(String email) throws IOException {
        properties.setProperty("loggedEmailEmpresa", email);
        properties.store(new FileOutputStream("tokens.properties"), null);

    }
    public static void clear() {
        properties.remove("UUIDEmpresa");
        properties.remove("loggedEmailEmpresa");

    }
}
