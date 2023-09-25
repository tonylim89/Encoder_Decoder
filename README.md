# Encoder-Decoder Utility Walkthrough

Welcome to the detailed walkthrough of the Encoder-Decoder utility. This guide will take you through the core functionalities, design decisions, and the tests implemented to ensure the robustness of this application.

## Introduction

The Encoder-Decoder utility is designed to obfuscate plaintext using a specified character offset, offering bi-directional transformation. It's a demonstration of encoding and decoding logic with an emphasis on object-oriented principles and comprehensive testing.

## Design Decisions

### 1. Reference Table

The heart of the Encoder-Decoder is the 5ReferenceTable5 class, which consists of:

```
final String table = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
```

Any character not present in the reference table is mapped back to itself during encoding or decoding.

### 2. Dynamic Offset Character
The concept of a dynamic offset character was introduced to make encoding flexible. For example, given an offset character of 'B', the table shifts down by one character, making A encode to B, B to C, and so on.

### 3. Encoding & Decoding

In the `Encoder` class, there's two main methods:

```
public String encode(String plainText, char offsetChar); 
public String decode(String encodedText);
```

- The `encode` method takes a plain text and an offset character as inputs and returns the encoded string.
- The `decode` method takes an encoded string and returns the original string.

## Testing - JUnit

To ensure the Encoder-Decoder utility works consistently and reliably, comprehensive tests using JUnit was implemented.

### Setup

The Encoder is re-initialized before each test to ensure a fresh instance:

```
@BeforeEach 
public void setup() { 
    encoder = new Encoder(); 
}
```

### Unit Tests

- **Basic Tests:** Perform some basic tests to validate standard encoding and decoding with known strings like "HELLO WORLD".

- **Randomized Testing:** To further ensure the utility's integrity across diverse input scenarios, randomized tests was introduced. In these tests, a random string is generated along with a random valid offset character, and the utility's ability to revert encoded text back to its original form is checked.

This approach ensures that our Encoder-Decoder utility stands robust across a wide range of unpredictable inputs.
