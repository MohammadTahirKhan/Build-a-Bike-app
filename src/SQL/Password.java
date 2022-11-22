package SQL;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Password {

    public static boolean checkPassword(byte[] hash, String inputPassword, byte[] salt){
        try {
            byte[][] inputHashSalt = encryptPassword(inputPassword, salt);
            return Arrays.equals(inputHashSalt[0], hash);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static byte[][] encryptPassword(String password, byte[] salt) {
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


    public static byte[] getSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }















}
