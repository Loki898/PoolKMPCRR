package ies.antonio.sequeros

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform