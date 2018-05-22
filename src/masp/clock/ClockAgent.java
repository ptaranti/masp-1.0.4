package masp.clock;

import masp.clock.controlApproach.HandleTimeRateBehaviorLinear;
import masp.support.PropertiesLoaderImpl;
import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.Agent;

public class ClockAgent extends Agent {
	
	
	long TimeRateControl = PropertiesLoaderImpl.TIME_RATE_CONTROL;
	

	private ContentManager manager = (ContentManager) getContentManager();
	// This agent "speaks" the SL language
	private Codec codec = new SLCodec();

	// This agent "knows" the PlatDominiumOntology()
	// private Ontology ontology = PlatDominiumOntology.getInstance();

	protected void setup() {
		
		
		manager.registerLanguage(codec);
		//manager.registerOntology(ontology);
		addBehaviour(FactoryHandleTimeRateBehavior.getTickerBehaviour(this, TimeRateControl));
		
		if(PropertiesLoaderImpl.DEBUG) System.out.println(this.getName() +" alive!!!!!!!!!!\nStarting the simulation time");
		SimulationClock.getInstance().setSimulationStarted(true);
	}

}
