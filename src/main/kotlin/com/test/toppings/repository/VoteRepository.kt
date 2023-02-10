package com.test.toppings.repository

import com.test.toppings.entity.Vote
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface VoteRepository : CrudRepository<Vote, Long> {

  fun findVoteByEmail(email:String): Optional<Vote>
}