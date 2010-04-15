package soc;

import org.eclipse.ui.application._;

/**
 * This workbench advisor creates the window advisor, and specifies
 * the perspective id for the initial window.
 */
class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {
	
  override def createWorkbenchWindowAdvisor (configurer: IWorkbenchWindowConfigurer): WorkbenchWindowAdvisor = {
    new ApplicationWorkbenchWindowAdvisor(configurer);
  }
  def getInitialWindowPerspectiveId(): String = {
    Perspective.ID;
  }
  override def initialize(configurer: IWorkbenchConfigurer): Unit = {
    super.initialize(configurer)
    configurer.setSaveAndRestore(true)
  }
}
