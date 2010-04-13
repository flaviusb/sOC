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

/* import _root_.net.sourceforge.jeuclid.swt._ */


case class MI2(parent: MenuManager, title: String, children: scala.List[MI1]) extends SetTRText {
  children foreach(x => {
    if (x.children.length == 0) { 
      parent.add(x.action)
      setTRTextCB(x.action, x.title)
    } else {
      var menu = new MenuManager(TranslationData.translations(x.title)(TranslationData.currlang));
      parent.add(menu)
      setTRTextCB(menu, x.title)
      MI2(menu, TranslationData.translations(x.title)(TranslationData.currlang), x.children)
    }
  })
}


