package org.nlogo.prim.etc;

import org.nlogo.api.LogoException;
import org.nlogo.nvm.Reporter;
import org.nlogo.api.Syntax;

public final strictfp class _ispatchset
    extends Reporter
    implements org.nlogo.nvm.Pure {
  @Override
  public Object report(final org.nlogo.nvm.Context context) throws LogoException {
    Object thing = args[0].report(context);
    if (thing instanceof org.nlogo.agent.AgentSet) {
      return (((org.nlogo.agent.AgentSet) thing).type() == org.nlogo.agent.Patch.class)
          ? Boolean.TRUE : Boolean.FALSE;
    } else {
      return Boolean.FALSE;
    }
  }

  @Override
  public Syntax syntax() {
    int[] right = {Syntax.WildcardType()};
    int ret = Syntax.BooleanType();
    return Syntax.reporterSyntax(right, ret);
  }
}




