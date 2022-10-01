package com.hawazin.jababira.services

import com.hawazin.jababira.models.Player
import graphql.schema.idl.RuntimeWiring
import org.springframework.stereotype.Service
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.hawazin.jababira.models.Match
import com.hawazin.jababira.models.NewMatch
import java.util.*


@Service
class SchemaBuilder(
    private val playerService: PlayerService,
    private val matchService: MatchService,
    private val playerRepository: PlayerRepository,
    private val positionRepository: PositionRepository,
    private val venueRepo:VenueRepository,
    ) {

    private final val objectMapper = jacksonObjectMapper()

    fun buildRunTimeWiring(): RuntimeWiring {
        return RuntimeWiring.newRuntimeWiring()
            .type("Query") {
                it.dataFetcher("players") {
                    var players = playerService.getAll()
                    return@dataFetcher players
                }
                it.dataFetcher("lookups") {
                    {}
                }
            }
            .type("Mutation") {
                it.dataFetcher("CreatePlayer") { env ->
                    val newPlayer = objectMapper.convertValue(env.arguments["player"],Player::class.java)
                    newPlayer.id = UUID.randomUUID()
                    return@dataFetcher playerService.save(newPlayer)
                }
                it.dataFetcher("UpdatePlayer") { env ->
                    val existingPlayer = objectMapper.convertValue(env.arguments["player"],Player::class.java)
                    return@dataFetcher playerRepository.save(existingPlayer)
                }
                it.dataFetcher("CreateMatch") {  env ->
                    val match = objectMapper.convertValue(env.arguments["match"], NewMatch::class.java)
                    return@dataFetcher matchService.save(match)
                }
            }
            .type("Lookup") {
                it.dataFetcher("venues") {
                    return@dataFetcher venueRepo.findAll()
                }
                it.dataFetcher("positions") {
                    return@dataFetcher positionRepository.findAll()
                }
            }
            .build()
    }

}