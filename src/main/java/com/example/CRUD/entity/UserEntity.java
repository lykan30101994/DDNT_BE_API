package com.example.CRUD.entity;

import com.example.CRUD.common.validation.annotation.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.seasar.doma.*;

@Entity(immutable = true, metamodel = @Metamodel)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@With
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    @ValidEmail
    private String email;

}
