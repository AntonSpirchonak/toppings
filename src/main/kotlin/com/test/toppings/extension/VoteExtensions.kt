package com.test.toppings.extension

import com.test.toppings.dto.VoteView
import com.test.toppings.entity.Vote

fun Vote.toVoteView() = VoteView(
  email = email,
  toppings = toppings.map { it.name }
)