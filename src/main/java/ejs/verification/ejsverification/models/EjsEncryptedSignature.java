    package ejs.verification.ejsverification.models;

    import jakarta.persistence.*;


    @Entity
    @Table
    public class EjsEncryptedSignature {

        @Id
        @SequenceGenerator(name="ejs_sequence",sequenceName = "ejs_sequence",allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="ejs_sequence")
        private Long id;

        private String key;
        private String signature;
        @Column(name="file_name")
        private String filename;
        private String test;

        public String getSignature() {
            return signature;
        }
        public String getKey(){
            return this.key;
        }
        public String getFilename(){
            return this.filename;
        }

    }
