package com.hawazin.jababira.models

import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.node.TextNode
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
class Player (
    @Id @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: UUID?,
    @Column(nullable=false, length = 20)
    var firstName:String,
    @Column(nullable=false, length = 20)
    var lastName:String,
    @Temporal(TemporalType.DATE)
    var dob:Date?,
    var picture:String?,
    @ManyToOne(optional=true)
    var nationality:Nationality?,
    @Column(nullable=true)
    var height:Float?,
    @Column(nullable=true)
    var weight:Float?,
    var attributes:PlayerAttributes
)

@Embeddable
class PlayerAttributes(
    var speed:Int,
    var shoot:Int,
    var dribble:Int,
    var pass:Int,
    var head:Int,
    var defense:Int,
    var stamina:Int,
    var gk:Int,
    var team:Int,
    var iq:Int,
    @ManyToOne @JoinColumn(name ="position")
    @JsonDeserialize(using=PositionDeserializer::class)
    var position:Position
)

