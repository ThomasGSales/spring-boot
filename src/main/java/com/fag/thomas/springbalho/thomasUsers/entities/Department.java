package com.fag.thomas.springbalho.thomasUsers.entities;

import jakarta.persistence.*;

/**
 * Entidade que representa um departamento no sistema.
 */
@Entity
@Table(name= "ga_department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * Construtor padrão da classe Department.
     */
    public Department() {
    }

    /**
     * Obtém o ID do departamento.
     *
     * @return O ID do departamento.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do departamento.
     *
     * @param id O novo ID do departamento.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do departamento.
     *
     * @return O nome do departamento.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do departamento.
     *
     * @param name O novo nome do departamento.
     */
    public void setName(String name) {
        this.name = name;
    }
}
