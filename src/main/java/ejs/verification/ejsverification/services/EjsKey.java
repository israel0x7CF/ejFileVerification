package ejs.verification.ejsverification.services;

import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ejs.verification.ejsverification.controllers.EjsEncryption;

@Service
public class EjsKey {
    public String generatekey(){
        
        try{
            KeyGenerator kg =KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey secretKey = kg.generateKey();
            Logger logger = LoggerFactory.getLogger(EjsKey.class);
            String b64  = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            logger.info(b64);
            return b64;
        }catch(Exception e){
            e.printStackTrace();
            
            return e.getMessage();
        }
    }


}
    