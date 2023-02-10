package com.test.toppings.controller

import com.test.toppings.dto.VoteView
import com.test.toppings.dto.VoteResultView
import com.test.toppings.service.VoteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/vote/toppings")
class VoteController(val voteService: VoteService) {

  @GetMapping("/result")
  fun getVoteResult(): VoteResultView = voteService.getVoteResults()

  @GetMapping("/result/{email}")
  fun getVoteResultById(@PathVariable("email") email: String): VoteResultView = voteService.getVoteResultByEmail(email)

  @PostMapping()
  fun submitVote(@RequestBody vote: VoteView) {
    voteService.vote(vote)
  }
}