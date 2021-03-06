package masp.support;



/**
 * Oferece metodos estaticos para leitura das propriedades do arquivo de
 * propriedades acessado pela classe PropertiesLoader
 * 
 * @author taranti
 * 
 */
public class PropertiesLoaderImpl {

	private static PropertiesLoader loader = new PropertiesLoader();
	private static boolean overallClassTest = true;

	
	//variavles to be used in static way

	public static final String JADE_PORT = findJadePort();

	public static final String   ONTOLOGY_NAME_OWL = findOntologyName();


	public static  double   INITIAL_SIMULATION_TIME_RATE = findInitialSimulationTimeRate();

	public static void setINITIAL_SIMULATION_TIME_RATE(
			double iNITIALSIMULATIONTIMERATE) {
		INITIAL_SIMULATION_TIME_RATE = iNITIALSIMULATIONTIMERATE;
	}

	public static final boolean AVOID_OVERLOAD = findAvoidOverload();
	
	public static final boolean STOP_WHEN_OVERLOAD = findStopWhenOverload();

	public static final boolean AUTOMATIC_CONTROL = findAutomaticControl();

		  
	public static final double MAX_ERROR_TRIGGER = findMaxErrorTrigger();


	public static final double ERROR_TRIGGER = findErrorTrigger();


	public static final double OPTIMIZATION_RATE = findOptimizationRate();


	public static final int STABLES_CYCLES_TO_OPTIMIZE = findStableCyclesToOptimize();


	public static long TIME_RATE_CONTROL = findTimeRateControl();


	public static final long DEFAULT_SLICE_TIME = findDefaultSliceTime();


	public static final double MAXIMUM_SPATIAL_ERROR = findMaximumSpatialError();
	
	public static final boolean ALLOW_MULTIPLE_AGENTS = findAllowMultipleAgents();


	public static final boolean DEBUG = findDebug();
	
	public static final boolean FILE_LOG = findFileLog();

	public static final boolean RMA = findRMA();
	
	public static final String APPROACH = findApproach();
	
	public static final int EXPERIMENT_DURATION_MIN = findExprerimentDurationMin();
	
	public static boolean	USE_HEATING_CYCLE = findUseHeatingCycle();
	
	public static final int 	TIME_FOR_HEATING = findTimeForHeating();
	
	
	/**
	 * @return porta logica a ser usada pela plataforma JADE
	 */
	private static String findJadePort() {

		if (overallClassTest)
			overallClassTest(); // teste completo de todas propriedades caso nao
		// tenha sido executado

		String port = PropertiesLoaderImpl.getValor("JADE_PORT");
		//System.out.println(port);
		if (port.equals("1099")) {

		}
		return port;
	}

	/**
	 * @return porta logica a ser usada pela plataforma JADE
	 */
	private static String findOntologyName() {

		if (overallClassTest)
			overallClassTest(); // teste completo de todas propriedades caso nao
		// tenha sido executado

		String port = PropertiesLoaderImpl.getValor("ONTOLOGY_NAME_OWL");
		//System.out.println(port);

		return port;
	}

	/**
	 * @return periodo para atualizacao de posicoes geograficas em minutos
	 *         <p>
	 *         valor default 1 minuto
	 */
	private static double findInitialSimulationTimeRate() {

		if (overallClassTest)
			overallClassTest(); // teste completo de todas propriedades caso nao
		// tenha sido executado

		return Double.parseDouble(PropertiesLoaderImpl
				.getValor("INITIAL_SIMULATION_TIME_RATE"));
	}
	
	
	private static boolean findAvoidOverload() {
		return Boolean.parseBoolean(PropertiesLoaderImpl.getValor("AVOID_OVERLOAD"));
	}
	
	public static final boolean findStopWhenOverload(){
		return Boolean.parseBoolean(PropertiesLoaderImpl.getValor("STOP_WHEN_OVERLOAD"));}
	
	
	private static boolean findAutomaticControl() {
		return Boolean.parseBoolean(PropertiesLoaderImpl.getValor("AUTOMATIC_CONTROL"));
	}
	

	
	private static double findMaxErrorTrigger() {

		if (overallClassTest)
			overallClassTest(); // teste completo de todas propriedades caso nao
		// tenha sido executado

		return Double.parseDouble(PropertiesLoaderImpl
				.getValor("MAX_ERROR_TRIGGER"));
	}



	private static double findErrorTrigger() {

		if (overallClassTest)
			overallClassTest(); // teste completo de todas propriedades caso nao
		// tenha sido executado

		return Double.parseDouble(PropertiesLoaderImpl
				.getValor("ERROR_TRIGGER"));
	}


	private static double findOptimizationRate() {

		if (overallClassTest)
			overallClassTest(); // teste completo de todas propriedades caso nao
		// tenha sido executado

		return Double.parseDouble(PropertiesLoaderImpl
				.getValor("OPTIMIZATION_RATE"));
	}


	private static int findStableCyclesToOptimize() {

		if (overallClassTest)
			overallClassTest(); // teste completo de todas propriedades caso nao
		// tenha sido executado

		return Integer.parseInt(PropertiesLoaderImpl
				.getValor("STABLES_CYCLES_TO_OPTIMIZE"));
	}

	private static int findExprerimentDurationMin() {

		if (overallClassTest)
			overallClassTest(); // teste completo de todas propriedades caso nao
		// tenha sido executado

		return Integer.parseInt(PropertiesLoaderImpl
				.getValor("EXPERIMENT_DURATION_MIN"));
	}
	private static long findTimeRateControl() {

		if (overallClassTest)
			overallClassTest(); // teste completo de todas propriedades caso nao
		// tenha sido executado

		return Long.parseLong(PropertiesLoaderImpl
				.getValor("TIME_RATE_CONTROL"));
	}
	
	
	private static double findMaximumSpatialError() {

		if (overallClassTest)
			overallClassTest(); // teste completo de todas propriedades caso nao
		// tenha sido executado

		return Double.parseDouble(PropertiesLoaderImpl
				.getValor("MAXIMUM_SPATIAL_ERROR"));
	}
	
	
	
	private static long findDefaultSliceTime() {

		if (overallClassTest)
			overallClassTest(); // teste completo de todas propriedades caso nao
		// tenha sido executado

		return Long.parseLong(PropertiesLoaderImpl
				.getValor("DEFAULT_SLICE_TIME"));
	}

	private static boolean findAllowMultipleAgents() {
		return Boolean.parseBoolean(PropertiesLoaderImpl.getValor("ALLOW_MULTIPLE_AGENTS"));
	}
	
	/**
	 * @return true caso o sistema deva ser inicializado em modo verboso para
	 *         debug
	 *         <p>
	 *         Caso utilizado o agente RMA do jade será carregado para
	 *         monitoração dos agentes
	 */
	private static boolean findDebug() {
		return Boolean.parseBoolean(PropertiesLoaderImpl.getValor("DEBUG"));
	}
	
	
	private static boolean findFileLog() {
		return Boolean.parseBoolean(PropertiesLoaderImpl.getValor("FILE_LOG"));
	}
	
	private static boolean findRMA() {
		return Boolean.parseBoolean(PropertiesLoaderImpl.getValor("RMA"));
	}
	
	
	
	private static boolean findUseHeatingCycle() {
		return Boolean.parseBoolean(PropertiesLoaderImpl.getValor("USE_HEATING_CYCLE"));
	}
	


	public static void setUseHeatingCycle(boolean useHeatingCycle) {
		USE_HEATING_CYCLE = useHeatingCycle;
	}

	private static int findTimeForHeating() {

		if (overallClassTest)
			overallClassTest(); // teste completo de todas propriedades caso nao
		// tenha sido executado

		return Integer.parseInt(PropertiesLoaderImpl
				.getValor("TIME_FOR_HEATING"));
	}
	
	
	private static String findApproach() {
		if (overallClassTest)
			overallClassTest(); // teste completo de todas propriedades caso nao
		// tenha sido executado

		String approach = PropertiesLoaderImpl.getValor("APPROACH");
		//System.out.println(port);
		if (approach.equals("linear2") )return approach; 
		if (approach.equals("linear") )return approach; 
		if (approach.equals("sqr1") )return approach; 
		if (approach.equals("sqr2") )return approach; 
		System.out.println("The approach selected does not exist");
		System.exit(0);
		return null;
	}

	
	private static String getValor(String chave) {
		return (String) loader.getValor(chave);
	}


	private static void overallClassTest() {

		overallClassTest = false;

		findJadePort();
		findInitialSimulationTimeRate();

		findDebug();
	}

	public static void main(String[] args) {
		overallClassTest();
	}
}

// / para usar:
// PropertiesLoaderImpl.getValor("SUA VARIAVEL")
// find....






