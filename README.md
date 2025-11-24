# SmartBank – Java OOP Banking Application

SmartBank is a console-based Java application built using Object-Oriented Programming (OOP) principles. It simulates basic banking operations like creating accounts, depositing money, withdrawing funds, showing account details, and maintaining transaction history.

---

## Features

- Create different types of bank accounts:
  - **SavingsAccount**
  - **CurrentAccount**
- Deposit money
- Withdraw with balance validation
- Overdraft support for Current Account
- Full transaction history tracking
- View all accounts
- View single account summary

---

## Project Structure

```
SmartBank/
│── Main.java
│── BankAccount.java
│── SavingsAccount.java
│── CurrentAccount.java
│── (Compiled .class files)
```

### **Class Overview**

| Class Name        | Purpose |
|------------------|---------|
| `BankAccount`    | Abstract base class for all account types |
| `SavingsAccount` | Supports normal withdraw + logs transactions |
| `CurrentAccount` | Supports overdraft limit of ₹5000 |
| `Main`           | Handles menu, input, and program control |

---

## Technologies Used

- **Java (JDK 8 or above)**
- **Core OOP Concepts**
- Scanner-based console UI

---

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/Patil-Shital-9236/SmartBank.git
```

2. Open folder:

```bash
cd SmartBank
```

3. Compile Java files:

```bash
javac Main.java
```

4. Run the program:

```bash
java Main
```

---

## Learning Outcome

You will learn:

- Abstraction  
- Inheritance  
- Polymorphism  
- Encapsulation  
- Real-world banking logic implementation  
- Clean menu-driven Java programming  

---

## License

This project is free to use and open-source.

---

## Author

**Shital Patil**  
GitHub: [Patil-Shital-9236](https://github.com/Patil-Shital-9236)

