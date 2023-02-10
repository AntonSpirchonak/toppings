package com.test.toppings.repository

import com.test.toppings.entity.Topping
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface ToppingRepository : CrudRepository<Topping, Long> {

  fun findByName(name: String): Optional<Topping>

  @Query(
    """SELECT t.name
       FROM topping t
       JOIN vote_detail vd on t.id = vd.topping_id
       GROUP BY t.name
    """, nativeQuery = true
  )
  fun findVoteResult(): List<String>
}