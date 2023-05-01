package com.example.soccer.repository

import com.example.soccer.model.player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository   //EL JPA al heredar de la clase player puede realizar la acciones del CRUD
interface playerRepository:JpaRepository<player, Long> {

    fun findById(id: Long?):player?


}