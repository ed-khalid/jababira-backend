package com.hawazin.jababira.services

import com.hawazin.jababira.models.*
import org.springframework.stereotype.Service
import java.util.*

@Service
class PlayerService(val playerRepo:PlayerRepository, val positionRepo:PositionRepository) {

    fun getAll(): MutableIterable<Player> = playerRepo.findAll()

    fun save(player: Player) : Player {
        val position = positionRepo.findByValue(player.attributes.position.value)
        player.attributes.position = position
        return playerRepo.save(player)
    }
}

@Service
class MatchService
    (val matchRepository: MatchRepository,
     val colorRepository: UniformColorRepository,
     val positionRepo: PositionRepository,
     val playerRepo: PlayerRepository,
     val nationalityRepository: NationalityRepository,
     val venueRepository: VenueRepository,
     val matchTypeRepository: MatchTypeRepository
    )
{

    fun save(newMatch: NewMatch) : Match {
        val matchType = matchTypeRepository.findByValue(newMatch.type.value)
        val venue = venueRepository.findById(newMatch.venueId)
        val squads = newMatch.squads.map { squad ->
            val color = colorRepository.findByValue(squad.color.value)
            val nationality = nationalityRepository.findByValue(squad.dominantNationality.value)
            val captain = playerRepo.findById(squad.captainId)
            val squadPlayers = squad.players.map squadPlayer@{
                val position = positionRepo.findByValue(it.position.value)
                val player = playerRepo.findById(it.playerId)
                return@squadPlayer it.let { SquadPlayer(id= UUID.randomUUID(), player = player.get(), performanceRating = it.performanceRating, position = position, hasPaid = null, squad = null) }
            }
            Squad(id = null, color= color, dominantNationality= nationality, players = squadPlayers.toMutableList(), isJababiraSquad = squad.isJababiraSquad, score= squad.score, captain = captain.get(), match= null)
        }
        val match = newMatch.let { Match( id = null, type = matchType, venue =  venue.get(), squads = squads.toMutableList(), date = it.date, time = it.time  )}
        return matchRepository.save(match)
    }
}