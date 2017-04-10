package net.sourceforge.vrapper.eclipse.interceptor;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IExecutionListener;
import org.eclipse.core.commands.NotHandledException;

/**
 * Listen to selection commands and publish their state
 * 
 * @author Pedro Santos
 *
 */
public class EclipseSelectionCommandListener implements IExecutionListener {
	boolean selectingViaCommand;

	public boolean isSelectingViaCommand() {
		return selectingViaCommand;
	}

	@Override
	public void preExecute(String commandId, ExecutionEvent event) {
		selectingViaCommand = true;
	}

	@Override
	public void notHandled(String commandId, NotHandledException exception) {
		selectingViaCommand = false;
	}

	@Override
	public void postExecuteFailure(String commandId, ExecutionException exception) {
		selectingViaCommand = false;
	}

	@Override
	public void postExecuteSuccess(String commandId, Object returnValue) {
		selectingViaCommand = false;
	}
}