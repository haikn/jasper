/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jasper;


import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 *
 * @author khuchainam
 */
public class KeyReader {
    
    private static Cipher ecipher;
    private static Cipher dcipher;
    //private static SecretKey key;
    private static final int iterationCount = 10;
    // 8-byte Salt
    private static byte[] salt = {(byte)0xB2, (byte)0x12, (byte)0xD5, (byte)0xB2,(byte)0x44, (byte)0x21, (byte)0xC3, (byte)0xC3};
    private static String passPhrase = "okgaden123";
    
    /**
     * @author Khuc Nam Hai
     * @Function: verifyKey()
     * @Param: no parameters
     * @return boolean: true if still in trial time. false if not
     * @throws IOException 
     */
    public boolean verifyKey() throws IOException {
        //File file = new File("config.properties");
        FileInputStream fIn = new FileInputStream("./src/resources/config.properties");
        
        
        Properties propertiesFile = new Properties();
        propertiesFile.load(fIn);
        String key1 = propertiesFile.getProperty("KEY1");
        String key_initial = propertiesFile.getProperty("KEYIN");
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        if(key_initial == null || key_initial.equals("")) {
            if(key1 == null || key1.equals("")) {
                return false;
            }
        } else {
            if(key1 == null || key1.equals("")) {
                Calendar cal1 = Calendar.getInstance();

                String key1Value = dateFormat.format(cal1.getTime());

                if(addKey("KEY1", key1Value) == false) {
                    return false;
                }
            }
        }
        
        propertiesFile.load(fIn);
        key1 = propertiesFile.getProperty("KEY1");
        
        if(key1.equalsIgnoreCase("")) {
            return false;
        }
        
        //Decrypt key1
        String key1Decrypted = "";
        paramInit("DEC");
        try {
            key1Decrypted =  decrypt(key1);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        //Get the current date
        Calendar current = Calendar.getInstance();
        String currentDate = dateFormat.format(current.getTime());
        try {
            Date date1 = dateFormat.parse(key1Decrypted);
            Date date2 = dateFormat.parse(currentDate);
            if(date2.compareTo(date1)> 30){
                return false;
            } else {
                return true;  
            }
        } catch(ParseException e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    
    /**
     * @author Khuc Nam Hai
     * @param key
     * @return
     * @throws FileNotFoundException 
     */
    public boolean addKey(String inputKeyName, String inputKeyValue) {
        
        String encryptedStr = "";
        
        try {

            paramInit("ENC");

            encryptedStr = encrypt(inputKeyValue);
            //System.out.println(encryptedStr);
            //System.out.println(decrypt(encryptedStr));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        try {
            File file = new File("./src/resources/config.properties");
            FileOutputStream fOut = new FileOutputStream(file);       
            Properties propertiesFile = new Properties();
            propertiesFile.setProperty(inputKeyName, encryptedStr);
            propertiesFile.store(fOut, null);
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    /**
     * 
     * @param str
     * @return 
     */
    public static String encrypt(String str) {
        try {
            // encode the string into a sequence of bytes using the named charset
            // storing the result into a new byte array. 
            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc = ecipher.doFinal(utf8);
            // encode to base64
            enc = BASE64EncoderStream.encode(enc);
            return new String(enc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }    
    
    /**
     * 
     * @param str
     * @return 
     */
    public static String decrypt(String str) {
        try {
            
            // decode with base64 to get bytes
            byte[] dec = BASE64DecoderStream.decode(str.getBytes());
            byte[] utf8 = dcipher.doFinal(dec);
            
            // create new string based on the specified charset
            return new String(utf8, "UTF8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        
    }    
    
    private static void paramInit(String method) {
        try {
            // create a user-chosen password that can be used with password-based encryption (PBE)
            // provide password, salt, iteration count for generating PBEKey of fixed-key-size PBE ciphers
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);

            // create a secret (symmetric) key using PBE with MD5 and DES 
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

            // construct a parameter set for password-based encryption as defined in the PKCS #5 standard
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
            
            if(method.equalsIgnoreCase("ENC")) {
                ecipher = Cipher.getInstance(key.getAlgorithm());
                
                ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            } else {
                dcipher = Cipher.getInstance(key.getAlgorithm());
                dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
