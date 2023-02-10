package com.test.toppings.repository

import com.test.toppings.entity.Vote
import org.springframework.data.repository.CrudRepository

interface VoteRepository : CrudRepository<Vote, Long> {

  fun findVoteByEmail(email:String): Vote?
}