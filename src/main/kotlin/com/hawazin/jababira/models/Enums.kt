package com.hawazin.jababira.models

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*
import javax.persistence.EnumType.*

@Entity
class MatchType(@Id @GeneratedValue(generator = "UUID") @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator") override var id: UUID, @Enumerated(STRING) override var value:MatchTypeValue)
    : AbstractJababiraEnum<MatchTypeValue>(id, value)
@Entity
class UniformColor(@Id @GeneratedValue(generator = "UUID") @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator") override var id: UUID, @Enumerated(STRING) override var value:ColorValue)
    : AbstractJababiraEnum<ColorValue>(id, value)
@Entity
class Nationality(@Id @GeneratedValue(generator = "UUID") @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator") override var id: UUID, @Enumerated(STRING) override var value:NationalityValue)
    : AbstractJababiraEnum<NationalityValue>(id, value)
@Entity
class Position(@Id @GeneratedValue(generator = "UUID") @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator") override var id: UUID, @Enumerated(STRING) override var value:PositionValue)
    : AbstractJababiraEnum<PositionValue>(id, value)
@Entity
class VenueType(@Id @GeneratedValue(generator = "UUID") @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator") override var id: UUID, @Enumerated(STRING) override var value:VenueTypeValue)
    : AbstractJababiraEnum<VenueTypeValue>(id, value)


enum class NationalityValue {
    IRAQ, LIBYA, SUDAN, PALESTINE, IRAN, SAUDI_ARABIA
}
enum class MatchTypeValue {
    CASUAL, FRIENDLY, LEAGUE
}
enum class ColorValue {
    BLACK, WHITE, RED;
}
enum class PositionValue {
    GK, DEF, MID, FW;
}
enum class PrecisePosition {
    CB,RB,LB,RM,CM,LM,FW,LW,RW
}
enum class VenueTypeValue {
    INDOOR, OUTDOOR
}
abstract class AbstractJababiraEnum<T>(
    open var id:UUID,
    open var value:T
)  {
    constructor(): this(UUID.randomUUID(), null as T ) {
    }
    override fun equals(other: Any?): Boolean {
        return this.toString() == other.toString()
    }
    override fun toString(): String {
        return value.toString()
    }
}


