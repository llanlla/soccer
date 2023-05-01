package com.example.soccer.controller

import com.example.soccer.model.player
import com.example.soccer.service.playerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/player")
class playerController {
    @Autowired  //inyectar un service
    lateinit var playerService: playerService

    @GetMapping
    /*fun list():List<player>{
        return playerService.list()
    }*/

    fun list(): ResponseEntity<*>{
        return ResponseEntity(playerService.list(), HttpStatus.OK)
    }

    @PostMapping
    /*fun save(@RequestBody player: player):player{
        return playerService.save(player)
    }*/

    fun save (@RequestBody player: player):ResponseEntity<player>{
        return ResponseEntity(playerService.save(player), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody player: player): ResponseEntity<player>{
        return ResponseEntity(playerService.update(player),HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody player: player ):ResponseEntity<player>{
        return ResponseEntity(playerService.updateName(player), HttpStatus.OK)
    }


}
