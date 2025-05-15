# Tic-Tac-Toe Game with AspectJ

This project is a console-based two-player Tic-Tac-Toe game built in Java and enhanced with AspectJ. It demonstrates how Aspect-Oriented Programming (AOP) can be used to cleanly separate core gameplay from rule-checking logic like win and tie detection.

---

## 🎯 Key Features

- 👤 Two-player, turn-based gameplay
- 🔄 AspectJ handles cross-cutting logic:
  - Win and tie detection happens outside the main game class
  - Aspect runs **before** each player's turn to evaluate game state
- 🧼 Clean separation of concerns for better modularity

---

## 💡 Why AspectJ?

AspectJ allows you to isolate repetitive or cross-cutting concerns (like win-checking) from the rest of your business logic.

In this game:
- The **RefereeAspect.aj** file monitors the state of the board before each turn.
- If a win or tie condition is met, it prints the result and stops the game.
- This keeps the main game loop focused only on input/output and player flow.

---

## 📁 File Structure

```
tic-tac-toe-aspectj/
├── TicTacToeGameMain.java      // Core gameplay logic and turn loop
└── RefereeAspect.aj            // Aspect to check for win/tie before each turn
```

---

## 🛠 Technologies Used

- Java (Standard Edition)
- AspectJ (.aj file + pointcuts and advice)
- Console-based input/output

---

## 🚀 How to Run

1. Compile the Java file and AspectJ file using `ajc` (AspectJ compiler):
   ```
   ajc TicTacToeGameMain.java RefereeAspect.aj
   ```

2. Run the compiled class:
   ```
   java TicTacToeGameMain
   ```

> Note: You’ll need the AspectJ tools installed or configured in your IDE (e.g., Eclipse with AJDT plugin).

---

## 👤 Author

**Yalem Gebremariam**  
GitHub: [github.com/Yalemgy](https://github.com/Yalemgy)

---

## 📌 Future Improvements

- Add AI opponent mode
- Track player scores across rounds
- Build a GUI version using JavaFX or Swing
