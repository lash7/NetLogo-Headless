package org.nlogo.prim;

import org.nlogo.nvm.Context;
import org.nlogo.nvm.Reporter;
import org.nlogo.agent.Turtle;
import org.nlogo.agent.Patch;
import org.nlogo.api.Nobody$;
import org.nlogo.api.Syntax;

public final strictfp class _patcheast
    extends Reporter {
  @Override
  public Syntax syntax() {
    return Syntax.reporterSyntax
        (Syntax.PatchType(), "-TP-");
  }

  @Override
  public Object report(Context context) {
    return report_1(context);
  }

  public Object report_1(Context context) {
    Patch patch;
    if (context.agent instanceof Patch) {
      patch = ((Patch) context.agent).getPatchEast();
    } else if (context.agent instanceof Turtle) {
      patch = ((Turtle) context.agent).getPatchHere().getPatchEast();
    } else {
      patch = world.fastGetPatchAt(1, 0);
    }
    if (patch == null) {
      return Nobody$.MODULE$;
    }
    return patch;
  }
}
