package masp.clock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import masp.nursery.Starter;
import masp.support.PropertiesLoaderImpl;

public class SimulationClock {

	/**
	 * Counter for simulation time, in milliseconds
	 */
	private long lastSimulationTime;
	public boolean simulationStarted;
	private boolean isHeatingCycle;

	private long startRealTime;
	private long lastRealTime;

	private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private static Lock readLock = rwl.readLock();
	private Lock writeLock = rwl.writeLock();

	private SimulationClockControl simulationClockControl;

	/**
	 * Singleton
	 */
	private static SimulationClock INSTANCE = new SimulationClock();

	private SimulationClock() {
		this.startRealTime = System.currentTimeMillis();
		this.lastRealTime = 0;
		simulationClockControl = SimulationClockControl.getInstance();
		this.lastSimulationTime = 0;
		this.isHeatingCycle = PropertiesLoaderImpl.USE_HEATING_CYCLE;
	}

	/**
	 * @return Singleton to simulation clock
	 */
	public static SimulationClock getInstance() {
		readLock.lock();
		try {
			return INSTANCE;
		} finally {
			readLock.unlock();
		}
	}

	public void setSimulationStarted(boolean simulationStarted) {

		{
			writeLock.lock();
			try {
				StatisticCollector.getInstance().reset();
				this.simulationStarted = simulationStarted;
			} finally {
				writeLock.unlock();
			}
		}

	}

	public long getCurrentSimulationTime() {
		{
			writeLock.lock();
			try {
				
				if (!simulationStarted)
					return 0;

				long nowRealTime = System.currentTimeMillis() - startRealTime;
				double incrementSimulationTime = ((nowRealTime - this.lastRealTime) * simulationClockControl
						.getSimulationClockRate());
				this.lastRealTime = nowRealTime;
				this.lastSimulationTime = this.lastSimulationTime
				+ (long) incrementSimulationTime;

				// code to stop the experiment when achieve the parameter
				// EXPERIMENT_DURATION_MIN
				if (!isHeatingCycle
						&& nowRealTime >= (PropertiesLoaderImpl.EXPERIMENT_DURATION_MIN * 60 * 1000)) {
					System.out.println("******************************************");
					System.out.println("*** The experiment has finished       ****");
					System.out.println("******************************************");
					setSimulationStarted(false);
					System.exit(0);
				}

				if (isHeatingCycle
						&& (nowRealTime >= (60 * 1000 * PropertiesLoaderImpl.TIME_FOR_HEATING))) {
					PropertiesLoaderImpl
					.setINITIAL_SIMULATION_TIME_RATE(simulationClockControl
							.getSimulationClockRate());
					System.out.println("******************************************");
					System.out.println("*** The heating cycle has finished    ****");
					System.out.println("******************************************");
					PropertiesLoaderImpl.setUseHeatingCycle(false);
					setSimulationStarted(false);
					this.isHeatingCycle = false;
					this.lastSimulationTime = 0;
					Starter.stopHeating();
				}

				return this.lastSimulationTime;
				
			} finally {
				writeLock.unlock();
			}
		}
		
	}

}