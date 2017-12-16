package com.andreadev.stargazerssample.exceptions

class GitHubApiException : RuntimeException {

    var code: Int = 0
    var body: String? = null

    private constructor(code: Int, body: String) {
        this.code = code
        this.body = body
    }

    private constructor(message: String, cause: Throwable, code: Int, body: String) : super(message, cause) {
        this.code = code
        this.body = body
    }

    companion object {

        fun create(httpStatus: Int, body: String): GitHubApiException {
            return GitHubApiException(httpStatus, body)
        }

        fun create(message: String, cause: Throwable, httpStatus: Int, body: String): GitHubApiException {
            return GitHubApiException(message, cause, httpStatus, body)
        }
    }

}
