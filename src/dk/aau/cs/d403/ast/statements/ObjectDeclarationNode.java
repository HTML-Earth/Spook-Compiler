package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;

import java.util.ArrayList;

public class ObjectDeclarationNode extends DeclarationNode {

    private Enums.ClassType classType;
    private String variableName;
    private ArrayList<ObjectArgumentNode> objectArguments;

    public ObjectDeclarationNode(Enums.ClassType classType, String variableName, ArrayList<ObjectArgumentNode> objectArguments) {
        this.classType = classType;
        this.variableName = variableName;
        this.objectArguments = objectArguments;
    }

    public ObjectDeclarationNode() {
    }

    public Enums.ClassType getClassType() {
        return classType;
    }

    public String getVariableName() {
        return variableName;
    }

    public ArrayList<ObjectArgumentNode> getObjectArguments() {
        return objectArguments;
    }

    @Override
    public String prettyPrint() {
        return "Object Declaration";
    }
}
