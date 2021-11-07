package com.jay.jpa.entity

import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private var id: Long? = null,

    @Column(name = "name", nullable = true)
    var name: String? = null,

    @Column(name = "phone", nullable = true, unique = true)
    var phone: String? = null,

    @Column(name = "created_at", nullable = false)
    @DateTimeFormat(style = "yyyy-MM-dd hh:mm:ss")
    var createdAt: Date = Date(System.currentTimeMillis())
): Serializable {
    constructor(name: String, phone: String): this() {
        this.name = name
        this.phone = phone
    }
}