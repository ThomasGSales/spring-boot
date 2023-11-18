package com.fag.thomas.springbalho.thomasUsers.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;

/**
 * Entidade que representa um usuário no sistema.
 */
@Entity
@Table(name= "ga_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    /**
     * Associação Many-to-One com a entidade Department.
     * Cada usuário pertence a um departamento.
     */
    @ManyToOne
    @JoinColumn(name = "id_department")
    private Department department;

    /**
     * Construtor padrão da classe User.
     */
    public User() {
    }

    /**
     * Obtém o ID do usuário.
     *
     * @return O ID do usuário.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do usuário.
     *
     * @param id O novo ID do usuário.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do usuário.
     *
     * @return O nome do usuário.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do usuário.
     *
     * @param name O novo nome do usuário.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o email do usuário.
     *
     * @return O email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     *
     * @param email O novo email do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o departamento ao qual o usuário pertence.
     *
     * @return O departamento do usuário.
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Define o departamento ao qual o usuário pertence.
     *
     * @param department O novo departamento do usuário.
     */
    public void setDepartment(Department department) {
        this.department = department;
    }
}
