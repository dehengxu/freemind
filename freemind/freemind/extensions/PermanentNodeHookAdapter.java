/*
 * Created on 06.03.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package freemind.extensions;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import freemind.main.XMLElement;
import freemind.modes.ControllerAdapter;
import freemind.modes.MindMap;
import freemind.modes.MindMapNode;
import freemind.modes.ModeController;

/**
 * @author foltin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PermanentNodeHookAdapter
	extends NodeHookAdapter
	implements PermanentNodeHook {

		// Logging: 
		// private static java.util.logging.Logger logger;

	/**
	 * @param node
	 * @param map
	 * @param controller
	 */
	public PermanentNodeHookAdapter() {
		super();
//		if(logger == null)
//			logger = ((ControllerAdapter)getController()).getFrame().getLogger(this.getClass().getName());
	}

	/* (non-Javadoc)
	 * @see freemind.extensions.NodeHook#invoke(freemind.modes.MindMapNode, java.util.List)
	 */
	public void invoke(MindMapNode focussed, List selecteds) {
		logger.finest("invoke(selecteds) called.");
		for (Iterator it = selecteds.iterator(); it.hasNext();) {
			MindMapNode selected = (MindMapNode) it.next();
			PermanentNodeHook hook = (PermanentNodeHook) getController()
					.createNodeHook(getName(), selected, getMap());
			// call invoke.
			selected.invokeHook(hook);
			// the focussed receives the focus:
			if (selected == focussed) {
				hook.onReceiveFocusHook();
			}
			// using this method, the map is dirty now. This is important to
			// guarantee, that the hooks are saved.
			this.nodeChanged(selected);
		}
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see freemind.modes.NodeHook#shutdownMapHook()
	 */
	public void shutdownMapHook() {
		logger.finest("shutdownMapHook");
		setNode(null);
		setMap(null);
		super.shutdownMapHook();
	}

	/* (non-Javadoc)
	 * @see freemind.modes.NodeHook#onMouseOverHook()
	 */
	public void onMouseOverHook() {
	}

	/* (non-Javadoc)
	 * @see freemind.modes.NodeHook#onUpdateNodeHook()
	 */
	public void onUpdateNodeHook() {
		logger.finest("onUpdateNodeHook");
	}

	/* (non-Javadoc)
	 * @see freemind.modes.NodeHook#onUpdateChildrenHook()
	 */
	public void onUpdateChildrenHook(MindMapNode updatedNode) {
		logger.finest("onUpdateChildrenHook");
	}

	/* (non-Javadoc)
	 * @see freemind.modes.NodeHook#onAddChild(freemind.modes.MindMapNode)
	 */
	public void onAddChild(MindMapNode newChildNode) {
		logger.finest("onAddChild");
	}

	/* (non-Javadoc)
	 * @see freemind.extensions.PermanentNodeHook#onRemoveChild(freemind.modes.MindMapNode)
	 */
	public void onRemoveChild(MindMapNode oldChildNode) {
		logger.finest("onRemoveChild");
	}

	/* (non-Javadoc)
	 * @see freemind.extensions.PermanentNodeHook#save(freemind.main.XMLElement)
	 */
	public void save(XMLElement xml) {
		String saveName = getName();
		saveName=saveName.replace(File.separatorChar, '/');
		xml.setAttribute("name", saveName);
	}

	/* (non-Javadoc)
	 * @see freemind.extensions.PermanentNodeHook#loadFrom(freemind.main.XMLElement)
	 */
	public void loadFrom(XMLElement child) {
	}

	/* (non-Javadoc)
	 * @see freemind.modes.NodeHook#onReceiveFocusHook()
	 */
	public void onReceiveFocusHook() {
		logger.finest("onReceiveFocusHook");

	}

	/* (non-Javadoc)
	 * @see freemind.extensions.PermanentNodeHook#onLooseFocusHook()
	 */
	public void onLooseFocusHook() {
		logger.finest("onLooseFocusHook");
	}


}
