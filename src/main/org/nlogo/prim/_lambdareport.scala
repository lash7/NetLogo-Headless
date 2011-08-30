package org.nlogo.prim

import org.nlogo.api.{ Let, Syntax }
import org.nlogo.nvm.{ ReporterLambda, Context, Reporter }

class _lambdareport extends Reporter {

  val formals = collection.mutable.ArrayBuffer[Let]()

  override def syntax = Syntax.reporterSyntax(
    Array(Syntax.WildcardType),
    Syntax.ReporterTaskType)

  override def report(c: Context): AnyRef =
    ReporterLambda(body = args(0),
                   formals = formals.reverse.dropWhile(_==null).reverse.toArray,
                   lets = c.letBindings,
                   locals = c.activation.args)

  def getFormal(n: Int): Let = {
    while(formals.size < n)
      formals += new Let
    formals(n - 1)
  }

}
