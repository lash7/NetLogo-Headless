package org.nlogo.prim.etc

import org.nlogo.agent.Link
import org.nlogo.api.Syntax
import org.nlogo.nvm.{ Command, Context }

class _tie extends Command {
  override def syntax =
    Syntax.commandSyntax("---L", true)
  override def perform(context: Context) {
    context.agent.asInstanceOf[Link].mode(Link.MODE_FIXED)
    context.ip = next
  }
}
