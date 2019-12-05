package inputs;

import inputs.commands.CommandEnum;

public class CommandsMapLoader {
	public static void loadCommandsMap(InputMotor inputMotor) {
		inputMotor.bindInputToCommandEnum('z', CommandEnum.Enum.MOVE_UP);
		inputMotor.bindInputToCommandEnum('d', CommandEnum.Enum.MOVE_RIGHT);
		inputMotor.bindInputToCommandEnum('s', CommandEnum.Enum.MOVE_DOWN);
		inputMotor.bindInputToCommandEnum('q', CommandEnum.Enum.MOVE_LEFT);
		inputMotor.bindInputToCommandEnum('n', CommandEnum.Enum.NEW_GAME);
		inputMotor.bindInputToCommandEnum('p', CommandEnum.Enum.PLAY_PAUSE);
		inputMotor.bindInputToCommandEnum('e', CommandEnum.Enum.REDUCE_PAC);
		inputMotor.bindInputToCommandEnum('a', CommandEnum.Enum.GROW_PAC);
	}
}
