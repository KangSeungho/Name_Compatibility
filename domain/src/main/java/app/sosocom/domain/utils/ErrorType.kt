package app.sosocom.domain.utils

enum class ErrorType {
    // 네트워크 문제
    NETWORK,

    // 요청 시간 초과
    TIMEOUT,

    // 세션 만료
    SESSION_EXPIRED,

    // 알수 없음
    UNKNOWN
}