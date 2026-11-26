# DSA-A6 — Java Algorithms & Object-Oriented Programming

A Java coursework repository covering data structures and algorithms (DSA), advanced object-oriented programming (AOOP), and laboratory debugging exercises.

## Coursework areas

| Directory | Focus |
| --- | --- |
| [DSA](DSA/) | Dynamic programming, pattern matching and network flow |
| [AOOP](AOOP/) | Object-oriented programming practice and lab exercises |
| [AOOP-093](AOOP-093/) | Additional Java laboratory debugging exercises |

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

## Object-oriented programming

- [CO1 practice](AOOP/CO1/): BankAcc, Employee, Library, Product and Student examples.
- [AOOP lab](AOOP/LAB/): SmartWayPoint.java.
- [AOOP-093 lab L01](AOOP-093/LAB/L01/): Bug1.java and Bug2.java debugging exercises.

## From coursework to application

This repository remains the home of the Java coursework and its learning history. Selected ideas from the dynamic-programming and text-matching work have also informed a separate practical project: [DBMS_LMS](https://github.com/luffy-loop/DBMS_LMS), a full-stack Learning Management System with an AI-assisted answer-grading engine.

In particular, the LMS contains a Python token-level sequence-alignment heuristic inspired by the general idea of sequence alignment. It supplements lexical and semantic evidence to help recognize equivalent phrasing in student answers. It is an adaptation, not a direct import or line-for-line port of the Java code.

See [Real-World Applications](DSA/docs/real-world-applications.md) for the mapping between coursework concepts and the LMS, implementation links, and reliability boundaries.

## Repository structure

```text
DSA-A6/
├── DSA/
│   ├── docs/
│   └── src/texthack/
│       ├── dynamicprogramming/
│       ├── networkflow/
│       └── patternmatching/
├── AOOP/
│   ├── CO1/
│   └── LAB/
├── AOOP-093/
│   └── LAB/L01/
└── README.md
```

## Running

This is a Java source repository. Open it in an IDE such as IntelliJ IDEA, compile the relevant source file, and run the class or method for the algorithm you want to explore. Some classes expose methods rather than standalone `main` methods, so they may need a small driver class to try sample inputs.

## Related project

- **Applied project:** [DBMS_LMS](https://github.com/luffy-loop/DBMS_LMS)
- **Integration implementation:** [evaluation_service.py](https://github.com/luffy-loop/DBMS_LMS/blob/main/LMS/backend/evaluation_service.py)
- **Integration notes:** [DSA algorithm integration in DBMS_LMS](https://github.com/luffy-loop/DBMS_LMS/blob/main/docs/dsa-algorithm-integration.md)

The repositories intentionally remain separate: this repository preserves the algorithm coursework, while DBMS_LMS contains the application code, integration tests, and grading workflow.
