# ⌨️ Typing Speed Checker

A fun and interactive **Typing Speed Test** built in Java. It challenges your typing skills by measuring your **words per minute (WPM)** and **accuracy**, using realistic, punctuation-rich sentences.

![Java](https://img.shields.io/badge/Language-Java-blue.svg)
![Beginner Project](https://img.shields.io/badge/Level-Beginner-brightgreen)
![Console Game](https://img.shields.io/badge/Type-Console--App-lightgrey)

---

## ✨ Features

### 🚀 Real-Time Typing Challenge
- Displays a **random long sentence** with punctuation.
- Starts measuring your typing **speed and accuracy** as soon as you begin.

### 📏 Dual Accuracy Scoring
- **Total Accuracy**: How close your typed text is to the original.
- **Typed Accuracy**: Accuracy relative to how much you typed.

### 🧠 Smart WPM Calculation
- Calculates both:
    - **Raw WPM**: Based on total words typed.
    - **Accurate WPM**: Based only on correctly typed words.

### ⏱️ Live Countdown & Timer
- Adds a **countdown before the test begins**.
- Records typing duration in seconds with precise timing.

### 🧾 Motivating Feedback
- Personalized feedback based on performance.
- Encouraging messages whether you're fast, steady, or improving!

### 💡 Clean UI Output
- Uses box art, spacing, and emojis to improve readability and visual appeal.
- Clearly separates **Results Section** from input and instructions.

---

## 🚀 Getting Started

### 📦 Requirements
- Java 8 or higher
- A terminal or command line interface

### 🛠️ How to Run

Download the jar file from the releases section
```bash
java -jar typing-speed.jar
```
---

## 🕹️ How to Play

1. Run the program in your terminal.
2. Read the welcome instructions and press **Enter** to begin.
3. Watch the **3-second countdown** on screen.
4. A sentence will be displayed — type it **as fast and accurately as possible**, including **punctuation**.
5. Press **Enter** once you finish typing.
6. The results screen will show:
    - ⏱️ Time Taken (in seconds)
    - 🚀 Raw WPM (total words typed)
    - 🎯 Accurate WPM (only correctly typed words)
    - 📌 Sentence Match Accuracy (based on original sentence)
    - 📌 Typed Input Accuracy (based on what *you* typed)
7. Receive a motivational message based on your final WPM.
8. To replay, simply **re-run the program**.

---
## 🧠 Future Improvements
✅ Word-by-word highlighting of mistakes  
⏱️ Live WPM counter while typing  
📊 Add leaderboard and score-saving  
🌐 Online multiplayer typing duel  
🖼️ GUI version using JavaFX or Swing  
🔄 Continuous mode (multiple sentences per round)

---
## 🔧 Tools Used
Java 17 (works with Java 8+)

IntelliJ IDEA (recommended)

Git + GitHub

---

## 🙌 Author Notes
This project is designed to help new Java learners practice:

✅ String handling and splitting  
✅ Accurate timing with System.currentTimeMillis()  
✅ Realistic console output formatting  
✅ Logic branching and precision calculations  

If you're new to Java and want a simple yet satisfying way to improve your skills — this is a great challenge!

---
## 🧠 Sample Output

```console
╔══════════════════════════════════════════════════╗
║       👋 Welcome to the Typing Speed Test!       ║
╠══════════════════════════════════════════════════╣
║ ✨ You’ll be shown a sentence to type.           ║
║ ⌨️ Try to type it as quickly and accurately      ║
║     as possible — punctuation included!          ║
║ 🎯 Let’s see how fast those fingers can fly!     ║
╚══════════════════════════════════════════════════╝

👉 Press Enter when you're ready to begin: 

⏳ Get ready! The typing test begins in ⏱️ 3
⏳ Get ready! The typing test begins in ⏱️ 2
⏳ Get ready! The typing test begins in ⏱️ 1
✅ Go! Start typing the following sentence:
📄 "Although it was raining heavily, the children decided to play outside, splashing in puddles and laughing with joy."
📝 You typed: "Although it was raining heavily, the children decided to play outside, splashing in puddles and laughing with joi."

━━━━━━━━━━━━━━━━━━━━━━ 📊 RESULTS 📊 ━━━━━━━━━━━━━━━━━━━━━━
⏱️ Time Taken: 13.8s
✍️ Words Typed: 19
🚀 Raw Speed (WPM): 82
🎯 Accurate Speed (WPM): 76
📌 Sentence Match Accuracy: 95.1%
📌 Typed Input Accuracy:    96.4%
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
💪 Great job! Keep practicing and you'll be even faster.

🎉 Thanks for trying the Typing Speed Checker!
```
