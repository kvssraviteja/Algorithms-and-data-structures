# Algorithms-and-data-structures

## Comparison of collision resolution techniques in hashing

In this project, I analyzed the performance of three types of open addressing techniques: linear probing, quadratic probing and double hashing considering the parameter of the number of probes generated for each technique.

To analyze the performance of the three techniques, hash tables of 3 different sizes are used: 1223, 1831 and 2447. I defined a class called UserHashTable which can store keys and the count of the keys (if duplicate keys are being inserted). The class has the following methods:
- ifExists(int) – to check whether a key already exists in the table,
- insert(int, int) – to insert the key into a position,
- increment_count(int) – to increment the count when a duplicate entry is found,
- isFree(int) – to check whether a position in hash table is free or not

1100 random numbers between 1 and 10,000(both included) are generated and stored in an array. Three UserHashTable objects is generated for size of 1223, one for each technique, and is used to hash the 1100 random values generated. Probe count is maintained for each technique. Whenever a position is probed in the table, the count gets incremented by 1. Finally, the output is generated which consists of probe count for each technique. The same process is repeated for hash tables of sizes 1831, 2447 and the outputs are generated.


## DAG : Determining acyclic graph

For determining the graph is a DAG, or not, the project uses the algorithm similar to the Depth First Search(DFS) technique. In this technique, the algorithm selects an arbitrary point in the graph and traverses the graph in depth ward motion, by storing the vertices encountered in a stack. It backtracks when there are no more vertices to go forward.

The project is implemented using Java8 and “eclipse oxygen” is used as the IDE. A Graph class is designed which stores the graph using as adjacency list and also stores the number of vertices of the graph. An ArrayList is used for storing the adjacency list. To keep track of any cycles, another ArrayList “cycle” is used. The class has the following public functions:
addEdge(int s, int e) – adds an edge from s to e to the graph.

- isDAG() – checks whether a graph is DAG or not. It calls a private helper function
- isDAGHelper() for implementing DFS algorithm
- topOrder() – prints a topological order for the DAG. It calls a private helper function, topOrderHelper().
- printCycle() – prints the cycle, if the graph is not a DAG.

The input of number of vertices and the adjacency matrix of the graph is read from the user, and the result, whether the input graph is a DAG or not, is printed. If the graph is a DAG, a topological order is printed or else, a cycle determined is printed.

