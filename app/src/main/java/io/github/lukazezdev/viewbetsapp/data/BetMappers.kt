package io.github.lukazezdev.viewbetsapp.data

import android.content.Context
import io.github.lukazezdev.viewbetsapp.domain.Bet
import io.github.lukazezdev.viewbetsapp.domain.BetType

fun BetResponseObject.toBet(context: Context) =
    Bet(
        type = BetType.entries.find { context.getString(it.stringId).equals(type.trim(), ignoreCase = true) } ?: BetType.OTHER,
        sellIn = sellIn,
        odds = odds,
        imageUrl = imageUrl
    )