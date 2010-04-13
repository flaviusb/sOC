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

case class MI1(title: String, mask: String, action: IAction, children: scala.List[MI1]) { }
object MI1 {
  def apply(title: String, mask: String, action: Unit => Unit, children: scala.List[MI1]): MI1 = { MI1(title, mask, new Actioned(action), children) }
  def apply(title: String, mask: String, children: scala.List[MI1]): MI1 = { MI1(title, mask, Unit => println("Does nothing"), children) }
  def apply(title: String, children: scala.List[MI1]): MI1 = { MI1(title, null, Unit => println("Does nothing"), children) }
  def apply(title: String, action: Unit => Unit, children: scala.List[MI1]): MI1 = { MI1(title, null, action, children) }
  def apply(base: IAction): MI1 = { MI1(base.getText(), null, base, Nil) }
}


