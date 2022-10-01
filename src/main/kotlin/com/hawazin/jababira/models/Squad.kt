package com.hawazin.jababira.models

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
class Squad (
    @Id @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: UUID?,
    @ManyToOne @JoinColumn(name = "color")
    var color:UniformColor,
    @ManyToOne @JoinColumn(name = "nationality")
    var dominantNationality:Nationality,
    var isJababiraSquad:Boolean,
    @OneToMany(mappedBy="squad")
    var players:MutableList<SquadPlayer>,
    @ManyToOne @JoinColumn(name="match_id")
    var match:Match?,
    @Column(nullable=true)
    var score:Int?,
    @ManyToOne @JoinColumn(name="captain_id")
    var captain:Player
)

data class NewSquad(@JsonDeserialize(using = UniformColorDeserializer::class) val color:UniformColor, @JsonDeserialize(using = NationalityDeserializer::class) val dominantNationality: Nationality, val isJababiraSquad: Boolean, val score: Int?, val captainId:UUID, val players:List<NewSquadPlayer>)
data class NewSquadPlayer(val playerId:UUID, val performanceRating: Int, @JsonDeserialize(using=PositionDeserializer::class) val position:Position )

@Entity
class SquadPlayer(
    @Id @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id:UUID?,
    @ManyToOne @JoinColumn(name= "player_id")
    var player:Player?,
    @ManyToOne @JoinColumn(name="position_id")
    var position:Position,
    @ManyToOne @JoinColumn(name= "squad_id")
    var squad:Squad?,
    @Column(nullable=true)
    var performanceRating:Int?,
    @Column(nullable=true)
    var hasPaid:Boolean?
)





