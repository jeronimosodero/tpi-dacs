package cosas;

import java.math.BigInteger;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
/**
 *

 */
public class Cifrador {
     
    //NO CAMBIAR NUNCA EN LA VIDA
    private static final BigInteger KEY_VALE = new BigInteger(
            "774978611969793576");
    private static final String KEY_CIFRADOR = "abc12345abc12345";
     
    private Key aesKey;
    private Cipher cipher;
     
     
    public Cifrador() {
        try {
            aesKey = new SecretKeySpec(KEY_CIFRADOR.getBytes(), "AES");
            cipher = Cipher.getInstance("AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public String cifrar(Long cuil) {
    	String s = Long.toString(cuil);
    	String encrypted = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            encrypted = String.valueOf(Base32.encode(cipher.doFinal(s.getBytes()))).substring(0, 6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;
    }  
    
    
}
