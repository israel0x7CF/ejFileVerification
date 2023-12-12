package ejs.verification.ejsverification.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import ejs.verification.ejsverification.models.EjsEncryptedSignature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface EjsRepository extends JpaRepository<EjsEncryptedSignature,Long>
{
    @Query("SELECT ej FROM EjsEncryptedSignature ej WHERE ej.filename = :filename")
    Optional<EjsEncryptedSignature> findEjsByName(@Param("filename") String filename);

}
