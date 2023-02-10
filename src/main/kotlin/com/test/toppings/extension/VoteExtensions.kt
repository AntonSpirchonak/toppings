package com.test.toppings.extension

import com.test.toppings.dto.VoteResultView
import com.test.toppings.entity.Vote

fun Vote.toVoteView() = VoteResultView(
  participantCount = 1,
  toppings = toppings.map { it.name }
)