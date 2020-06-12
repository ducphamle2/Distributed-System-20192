# Pham Le Duc
# Student ID: 20161128
# Class: ICT.01-K61

## Question 1: 

The result is sometimes different other than 3000, because there's no synchronization mechanism for the threads, so a thread may read an old value that has been updated before by another thread => the update value of each thread is different everytime => cannot get 3000

## Question 2:

The result is always 3000 because all the threads have been synchronized, at one time, only one thread can access the variable. Therefore, the each thread will increment the latest value of rsc.

## Question 3:

The result is always 3000 because now a worker can only access the variable when it is free, meaning that the variable is not being used by other workers. After executing the operation relating to the variable rsc, it will be unlocked for other thread workers to access

## Question 4:

the code part that needs to be completed:

    while (time(NULL) <= end)

    {

      shared++;

      sleep(1);

    }

## Question 5:

We obtain the different results between the two values because as the number of threads increases without synchronization, they simutanously access the same balance and credits variables at the same time. Because of this, a variable may be changed when a thread is trying to change its value. 

For example, we have balance = balance - v; while thread 1 finish calculating balance = 1, but before assigning that value, another thread 2 has changed balance = 2 before => the variable has different values after the program executes.

## Question 6: 

The difference may come from the code block below:

    while (lock > 0);

    lock = 1; //set lock

    shared++; //increment

    lock = 0; //unlock

After lock = 0, the while (lock > 0) stops for other threads running concurrently. As a result, a number of threads start the next code lines: lock = 1 and shared++ at the same time => the resource is used by multiple threads => lock fails

## Question 7: 

The balance is equal to the result of INIT_BALANCE + credits - debits. 

./mutex-lock-banking 1000

    Credits:        4537683

    Debits:        3609904

    50+4537683-3609904=     927829

    Balance:       927829

## Question 8:

./fine-locking-bank 5000

    Time spent: 8.08

    Credits:        16006627

    Debits:        3332143

    50+16006627-3332143=    12674534

    Balance:       12674534

./mutex-lock-banking 5000

    Time spent: 9.17

    Credits:        11858147

    Debits:        10003773

    50+11858147-10003773=           1854424

    Balance:       1854424

The results show that the fine-locking strategy is faster (1 sec faster is a lot) when the number of threads increases

## Question 9:

There is no output because the program is in deadlock, and it is stuck there forever. A deadlock is when two threads or two processes waiting for the other's resource to be unlocked in order to unlock its currently used resource. In this code, thread 1 holding resource a is waiting for b to be unlocked to unlock a, while thread 2 is waiting for a to be unlocked to unlock b. This leads to a situation called deadlock, and the program is stuck unless one of the two threads or both are killed which release the resources.