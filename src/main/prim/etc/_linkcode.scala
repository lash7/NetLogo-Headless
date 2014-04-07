// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.core.Syntax
import org.nlogo.nvm.{ Command, Context, CustomAssembled, AssemblerAssistant }

class _linkcode extends Command with CustomAssembled {
  override def syntax =
    Syntax.commandSyntax(
      agentClassString = "---L")
  override def perform(context: Context) {
    throw new UnsupportedOperationException
  }
  override def assemble(a: AssemblerAssistant) {
    // by doing nothing here, drop out of existence
  }
}
