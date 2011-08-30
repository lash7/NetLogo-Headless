package org.nlogo.prim.hubnet;

import org.nlogo.api.Dump;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.nlogo.api.LogoException;
import org.nlogo.api.LogoList;
import org.nlogo.api.TypeNames;
import org.nlogo.nvm.EngineException;
import org.nlogo.api.Syntax;
import static scala.collection.JavaConversions.asScalaBuffer;

public final strictfp class _hubnetsend
    extends org.nlogo.nvm.Command {
  @Override
  public void perform(final org.nlogo.nvm.Context context)
      throws LogoException {
    Object nodesArg = args[0].report(context);
    String tag = argEvalString(context, 1);
    Object message = args[2].report(context);
    org.nlogo.api.HubNetInterface hubnetManager = workspace.getHubNetManager();
    List<String> nodes = new ArrayList<String>();
    if (nodesArg instanceof LogoList) {
      for (Iterator<Object> nodesIter = ((LogoList) nodesArg).iterator();
           nodesIter.hasNext();) {
        Object node = nodesIter.next();
        if (!(node instanceof String)) {
          throw new EngineException
              (context, this, "HUBNET-SEND expected "
                  + TypeNames.aName(Syntax.StringType() | Syntax.ListType())
                  + " of strings as the first input, but one item is the "
                  + TypeNames.name(node) + " " +
                  Dump.logoObject(node)
                  + " instead");
        }
        nodes.add((String) node);
      }
    } else if (nodesArg instanceof String) {
      nodes.add((String) nodesArg);
    } else {
      throw new org.nlogo.nvm.ArgumentTypeException
          (context, this, 0, Syntax.ListType() | Syntax.StringType(), nodesArg);
    }
    hubnetManager.send(asScalaBuffer(nodes), tag, message);
    context.ip = next;
  }

  @Override
  public Syntax syntax() {
    int[] right = {Syntax.StringType() | Syntax.ListType(),
        Syntax.StringType(),
        Syntax.WildcardType()};
    return Syntax.commandSyntax(right);
  }
}
