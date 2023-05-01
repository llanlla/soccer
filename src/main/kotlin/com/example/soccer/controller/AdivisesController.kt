package com.example.soccer.controller

import com.example.soccer.model.Advises
import com.example.soccer.service.AdvisesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/advises")

class AdivisesController {
    @Autowired  //inyectar un service
    lateinit var advisesService: AdvisesService

    @GetMapping

    fun list(): ResponseEntity<*> {
        return ResponseEntity(advisesService.list(), HttpStatus.OK)
    }

    @PostMapping
            /*fun save(@RequestBody player: player):player{
                return playerService.save(player)
            }*/

    fun save (@RequestBody advises: Advises): ResponseEntity<Advises> {
        return ResponseEntity(advisesService.save(advises), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody advises: Advises): ResponseEntity<Advises> {
        return ResponseEntity(advisesService.update(advises), HttpStatus.OK)
    }

    @PatchMapping
    fun updateColorCard (@RequestBody advises: Advises): ResponseEntity<Advises> {
        return ResponseEntity(advisesService.updateColorCard(advises), HttpStatus.OK)
    }
}