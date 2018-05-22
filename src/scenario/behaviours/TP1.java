package scenario.behaviours;

import masp.simulacrum.MaspAgent;
import masp.simulacrum.MaspSimulationBehaviour;
import masp.support.PropertiesLoaderImpl;

public class TP1 extends MaspSimulationBehaviour {

	static long startTime;

	public TP1(MaspAgent a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public void onStart() {
		if (PropertiesLoaderImpl.DEBUG)
			System.out.println(this.getBehaviourName()
					+ " -> NOME DO BEHAVIOUR CARREGADO para o agente "
					+ myAgent.getLocalName());
		startTime = System.currentTimeMillis();
	}

	@Override
	protected void onTick() {
		// TODO Auto-generated method stub
		if (PropertiesLoaderImpl.DEBUG)
			System.out.println(this.getBehaviourName()
					+ " -> NOME DO BEHAVIOUR CARREGADO para o agente "
					+ myAgent.getLocalName() + " " + getTickCount() + "ciclo");

		//long millis = 0;
		//if ((PropertiesLoaderImpl.EXPERIMENT_DURATION_MIN - PropertiesLoaderImpl.TIME_FOR_HEATING) != 0)
		//	millis = (long) (100 * Math
		//			.sin(Math.PI
		//					* (System.currentTimeMillis() - startTime)
		//					/ ((PropertiesLoaderImpl.EXPERIMENT_DURATION_MIN) * 60000)));

		
		long millis = 0;
		if ((PropertiesLoaderImpl.EXPERIMENT_DURATION_MIN - PropertiesLoaderImpl.TIME_FOR_HEATING) != 0)
			millis = (long) ((200 * (System.currentTimeMillis() - startTime))
							/ ((PropertiesLoaderImpl.EXPERIMENT_DURATION_MIN) * 60000));
				
		
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
