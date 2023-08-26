# javaNetworking

## Multithreading

-  It doesn't block the user because threads are independent and you can perform multiple operations at the same time.
-  You can perform many operations together, so it saves time
-  Threads are independent, so it doesn't affect other threads if an exception occurs in a single thread.

1) Process-based Multitasking (Multiprocessing)
- Each process has an address in memory. In other words, each process allocates a separate memory area.
A process is heavyweight.
Cost of communication between the process is high.
Switching from one process to another requires some time for saving and loading registers, memory maps, updating lists, etc.
2) Thread-based Multitasking (Multithreading)
- Threads share the same address space.
A thread is lightweight.
Cost of communication between the thread is low.



