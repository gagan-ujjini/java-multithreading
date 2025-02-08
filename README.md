# java-multithreading

## Steps to create thread

1. Extend thread class
2. Implement runnable interface

## Implementing "Runnable" interface (Steps):

1. Create a Runnable Object

- create a class that implements 'Runnable' interface
- implement the "run()" method to tell the task which a thread will have to do

2. Start the thread

- create an instance of class that implement 'Runnable'
- pass the runnable object to the thread constructor
- start the thread

## Extending the 'Thread' class

1. Create a Thread subclass

- create a class that extends 'Thread' class
- override the 'run()' method to tell the task which thread has to do

2. Initiate and start the thread

- Create an instance of the subclass
- call the start() method to begin the execution
