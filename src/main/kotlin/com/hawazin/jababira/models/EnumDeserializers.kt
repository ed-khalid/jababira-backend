package com.hawazin.jababira.models

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.node.TextNode
import java.util.*

class UniformColorDeserializer : JsonDeserializer<UniformColor>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): UniformColor {
        if (p != null) {
            val node = p.codec.readTree<TextNode>(p)
            return UniformColor(UUID.randomUUID(), ColorValue.valueOf(node.textValue()) )
        }
        throw Error("Error deserializing UniformColor.class, JsonParser is null")
    }
}

class MatchTypeDeserializer : JsonDeserializer<MatchType>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): MatchType {
        if (p != null) {
            val node = p.codec.readTree<TextNode>(p)
            return MatchType(UUID.randomUUID(), MatchTypeValue.valueOf(node.textValue()) )
        }
        throw Error("Error deserializing MatchType.class, JsonParser is null")
    }
}
class PositionDeserializer : JsonDeserializer<Position>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Position {
        if (p != null) {
            val node = p.codec.readTree<TextNode>(p)
            return Position(UUID.randomUUID(), PositionValue.valueOf(node.textValue()) )
        }
        throw Error("Error deserializing Position.class, JsonParser is null")
    }
}
class NationalityDeserializer : JsonDeserializer<Nationality>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Nationality {
        if (p != null) {
            val node = p.codec.readTree<TextNode>(p)
            return Nationality(UUID.randomUUID(), NationalityValue.valueOf(node.textValue()) )
        }
        throw Error("Error deserializing Nationality.class, JsonParser is null")
    }
}
