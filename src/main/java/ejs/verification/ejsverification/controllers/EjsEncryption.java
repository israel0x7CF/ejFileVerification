package ejs.verification.ejsverification.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ejs.verification.ejsverification.models.EjsEncryptedSignature;
import ejs.verification.ejsverification.services.EjsEncryptedSignatureService;
import ejs.verification.ejsverification.services.EjsKey;

@RestController
@RequestMapping("/encrypt")
@CrossOrigin
public class EjsEncryption {

    
    private EjsKey ejs;
    private  EjsEncryptedSignatureService ejsService;
    Logger logger = LoggerFactory.getLogger(EjsEncryption.class);
    @Autowired
    public EjsEncryption(EjsKey ejsKey,EjsEncryptedSignatureService ejsService){
        this.ejs = ejsKey;
        this.ejsService = ejsService;
    }
    @GetMapping("/b64EncryptionKey")
    public String getkey(){
        String key = this.ejs.generatekey(); 
        return key;
    }

   @PostMapping("/EncryptedSignature")
   public String createSignedRecord(@RequestBody EjsEncryptedSignature ej)
   {   
       try {
           
           this.ejsService.createSignedRecord(ej);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Digital Signature created";
   }
   @GetMapping("/getKeyByName")
   public String getKeyByName(@RequestParam String name){
        
        return this.ejsService.getKeyByFileName(name);

   }
    @GetMapping("/getSignatureByName")
   public String getSignatureByName(@RequestParam String name){
        String signature = this.ejsService.getSigniatureByname(name);
        if (signature.equals("")){
            return "not signed";
        }
        else{
            return signature;
        }
        

   }

    
}
