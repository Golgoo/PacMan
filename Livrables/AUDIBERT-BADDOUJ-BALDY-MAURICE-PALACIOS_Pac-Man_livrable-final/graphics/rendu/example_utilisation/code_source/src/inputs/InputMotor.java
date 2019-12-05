package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import inputs.commands.*;
import kernel.Kernel;

public class InputMotor implements KeyListener {

	private Kernel kernel ;
	
	private Map<Character, CommandEnum.Enum> commandsMap = new HashMap<>();
	private Map<CommandEnum.Enum, Character> controlMap = new HashMap<>();
	
	private Map<CommandEnum.Enum, Command> bindedCommands = new HashMap<>();
	
	public InputMotor(Kernel kernel) {
		this.kernel = kernel ;
		bindCommands();
		CommandsMapLoader.loadCommandsMap(this);
	}
	
	private void bindCommands() {
		bindCommand(CommandEnum.Enum.MOVE_UP, new PacUpCommand());
		bindCommand(CommandEnum.Enum.MOVE_RIGHT, new PacRightCommand());
		bindCommand(CommandEnum.Enum.MOVE_DOWN, new PacDownCommand());
		bindCommand(CommandEnum.Enum.MOVE_LEFT, new PacLeftCommand());
		bindCommand(CommandEnum.Enum.NEW_GAME, new StartGameCommand());
		bindCommand(CommandEnum.Enum.PLAY_PAUSE, new PauseGameCommand());
		bindCommand(CommandEnum.Enum.REDUCE_PAC, new ReducePacmanCommand());
		bindCommand(CommandEnum.Enum.GROW_PAC, new GrowPacmanCommand());
	}
	
	public void bindCommand(CommandEnum.Enum commandEnum, Command command) {
		bindedCommands.put(commandEnum, command);
	}
	
	public void bindInputToCommandEnum(Character character, CommandEnum.Enum commandEnum) {
		commandsMap.put(character, commandEnum);
		controlMap.put(commandEnum, character);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		CommandEnum.Enum commandEnum = commandsMap.get(e.getKeyChar());
		if(commandEnum != null) {
			Command command = bindedCommands.get(commandEnum);			
			if(command != null) {
				command.launchKernelFunction(kernel);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	public char getKeyOf(CommandEnum.Enum controlEnum) {
		return controlMap.get(controlEnum);
	}

}
