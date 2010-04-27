package soc

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt._
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.jfree._
import org.jfree.chart._
import org.jfree.experimental.chart.swt.demo.SWTMultipleAxisDemo1
import org.jfree.experimental.swt._
import org.jfree.experimental.chart.swt.ChartComposite
import org.eclipse.swt.widgets.Layout

class GraphView extends ViewPart {
  override def createPartControl(parent: Composite): Unit = {
    //var ch = new ChartComposite(parent, SWT.NONE)
    var compositeGauge: Composite = new Composite(parent, SWT.EMBEDDED)
    //var gridData: GridData = new GridData(SWT.FILL, SWT.FILL, true, true)
    //gridData.heightHint = 120
    //gridData.widthHint = 250
    //compositeGauge.setLayout(new GridLayout())
    //compositeGauge.setLayoutData(gridData)
    var chart = SWTMultipleAxisDemo1.createDemoPanel()
    var chfr = SWT_AWT.new_Frame(compositeGauge)
    chfr.add(chart)
  }
  override def setFocus(): Unit = { }
}


/*
package soc;

import java.io.IOException;
import org.eclipse.swt.layout.FillLayout;

import net.sourceforge.jeuclid.LayoutContext;
import net.sourceforge.jeuclid.swt.MathView;
import net.sourceforge.jeuclid.context.LayoutContextImpl;
import net.sourceforge.jeuclid.context.Parameter;
import net.sourceforge.jeuclid.parser.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class RenderedView extends ViewPart {
  public void createPartControl(Composite parent)
  {
    parent.setLayout(new FillLayout(SWT.HORIZONTAL));
    MathView2 top = new MathView2(parent, SWT.NONE);
    javax.xml.transform.stream.StreamSource file = new javax.xml.transform.stream.StreamSource("/home/justin/workspace/sOC/res/mmlEqn.mml");
    net.sourceforge.jeuclid.parser.Parser parser = net.sourceforge.jeuclid.parser.Parser.getInstance();
    Node foo = null;
    try {
		foo = parser.parse(file);
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	top.setLayout(new FillLayout(SWT.HORIZONTAL));
	top.setDocument(foo);
	
	parent.pack();
  }
  public void setFocus() {}
}

class RenderedView extends ViewPart {
  def createPartControl(parent: Composite): Unit = {
	var classes = Array[java.lang.Class[_]](
      java.lang.Class.forName("net.sourceforge.jeuclid.parser.Parser"),
      java.lang.Class.forName("javax.xml.transform.Source")
	)
    var methods = Array[java.lang.reflect.Method](
      classes(0).getMethod("getInstance"),
      classes(0).getMethod("parse", classes(1))
    )
    var top: net.sourceforge.jeuclid.swt.MathView = new net.sourceforge.jeuclid.swt.MathView(parent, SWT.NONE)
    var file: javax.xml.transform.stream.StreamSource = new javax.xml.transform.stream.StreamSource("/home/justin/workspace/sOC/res/mmlEqn.mml")
    //var parser: net.sourceforge.jeuclid.parser.Parser = ((new getParser()).getAParser())
    var parser: net.sourceforge.jeuclid.parser.Parser = methods(0).invoke(null, null).asInstanceOf[net.sourceforge.jeuclid.parser.Parser];
    var fooo: org.w3c.dom.Node = methods(1).invoke(parser, file.asInstanceOf[javax.xml.transform.Source]).asInstanceOf[org.w3c.dom.Node];
    //var foo: org.w3c.dom.Document = parser.parseStreamSource(file)
    null
  }

  def setFocus(): Unit = {
	  
  }
}
*/
