package com.example.soccer.service

import com.example.soccer.model.player
import com.example.soccer.repository.playerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service //avisar al compilador que vamos a iyectar un servicio y un servicio inyecta un controller
class playerService {
    @Autowired //
    lateinit var playerRepository: playerRepository

    fun list ():List<player>{
        return playerRepository.findAll() //llama al metodo del metodo del repositorio y llama a cada uno de los metodos
    }
    fun save (player: player):player{
        return playerRepository.save(player)
    }
    fun update (player: player): player{
        try {
            playerRepository.findById(player.id)
                    ?: throw Exception("id no existe")
            return playerRepository.save(player)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(player: player): player {
        try{
            val response = playerRepository.findById(player.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                fullname=player.fullname
            }
            return playerRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}