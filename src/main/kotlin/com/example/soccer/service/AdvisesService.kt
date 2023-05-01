package com.example.soccer.service

import com.example.soccer.model.Advises
import com.example.soccer.repository.AdvisesRepository
import com.example.soccer.repository.playerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class AdvisesService {
    @Autowired //
    lateinit var advisesRepository: AdvisesRepository
    @Autowired
    lateinit var playerRepository: playerRepository

    fun list ():List<Advises>{
        return advisesRepository.findAll() //llama al metodo del metodo del repositorio y llama a cada uno de los metodos
    }
    fun save (advises: Advises): Advises {
        try {
            playerRepository.findById(advises.playerId)
                    ?: throw Exception ("Id de player no exist")
            return advisesRepository.save(advises)
        } catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message,ex)
        }
    }

    fun update (advises: Advises): Advises {
        try {
            advisesRepository.findById(advises.id)
                    ?: throw Exception("id no existe")
            return advisesRepository.save(advises)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateColorCard(advises: Advises): Advises {
        try{
            val response = advisesRepository.findById(advises.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                colorCard=advises.colorCard
            }
            return advisesRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}