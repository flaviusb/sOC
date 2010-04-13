package soc;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	/**
	 * The ID of the perspective as specified in the extension.
	 */
	public static final String ID = "sOC.perspective";

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		
		//layout.addStandaloneView(NavigationView.ID,  false, IPageLayout.LEFT, 0.25f, editorArea);
		IFolderLayout folder = layout.createFolder("messages", IPageLayout.LEFT, 0.33f, editorArea);
		folder.addPlaceholder(ViewStatic.ID + ":*");
		folder.addView(View.ID);
		IFolderLayout folder2 = layout.createFolder("messages", IPageLayout.RIGHT, 0.33f, editorArea);
		folder2.addPlaceholder(View.ID + ":*");
		folder2.addView(View.ID);
		IFolderLayout folder3 = layout.createFolder("messages", IPageLayout.TOP, 0.33f, editorArea);
		folder3.addPlaceholder(View.ID + ":*");
		folder3.addView(View.ID);

		//layout.getViewLayout(NavigationView.ID).setCloseable(false);
	}
}
