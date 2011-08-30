package org.nlogo.prim.dead

import org.nlogo.api.Syntax
import org.nlogo.nvm.{ Command, Context }

/**
 * This isn't in the language anymore, but in order to auto-translate it to HISTOGRAM + OF, we need
 * to have a class for it so the tokenizer and parser can parse it.
 */

class _histogramfrom extends Command {
  override def perform(context: Context) {
    throw new IllegalStateException
  }
  override def syntax =
    Syntax.commandSyntax(Array(Syntax.AgentsetType, Syntax.NumberBlockType))
}
