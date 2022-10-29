package app.doggy.objectanimatorsample.model

import android.graphics.Color

data class Dancer(
  val name: String,
  val color: Color,
  val positionList: List<Position>,
)
