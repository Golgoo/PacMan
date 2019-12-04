package inputs.commands;

import kernel.Kernel;
import util.Direction;

public class PacRightCommand implements Command{
	@Override
	public void launchKernelFunction(Kernel kernel) {
		kernel.setPacmanDirection(Direction.RIGHT);
	}
}
