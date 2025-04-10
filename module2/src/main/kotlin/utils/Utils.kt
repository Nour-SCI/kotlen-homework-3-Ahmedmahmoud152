package utils

fun <T> List<T>.getStringRepresentation(): String {
    return this.joinToString(", ", "[", "]")
}