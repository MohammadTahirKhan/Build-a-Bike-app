package SQL;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class Password {

    /**
     * Checks password inputted by user
     * @param hash hash from the database
     * @param inputPassword password entered in GUI
     * @param salt salt from database
     * @return returns a boolean if the passwords match
     */
    public static boolean checkPassword(String inputPassword, byte[] salt, byte[] hash){
        try {
            byte[][] inputHashSalt = hashPassword(inputPassword, salt);
            if (inputHashSalt != null) {
                return Arrays.equals(inputHashSalt[0], hash);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Hashes the password with an inputted salt
     * @param password Plain text password
     * @param salt Salt used to create the hash
     * @return Hashed password from plaintext and salt
     */
    public static byte[][] hashPassword(String password, byte[] salt) {
        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return new byte[][]{hash, salt};
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Generates a secure random salt
     * @return secure random salt
     */
    public static byte[] getSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }















}
