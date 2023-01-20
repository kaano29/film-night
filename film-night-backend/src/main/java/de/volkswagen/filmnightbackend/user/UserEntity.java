package de.volkswagen.filmnightbackend.user;

import de.volkswagen.filmnightbackend.enums.Avatar;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private Avatar avatar;

    @ElementCollection
    private Set<String> favoriteMovies;


}

