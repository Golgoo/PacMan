package inputs.commands;

import kernel.Kernel;

public class PauseGameCommand implements Command {
	@Override
	public void launchKernelFunction(Kernel kernel) {
		kernel.pauseGame();
	}
}
