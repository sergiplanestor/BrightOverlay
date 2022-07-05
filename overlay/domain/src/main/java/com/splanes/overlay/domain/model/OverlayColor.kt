package com.splanes.overlay.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class OverlayColor(open val hex: String) : Parcelable {
  @Parcelize
  object Black : OverlayColor(hex = "#000000")
  
  @Parcelize
  object Gray : OverlayColor(hex = "#808080")
  
  @Parcelize
  object DarkGray : OverlayColor(hex = "#212121")
  
  @Parcelize
  object BlueGray : OverlayColor(hex = "#263238")
  
  @Parcelize
  object StealGray : OverlayColor(hex = "#71797E")
  
  @Parcelize
  data class Custom internal constructor(override val hex: String) : OverlayColor(hex)
  
  companion object
}