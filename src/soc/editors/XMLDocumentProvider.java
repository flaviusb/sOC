package soc.editors;

import org.eclipse.core.filebuffers.IDocumentSetupParticipant;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.editors.text.ForwardingDocumentProvider;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;

public class XMLDocumentProvider extends ForwardingDocumentProvider {
    public XMLDocumentProvider()
    {
      super(null, new innersetup(), new TextFileDocumentProvider());	
    }

}
class innersetup implements IDocumentSetupParticipant {
	public void setup(IDocument document) {
		//IDocument document = super.createDocument(element);
		if (document != null) {
			IDocumentPartitioner partitioner =
				new FastPartitioner(
					new XMLPartitionScanner(),
					new String[] {
						XMLPartitionScanner.XML_TAG,
						XMLPartitionScanner.XML_COMMENT });
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
		}
	} 
}