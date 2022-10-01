package com.hawazin.jababira.services

import com.hawazin.jababira.models.*
import org.springframework.data.repository.CrudRepository
import java.util.*


interface PlayerRepository: CrudRepository<Player, UUID>  {}
interface VenueRepository: CrudRepository<Venue, UUID>  {}
interface MatchTypeRepository: CrudRepository<MatchType, UUID> {
    fun findByValue(value:MatchTypeValue): MatchType
}
interface PositionRepository: CrudRepository<Position, UUID>  {
    fun findByValue(value:PositionValue): Position
}
interface UniformColorRepository: CrudRepository<UniformColor, UUID>  {
    fun findByValue(value:ColorValue): UniformColor
}
interface NationalityRepository: CrudRepository<Nationality, UUID>  {
    fun findByValue(value:NationalityValue): Nationality
}
interface MatchRepository : CrudRepository<Match, UUID>  {}
interface SquadRepository: CrudRepository<Squad, UUID>  {}
interface SquadPlayerRepository: CrudRepository<SquadPlayer, UUID>  {}
