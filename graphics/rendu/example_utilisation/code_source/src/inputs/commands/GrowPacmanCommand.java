package inputs.commands;

import kernel.Kernel;

public class GrowPacmanCommand implements Command {

	@Override
	public void launchKernelFunction(Kernel kernel) {
		kernel.growPacmanSize();
	}

}
