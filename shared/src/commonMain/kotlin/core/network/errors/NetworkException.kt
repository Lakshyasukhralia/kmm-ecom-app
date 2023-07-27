package core.network.errors

enum class NetworkError {
    ServiceUnavailable,
    ClientError,
    ServerError,
    UnknownError
}

class NetworkException(error: NetworkError): Exception(
    "Something goes wrong: $error"
)