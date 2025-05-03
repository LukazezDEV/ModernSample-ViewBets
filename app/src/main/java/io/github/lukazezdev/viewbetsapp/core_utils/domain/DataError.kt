package io.github.lukazezdev.viewbetsapp.core_utils.domain

import androidx.annotation.StringRes
import io.github.lukazezdev.viewbetsapp.R

interface Error

sealed interface DataError: Error {
    val stringRes: Int

    enum class Remote(@StringRes override val stringRes: Int): DataError {
        REQUEST_TIMEOUT(R.string.error_request_timeout),
        TOO_MANY_REQUESTS(R.string.error_too_many_requests),
        NO_INTERNET(R.string.error_no_internet),
        SERVER(R.string.error_server),
        SERIALIZATION( R.string.error_serialization),
        BAD_REQUEST(R.string.error_bad_request),
        UNAUTHORIZED(R.string.error_unauthorized),
        FORBIDDEN(R.string.error_forbidden),
        NOT_FOUND(R.string.error_not_found),
        UNKNOWN(R.string.error_unknown),
    }
}