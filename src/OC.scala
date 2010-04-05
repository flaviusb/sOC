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

case class MI1(title: String, action: Unit => Unit, children: scala.List[MI1]) { }
object MI1 {
  def apply(title: String, children: scala.List[MI1]): MI1 = apply(title, Unit => println("Does nothing"), children)
  //def apply(titleCallback: )
}

case class MI2(parent: MenuManager, title: String, children: scala.List[MI1]) {
  children foreach(x => {
    if (x.children.length == 0) { 
      var menuitem = new Actioned(x.action)
      menuitem.setText(TranslationData.translations(x.title)(TranslationData.currlang))
      TranslationData.translateCallback((y: String) => {menuitem.setText(TranslationData.translations(x.title)(y)); null })
      parent.add(menuitem)
    } else {
      var menu = new MenuManager(TranslationData.translations(x.title)(TranslationData.currlang));
      MI2(menu, TranslationData.translations(x.title)(TranslationData.currlang), x.children)
      TranslationData.translateCallback((y: String) => {menu.getMenu().getParentItem().setText(TranslationData.translations(x.title)(y)); null })
      parent.add(menu)
    }
  })
}

case class MB(children: scala.List[MI1]) {
  var me = new MenuManager("")
  children foreach(x => {
    if (x.children.length == 0) { 
      var menuitem = new Actioned(null)
      menuitem.setText(TranslationData.translations(x.title)(TranslationData.currlang))
      TranslationData.translateCallback((y: String) => {menuitem.setText(TranslationData.translations(x.title)(y)); null })
      me.add(menuitem)
    } else {
      var menu = new MenuManager(TranslationData.translations(x.title)(TranslationData.currlang));
      MI2(menu, TranslationData.translations(x.title)(TranslationData.currlang), x.children)
      TranslationData.translateCallback((y: String) => {menu.getMenu().getParentItem().setText(TranslationData.translations(x.title)(y)); null })
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
          MI1("Open...", Unit => println("Open Model not implemented") , Nil) ::
          MI1("Save", Unit => println("Save Model not implemented") , Nil) ::
          MI1("Save As...", Unit => println("Save As not implemented") , Nil) ::
          MI1("Save All", Unit => println("Save All not implemented") , Nil) ::
          MI1("Exit", Unit => close() , Nil)
        ) ::
        MI1("Edit",
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
      var layout = new GridLayout()
      layout.numColumns = 3
      parent.setLayout(layout)
      for(i<- 1 to 9) {
        var j = new CTabFolder(parent, SWT.CLOSE | SWT.BORDER | SWT.MULTI | SWT.RESIZE)
        var k = new CTabItem(j, SWT.CLOSE | SWT.MULTI)
        k.setText(i.toString())
        var foo = new org.eclipse.swt.widgets.Text(j, SWT.BORDER | SWT.MULTI | SWT.RESIZE)
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








