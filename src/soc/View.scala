package soc;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

class View extends ViewPart {
  def createPartControl(parent: Composite): Unit = {
    var top: Composite = new Composite(parent, SWT.NONE)
    var layout: GridLayout = new GridLayout()
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    top.setLayout(layout);
  }

  def setFocus(): Unit = {
  }
}