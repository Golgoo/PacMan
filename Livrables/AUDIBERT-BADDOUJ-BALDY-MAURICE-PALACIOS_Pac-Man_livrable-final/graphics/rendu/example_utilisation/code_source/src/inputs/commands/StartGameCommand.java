package inputs.commands;

import kernel.Kernel;

public class StartGameCommand implements Command{
	@Override
	public void launchKernelFunction(Kernel kernel) {
		kernel.startRequire();
	}
}
