package soc

import org.eclipse.ui.IEditorInput;
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.ui.IPersistableElement

class FakeEditorInput extends IEditorInput {
  def exists = true
  def getImageDescriptor: ImageDescriptor = ImageDescriptor.getMissingImageDescriptor()
  def getName: String = "A non-file"
  def getPersistable: IPersistableElement = null
  def getToolTipText: String = "An empty editor"
  def getAdapter(foo: Class[_]): Object = null
}