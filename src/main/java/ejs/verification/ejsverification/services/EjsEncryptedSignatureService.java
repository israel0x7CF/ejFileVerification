package ejs.verification.ejsverification.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejs.verification.ejsverification.Repository.EjsRepository;
import ejs.verification.ejsverification.controllers.EjsEncryption;
import ejs.verification.ejsverification.models.EjsEncryptedSignature;

@Service
public class EjsEncryptedSignatureService {
     Logger logger = LoggerFactory.getLogger(EjsEncryption.class);
     private  EjsRepository ejsRepository;
   public EjsEncryptedSignatureService(EjsRepository ej){
      this.ejsRepository = ej;
   }

     public void createSignedRecord(EjsEncryptedSignature ejs){
      try {
         logger.info("Name of the file:"+ejs.getFilename());
         this.ejsRepository.save(ejs);
         
      } catch (Exception e) {
         e.printStackTrace();
      }

     }
     public String getSigniatureByname(String name){
      EjsEncryptedSignature ejs = this.ejsRepository.findEjsByName(name).orElse(null);
      return ejs.getSignature();

     }
     public String getKeyByFileName(String name){
      EjsEncryptedSignature ejs = this.ejsRepository.findEjsByName(name).orElse(null);
      return ejs.getKey();
     }
     
}
