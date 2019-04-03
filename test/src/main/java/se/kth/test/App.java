package se.kth.test;

import java.io.File;
import java.util.List;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;

public class App
{
public static void main( String[] args )
{
        // Input file
        File input = new File(args[0]);
        if(!input.exists()) // If the input file does not exists
        {
                System.err.println(args[0] + " does not exists!");
                System.exit(1);
        }

        try {
                CompilationUnit cu = JavaParser.parse(input); // Build AST
                List<MethodDeclaration> methodsInFile = cu.findAll(MethodDeclaration.class);  // Find all methods in file
                for(MethodDeclaration method : methodsInFile) // For each method
                {
                        System.out.println(method.getSignature().asString()); // Print the signature
                        System.out.println(method.toString()); //  Print the method
                        System.out.println(); // Print new line
                }
        } catch (Exception e) { // If we failed to build AST
                System.err.println("Failed to build JavaParser model for " + args[0]);
                System.exit(1);
        }
}

// Dummy method
public static void dummyMethod(int a)
{
        int b = a;
        b++;
}
}
