package inputs.commands;

import kernel.Kernel;
import util.Direction;

public class PacDownCommand implements Command{

	@Override
	public void launchKernelFunction(Kernel kernel) {
		kernel.setPacmanDirection(Direction.DOWN);
	}

}
