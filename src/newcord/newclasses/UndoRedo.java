package newcord.newclasses;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.JTextComponent;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class UndoRedo {
	public final static String UNDO_ACTION = "Undo";
	public final static String REDO_ACTION = "Redo";

	public static void makeUndoable(JTextComponent pTextComponent) {
		final UndoManager undoMgr = new UndoManager();
		pTextComponent.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent evt) {
				undoMgr.addEdit(evt.getEdit());
			}
		});

		pTextComponent.getActionMap().put(UNDO_ACTION, new AbstractAction(UNDO_ACTION) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent evt) {
				try {
					for(int i = 0; i < 10; i++) {
						if (undoMgr.canUndo()) {
							undoMgr.undo();
						}
					}
				} catch (CannotUndoException e) {
					e.printStackTrace();
				}
			}
		});
		pTextComponent.getActionMap().put(REDO_ACTION, new AbstractAction(REDO_ACTION) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent evt) {
				try {
					for(int i = 0; i < 5; i++) {
						if (undoMgr.canRedo()) {
							undoMgr.redo();
						}
					}
				} catch (CannotRedoException e) {
					e.printStackTrace();}
			}
		});

		pTextComponent.getInputMap().put(
				KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK), UNDO_ACTION);
		pTextComponent.getInputMap().put(
				KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_DOWN_MASK), REDO_ACTION);
	}
}
