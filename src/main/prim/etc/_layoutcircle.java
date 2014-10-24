// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc;

import org.nlogo.agent.AgentSet;
import org.nlogo.agent.Turtle;
import org.nlogo.core.AgentKindJ;
import org.nlogo.api.I18N;
import org.nlogo.api.LogoList;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;
import org.nlogo.nvm.Command;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.EngineException;

public final strictfp class _layoutcircle
    extends Command {

  public _layoutcircle() {
    switches = true;
  }

  @Override
  public void perform(final Context context) {
    Object nodes = args[0].report(context);
    double radius = argEvalDoubleValue(context, 1);
    try {
      if (nodes instanceof LogoList) {
        org.nlogo.agent.Layouts.circle
            (world, (LogoList) nodes, radius);
      } else {
        AgentSet set = (AgentSet) nodes;
        if (set.kind() != AgentKindJ.Turtle()) {
          throw new EngineException
              (context, this,
                  I18N.errorsJ().get("org.nlogo.prim.etc._layoutcircle.patchesImmovable"));
        }
        org.nlogo.agent.Layouts.circle(world, set, radius, context.job.random);
      }
    } catch (org.nlogo.api.AgentException e) {
      throw new EngineException(context, this, e.getMessage());
    }
    context.ip = next;
  }
}
