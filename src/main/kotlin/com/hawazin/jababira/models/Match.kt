package com.hawazin.jababira.models
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.node.TextNode
import org.hibernate.annotations.GenericGenerator
import java.sql.Time
import java.time.LocalTime
import java.util.*
import java.util.concurrent.TimeUnit
import javax.persistence.*

@Entity
class Match (
    @Id @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: UUID?,
    @ManyToOne @JoinColumn(name = "match_type")
    var type:MatchType,
    var date: Date,
    var time:LocalTime,
    @ManyToOne @JoinColumn(name ="venue_id")
    var venue:Venue,
    @OneToMany(mappedBy = "match", cascade = CascadeType.PERSIST )
    var squads:MutableList<Squad>,
)

data class NewMatch(val date:Date, @JsonDeserialize(using = TimeDeserializer::class) val time:LocalTime, @JsonDeserialize(using = MatchTypeDeserializer::class) val type:MatchType, val venueId:UUID, val squads:List<NewSquad> )

class TimeDeserializer : JsonDeserializer<LocalTime>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext): LocalTime {
        if (p != null) {
            val node = p.codec.readTree<TextNode>(p)
            val localtime = LocalTime.parse(node.asText())
            return localtime
        }
        throw Error("JsonParser not found")
    }
}

