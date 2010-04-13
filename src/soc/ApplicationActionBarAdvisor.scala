package soc;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of the
 * actions added to a workbench window. Each window will be populated with
 * new actions.
 */

class ApplicationActionBarAdvisor(configurer: IActionBarConfigurer) extends ActionBarAdvisor(configurer) with GUIImplicits {

  // Actions - important to allocate these only in makeActions, and then use them
  // in the fill methods.  This ensures that the actions aren't recreated
  // when fillActionBars is called with FILL_PROXY.
  private var exitAction: IWorkbenchAction = _;
  private var aboutAction: IWorkbenchAction = _;
  private var newWindowAction: IWorkbenchAction = _;
  private var openViewAction: OpenViewAction = _;
  private var messagePopupAction: Action = _;
  
  protected override def makeActions(window: IWorkbenchWindow) = {
    // Creates the actions and registers them.
    // Registering is needed to ensure that key bindings work.
    // The corresponding commands keybindings are defined in the plugin.xml file.
    // Registering also provides automatic disposal of the actions when
    // the window is closed.

    exitAction = ActionFactory.QUIT.create(window);
    register(exitAction);
    
    aboutAction = ActionFactory.ABOUT.create(window);
    register(aboutAction);
    
    newWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
    register(newWindowAction);
    
    openViewAction = new OpenViewAction(window, "Open Another Message View", ViewStatic.ID);
    register(openViewAction);
    
    messagePopupAction = new MessagePopupAction("Open Message", window);
    register(messagePopupAction);
  }
  protected override def fillMenuBar(menuBar: IMenuManager) = {

     MB(menuBar,
      MI1("File", IWorkbenchActionConstants.M_FILE,
        MI1(exitAction)
      ) ::
       MI1("Edit", IWorkbenchActionConstants.M_EDIT,
        MI1("Cut", Unit => println("Cut not implemented") , Nil) ::
        MI1("Copy", Unit => println("Copy not implemented") , Nil) ::
        MI1("Paste", Unit => println("Paste not implemented") , Nil) ::
        MI1("Select All", Unit => println("Select All not implemented") , Nil)
      ) ::
      MI1("View", IWorkbenchActionConstants.M_VIEW, Nil))
     menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
     MB(menuBar,
      MI1("Tools",
        MI1("Language", 
          MI1("English", Unit => { TranslationData.currlang = "en"; TranslationData.callcallbacks }, Nil) ::
          MI1("French" , Unit => { TranslationData.currlang = "fr"; TranslationData.callcallbacks } , Nil))) ::
      MI1("Help", IWorkbenchActionConstants.M_HELP, MI1(aboutAction))
      ) 
  }
    
  protected override def fillCoolBar(coolBar: ICoolBarManager): Unit = {
    var toolbar: IToolBarManager = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
    coolBar.add(new ToolBarContributionItem(toolbar, "main"));   
    toolbar.add(openViewAction);
    toolbar.add(messagePopupAction);
  }
}

