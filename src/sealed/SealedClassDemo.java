package sealed;

sealed interface Response permits SuccessResponse, ErrorResponse {

}

public class SealedClassDemo {
}

non-sealed class SuccessResponse implements Response {

}

non-sealed class ErrorResponse implements Response {

}