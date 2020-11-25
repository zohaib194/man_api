package no.freelanceInit.api.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "User.updateUserInfo", query = "UPDATE User u SET u.firstName = ?1, u.lastName = ?2, u.dateOfBirth = ?3, u.email = ?4, u.mobileNr = ?5, u.pwd = ?6 WHERE userId = ?7")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userId;
    @Column(name = "fname")
    private String firstName;
    @Column(name = "lname")
    private String lastName;
    @Column(name = "bdate")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateOfBirth;
    private String email;
    @Column(name = "mobile")
    private String mobileNr;
    private String pwd;
}
