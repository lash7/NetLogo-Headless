package org.nlogo.prim.etc

import org.nlogo.api.{ I18N, LogoListBuilder, Syntax }
import org.nlogo.nvm.{ Context, EngineException, Reporter }

class _nvalues extends Reporter {

  override def syntax =
    Syntax.reporterSyntax(Array(Syntax.NumberType, Syntax.ReporterTaskType),
                          Syntax.ListType)

  override def report(context: Context) = {
    // get the first argument...
    val n = argEvalIntValue(context, 0)
    if (n < 0)
      throw new EngineException( context, this,
        I18N.errors.getN("org.nlogo.prim.etc.$common.noNegativeNumber", displayName))
    // make the result list.
    val result = new LogoListBuilder
    val lambda = argEvalReporterLambda(context, 1)
    if(lambda.formals.size > 1)
      throw new EngineException(
        context, this, lambda.missingInputs(1))
    for (i <- 0 until n)
      result.add(lambda.report(context, Array(java.lang.Double.valueOf(i))))
    result.toLogoList
  }

}
