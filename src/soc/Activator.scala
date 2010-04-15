package soc;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * Due to limitations in Java-Scala interop, static members are stored in ActivatorStatic
 */

class Activator extends AbstractUIPlugin {
  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  override def start(context: BundleContext): Unit = {
    super.start(context);
    ActivatorStatic.plugin = this;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  override def stop(context: BundleContext): Unit = {
    ActivatorStatic.plugin = null;
    super.stop(context);
  }
}
