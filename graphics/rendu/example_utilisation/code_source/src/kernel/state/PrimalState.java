package kernel.state;

import java.util.Timer;
import java.util.TimerTask;


public class PrimalState {
	private Timer timer = new Timer();
	private State currentState ;
	private TimerTask currentTask ;
	
	private boolean taskIsWaiting;
	private long taskStartedTime ;
	private long taskScheduleTime ;
	
	private State nextState ;
	
	private State defaultState ;
	public PrimalState(State defaultState){
		this.defaultState = defaultState ;
		this.currentState = defaultState ;
	}
	
	
	public void setState(State requiredState) {
		if(requiredState != null) {
			currentState.released();
			
			if(taskIsWaiting) {
				currentTask.cancel();
			}
			
			currentState = requiredState ;
			currentState.activate();
		}
	}
	
	
	/**
	 * Call setState(requiredStateKey, time, defaultState)
	 * @param requiredStateKey
	 * @param time
	 */
	public void setState(State requiredState, long time) {
		setState(requiredState, time, defaultState);
	}
	
	/**
	 * 
	 * Call setState(requiredState) then schedule a task to launch setState(nextState)
	 * 
	 * @param key requiredState
	 * @param time time for the requiredState
	 * @param nextState nextState after requiredState time
	 */
	public void setState(State requiredState, long time, State nextState) {
		setState(requiredState);
		
		this.nextState = nextState ;
		taskIsWaiting = true ;
		
		launchTask(time);
	}
	
	private void launchTask(long scheduleTime) {
		currentTask = createTask();
		timer.schedule(currentTask, scheduleTime);
		taskScheduleTime = scheduleTime ;
		taskStartedTime = System.currentTimeMillis();
	}
	
	public void pause() {
		if(taskIsWaiting) {
			currentTask.cancel();
			long elapsed = System.currentTimeMillis() - taskStartedTime;
			if(elapsed < taskScheduleTime) {
				rescheduleTime = taskScheduleTime - elapsed ;
			}
		}
	}
	
	long rescheduleTime = -1 ;
	public void resume() {
		
		if(rescheduleTime > 0) {
			launchTask(rescheduleTime);
		}
		
		rescheduleTime = -1 ;
	}
	
	private TimerTask createTask() {
		return new TimerTask() {
			@Override
			public void run() {
				setState(nextState);
				taskIsWaiting = false;
			}
		};
	}
	
	
}
