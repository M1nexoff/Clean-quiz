package com.example.cleanquiz.domain;

import android.content.SharedPreferences;

import com.example.cleanquiz.data.model.CategoryEnum;
import com.example.cleanquiz.data.model.QuestionData;
import com.example.cleanquiz.data.source.GameResultManager;
import com.example.cleanquiz.data.source.Pref;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppController {
    private static AppController instance;
    private CategoryEnum selectCategory;
    private Pref pref = Pref.getInstance();
    private GameResultManager gameResultManager = GameResultManager.getInstance();
    List<QuestionData> listQuestions = new ArrayList<>();
    private AppController(){}
    public static AppController getInstance() {
        if (instance == null)
            instance = new AppController();
        return instance;
    }
    public CategoryEnum getType(){
        return selectCategory;
    }
    public void setSelectCategory(CategoryEnum category) {
        this.selectCategory = category;
        loadQuestions();
    }

    public List<QuestionData> getQuestionByCategory() {
        Collections.shuffle(listQuestions);
        return listQuestions.subList(0, 10);
    }
    public boolean isOpen(CategoryEnum categoryEnum) {
        return pref.isOpen(categoryEnum);
    }

    public void setOpen(CategoryEnum categoryEnum) {
        pref.setOpen(categoryEnum);
    }
    private void loadQuestions() {
        listQuestions.clear();

        switch (selectCategory) {
            case KOTLIN:
                listQuestions.add(new QuestionData(
                        "What keyword is used to declare a variable in Kotlin?",
                        "var",
                        "val",
                        "const",
                        "let",
                        "var"));
                listQuestions.add(new QuestionData(
                        "Which of the following represents a nullable type in Kotlin?",
                        "Int",
                        "String",
                        "Double",
                        "String?",
                        "String?"));
                listQuestions.add(new QuestionData(
                        "What is the output of the following Kotlin code snippet?\n\nfun main() {\n    val x: Int? = null\n    println(x ?: 0)\n}",
                        "0",
                        "1",
                        "Null",
                        "Compilation error",
                        "0"));
                listQuestions.add(new QuestionData(
                        "What is the correct syntax for defining a function in Kotlin?",
                        "function add(a: Int, b: Int) { return a + b }",
                        "fun add(a: Int, b: Int): Int { return a + b }",
                        "def add(a: Int, b: Int): Int { return a + b }",
                        "fun add(a: Int, b: Int) -> Int { return a + b }",
                        "fun add(a: Int, b: Int): Int { return a + b }"));
                listQuestions.add(new QuestionData(
                        "What is the purpose of the \"let\" function in Kotlin?",
                        "To declare a constant variable",
                        "To perform a null-safe operation",
                        "To define an extension function",
                        "To execute a block of code on a nullable object",
                        "To execute a block of code on a nullable object"));
                listQuestions.add(new QuestionData(
                        "Which of the following is the correct way to declare a nullable type in Kotlin?",
                        "String?",
                        "String",
                        "String!",
                        "String??",
                        "String?"));
                listQuestions.add(new QuestionData(
                        "What is the purpose of the \"apply\" function in Kotlin?",
                        "To execute a block of code on a nullable object",
                        "To initialize the properties of an object",
                        "To define an extension function",
                        "To perform a null-safe operation",
                        "To initialize the properties of an object"));
                listQuestions.add(new QuestionData(
                        "What is the output of the following Kotlin code snippet?\n\nfun main() {\n    val x: String? = null\n    println(x ?: \"Hello\")\n}",
                        "null",
                        "Hello",
                        "Compilation error",
                        "Runtime error",
                        "Hello"));
                listQuestions.add(new QuestionData(
                        "What is the correct syntax for a lambda expression in Kotlin?",
                        "{ (a, b) -> a + b }",
                        "{ a, b -> a + b }",
                        "{ (a: Int, b: Int) -> a + b }",
                        "{ Int a, Int b -> a + b }",
                        "{ (a, b) -> a + b }"));
                listQuestions.add(new QuestionData(
                        "What is the purpose of the \"with\" function in Kotlin?",
                        "To execute a block of code on a nullable object",
                        "To initialize the properties of an object",
                        "To define an extension function",
                        "To perform a null-safe operation",
                        "To initialize the properties of an object"));
                break;
            case CPP:
                listQuestions.add(new QuestionData(
                        "What is the correct syntax for declaring a variable in C++?",
                        "var x;",
                        "variable x;",
                        "int x;",
                        "x = int;",
                        "int x;"));
                listQuestions.add(new QuestionData(
                        "How do you initialize an array in C++ with 5 elements of value 0?",
                        "int arr[5] = {0};",
                        "int arr[] = {0, 0, 0, 0, 0};",
                        "int arr[5] = {1};",
                        "int arr[5] = 0;",
                        "int arr[5] = {0};"));
                listQuestions.add(new QuestionData(
                        "What does the 'cin' object in C++ handle?",
                        "File operations",
                        "Error handling",
                        "Output",
                        "Input",
                        "Input"));
                listQuestions.add(new QuestionData(
                        "Which C++ keyword is used to dynamically allocate memory?",
                        "alloc",
                        "malloc",
                        "new",
                        "allocate",
                        "new"));
                listQuestions.add(new QuestionData(
                        "What is the purpose of the 'break' statement in a switch statement?",
                        "Terminate the program",
                        "Skip the next iteration",
                        "Exit the loop",
                        "Exit the switch statement",
                        "Exit the switch statement"));
                listQuestions.add(new QuestionData(
                        "How is a reference variable declared in C++?",
                        "int &x = y;",
                        "ref int x = y;",
                        "ref x = y;",
                        "int *x = & y;",
                        "int &x = y;"));
                listQuestions.add(new QuestionData(
                        "What is the output of the following code snippet?\n\nint x = 5;\ncout << ++x + x++ >>",
                        "11",
                        "12",
                        "13",
                        "14",
                        "13"));
                listQuestions.add(new QuestionData(
                        "In C++, how do you open a file named \"example.txt\" for writing?",
                        "ofstream file(\"example.txt\");",
                        "file.open(\"example.txt\");",
                        "file.open(\"example.txt\", \"w\");",
                        "ifstream file(\"example.txt\");",
                        "ofstream file(\"example.txt\");"));
                listQuestions.add(new QuestionData(
                        "What is the purpose of the 'const' keyword in C++?",
                        "Declare a variable with a constant value",
                        "Declare a constant variable",
                        "Specify a constant class",
                        "Create a constant function",
                        "Declare a constant variable"));
                listQuestions.add(new QuestionData(
                        "Which C++ loop is guaranteed to execute at least once?",
                        "for loop",
                        "while loop",
                        "do-while loop",
                        "switch loop",
                        "do-while loop"));
                break;
            case JAVA:
                listQuestions.add(new QuestionData(
                        "What is the correct syntax for declaring a variable in Java?",
                        "var x;",
                        "variable x;",
                        "int x;",
                        "x = int;",
                        "int x;"));

                listQuestions.add(new QuestionData(
                        "Which keyword is used to define a constant in Java?",
                        "const",
                        "final",
                        "static",
                        "immutable",
                        "final"));

                listQuestions.add(new QuestionData(
                        "What is the output of the following code snippet?\n\nString str1 = \"Hello\";\nString str2 = new String(\"Hello\");\nSystem.out.println(str1 == str2);",
                        "true",
                        "false",
                        "null",
                        "Compilation Error",
                        "false"));

                listQuestions.add(new QuestionData(
                        "What is the purpose of the 'super' keyword in Java?",
                        "To call superclass constructor",
                        "To access superclass members",
                        "To create subclass",
                        "To access subclass members",
                        "To access superclass members"));

                listQuestions.add(new QuestionData(
                        "Which of the following is not a Java primitive data type?",
                        "int",
                        "float",
                        "char",
                        "string",
                        "string"));

                listQuestions.add(new QuestionData(
                        "What is the result of 10 % 3 in Java?",
                        "0",
                        "1",
                        "2",
                        "3",
                        "1"));

                listQuestions.add(new QuestionData(
                        "What is the default value of an instance variable in Java?",
                        "null",
                        "0",
                        "false",
                        "Depends on the data type",
                        "Depends on the data type"));

                listQuestions.add(new QuestionData(
                        "What is the correct syntax for creating an array in Java?",
                        "int[] arr = new int[];",
                        "int arr[] = new int();",
                        "int arr[];",
                        "int arr[] = new int[5];",
                        "int arr[] = new int[5];"));

                listQuestions.add(new QuestionData(
                        "What is the purpose of the 'this' keyword in Java?",
                        "To refer to current object",
                        "To refer to parent class object",
                        "To refer to child class object",
                        "To create a new object",
                        "To refer to current object"));

                listQuestions.add(new QuestionData(
                        "Which collection class allows null values in Java?",
                        "ArrayList",
                        "HashSet",
                        "TreeMap",
                        "HashMap",
                        "HashMap"));
                break;
            case PHP:
                // PHP Question 1
                listQuestions.add(new QuestionData(
                        "What does PHP stand for?",
                        "Personal Home Page",
                        "PHP: Hypertext Preprocessor",
                        "Private Hyperlink Processor",
                        "Practical Hypertext Parser",
                        "PHP: Hypertext Preprocessor"));

                // PHP Question 2
                listQuestions.add(new QuestionData(
                        "Which of the following is a correct way to start a PHP script?",
                        "<?php echo \"Hello World\"; ?>",
                        "<?php echo \"Hello World\"; ?>",
                        "<? echo \"Hello World\"; ?<",
                        "<? echo \"Hello World\"; ?<",
                        "<?php echo \"Hello World\"; ?>"));

                // PHP Question 3
                listQuestions.add(new QuestionData(
                        "What does the PHP function 'strlen()' do?",
                        "Converts a string to lowercase",
                        "Calculates the length of a string",
                        "Converts a string to uppercase",
                        "Returns the substring of a string",
                        "Calculates the length of a string"));

                // PHP Question 4
                listQuestions.add(new QuestionData(
                        "How do you define a constant in PHP?",
                        "define($constant_name, $value);",
                        "const $constant_name = $value;",
                        "constant($constant_name, $value);",
                        "define($value, $constant_name);",
                        "define($constant_name, $value);"));

                // PHP Question 5
                listQuestions.add(new QuestionData(
                        "Which of the following is the correct way to comment out a single line in PHP?",
                        "// This is a comment",
                        "# This is a comment",
                        "/* This is a comment */",
                        "/** This is a comment */",
                        "// This is a comment"));

                // PHP Question 6
                listQuestions.add(new QuestionData(
                        "What is the correct way to start a PHP block?",
                        "<?php",
                        "<script>",
                        "<?php_block>",
                        "<php>",
                        "<?php"));

                // PHP Question 7
                listQuestions.add(new QuestionData(
                        "How do you concatenate two strings in PHP?",
                        "$str1 . $str2;",
                        "$str1 && $str2;",
                        "$str1 + $str2;",
                        "$str1 .+ $str2;",
                        "$str1 . $str2;"));

                // PHP Question 8
                listQuestions.add(new QuestionData(
                        "What is the purpose of the PHP function 'isset()'?",
                        "Checks if a variable is empty",
                        "Checks if a variable is set and is not NULL",
                        "Checks if a variable is set and is empty",
                        "Checks if a variable exists in the current scope",
                        "Checks if a variable is set and is not NULL"));

                // PHP Question 9
                listQuestions.add(new QuestionData(
                        "What does PHP_EOL represent in PHP?",
                        "End Of Line",
                        "End Of List",
                        "End Of Loop",
                        "End Of Link",
                        "End Of Line"));

                // PHP Question 10
                listQuestions.add(new QuestionData(
                        "Which of the following is used to access a specific element of an array in PHP?",
                        "$array{index}",
                        "$array[index]",
                        "$array(index)",
                        "$array.index",
                        "$array[index]"));
                break;
            case GO:
                listQuestions.add(new QuestionData(
                        "Which keyword is used to declare a variable in Go?",
                        "var",
                        "let",
                        "const",
                        "make",
                        "var"));
                listQuestions.add(new QuestionData(
                        "What does the 'defer' keyword do in Go?",
                        "Delays the execution of a function until the surrounding function returns",
                        "Creates a pointer to a function",
                        "Defines a constant value",
                        "Allocates memory for a new variable",
                        "Delays the execution of a function until the surrounding function returns"));
                listQuestions.add(new QuestionData(
                        "What is the output of the following Go code snippet?\n\nfunc main() {\n    x := 5\n    fmt.Println(x)\n}",
                        "5",
                        "x",
                        "nil",
                        "Compilation error",
                        "5"));
                listQuestions.add(new QuestionData(
                        "What is the correct syntax for a function declaration in Go?",
                        "func add(a, b int) int { return a + b }",
                        "function add(a, b int) { return a + b }",
                        "def add(a int, b int) { return a + b }",
                        "func add(a, b int) { return a + b }",
                        "func add(a, b int) int { return a + b }"));
                listQuestions.add(new QuestionData(
                        "Which of the following is NOT a basic data type in Go?",
                        "Float",
                        "Int",
                        "String",
                        "Bool",
                        "Float"));
                listQuestions.add(new QuestionData(
                        "What does the 'range' keyword do in Go?",
                        "Iterates over elements in a variety of data structures",
                        "Defines a constant value",
                        "Specifies the size of an array",
                        "Creates a slice",
                        "Iterates over elements in a variety of data structures"));
                listQuestions.add(new QuestionData(
                        "What is the purpose of the 'make' function in Go?",
                        "Allocates memory for slices, maps, and channels",
                        "Performs arithmetic operations",
                        "Defines an anonymous function",
                        "Initializes a variable",
                        "Allocates memory for slices, maps, and channels"));
                listQuestions.add(new QuestionData(
                        "What is the output of the following Go code snippet?\n\nfunc main() {\n    var x *int\n    fmt.Println(x)\n}",
                        "nil",
                        "0",
                        "Error",
                        "Compilation error",
                        "nil"));
                listQuestions.add(new QuestionData(
                        "What is the correct way to declare a constant in Go?",
                        "const pi = 3.14",
                        "constant pi = 3.14",
                        "let pi = 3.14",
                        "define pi = 3.14",
                        "const pi = 3.14"));
                listQuestions.add(new QuestionData(
                        "What does the 'panic' function do in Go?",
                        "Causes the program to stop immediately and print a stack trace",
                        "Resumes execution after a deferred function call",
                        "Prints a message to the console",
                        "Halts the program and returns an error",
                        "Causes the program to stop immediately and print a stack trace"));
                break;
            case RUST:
                listQuestions.add(new QuestionData(
                        "What keyword is used to declare a variable in Rust?",
                        "let",
                        "var",
                        "const",
                        "def",
                        "let"));
                listQuestions.add(new QuestionData(
                        "What does the 'mut' keyword do in Rust?",
                        "Allows a variable to be mutable",
                        "Defines a constant value",
                        "Creates a pointer to a function",
                        "Allocates memory for a new variable",
                        "Allows a variable to be mutable"));
                listQuestions.add(new QuestionData(
                        "What is the output of the following Rust code snippet?\n\nfn main() {\n    let x = 5;\n    println!(\"{}\", x);\n}",
                        "5",
                        "x",
                        "nil",
                        "Compilation error",
                        "5"));
                listQuestions.add(new QuestionData(
                        "What is the correct syntax for a function declaration in Rust?",
                        "fn add(a: i32, b: i32) -> i32 { return a + b }",
                        "function add(a: i32, b: i32) -> i32 { return a + b }",
                        "def add(a: i32, b: i32) -> i32 { return a + b }",
                        "fn add(a, b: i32) -> i32 { return a + b }",
                        "fn add(a: i32, b: i32) -> i32 { return a + b }"));
                listQuestions.add(new QuestionData(
                        "Which of the following is NOT a basic data type in Rust?",
                        "Float",
                        "Int",
                        "String",
                        "Bool",
                        "Float"));
                listQuestions.add(new QuestionData(
                        "What does the 'match' keyword do in Rust?",
                        "Provides pattern matching for control flow",
                        "Defines a constant value",
                        "Specifies the size of an array",
                        "Creates a slice",
                        "Provides pattern matching for control flow"));
                listQuestions.add(new QuestionData(
                        "What is the purpose of the 'Vec' type in Rust?",
                        "Represents a growable array",
                        "Performs arithmetic operations",
                        "Defines an anonymous function",
                        "Initializes a variable",
                        "Represents a growable array"));
                listQuestions.add(new QuestionData(
                        "What is the output of the following Rust code snippet?\n\nfn main() {\n    let x: Option<i32> = None;\n    println!(\"{}\", x.unwrap_or(0));\n}",
                        "0",
                        "1",
                        "None",
                        "Compilation error",
                        "0"));
                listQuestions.add(new QuestionData(
                        "What is the correct syntax for a tuple in Rust?",
                        "(1, 'hello', true)",
                        "[1, 'hello', true]",
                        "{1, 'hello', true}",
                        "<1, 'hello', true>",
                        "(1, 'hello', true)"));
                listQuestions.add(new QuestionData(
                        "What does the 'unwrap' method do in Rust?",
                        "Attempts to extract the value from a 'Result' or 'Option', panicking if the value is 'None' or 'Err'",
                        "Creates a new instance of a 'Result' type",
                        "Prints a message to the console",
                        "Halts the program and returns an error",
                        "Attempts to extract the value from a 'Result' or 'Option', panicking if the value is 'None' or 'Err'"));
                break;
            case JAVASCRIPT:
                listQuestions.add(new QuestionData(
                        "Which keyword is used to declare a variable in JavaScript?",
                        "var",
                        "let",
                        "const",
                        "def",
                        "var"));
                listQuestions.add(new QuestionData(
                        "What does the 'let' keyword do in JavaScript?",
                        "Declares a block-scoped variable",
                        "Defines a constant value",
                        "Creates a pointer to a function",
                        "Allocates memory for a new variable",
                        "Declares a block-scoped variable"));
                listQuestions.add(new QuestionData(
                        "What is the output of the following JavaScript code snippet?\n\nlet x = 5;\nconsole.log(x);",
                        "5",
                        "x",
                        "nil",
                        "Compilation error",
                        "5"));
                listQuestions.add(new QuestionData(
                        "What is the correct syntax for a function declaration in JavaScript?",
                        "function add(a, b) { return a + b }",
                        "func add(a, b) { return a + b }",
                        "def add(a, b) { return a + b }",
                        "fn add(a, b) { return a + b }",
                        "function add(a, b) { return a + b }"));
                listQuestions.add(new QuestionData(
                        "Which of the following is NOT a basic data type in JavaScript?",
                        "Float",
                        "Int",
                        "String",
                        "Bool",
                        "Float"));
                listQuestions.add(new QuestionData(
                        "What does the 'typeof' operator do in JavaScript?",
                        "Returns the data type of a variable or expression",
                        "Defines a constant value",
                        "Specifies the size of an array",
                        "Creates a slice",
                        "Returns the data type of a variable or expression"));
                listQuestions.add(new QuestionData(
                        "What is the purpose of the 'Array' object in JavaScript?",
                        "Represents a list of elements",
                        "Performs arithmetic operations",
                        "Defines an anonymous function",
                        "Initializes a variable",
                        "Represents a list of elements"));
                listQuestions.add(new QuestionData(
                        "What is the output of the following JavaScript code snippet?\n\nlet x = null;\nconsole.log(x ?? 0);",
                        "0",
                        "1",
                        "null",
                        "Compilation error",
                        "0"));
                listQuestions.add(new QuestionData(
                        "What is the correct way to declare a constant in JavaScript?",
                        "const pi = 3.14",
                        "let pi = 3.14",
                        "var pi = 3.14",
                        "define pi = 3.14",
                        "const pi = 3.14"));
                listQuestions.add(new QuestionData(
                        "What does the 'NaN' value represent in JavaScript?",
                        "Not a Number",
                        "Null",
                        "Undefined",
                        "Negative Infinity",
                        "Not a Number"));
                break;

        }
    }
}

