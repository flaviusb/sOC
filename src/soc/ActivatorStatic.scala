package soc;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */

object ActivatorStatic extends AbstractUIPlugin {
  val PLUGIN_ID: String = "sOC";
  var plugin: Activator = _;
  def getDefault(): Activator = {
    plugin
  }
  def getImageDescriptor(path: String): ImageDescriptor = {
    AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
  }
}
