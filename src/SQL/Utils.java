package SQL;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Utils {

    /**
     * Get the credentials from the properties file
     * @return string of credentials
     */
    static String[] getCredentials() {

        String[] credentials = new String[2];

        try (InputStream propertiesInput = Files.newInputStream(Paths.get("Credentials.properties"))) {

            Properties properties = new Properties();
            properties.load(propertiesInput);

            credentials[0] = properties.getProperty("db.username");
            credentials[1] = properties.getProperty("db.password");
        } catch (IOException e){
            e.printStackTrace();
        }
        return credentials;
    }
}