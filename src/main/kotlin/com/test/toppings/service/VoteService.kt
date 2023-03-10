package com.test.toppings.service

import com.test.toppings.dto.ToppingStatistic
import com.test.toppings.dto.VoteView
import com.test.toppings.entity.Topping
import com.test.toppings.entity.Vote
import com.test.toppings.extension.toVoteView
import com.test.toppings.repository.ToppingRepository
import com.test.toppings.repository.VoteRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import org.springframework.web.server.ResponseStatusException

@Service
class VoteService(
  val voteRepository: VoteRepository,
  val toppingRepository: ToppingRepository,
) {

  fun getVoteResultByEmail(email: String): VoteView {
    return voteRepository.findVoteByEmail(email)?.toVoteView() ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
  }

  //Generally, it is a bad idea to send two request here and might be adjusted to use single query instead of two requests
  fun getVoteResults(): List<ToppingStatistic> {
    return toppingRepository.findVoteResult()
  }

  fun vote(vote: VoteView) {

    if (vote.email.isBlank() || CollectionUtils.isEmpty(vote.toppings)) {
      throw ResponseStatusException(HttpStatus.BAD_REQUEST)
    }

    val voteEntity = voteRepository.findVoteByEmail(vote.email) ?: Vote(vote.email)

    voteEntity.toppings = vote.toppings
      .map { it.uppercase() }
      .map {
        toppingRepository.findByName(it) ?: Topping(it)
      }

    voteRepository.save(voteEntity)
  }
}