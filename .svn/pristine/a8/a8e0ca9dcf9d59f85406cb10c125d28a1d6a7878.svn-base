package masp.nursery;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.tools.rma.rma; //import jade.util.leap.Set;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;

import java.util.List;

import masp.support.JenaFacade;
import masp.support.PropertiesLoaderImpl;

public class Starter {

	private static ContainerController myMain;

	public static Starter singleton = null;

	private static Runtime rt;

	static rma remoteAgentManager;

	public static Starter getInstance() {
		if (singleton == null) {
			singleton = new Starter();
		}
		return singleton;
	}

	public Starter() {
		rt = Runtime.instance();
		try {
			createSimulatedEnvironment(rt);
		} catch (ControllerException e) {
			e.printStackTrace();
		}
	}

	public static void createSimulatedEnvironment(Runtime rt) throws ControllerException {

		// instanciando MainConteiner (JADE)
		Profile m = new ProfileImpl(true);
		//m.setParameter("detect-main", "false"); // to avoid a bug in jade 3.5
		m.setParameter("local-port", PropertiesLoaderImpl.JADE_PORT);
		m.setParameter("port", PropertiesLoaderImpl.JADE_PORT);
		myMain = rt.createMainContainer(m);

		// instanciando SeaAgents
		AgentController controlAgent;

		// RMA -Remot Monitoring Agent - interface grafica
		if(PropertiesLoaderImpl.RMA){
			AgentController myRMA = myMain.createNewAgent("RMA",
					"jade.tools.rma.rma", new Object[0]);
			myRMA.start();
		}



		List<String> agentesNames = JenaFacade.getAgents();
		if (PropertiesLoaderImpl.DEBUG)
			for (String a : agentesNames)
				System.out.println(a);

		System.out.println("The simulation is starting to charge simulation agents");
		long timeOfCharge = System.currentTimeMillis();


		for (String agt : agentesNames) {

			int nrImages = JenaFacade.getDataTypePropertyValueInt(agt, "numberOfImages");

			String role = JenaFacade.getRoleForAgent(agt);
			String roleClass = JenaFacade.getOntologyClassForIndividual(role);
			if (PropertiesLoaderImpl.DEBUG)
				System.out.println("Instanciando agente: " + agt + " no papel "
						+ role + " com a classe " + roleClass);
			String agentClassName = "scenario.agents." + roleClass + "Agent";
			if (PropertiesLoaderImpl.DEBUG)
				System.out.println("agente pertence a classe: "
						+ agentClassName);

			for (int agtNr = 1; agtNr <= nrImages; agtNr++){
				controlAgent = myMain.createNewAgent(agt + "_" + agtNr, agentClassName,
						new Object[0]);
				controlAgent.start();
				System.out.println(myMain.getAgent(agt + "_" + agtNr).getName());

			}
		}

		System.out.println("The simulation ended to charge simulation agents");
		System.out.println("The simulation is starting to charge the time controll agent");



		controlAgent = myMain.createNewAgent("clockAgent",
				"masp.clock.ClockAgent", new Object[0]);
		controlAgent.start();

		System.out.println("The simulation ended to charge time controll agent");
		System.out.println("The simulation was charged in " + ((System.currentTimeMillis()- timeOfCharge)/1000) + " seconds");

	}

	static public  void stopHeating(){



		List<String> agentesNames = JenaFacade.getAgents();
		if (PropertiesLoaderImpl.DEBUG)
			for (String a : agentesNames)
				System.out.println(a);

		System.out.println("The simulation is stoping the heating cycle");
		rt.shutDown();
		for (String agt : agentesNames) {
			int nrImages = JenaFacade.getDataTypePropertyValueInt(agt, "numberOfImages");
			for (int agtNr = 1; agtNr <= nrImages; agtNr++)
				try {
					myMain.getAgent(agt + "_" + agtNr).kill();
				} catch (StaleProxyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ControllerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		/*try {
			myMain.kill();
			
		} catch (StaleProxyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

//rt.resetTerminators();
//rt.shutDown();

try {
			createSimulatedEnvironment(rt);
			System.out.println(">>>>>>>>> Heating cycle is finished!!");
			System.out.println(">>>>>>>>> Starting normal cycle with start rate :" + PropertiesLoaderImpl.INITIAL_SIMULATION_TIME_RATE);
		} catch (ControllerException e) {
			e.printStackTrace();
		}
	}


	public Runtime getRt() {
		return rt;
	}

	public static void main(String[] args) {
		if (PropertiesLoaderImpl.DEBUG)
			System.out.println("debug = " + PropertiesLoaderImpl.DEBUG);
		Starter.getInstance();
	}

}
