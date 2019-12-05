package inputs.commands;

import inputs.commands.Command;
import kernel.Kernel;

public class ReducePacmanCommand implements Command {

	@Override
	public void launchKernelFunction(Kernel kernel) {
		kernel.reducePacmanSize();
	}

}
