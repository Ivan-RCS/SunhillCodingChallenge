Sunhill Engineering Coding Challenge.

In relation for Java Role aplication, a small Java project was developed to solve the challenge.
The IDE used was Eclipe.
Java 8.
A project management and comprehension tool (Maven) was utilized. This allow compile and test the project easily using commands via the console.

Use these commands:

	- mvn clean install  //to create the jar and execute the test
	- mvn exec:java //to execute the program

This approach tries to demonstrate the skills in modeling different classes, show oriented-object knowledge as well as design patterns. In addition, some of the last Java features like lambda expressions or Optional were used.

The challenge was related to bank accounts operations. The solution is a small approach but I noticed the importance of concurrency in a real scenario when an account modifies the balance. For that reason, as a simple solution for the challenge, the methods of deposit and withdraw are synchronized for preventing thread interference and memory consistency errors.

Other comments:

	- Unit Tests have been included with different text files. See the test packages.

	- The code provides comments on the applied operations.

In the target folder is founded the SunhillCodingChallenge-1.0.jar (The jar is created after running "mvn clean install").
To Run the App, use the next command:

	- java -jar SunhillCodingChallenge-1.0.jar