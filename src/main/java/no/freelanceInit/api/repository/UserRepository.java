package no.freelanceInit.api.repository;

import no.freelanceInit.api.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    void updateUserInfo(String firstName, String lastName, Date birthday, String email, String mobile, String pwd, Long userId);
}
