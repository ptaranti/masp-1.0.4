package masp.clock.controlApproach;

import masp.support.PropertiesLoaderImpl;
import jade.core.Agent;

/**
 * @author taranti incluido tratamento brusco de erros alem do limite
 */
public class HandleTimeRateBehaviorLinear2 extends HandleTimeRateBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static boolean usedStrongCorrection = false;
	private static int counterStrongCorrection = 0;
	private static double lastError = 0;

	public HandleTimeRateBehaviorLinear2(Agent a, long period) {
		super(a, period);
		// TODO Auto-generated constructor stub

	}

	@Override
	void errorControl() {

		// vies
		double vies = currentStatistics.getMaxErrorInformed() - lastError;

		double newRate = simulationClockControl.getSimulationClockRate();
		boolean flag = true;

		// ultrapassou limite
		if (!usedStrongCorrection
				&& currentStatistics
						.getNumberOfErrorsGreatherThenTriggerUpperLimit() > 0
				&& counterStrongCorrection == 0) {
			newRate = simulationClockControl.getSimulationClockRate()
					/ (currentStatistics.getMaxErrorInformed()
							- PropertiesLoaderImpl.ERROR_TRIGGER + 1);
			flag = false;
			usedStrongCorrection = true;
			counterStrongCorrection = 5;
			System.out.println("TP1");

		}
		// com erro mais no limite
		if (currentStatistics.getNumberOfErrorsGreatherThenTriggerPoint() > 0
				&& flag) {
			if (stabilityCounter >= 0) {
				stabilityCounter = (-1);
				System.out.println("TP2"
						+ stabilityCounter
						+ " "
						+ currentStatistics
								.getNumberOfErrorsGreatherThenTriggerPoint());
			} else {
				stabilityCounter = stabilityCounter - 1;
				System.out.println("TP3 "
						+ stabilityCounter
						+ " "
						+ currentStatistics
								.getNumberOfErrorsGreatherThenTriggerPoint());
			}

			flag = false;

			if (vies > 0) {
				newRate = optimizeSimulationTimeRate((-1) * stabilityCounter
						* stabilityCounter);
				System.out.println(newRate + " 1");
			}
			if (vies < 0) {
				newRate = optimizeSimulationTimeRate((-1)
						* Math.sqrt((-1) * stabilityCounter));
				System.out.println(newRate + " 2");
			}
			if (vies == 0) {
				newRate = optimizeSimulationTimeRate(stabilityCounter);
				System.out.println(newRate + " 3");
			}

		}

		if (flag) {
			stabilityCounter++;
			if (PropertiesLoaderImpl.AUTOMATIC_CONTROL) {
				if (stabilityCounter > PropertiesLoaderImpl.STABLES_CYCLES_TO_OPTIMIZE) {
					if (vies > 0)
						newRate = optimizeSimulationTimeRate(Math
								.sqrt(stabilityCounter));
					if (vies < 0)
						newRate = optimizeSimulationTimeRate(stabilityCounter
								* stabilityCounter);
					if (vies == 0)
						newRate = optimizeSimulationTimeRate(stabilityCounter);
					System.out.println("TP4");
				}
			}
		}

		simulationClockControl.setSimulationClockRate(newRate);
		System.out.println("newRate  " + newRate);

		if (this.currentStatistics.getMaxPeriodInformed() > 0) {
			this
					.reset((long) (this.currentStatistics
							.getMaxPeriodInformed() / newRate));
			System.out.println("new period for verification = "
					+ this.currentStatistics.getMaxPeriodInformed() + " / "
					+ newRate + " = "
					+ (long) this.currentStatistics.getMaxPeriodInformed()
					/ newRate);
		}
		counterStrongCorrection =0;
		//if(counterStrongCorrection > 0)  counterStrongCorrection--;
		// lastError = currentStatistics.getMaxErrorInformed();
	}

	public double optimizeSimulationTimeRate(double value) {
		// negative counter counter has as consequence a more fast simulation
		double simulationClockRate = simulationClockControl
				.getSimulationClockRate()
				* (1 + (value * PropertiesLoaderImpl.OPTIMIZATION_RATE));
		if (simulationClockRate < 0.001)
			simulationClockRate = 0.001;
		if (PropertiesLoaderImpl.DEBUG)
			System.out.println("DEBUG " + this.getClass()
					+ " new simulation rate = " + simulationClockRate);
		return simulationClockRate;

	}

}
