package com.test.toppings.repository

import com.test.toppings.dto.ToppingStatistic
import com.test.toppings.entity.Topping
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ToppingRepository : CrudRepository<Topping, Long> {

  fun findByName(name: String): Topping?

  @Query(
    """SELECT t.name, count(vd.vote_id) as votes
       FROM topping t
       JOIN vote_detail vd on t.id = vd.topping_id
       GROUP BY t.name
    """, nativeQuery = true
  )
  fun findVoteResult(): List<ToppingStatistic>
}