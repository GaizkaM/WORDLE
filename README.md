# Wordle

Welcome to **Wordle**, a simple and fun word-guessing game implemented in Java using the NetBeans IDE! This project was created as the final assignment for the **Programming I** course in Computer Engineering.

## 📖 Description

**Wordle** is a word puzzle game where players must guess a 5-letter target word within a limited number of attempts. The game provides feedback using colors to indicate how close the guess is to the target word:

- **Gray**: The letter is not in the target word.
- **Yellow**: The letter is in the target word but in the wrong position.
- **Green**: The letter is in the target word and in the correct position.

The goal is to guess the target word before running out of attempts. The game also tracks statistics of past games, which can be reviewed at any time.

## 🎮 How to Play

1. **Main Menu**:
   - The game starts with a menu offering three options:
     1. Play a game
     2. View game statistics
     3. Exit the game

2. **Starting a Game**:
   - Enter your name and the number of rounds you'd like to play.
   - A random 5-letter target word is selected from a predefined word list.

3. **Gameplay**:
   - Type your guess for the target word.
   - The game provides feedback for each letter based on its match with the target word (Gray, Yellow, or Green).
   - If your guess is invalid (not in the word list), you can try again without losing a turn.

4. **End of Game**:
   - If you guess the target word, the game ends and saves your result.
   - If you fail to guess the word within the given rounds, the target word is revealed.

5. **Statistics**:
   - Review all previous games, including player names, dates, target words, and guesses, stored in a file named `historial.txt`.

6. **Exit**:
   - Choose to exit the program or return to the main menu.

## 🗂 Project Structure

The project is organized into the following files:

- **LT.java**: A utility class for input/output operations, used throughout the course.
- **Palabra.java**: A class for word-related functions, including custom methods for this project.
- **PalabraFicherosLectura.java** and **PalabraFicherosEscritura.java**: Classes for reading and writing word files, ensuring the validity of guessed words and target words.
- **ResultadoFicherosLectura.java** and **ResultadoFicherosEscritura.java**: Classes for managing game statistics. They handle reading (`historial.txt`) and writing game results.
- **ETColor.java**: A class that enables colored output for feedback during the game.
- **main.java**: The main class that contains:
  - `Menu()`: Displays the main menu.
  - `JugarPartida()`: Implements the gameplay logic.
  - `EstadisticasPartidas()`: Shows game statistics.
  - `SalirJuego()`: Handles exiting the program.

## ✨ Key Features

- **Dynamic Feedback**: Colored feedback for guessed letters (Gray, Yellow, Green).
- **Randomized Words**: Target word selected randomly for each game.
- **File Management**: Game statistics are stored and retrievable from a text file.
- **Language Options**: Words can be selected from different language files (e.g., Spanish or Catalan).

## 📢 Author

- **Gaizka Medina Gordo**
