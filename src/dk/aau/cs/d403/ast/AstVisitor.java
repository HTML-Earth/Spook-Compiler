package dk.aau.cs.d403.ast;

public abstract class AstVisitor<T>
{
    public abstract T Visit(FloatDeclarationNode node);
    public abstract T Visit(IntDeclarationNode node);
    //public abstract T Visit(MultiplicationNode node);
    //public abstract T Visit(DivisionNode node);
    //public abstract T Visit(NegateNode node);
    //public abstract T Visit(FunctionNode node);
    //public abstract T Visit(NumberNode node);

    public T Visit(DeclarationNode node)
    {
        if (node instanceof FloatDeclarationNode) {
            return Visit((FloatDeclarationNode)node);
        }
        else if (node instanceof IntDeclarationNode) {
            return Visit((IntDeclarationNode)node);
        }

        return null;
    }
}