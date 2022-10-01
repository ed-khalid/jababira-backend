package com.hawazin.jababira.models

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*


@Entity
class Venue (
    @Id @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: UUID,
    var name:String,
    var address:String,
    @ManyToOne @JoinColumn(name="venue_type")
    var type:VenueType
)
