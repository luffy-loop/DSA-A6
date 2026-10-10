# Real-World Applications of the DSA Coursework

This document connects selected algorithms in this repository to practical problem-solving. It distinguishes algorithms implemented here from adaptations or future ideas in the separate LMS project.

## 1. Sequence alignment and answer comparison

### Coursework sources
- [NeedlemanWunsch.java](../src/texthack/dynamicprogramming/NeedlemanWunsch.java) — global alignment using dynamic programming.
- [SmithWaterman.java](../src/texthack/dynamicprogramming/SmithWaterman.java) — local alignment using dynamic programming.

### Application: AI-assisted grading in DBMS_LMS
[DBMS_LMS](https://github.com/luffy-loop/DBMS_LMS) is a full-stack Learning Management System. Its answer-evaluation service includes a Python helper, `calculate_sequence_alignment_score(student_answer, reference_answer)`, which tokenizes answers, normalizes selected phrases, recognizes a limited set of equivalent terms, and computes a bounded alignment/overlap score using dynamic programming.

- [LMS evaluation service](https://github.com/luffy-loop/DBMS_LMS/blob/main/LMS/backend/evaluation_service.py)
- [Integration tests](https://github.com/luffy-loop/DBMS_LMS/blob/main/LMS/backend/tests/test_answer_similarity_scoring.py)
- [LMS integration design notes](https://github.com/luffy-loop/DBMS_LMS/blob/main/docs/dsa-algorithm-integration.md)

**Important implementation distinction:** the LMS helper is a Python, token-level heuristic inspired by sequence-alignment ideas. It is not the Java implementation copied into the LMS, and it is not claimed to be a full affine-gap Needleman–Wunsch or Smith–Waterman implementation. The Java examples here align characters; the LMS helper compares normalized tokens.

### Why it can help
A student may correctly explain a concept with different wording from the reference answer. Text alignment can provide evidence that meaningful parts overlap even when the exact phrasing differs. In the LMS it is only one signal alongside lexical and semantic evidence.

### Reliability boundaries
Sequence overlap is not the same as factual correctness. A response can reuse relevant terms while being wrong, and a correct response can use unfamiliar terminology. Contradiction checks, rubric quality, representative tests, and teacher review remain important. The LMS integration has regression tests for a deadlock paraphrase, unrelated text, bounded scores, and empty inputs, but these tests do not establish university-wide grading reliability.

## 2. Edit distance and text variation

### Coursework source
[EditDistance.java](../src/texthack/dynamicprogramming/EditDistance.java) calculates the minimum number of insertions, deletions, and replacements needed to transform one string into another.

### Practical uses
- Approximate string matching and typo detection.
- Comparing identifiers or short text fields with small spelling variations.
- Supporting search suggestions or data-cleaning workflows.

Edit distance is not currently described as part of the LMS grading score. It could be evaluated as a separate, carefully weighted signal for spelling variation in a future change, with tests to ensure it does not reward conceptually incorrect answers.

## 3. Pattern matching and search

### Coursework sources
[KMP.java](../src/texthack/patternmatching/KMP.java), [RabinKarp.java](../src/texthack/patternmatching/RabinKarp.java), [ZFunction.java](../src/texthack/patternmatching/ZFunction.java), and [SuffixArrayLCP.java](../src/texthack/patternmatching/SuffixArrayLCP.java).

### Practical uses
These algorithms illustrate exact or structured text matching, substring search, repeated-pattern discovery, and string preprocessing. They are useful foundations for search utilities and text-processing systems. They are not currently claimed as components of the LMS grading engine.

## 4. Network flow and optimization

### Coursework sources
[FordFulkerson.java](../src/texthack/networkflow/FordFulkerson.java) and [EdmondsKarp.java](../src/texthack/networkflow/EdmondsKarp.java).

### Practical uses
Maximum-flow algorithms model capacity-constrained movement through networks, such as routing, allocation, and flow optimization. They are part of the coursework repository and are not currently integrated into DBMS_LMS.

## Repository relationship

```text
DSA-A6 (Java coursework)
    |
    | algorithm study and concepts
    v
DBMS_LMS (separate full-stack application)
    |
    +-- Python token-level sequence-alignment heuristic
    +-- lexical and semantic grading evidence
    +-- regression tests and teacher-review safeguards
```

The repositories stay independent so the coursework history remains visible and the application retains its own code, tests, and release process.
