# Lab-1
1.	What is the output of each method in the console?
simple test, other simple test, @BeforeEach - executes before each test method in this class, @AfterEach - executed after each test method, @AfterAll - executed after all test methods

2.	What is the difference between the setup and init methods?
Set up is before all the tests and init is the first method to be run before each test

3.	Give an example of when you can use init and tearDown methods
When you use threads, it can be used in the critical section.

4.	What is @Disabled used for?
To skip at test that you don’t want to run yet, it can help to located bugs, etc.

5.	What is the difference and pros/cons of using Maven Test and Junit Test options?
Maven test only run the program and display in the console the results, junit test run each test and shows more detail of each test (how log it took to run) and ist more graphic but a little more slow that maven test.
