# Order Manager – Java Study Project

### What I practiced:
- Working with **ArrayList** as a core data structure  
- Implementing **basic OOP principles** like encapsulation and separation of concerns  
- Handling **user input and exceptions** gracefully with `Scanner` and `try-catch`  
- Managing simple **queue-like behavior** using ArrayList (FIFO logic)  
- Creating reusable methods to reduce code duplication  

### Features:
- Register new orders with multiple items and delivery or pickup option  
- Show and serve the next order in the queue  
- List all pending and served orders separately  
- Cancel orders by customer name  
- Input validation with error handling for a better user experience  

### How it works:
- The `OrderManagerDemo` class handles user interaction via the console (menu, inputs, outputs)  
- The `OrderManager` class contains all the business logic to manipulate orders and perform operations like serving or canceling orders  
- Orders are stored in `ArrayList<Order>` collections representing pending and served orders  
- The program starts with 10 sample orders already created for testing  

### Why I did it:
This project was built as a personal study exercise to practice and understand how to use ArrayLists effectively, organize code cleanly using OOP principles, and simulate real-world queue operations in a simple console application. It helped reinforce key Java concepts and improve code structure for maintainability.
