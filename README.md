# DSA-A6 — Data Structures and Algorithms

A Java repository of algorithm implementations developed as part of my DSA learning journey. The code covers dynamic programming, pattern matching, and network-flow algorithms.

## Topics

### Dynamic programming
- **Edit Distance** — minimum insertions, deletions, and replacements required to transform one string into another.
- **Needleman–Wunsch** — global sequence alignment with match, mismatch, and gap scores.
- **Smith–Waterman** — local sequence alignment for finding a high-scoring matching region.
- **Interval DP** and **TSP** — additional dynamic-programming problems.

### Pattern matching
- **KMP**, **Rabin–Karp**, **Z-function**, **Suffix Array + LCP**, and naive/multi-pattern matching.

### Network flow
- **Ford–Fulkerson** and **Edmonds–Karp** maximum-flow algorithms.

## From coursework to application

This repository remains the home of the Java coursework and its learning history. Selected ideas from the dynamic-programming and text-matching work have also informed a separate practical project: [DBMS_LMS](https://github.com/luffy-loop/DBMS_LMS), a full-stack Learning Management System with an AI-assisted answer-grading engine.

In particular, the LMS contains a Python token-level sequence-alignment heuristic inspired by the general idea of sequence alignment. It supplements lexical and semantic evidence to help recognize equivalent phrasing in student answers. It is an adaptation, not a direct import or line-for-line port of the Java code.

See [Real-World Applications](docs/real-world-applications.md) for the mapping between coursework concepts and the LMS, implementation links, and reliability boundaries.

## Repository structure

```text
src/
└── texthack/
    ├── dynamicprogramming/
    │   ├── EditDistance.java
    │   ├── IntervalDP.java
    │   ├── NeedlemanWunsch.java
    │   ├── SmithWaterman.java
    │   └── TSP.java
    ├── networkflow/
    │   ├── EdmondsKarp.java
    │   └── FordFulkerson.java
    └── patternmatching/
        ├── KMP.java
        ├── MultiPatternMatching.java
        ├── Naive.java
        ├── RabinKarp.java
        ├── SuffixArrayLCP.java
        └── ZFunction.java
```

## Running

This is a Java source repository. Open it in an IDE such as IntelliJ IDEA, compile the relevant source file, and run the class or method for the algorithm you want to explore. Some classes expose methods rather than standalone `main` methods, so they may need a small driver class to try sample inputs.

## Related project

- **Applied project:** [DBMS_LMS](https://github.com/luffy-loop/DBMS_LMS)
- **Integration implementation:** [evaluation_service.py](https://github.com/luffy-loop/DBMS_LMS/blob/main/LMS/backend/evaluation_service.py)
- **Integration notes:** [DSA algorithm integration in DBMS_LMS](https://github.com/luffy-loop/DBMS_LMS/blob/main/docs/dsa-algorithm-integration.md)

The repositories intentionally remain separate: this repository preserves the algorithm coursework, while DBMS_LMS contains the application code, integration tests, and grading workflow.
