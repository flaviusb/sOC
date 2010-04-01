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

case class MI1(title: String, action: Unit => Unit, children: scala.List[MI1]) { }
object MI1 {
  def apply(title: String, children: scala.List[MI1]): MI1 = apply(title, Unit => println("Does nothing"), children)
}

case class MI2(parent: MenuManager, title: String, children: scala.List[MI1]) {
  children foreach(x => {
    if (x.children.length == 0) { 
      var menuitem = new Actioned(x.action)
      menuitem.setText(x.title)
      parent.add(menuitem)
    } else {
      var menu = new MenuManager(x.title);
      MI2(menu, x.title, x.children)
      parent.add(menu)
    }
  })
}

case class MB(children: scala.List[MI1]) {
  var me = new MenuManager("")
  children foreach(x => {
    if (x.children.length == 0) { 
      var menuitem = new Actioned(null)
      menuitem.setText(x.title)
      me.add(menuitem)
    } else {
      var menu = new MenuManager(x.title);
      MI2(menu, x.title, x.children)
      me.add(menu)
    }
  })
}

class Actioned(toRun: Unit => Unit) extends Action {
  override def run = {
    if (toRun != null)
      toRun()
  }
}

object OC {
  class sOCWindow extends ApplicationWindow(null) {
    implicit def MI12List(a: MI1) : scala.List[MI1] = { a :: Nil }
    addMenuBar()
    def openAboutBox = {
      println ("foo")
      var buttons: Array[String] = new Array[String](1)
      buttons(0) = IDialogConstants.OK_LABEL
      var vv = new MessageDialog(this.getShell(), "About sOC", null, "About this thing: ...", MessageDialog.QUESTION, buttons, 0)
      vv.open()
      null
    }
    protected override def createMenuManager() : MenuManager = {
      var menu = MB(
        MI1("File", 
          MI1("New", Unit => println("New Model not implemented") , Nil) ::
          MI1("Open", Unit => println("Open Model not implemented") , Nil) ::
          MI1("Exit", Nil)
        ) ::
        MI1("Edit", Nil) ::
        MI1("Help", MI1("About", Unit => openAboutBox , Nil))
      ).me
      menu
    }
    protected override def createContents(parent: Composite) : Control = {
      var layout = new GridLayout()
      layout.numColumns = 3
      parent.setLayout(layout)
      for(i<- 1 to 9) {
        var j = new CTabFolder(parent, SWT.CLOSE | SWT.BORDER | SWT.MULTI)
        var k = new CTabItem(j, SWT.CLOSE | SWT.MULTI)
        k.setText(i.toString())
        var foo = new org.eclipse.swt.widgets.Text(j, SWT.BORDER|SWT.MULTI)
        foo.setText("Contents of pane " + i.toString())
        k.setControl(foo)
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








