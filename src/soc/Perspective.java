package soc;

import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;


public class Perspective implements IPerspectiveFactory {

	/**
	 * The ID of the perspective as specified in the extension.
	 */
	public static final String ID = "sOC.perspective";

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		
		//layout.addStandaloneView(NavigationView.ID,  false, IPageLayout.LEFT, 0.25f, editorArea);
		IFolderLayout renderedview = layout.createFolder("renderedview", IPageLayout.TOP, 0.25f, editorArea);
		renderedview.addPlaceholder(ViewStatic.RENDEREDVIEW());
		renderedview.addView(ViewStatic.RENDEREDVIEW() + ":0");
    IFolderLayout graphview = layout.createFolder("graphview", IPageLayout.RIGHT, 0.25f, editorArea);
    graphview.addPlaceholder(ViewStatic.GRAPHVIEW());
    graphview.addView(ViewStatic.GRAPHVIEW() + ":0");
    IFolderLayout folder = layout.createFolder("messages", IPageLayout.LEFT, 0.33f, editorArea);
		folder.addPlaceholder(ViewStatic.ID1());
		folder.addView(ViewStatic.ID1() + ":0");
		IFolderLayout folder2 = layout.createFolder("messages2", IPageLayout.RIGHT, 0.33f, editorArea);
		folder2.addPlaceholder(ViewStatic.ID2());
		folder2.addView(ViewStatic.ID2() + ":0");
		IFolderLayout folder3 = layout.createFolder("messages3", IPageLayout.TOP, 0.33f, editorArea);
		folder3.addPlaceholder(ViewStatic.ID3());
		folder3.addView(ViewStatic.ID3() + ":0");
		//FileEditorInput foo = new FileEditorInput()
		
		//IFile foo = new File(new Path("src"), 
	}
}
