package masp.simulacrum;


import masp.support.PropertiesLoaderImpl;

public abstract class Masp2DMovementSimulationBehaviour extends MaspSimulationBehaviour {


	public Masp2DMovementSimulationBehaviour(MaspAgent a) {
		super(a);
		super.speed = a.getSpatial2Dstate().speed;
		// TODO Auto-generated constructor stub
	}



	// For persistence service

	private void setSimulatedTimePeriod() {
		//if (PropertiesLoaderImpl.DEBUG)
		//	System.out.println(this.getBehaviourName()
		//			+ "verificando a rate de execucao");
		double currentSpeed = ((MaspAgent) myAgent).getSpatial2Dstate()
		.getSpeed();
		if (currentSpeed > 0) super.simulatedTimePeriod = (long) (PropertiesLoaderImpl.MAXIMUM_SPATIAL_ERROR
				/ (2 * currentSpeed));
		else super.simulatedTimePeriod = (long) PropertiesLoaderImpl.DEFAULT_SLICE_TIME;

		//System.out.println(myAgent.getLocalName() + " ->  behavior "
			//	+ this.getBehaviourName()
			//	+ "assumindo thisBeraviourSliceTime de velocidade "
			//	+ super.simulatedTimePeriod);

	}

}
