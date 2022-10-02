package com.hawazin.jababira.models

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
class PlayerGroup (
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id:UUID?,
    var name:String,
    @ManyToMany(mappedBy = "groups")
    var player:MutableList<Player>
)