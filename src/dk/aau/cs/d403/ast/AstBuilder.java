package dk.aau.cs.d403.ast;

import dk.aau.cs.d403.parser.SpookBaseVisitor;
import dk.aau.cs.d403.parser.SpookParser;

public class AstBuilder extends SpookBaseVisitor<DeclarationNode> {
    public DeclarationNode VisitMain(SpookParser.MainContext context)
    {
        return Visit(context.declarations());
    }
}
