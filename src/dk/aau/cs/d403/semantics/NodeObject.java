package dk.aau.cs.d403.semantics;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ExpressionNode;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.ast.statements.FunctionArgNode;

import java.util.ArrayList;

public class NodeObject {
    private Enums.DataType type;
    private Enums.ClassType classType;
    private Enums.ReturnType returnType;
    private String name;
    private String functionName;
    private String insideClass;
    private String scopeLevel;
    private String attributes;
    private ArrayList<ObjectArgumentNode> objectArguments;
    private ArrayList<FunctionArgNode> functionArguments;
    private ExpressionNode expression;

    // Constructor for Variable declarations
    public NodeObject(Enums.DataType type, String name, String scopeLevel) {
        this.type = type;
        this.name = name;
        this.scopeLevel = scopeLevel;
        this.attributes = "Variable";

        this.insideClass = null;
    }

    // Constructor for Variable declarations in classes
    public NodeObject(Enums.DataType type, String name, String insideClass, String scopeLevel) {
        this.type = type;
        this.name = name;
        this.insideClass = insideClass;
        this.scopeLevel = scopeLevel;
        this.attributes = "Variable";
    }

    // Constructor for Object declarations
    public NodeObject(Enums.ClassType type, String name, String scopeLevel, ArrayList<ObjectArgumentNode> objectArguments) {
        this.classType = type;
        this.name = name;
        this.scopeLevel = scopeLevel;
        this.objectArguments = objectArguments;

        StringBuilder sb = new StringBuilder();
        for(ObjectArgumentNode objectArg : objectArguments) {
            sb.append(objectArg.prettyPrint());
            sb.append(",");
        }
        this.attributes = sb.toString();
    }

    // Constructor for Object function calls
    public NodeObject(String name, String functionName, String scopeLevel, ArrayList<ObjectArgumentNode> objectArguments) {
        this.name = name;
        this.functionName = functionName;
        this.scopeLevel = scopeLevel;
        this.objectArguments = objectArguments;

        StringBuilder sb = new StringBuilder();
        for(ObjectArgumentNode objectArg : objectArguments) {
            sb.append(objectArg.prettyPrint());
            sb.append(",");
        }
        this.attributes = sb.toString();
    }

    // Constructor for Assignments
    public NodeObject(Enums.DataType type, String name, String scopeLevel, ExpressionNode expression) {
        this.type = type;
        this.name = name;
        this.scopeLevel = scopeLevel;
        this.expression = expression;
        this.attributes = expression.prettyPrint();
    }

    // Constructor for Function declarations
    public NodeObject(Enums.ReturnType returnType, String name, String scopeLevel, ArrayList<FunctionArgNode> functionArguments) {
        this.returnType = returnType;
        this.name = name;
        this.scopeLevel = scopeLevel;
        this.functionArguments = functionArguments;

        if(functionArguments != null) {
            StringBuilder sb = new StringBuilder();

            for(FunctionArgNode functionArg : functionArguments) {

                sb.append(functionArg.prettyPrint());
                sb.append(",");
            }
            this.attributes = sb.toString();
        }
        else
            this.attributes = "No arguments";

    }

    // Constructor for Classes
    public NodeObject(String name, String scopeLevel) {
        this.name = name;
        this.scopeLevel = scopeLevel;
        this.attributes = "Class";
    }


    public Enums.DataType getType() {
        return type;
    }

    public Enums.ReturnType getReturnType() {
        return returnType;
    }

    public String getName() {
        return name;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getScopeLevel() {
        return scopeLevel;
    }

    public String getInsideClass() {
        return insideClass;
    }

    public String getAttributes() {
        return attributes;
    }

    public Enums.ClassType getClassType() {
        return classType;
    }

    public ArrayList<ObjectArgumentNode> getObjectArguments() {
        return objectArguments;
    }

    public ArrayList<FunctionArgNode> getFunctionArguments() {
        return functionArguments;
    }

    public ExpressionNode getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format("%15s, %15s, %15s, %15s, %30s, %15s", getName(), getType(), getClassType(), getReturnType(), getAttributes(), getScopeLevel());
    }
}
