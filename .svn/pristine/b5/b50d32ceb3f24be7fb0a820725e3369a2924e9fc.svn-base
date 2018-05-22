package masp.clock;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import masp.support.PropertiesLoaderImpl;
import masp.support.analiseLoggers.StatisticsLogger;

/**
 * @author taranti Statistic is a class that only colect information to be used
 *         in time control activity
 */
public class StatisticCollector extends Statistics {

	private double triggerPoint;

	private double triggerUpperLimit;

	private static StatisticCollector statisticCollector;

	private File fileRegister;
	private FileWriter writerRegister;
	private PrintWriter outRegister;

	private StatisticCollector() {
		this.maxPeriodInformed = PropertiesLoaderImpl.DEFAULT_SLICE_TIME;
		this.maxErrorInformed = 0;
		this.errorSum = 0;
		this.numberOfInformations = 0;
		this.numberOfErrorsGreatherThenTriggerPoint = 0;
		this.numberOfErrorsGreatherThenTriggerUpperLimit = 0;
		this.triggerPoint = PropertiesLoaderImpl.ERROR_TRIGGER;
		this.triggerUpperLimit = PropertiesLoaderImpl.MAX_ERROR_TRIGGER;
	}

	public static StatisticCollector getInstance() {
		if (statisticCollector == null)
			statisticCollector = new StatisticCollector();
		return statisticCollector;
	}

	public void insertData(long period, double error) {

		if (this.maxPeriodInformed < period)
			this.maxPeriodInformed = period;
		if (this.maxErrorInformed < error)
			this.maxErrorInformed = error;
		this.errorSum = this.errorSum + error;
		this.numberOfInformations++;
		if (this.triggerPoint < error)
			this.numberOfErrorsGreatherThenTriggerPoint++;
		if (this.triggerUpperLimit < error)
			this.numberOfErrorsGreatherThenTriggerUpperLimit++;
		if (PropertiesLoaderImpl.DEBUG)
			System.out.println("data inserted  " + period + " " + error);
		// System.out.println("Insert data: error-> "+ error +
		// " triggerPoint->"+ triggerPoint + " triggerUpperLimit->" +
		// triggerUpperLimit );
	}

	public Statistics recoverData() {
		Statistics statistics = new Statistics(this.maxPeriodInformed,
				this.maxErrorInformed, this.errorSum,
				this.numberOfInformations,
				this.numberOfErrorsGreatherThenTriggerPoint,
				this.numberOfErrorsGreatherThenTriggerUpperLimit);

		if (PropertiesLoaderImpl.FILE_LOG)
			StatisticsLogger.getInstance().logStatistics(this.maxPeriodInformed,
					this.maxErrorInformed, this.errorSum,
					this.numberOfInformations,
					this.numberOfErrorsGreatherThenTriggerPoint,
					this.numberOfErrorsGreatherThenTriggerUpperLimit);
		this.reset();

		return statistics;
	}

	public void reset() {

		/*
		 * System.out.println( "\n this.maxPeriodInformed =" +
		 * this.maxPeriodInformed + "\n this.maxErrorInformed =" +
		 * this.maxErrorInformed + "\n this.errorSum =" + this.errorSum +
		 * "\n this.numberOfInformations =" + this.numberOfInformations +
		 * "\n this.numberOfErrorsGreatherThenTriggerPoint =" +
		 * this.numberOfErrorsGreatherThenTriggerPoint +
		 * "\n this.numberOfErrorsGreatherThenTriggerUpperLimit =" +
		 * this.numberOfErrorsGreatherThenTriggerUpperLimit );
		 */

		this.maxPeriodInformed = 0;
		this.maxErrorInformed = 0;
		this.errorSum = 0;
		this.numberOfInformations = 0;
		this.numberOfErrorsGreatherThenTriggerPoint = 0;
		this.numberOfErrorsGreatherThenTriggerUpperLimit = 0;

	}

/*	private void logStatistics() {

		// if (timeRegister == null)
		// timeRegister = logFormatterRegisterName
		// .format(new GregorianCalendar().getTime());
		if (fileRegister == null)
			fileRegister = new File("Statistics.csv");
		if (writerRegister == null)
			try {
				writerRegister = new FileWriter("Statistics.csv", true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("erro na abertura de Statistics.csv");
				e.printStackTrace();
			}

		if (outRegister == null) {
			outRegister = new PrintWriter(writerRegister, true);
		}

		outRegister.println(System.currentTimeMillis() + "; "
				+ SimulationClock.getInstance().getCurrentSimulationTime()
				+ "; "
				+ SimulationClockControl.getInstance().getSimulationClockRate()
				+ "; " + maxPeriodInformed + "; " + maxErrorInformed + "; "
				+ errorSum + "; " + numberOfInformations + "; "
				+ numberOfErrorsGreatherThenTriggerPoint + "; "
				+ numberOfErrorsGreatherThenTriggerUpperLimit);

	}*/

}
