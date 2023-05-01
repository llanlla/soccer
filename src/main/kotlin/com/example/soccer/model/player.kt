package com.example.soccer.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity //representacion de una clase es un mapeo
@Table(name="player") //enlazar la tabla clientes en la base de datos

class player {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)

    var id: Long? =null
    var fullname: String? =null
    var age: Int? =null
    var nationality: String? =null
    var weight: Double? = null



}