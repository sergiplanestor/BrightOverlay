package com.splanes.commons.data.errors

import com.splanes.commons.domain.errors.model.KnownThrowable
import kotlinx.parcelize.Parcelize

/*
 * Created on 05/07/2022 at 0:49
 * @author Sergi Planes
 * @since 1.0.0
 */

@Parcelize
class IdNotFoundException() : KnownThrowable()