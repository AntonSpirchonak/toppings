package com.test.toppings.entity

import javax.persistence.*

@Entity
data class Topping(

  @Column(nullable = false)
  val name: String,

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long = 0,

  @ManyToMany(mappedBy = "toppings")
  val votes: List<Vote> = listOf()
)
