package masp.simulacrum;

import masp.clock.SimulationClock;

import com.vividsolutions.jts.geom.Coordinate;

public class Spatial2Dstate {

	Coordinate coordinate;
	double lastUpdateCoordinateTime;
	double course;
	double speed;
	static SimulationClock simulationClock = SimulationClock.getInstance();
	
	
	public Spatial2Dstate(){
		this.coordinate = new Coordinate();
		this.course = 0;
		this.speed = 0.0;
		this.lastUpdateCoordinateTime = SimulationClock.getInstance().getCurrentSimulationTime();
	}
	

	public double getCourse() {
		return course;
	}

	public void setCourse(double course) {
		this.course = course;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public void setCoordinate() {
		double currentTime = simulationClock.getCurrentSimulationTime();
		double deltaTime = currentTime - lastUpdateCoordinateTime;
		lastUpdateCoordinateTime = currentTime;

		double deltaTimeHour;
		deltaTimeHour = deltaTime / (1000 * 60 * 60); // tempo em horas
		double curseRad = this.course * (2 * Math.PI) / 360;
		double deltaSpace = this.speed * deltaTimeHour;
		Coordinate transCoord = new Coordinate();

		if (curseRad <= (Math.PI / 2)) {
			transCoord.y = deltaSpace * Math.cos(curseRad);
			transCoord.x = deltaSpace * Math.sin(curseRad);
		} else if (curseRad <= (Math.PI)) {
			curseRad = Math.PI - curseRad;
			transCoord.y = (-1) * deltaSpace * Math.cos(curseRad);
			transCoord.x = deltaSpace * Math.sin(curseRad);
		} else if (curseRad <= (Math.PI * 3 / 2)) {
			curseRad = (Math.PI * 3 / 2) - curseRad;
			transCoord.y = (-1) * deltaSpace * Math.sin(curseRad);
			transCoord.x = (-1) * deltaSpace * Math.cos(curseRad);
		} else if (curseRad <= (Math.PI * 2)) {
			curseRad = (Math.PI * 2) - curseRad;
			transCoord.y = deltaSpace * Math.cos(curseRad);
			transCoord.x = (-1) * deltaSpace * Math.sin(curseRad);
		}

		this.coordinate = new Coordinate(this.coordinate.x + transCoord.x,
				this.coordinate.y + transCoord.y);

	}

}
