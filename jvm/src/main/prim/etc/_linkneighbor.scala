// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.agent.{ LinkManager, Turtle }
import org.nlogo.nvm.{ Context, EngineException, Reporter }

class _linkneighbor(breedName: String) extends Reporter {

  def this() = this(null)

  override def toString =
    super.toString + ":" + breedName

  override def report(context: Context): java.lang.Boolean =
    Boolean.box(report_1(context, argEvalTurtle(context, 0)))

  def report_1(context: Context, target: Turtle): Boolean = {
    val parent = context.agent.asInstanceOf[Turtle]
    val breed =
      if (breedName == null)
        world.links
      else
        world.getLinkBreed(breedName)
    val err = LinkManager.mustNotBeDirected(breed)
    if (err.isDefined)
      throw new EngineException(context, this, err.get)
    world.linkManager.findLinkFrom(parent, target, breed, true) != null ||
      world.linkManager.findLinkFrom(target, parent, breed, true) != null
  }

  def getBreedName = breedName

}
