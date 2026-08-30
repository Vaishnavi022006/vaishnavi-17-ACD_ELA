# Automata Theory - DFA, NFA and NFA to DFA

Code explanation video link: https://drive.google.com/file/d/1hNI30u-kk4rBUw-LQH5go40hwDsugC4l/view?usp=drivesdk

Finite Automata are mathematical models used to represent systems that process input strings and determine whether they are accepted or rejected.

This project implements basic concepts of Automata Theory using Java.

This project covers:

- 🔵 DFA (Deterministic Finite Automaton)
- 🟣 NFA (Nondeterministic Finite Automaton)
- 🔄 NFA to DFA Conversion
- 💻 Console-based implementation of finite automata
- 📚 Practical implementation of Automata Theory concepts using Java


---

## ✨ Features

### 1. 🔵 DFA

The program implements a Deterministic Finite Automaton that processes a binary input string containing `0` and `1`.

A DFA has:

- A finite set of states
- An input alphabet
- Transition functions
- An initial state
- A final/accepting state

The program starts from state `q0` and processes the input one symbol at a time.

For the implemented DFA:

- `q0 --0--> q0`
- `q0 --1--> q1`
- `q1 --0--> q0`
- `q1 --1--> q1`

The final state is checked to determine whether the input string is accepted or rejected.


### 2. 🟣 NFA

The program also implements a Nondeterministic Finite Automaton.

Unlike a DFA, an NFA can have multiple possible states for the same input symbol.

The NFA uses the following transitions:

- `q0 --0--> {q0, q1}`
- `q0 --1--> {q0}`
- `q1 --1--> {q2}`
- `q2 --0--> {q2}`

The initial state is:

`q0`

The final state is:

`q2`

The program maintains a set of current states and updates the set after reading each input symbol.

If the final set of states contains `q2`, the string is accepted.


### 3. 🔄 NFA to DFA Conversion

The project implements NFA to DFA conversion using the **Subset Construction Method**.

In this method:

- Each DFA state represents a set of NFA states.
- The initial DFA state is `{q0}`.
- For every input symbol, all possible NFA transitions are calculated.
- Newly generated sets of states become new DFA states.
- The process continues until all reachable DFA states are generated.

The program uses a queue to process newly discovered DFA states.


---

## 🧠 Concepts Used

The following Automata Theory concepts are demonstrated:

- Deterministic Finite Automaton (DFA)
- Nondeterministic Finite Automaton (NFA)
- State Transitions
- Input Alphabet
- Initial State
- Final State
- String Acceptance and Rejection
- Set of States
- Subset Construction
- NFA to DFA Conversion


---

## 💻 Technologies Used

- **Programming Language:** Java
- **Data Structures:** HashMap, HashSet, Queue
- **Input:** Java Scanner
- **Concept:** Automata Theory


---

## 📂 Project Structure

```text
vaishnavi-17-ACD_ELA/
│
├── Automata.java
├── Google_Drive_Link.txt
└── README.md
