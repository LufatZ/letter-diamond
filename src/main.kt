import exceptions.NoCharFoundException
import exceptions.NotAnCharException

/**
 * Main function to execute the letter-diamond drawing program.
 * It continuously prompts the user for a letter and draws a diamond until the user decides to exit.
 *
 * @author LufatZ
 */
fun main() {
    while (true) {
        println("Welcome to Letter-Diamond :)\nType a letter between \"A\" and \"Z\" and the program will count to it and draw a diamond!")
        val destination: Char = inputVerification(readln())
        println("Your letter is $destination. Look at this beautiful diamond!\n\n")
        draw(destination)
        println("\n\nDo you want to exit? y|n")
        if (readln().uppercase().contains('Y')) { break }
    }
}

/**
 * Draws a diamond shape using the letters from 'A' to the specified destination character.
 * @param destination The character up to which the diamond will be drawn.
 */
fun draw(destination: Char) {
    val start: Char = 'A'
    var counter: Char = start
    var countUp: Boolean = true
    var outerSpace: Int
    var innerSpace: Int

    while (counter >= start) {
        outerSpace = destination - counter
        innerSpace = if (counter - start <= 0) 0 else (counter - start) * 2 - 1
        println(
            " ".repeat(outerSpace) + counter +
                    ".".repeat(innerSpace) +
                    (if (counter != start) counter else "") +
                    " ".repeat(outerSpace)
        )
        if (counter == destination) countUp = false
        counter = if (countUp) counter + 1 else counter - 1
    }
}

/**
 * Verifies the input to ensure it contains a valid character between 'A' and 'Z'.
 * If the input is a string, it takes the first valid character. If no valid character is found, it defaults to 'D'.
 * @param input The user input string.
 * @return The verified character.
 */
fun inputVerification(input: String): Char {
    var char: Char = '0'
    val userInput = input.uppercase()

    if (userInput.length > 1) {
        println(NotAnCharException("You typed in a string, but a single character was expected! The program automatically chose the first letter from your input."))
    }
    for (c in userInput) {
        if (c in 'A'..'Z') {
            char = c
            break
        }
    }
    if (char == '0') {
        char = 'D'
        println(NoCharFoundException("The program couldn't find any letter in your input. An example is started with \"$char\"."))
    }
    return char
}
