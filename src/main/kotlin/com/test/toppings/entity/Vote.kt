package com.test.toppings.entity

import javax.persistence.*

@Entity
data class Vote(
  @Column(nullable = false)
  val email: String,

  @ManyToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
  @JoinTable(
    name = "vote_detail",
    joinColumns = [JoinColumn(name = "vote_id")],
    inverseJoinColumns = [JoinColumn(name = "topping_id")]
  )
  var toppings: List<Topping> = listOf(),

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = 0
)
