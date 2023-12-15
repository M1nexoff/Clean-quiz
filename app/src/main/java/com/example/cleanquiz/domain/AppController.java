package com.example.cleanquiz.domain;

import com.example.cleanquiz.data.model.CategoryEnum;
import com.example.cleanquiz.data.model.QuestionData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppController {
    private static AppController instance;
    private CategoryEnum selectCategory;
    List<QuestionData> listQuestions = new ArrayList<QuestionData>();
    private AppController(){}
    public static AppController getInstance() {
        if (instance == null)
            instance = new AppController();
        return instance;
    }

    public void setSelectCategory(CategoryEnum category) {
        this.selectCategory = category;
        loadQuestions();
    }
    public List<QuestionData> getQuestionByCategory() {
        Collections.shuffle(listQuestions);
        return listQuestions.subList(0, 10);
    }
    private void loadQuestions() {
        listQuestions.clear();
        switch (selectCategory) {
            case INTRODUCTION:
                listQuestions.add(new QuestionData("What is the syntax for a single-line comment in Java?",
                        "//comment",
                        "\\comment",
                        "==comment",
                        "/comment",
                        "//comment"));
                listQuestions.add(new QuestionData("What is the output of the following code?\nint x = 5;\nSystem.out.println(x++);\nSystem.out.println(++x);",
                        "6, 5",
                        "6, 6",
                        "5, 5",
                        "5, 7",
                        "5, 7"));

                listQuestions.add(new QuestionData("Which keyword is used to define a constant variable in Java?",
                        "final",
                        "const",
                        "static",
                        "1-3",
                        "1-3"));

                listQuestions.add(new QuestionData("What is the purpose of the 'this' keyword in Java?",
                        "It refers to the current instance of the class and is used to differentiate between instance variables and local variables with the same name.",
                        "It is used to define methods in a class.",
                        "It is used to declare variables in a class.",
                        "It is used for exception handling.",
                        "It refers to the current instance of the class and is used to differentiate between instance variables and local variables with the same name."));

                listQuestions.add(new QuestionData("What is the difference between '==' and '.equals()' in Java?",
                        "'==' compares the values of two objects, while '.equals()' compares the references.",
                        "'==' compares the references of two objects, while '.equals()' compares the values.",
                        "'==' is used for arithmetic operations, while '.equals()' is used for string comparison.",
                        "'==' and '.equals()' are the same and can be used interchangeably.",
                        "'==' compares the references of two objects, while '.equals()' compares the values."));

                listQuestions.add(new QuestionData("Which data type is used to store whole numbers in Java?",
                        "float",
                        "double",
                        "int",
                        "char",
                        "int"));

                listQuestions.add(new QuestionData("What is the output of the following code?\nString str = 'Hello';\nSystem.out.println(str.length());",
                        "5",
                        "6",
                        "4",
                        "Error",
                        "5"));

                listQuestions.add(new QuestionData("What is the purpose of the 'break' statement in a switch statement?",
                        "It skips the current iteration of a loop and continues with the next iteration.",
                        "It exits the current method and returns a value.",
                        "It terminates the switch statement and transfers control to the next statement.",
                        "It throws an exception and transfers control to the catch block.",
                        "It terminates the switch statement and transfers control to the next statement."));

                listQuestions.add(new QuestionData("What is the difference between a class and an object in Java?",
                        "A class is a collection of objects, while an object is a collection of classes.",
                        "A class is a blueprint for creating objects, while an object is an instance of a class.",
                        "A class is used to define variables, while an object is used to define methods.",
                        "A class is a reserved keyword, while an object is a user-defined keyword.",
                        "A class is a blueprint for creating objects, while an object is an instance of a class."));

                listQuestions.add(new QuestionData("What is the purpose of the 'main' method in Java?",
                        "It is used to declare variables.",
                        "It is used to define classes.",
                        "It is the entry point of a Java program.",
                        "It is used for exception handling.",
                        "It is the entry point of a Java program."));
                break;
            case TYPE:
                listQuestions.add(new QuestionData("What is the output of the following code?\nint num = 10;\nSystem.out.println(num % 3);",
                        "0",
                        "1",
                        "3",
                        "10 % 3",
                        "1"));

                listQuestions.add(new QuestionData("Which operator is used to concatenate strings in Java?",
                        "&",
                        "+",
                        "-",
                        "*",
                        "+"));

                listQuestions.add(new QuestionData("What is the purpose of the 'continue' statement in a loop?",
                        "It exits the loop completely and continues with the next iteration of the outer loop.",
                        "It skips the current iteration of the loop and continues with the next iteration.",
                        "It terminates the loop and transfers control to the next statement.",
                        "It throws an exception and transfers control to the catch block.",
                        "It skips the current iteration of the loop and continues with the next iteration."));

                listQuestions.add(new QuestionData("Which data type is used to store true/false values in Java?",
                        "boolean",
                        "byte",
                        "short",
                        "long",
                        "boolean"));

                listQuestions.add(new QuestionData("What is the output of the following code?\nint x = 4;\nint y = 2;\nSystem.out.println(x / y);",
                        "2",
                        "4",
                        "0",
                        "2.0",
                        "2"));

                listQuestions.add(new QuestionData("What is the purpose of the 'finally' block in exception handling?",
                        "It is used to define variables.",
                        "It is used to define classes.",
                        "It always executes whether an exception is thrown or not.",
                        "It is used for exception handling.",
                        "It always executes whether an exception is thrown or not."));

                listQuestions.add(new QuestionData("Which loop is guaranteed to execute at least once in Java?",
                        "for loop",
                        "while loop",
                        "do-while loop",
                        "if statement",
                        "do-while loop"));

                listQuestions.add(new QuestionData("Which keyword is used to prevent a class from being inherited in Java?",
                        "private",
                        "static",
                        "final",
                        "protected",
                        "final"));

                listQuestions.add(new QuestionData("What is the output of the following code?\nint[] arr = {1, 2, 3};\nSystem.out.println(arr[3]);",
                        "1",
                        "2",
                        "3",
                        "ArrayIndexOutOfBoundsException",
                        "ArrayIndexOutOfBoundsException"));

                listQuestions.add(new QuestionData("What is the purpose of the 'super' keyword in Java?",
                        "It refers to the current instance of the class and is used to differentiate between instance variables and local variables with the same name.",
                        "It is used to invoke the superclass constructor or method.",
                        "It is used to declare variables in a class.",
                        "It is used for exception handling.",
                        "It is used to invoke the superclass constructor or method."));
                break;
            case STRING:
                listQuestions.add(new QuestionData("What is the length() method used for in Java?",
                        "To convert a string to uppercase.",
                        "To return the number of characters in a string.",
                        "To concatenate two strings.",
                        "To check if a string contains a specific character.",
                        "To return the number of characters in a string."));

                listQuestions.add(new QuestionData("What is the output of the following code?\nString str = \"Hello World\";\nSystem.out.println(str.charAt(4));",
                        "H",
                        "W",
                        "o",
                        "r",
                        "o"));

                listQuestions.add(new QuestionData("Which method is used to compare two strings for equality in Java?",
                        "equals()",
                        "compareTo()",
                        "contains()",
                        "startsWith()",
                        "equals()"));

                listQuestions.add(new QuestionData("What is the output of the following code?\nString str = \"Hello\";\nSystem.out.println(str.substring(2));",
                        "lo",
                        "l",
                        "Hello",
                        "H",
                        "lo"));

                listQuestions.add(new QuestionData("Which method is used to convert a string to lowercase in Java?",
                        "toLower()",
                        "toLowerCase()",
                        "convertToLower()",
                        "toLowerCaseString()",
                        "toLowerCase()"));

                listQuestions.add(new QuestionData("What is the purpose of the trim() method in Java?",
                        "To remove the last character of a string.",
                        "To remove leading and trailing spaces from a string.",
                        "To replace all occurrences of a substring in a string.",
                        "To split a string into an array of substrings.",
                        "To remove leading and trailing spaces from a string."));

                listQuestions.add(new QuestionData("What is the output of the following code?\nString str = \"Hello\";\nSystem.out.println(str.indexOf('e'));",
                        "0",
                        "1",
                        "2",
                        "4",
                        "2"));

                listQuestions.add(new QuestionData("Which method is used to concatenate two strings in Java?",
                        "concat()",
                        "append()",
                        "join()",
                        "merge()",
                        "concat()"));

                listQuestions.add(new QuestionData("What is the output of the following code?\nString str = \"Hello World\";\nSystem.out.println(str.replace('o', 'a'));",
                        "Hello Warld",
                        "Hella World",
                        "Hello World",
                        "Hella Warld",
                        "Hella World"));

                listQuestions.add(new QuestionData("Which method is used to split a string into an array of substrings based on a delimiter in Java?",
                        "split()",
                        "slice()",
                        "substring()",
                        "divide()",
                        "split()"));
                break;
            case ARRAY:
                listQuestions.add(new QuestionData("What is the syntax to declare an array in Java?",
                        "int[] arrayName;",
                        "arrayName[] int;",
                        "arrayName = int[];",
                        "int arrayName[];",
                        "int[] arrayName;"));

                listQuestions.add(new QuestionData("What is the output of the following code?\nint[] numbers = {1, 2, 3};\nSystem.out.println(numbers.length);",
                        "0",
                        "1",
                        "2",
                        "3",
                        "3"));

                listQuestions.add(new QuestionData("Which method is used to access an element in an array at a specific index in Java?",
                        "get()",
                        "access()",
                        "retrieve()",
                        "None of the above",
                        "None of the above"));

                listQuestions.add(new QuestionData("What is the output of the following code?\nint[] numbers = new int[5];\nSystem.out.println(numbers[2]);",
                        "0",
                        "1",
                        "2",
                        "null",
                        "0"));

                listQuestions.add(new QuestionData("Which method is used to find the maximum element in an array in Java?",
                        "max()",
                        "maximum()",
                        "maxElement()",
                        "Arrays.sort()",
                        "Arrays.sort()"));

                listQuestions.add(new QuestionData("What is the purpose of the length property of an array in Java?",
                        "To add new elements to the array.",
                        "To remove elements from the array.",
                        "To store the number of elements in the array.",
                        "To sort the elements in the array.",
                        "To store the number of elements in the array."));

                listQuestions.add(new QuestionData("What is the output of the following code?\nint[] numbers = {1, 2, 3};\nfor (int i = 0; i < numbers.length; i++) {\n    System.out.print(numbers[i] + \" \");\n}",
                        "1 2 3",
                        "3 2 1",
                        "1 3 2",
                        "2 1 3",
                        "1 2 3"));

                listQuestions.add(new QuestionData("Which method is used to sort an array in ascending order in Java?",
                        "sort()",
                        "ascendingSort()",
                        "Array.sort()",
                        "None of the above",
                        "sort()"));

                listQuestions.add(new QuestionData("What is the output of the following code?\nint[] numbers = {1, 2, 3};\nSystem.out.println(numbers[numbers.length - 1]);",
                        "0",
                        "1",
                        "2",
                        "3",
                        "3"));

                listQuestions.add(new QuestionData("Which method is used to check if an array contains a specific element in Java?",
                        "contains()",
                        "hasElement()",
                        "find()",
                        "Arrays.equals()",
                        "contains()"));
                break;
        }
    }
}
