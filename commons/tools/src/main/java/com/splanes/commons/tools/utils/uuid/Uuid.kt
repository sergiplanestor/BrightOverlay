package com.splanes.commons.tools.utils.uuid

import android.os.Parcelable
import com.splanes.commons.tools.utils.primitive.remove
import java.util.UUID
import kotlinx.parcelize.Parcelize

/*
 * Created on 07/07/2022 at 22:46
 * @author Sergi Planes
 * @since 1.0.0
 */


sealed class Uuid(open val value: String) : Parcelable {

 @Parcelize
 data class Simple(override val value: String) : Uuid(value) {
  companion object
 }

 @Parcelize
 data class Timestamped(override val value: String, val timestamp: Long) : Uuid(value)

 companion object
}

fun Uuid.Simple.Companion.random(): Uuid.Simple = Uuid.Simple(value = UUID.randomUUID().toString().remove("-"))
fun Uuid.Companion.random(): Uuid = Uuid.Simple.random()


