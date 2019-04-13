package action

interface UseCase<in INPUT, out OUTPUT> {
    fun execute(input : INPUT) : OUTPUT
}