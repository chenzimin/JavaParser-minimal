# JavaParser-minimal

This is a minimal working example of JavaParser by extracting all method signature and method body of a Java file. First, make sure that you have maven and Java install.

Then, you can build the package by:
```bash
cd test
mvn package
```

Now you can execute the jar on any Java files, for example:
```bash
java -jar target/test-1.0-SNAPSHOT-jar-with-dependencies.jar src/main/java/se/kth/test/App.java
```

And you will get the following output:
```
main(String[])
public static void main(String[] args) {
    // Input file
    File input = new File(args[0]);
    if (// If the input file does not exists
    !input.exists()) {
        System.err.println(args[0] + " does not exists!");
        System.exit(1);
    }
    try {
        // Build AST
        CompilationUnit cu = JavaParser.parse(input);
        // Find all methods in file
        List<MethodDeclaration> methodsInFile = cu.findAll(MethodDeclaration.class);
        for (// For each method
        MethodDeclaration method : // For each method
        methodsInFile) {
            // Print the signature
            System.out.println(method.getSignature().asString());
            // Print the method
            System.out.println(method.toString());
            // Print new line
            System.out.println();
        }
    } catch (Exception e) {
        // If we failed to build AST
        System.err.println("Failed to build JavaParser model for " + args[0]);
        System.exit(1);
    }
}

dummyMethod(int)
// Dummy method
public static void dummyMethod(int a) {
    int b = a;
    b++;
}
```
where each part consists of the method signature and body.

See `JavaParser-minimal/test/src/main/java/se/kth/test/App.java` for more info
