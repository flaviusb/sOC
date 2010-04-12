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

trait SetTRText {
  def setTRText(toSet: {def setText(text: String): Unit}, text: String): Unit = {
    toSet.setText(TranslationData.translations(text)(TranslationData.currlang))
  }
  def setTRTextCB(toSet: {def setText(text: String): Unit}, text: String): Unit = {
    if (TranslationData.translations.contains(text)) { 
      setTRText(toSet, text)
      TranslationData.translateCallback((y: String) => {toSet.setText(TranslationData.translations(text)(y)); null })
    } else {
      toSet.setText(text)
    }
  }
  def setTRTextCB(toSet: MenuManager, text: String): Unit = {
    TranslationData.translateCallback((y: String) => {toSet.getMenu().getParentItem().setText(TranslationData.translations(text)(y)); null })
  }
  def safeGetText(text: String, lang: String): String = {
    if (TranslationData.translations.contains(text))
      TranslationData.translations(text)(TranslationData.currlang)
    else
      text
  }
}

case class MI1(title: String, mask: String, action: IAction, children: scala.List[MI1]) { }
object MI1 {
  def apply(title: String, mask: String, action: Unit => Unit, children: scala.List[MI1]): MI1 = { MI1(title, mask, new Actioned(action), children) }
  def apply(title: String, mask: String, children: scala.List[MI1]): MI1 = { MI1(title, mask, Unit => println("Does nothing"), children) }
  def apply(title: String, children: scala.List[MI1]): MI1 = { MI1(title, null, Unit => println("Does nothing"), children) }
  def apply(title: String, action: Unit => Unit, children: scala.List[MI1]): MI1 = { MI1(title, null, action, children) }
  def apply(base: IAction): MI1 = { MI1(base.getText(), null, base, Nil) }
}

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

case class MB(me: IMenuManager, children: scala.List[MI1]) extends SetTRText {
  children foreach(x => {
    if (x.children.length == 0) { 
      var menuitem = new Actioned(null)
      me.add(menuitem)
      setTRTextCB(menuitem, x.title)
    } else {
      var menu = new MenuManager(safeGetText(x.title, TranslationData.currlang));
      me.add(menu)
      setTRTextCB(menu, x.title)
      MI2(menu, safeGetText(x.title, TranslationData.currlang), x.children)
    }
  })
}

object MB {
  def apply(children: scala.List[MI1]): MB = { apply(new MenuManager(""), children) }
}

class Actioned(toRun: Unit => Unit) extends Action {
  override def run = {
    if (toRun != null)
      toRun()
  }
}

trait GUIImplicits {
  implicit def MI12List(a: MI1) : scala.List[MI1] = { a :: Nil }
}

/* object OC {
  class sOCWindow extends ApplicationWindow(null) {
    implicit def MI12List(a: MI1) : scala.List[MI1] = { a :: Nil }
    addMenuBar()
    def openAboutBox = {
      var buttons: Array[String] = new Array[String](1)
      buttons(0) = IDialogConstants.OK_LABEL
      var vv = new MessageDialog(this.getShell(), "About sOC", null, TranslationData.translations("Some general information about OpenCell, CellML, third party components and the system")(TranslationData.currlang), MessageDialog.QUESTION, buttons, 0)
      vv.open()
      null 
    }
    protected override def createMenuManager() : MenuManager = {
      var menu = MB(
        MI1("File", 
          MI1("New", Unit => println("New Model not implemented") , Nil) ::
          MI1("Open...", Unit => println("Open Model not implemented") , Nil) ::
          MI1("Save", Unit => println("Save Model not implemented") , Nil) ::
          MI1("Save As...", Unit => println("Save As not implemented") , Nil) ::
          MI1("Save All", Unit => println("Save All not implemented") , Nil) ::
          MI1("Exit", Unit => close() , Nil)
        ) ::
        MI1("Edit",
          MI1("Cut", Unit => println("Cut not implemented") , Nil) ::
          MI1("Copy", Unit => println("Copy not implemented") , Nil) ::
          MI1("Paste", Unit => println("Paste not implemented") , Nil) ::
          MI1("Select All", Unit => println("Select All not implemented") , Nil)
        ) ::
        MI1("View", Nil) ::
        MI1("Tools",
          MI1("Language", 
            MI1("English", Unit => { TranslationData.currlang = "en"; TranslationData.callcallbacks }, Nil) ::
            MI1("French" , Unit => { TranslationData.currlang = "fr"; TranslationData.callcallbacks } , Nil))) ::
        MI1("Help", MI1("About", Unit => openAboutBox , Nil))
      ).me
      menu
    }
    protected override def createContents(parent: Composite) : Control = {
      getShell().setText(TranslationData.translations("OpenCell")(TranslationData.currlang))
      TranslationData.translateCallback((y: String) => {this.getShell().setText(TranslationData.translations("OpenCell")(y)); null })
      var layout = new GridLayout()
      layout.numColumns = 3
      parent.setLayout(layout)
      for(i<- 1 to 9) {
        var j = new CTabFolder(parent, SWT.CLOSE | SWT.BORDER | SWT.MULTI | SWT.RESIZE)
        var k = new CTabItem(j, SWT.CLOSE | SWT.MULTI)
        k.setText(i.toString())
        var ee = new MathView(j, SWT.BORDER | SWT.MULTI | SWT.RESIZE)
        var foo = new org.eclipse.swt.widgets.Text(j, SWT.BORDER | SWT.MULTI | SWT.RESIZE)
        foo.setText("Contents of pane " + i.toString())
        k.setControl(ee)
        null
      }
      parent
    }
  }
  def main(args : Array[String]) : Unit = {
    var demo = new sOCWindow()
    demo.setBlockOnOpen(true)
    demo.open()
    Display.getCurrent().dispose()
  }
}
*/
