package soc;

import _root_.org.eclipse.jface._
import _root_.org.eclipse.swt._
import org.eclipse.jface.action._
import org.eclipse.swt.custom._
import org.eclipse.swt.graphics._
import org.eclipse.swt.layout._
import org.eclipse.swt.widgets._
import org.eclipse.jface.window._
import org.eclipse.jface.viewers._
import org.eclipse.jface.dialogs._
import scala.collection.mutable.{Map => MMap}

import org.eclipse.ui.IWorkbenchActionConstants
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

class Actioned(toRun: Unit => Unit) extends Action {
  override def run = {
    if (toRun != null)
      toRun()
  }
}
