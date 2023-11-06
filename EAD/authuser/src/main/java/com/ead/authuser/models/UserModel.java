package com.ead.authuser.models;

import com.ead.authuser.enums.UserStatus;
import com.ead.authuser.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data//Get´s e set´s otimizados e com menos códigos
@JsonInclude(JsonInclude.Include.NON_NULL)//Serialização de objetos Java para Json: sendo a nível e classe, ele oculta/ignora os atributos com valores "nulos", considerando apenas os que possuem valores salvos.
@Entity
@Table(name = "TB_USERS")
public class UserModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

//    Adionar a anotação coluna????
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    @Column(nullable = false, unique = true, length = 50)
    private String username;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(nullable = false, length = 255)
    @JsonIgnore//Não exibe visando não expor os dados do usuário
    private String password;
    @Column(nullable = false, length = 150)
    private String fullname;

    @Column
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @Column
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(length = 20)
    private String phoneNumber;
    @Column(length = 20)
    private String cpf;
    @Column
    private String imagemUrl;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime lastUpdateDate;
}