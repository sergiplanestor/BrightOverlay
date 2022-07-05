package com.splanes.overlay.domain.model

import android.os.Parcelable
import androidx.annotation.FloatRange
import com.splanes.brightoverlay.domain.overlay.model.extensions.MaxOpacity
import com.splanes.brightoverlay.domain.overlay.model.extensions.MinOpacity
import kotlinx.parcelize.Parcelize

sealed class OverlayOpacity(@FloatRange(from = 0.0, to = 1.0) open val alpha: Float) : Parcelable {
  @Parcelize
  object Opaque : OverlayOpacity(alpha = MaxOpacity)
  
  @Parcelize
  object Medium : OverlayOpacity(alpha = 0.5f)
  
  @Parcelize
  object Transparent : OverlayOpacity(alpha = MinOpacity)
  
  @Parcelize
  data class Value internal constructor(override val alpha: Float) : OverlayOpacity(alpha)
  
  companion object
}